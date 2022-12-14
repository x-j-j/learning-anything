package com.xjjlearning.springframework.security;

import com.xjjlearning.springframework.security.web.HelloController;
import com.xjjlearning.springframework.security.web.TokenController;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Instant;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ HelloController.class, TokenController.class })
@Import(RestConfig.class)
class JwtApplicationTests {
    @Resource
    JwtEncoder encoder;

    @Resource
    MockMvc mockMvc;

	@Test
	void contextLoads() {
        Instant now = Instant.now();
        long expiry = 36000L;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("xjj")
                .claim("scope", "USER ADMIN")
                .build();
        // @formatter:on
        System.out.println(encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        /**
         * header: {
         *   "alg": "RS256"
         * }
         * payload: {
         *   "iss": "self",
         *   "sub": "xjj",
         *   "exp": 1670338981,
         *   "iat": 1670302981,
         *   "scope": "USER ADMIN"
         * }
         */
	}

    @Test
    void rootWhenAuthenticatedThenSayHelloUser() throws Exception {
        MvcResult result = mockMvc.perform(post("/token").with(httpBasic("username", "password")))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.getResponse().getContentAsString();

        // System.out.println(token);
        // mockMvc.perform(get("/").header("Authorization", "Bearer " + token))
        //         .andExpect(content().string("Hello, username!"));
    }

    @Test
    void  rootWhenAuthenticatedThen401() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isUnauthorized()); // we don't have Authorization header
    }
    @Test
    void tokenWhenBadCredentialsThen401() throws Exception {
        mockMvc.perform(post("/token"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void indexGreetsAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/jwt").with(jwt().jwt(jwt -> jwt.subject("xjj"))))
                .andExpect(content().string("Hello, xjj!"));
    }
    @Test
    void messageCanBeReadWithScopeMessageReadAuthority() throws Exception {
        mockMvc.perform(get("/message").with(jwt().jwt(jwt -> jwt.claim("scope", "message:read"))))
                .andExpect(content().string("secret message"));
        mockMvc.perform(get("/message").with(jwt().authorities((GrantedAuthority) () -> "SCOPE_message:read")))
                .andExpect(content().string("secret message"));
    }


    @Test
    void messageCanNotBeCreatedSituation() throws Exception {
        // needs message:write scope
        mockMvc.perform(post("/message").with(jwt()).content("hello xjj"))
                .andExpect(status().isForbidden()); // we don't permission
        mockMvc.perform(post("/message")
                    .with(jwt().jwt(jwt -> jwt.claim("scope", "message:read")))
                    .content("hello xjj"))
                .andExpect(status().isForbidden());

        // success
        mockMvc.perform(post("/message")
                        .with(jwt().jwt(jwt -> jwt.claim("scope", "message:write")))
                        .content("hello xjj"))
                .andExpect(content().string("Message was created. Content: hello xjj"));
    }
}
