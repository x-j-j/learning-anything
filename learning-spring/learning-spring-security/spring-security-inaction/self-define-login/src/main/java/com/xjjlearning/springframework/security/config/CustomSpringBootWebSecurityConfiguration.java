package com.xjjlearning.springframework.security.config;

import com.xjjlearning.springframework.security.filter.JsonLoginPostProcessor;
import com.xjjlearning.springframework.security.filter.JwtAuthenticationFilter;
import com.xjjlearning.springframework.security.filter.LoginPostProcessor;
import com.xjjlearning.springframework.security.filter.PreLoginFilter;
import com.xjjlearning.springframework.security.handler.CustomLogoutHandler;
import com.xjjlearning.springframework.security.handler.CustomLogoutSuccessHandler;
import com.xjjlearning.springframework.security.handler.SimpleAccessDeniedHandler;
import com.xjjlearning.springframework.security.handler.SimpleAuthenticationEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * created by xjj on 2022/12/11
 */
@Configuration
@ConditionalOnClass(WebSecurityConfigurerAdapter.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CustomSpringBootWebSecurityConfiguration {
    private static final String LOGIN_PROCESSING_URL = "/process";

    /**
     * Json login post processor json login post processor.
     *
     * @return the json login post processor
     */
    @Bean
    public JsonLoginPostProcessor jsonLoginPostProcessor(){
        return new JsonLoginPostProcessor();
    }

    /**
     * Pre login filter pre login filter.
     * ??????????????? default ?????? JsonLoginPostProcessor, ????????????????????????????????????
     * @param loginPostProcessors the login post processors
     * @return the pre login filter
     */
    @Bean
    public PreLoginFilter preLoginFilter(Collection<LoginPostProcessor> loginPostProcessors){
        return new PreLoginFilter(LOGIN_PROCESSING_URL, loginPostProcessors);
    }


    /**
     * The type Default configurer adapter.
     */
    @Configuration
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    static class DefaultConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Resource
        private PreLoginFilter preLoginFilter;

        @Resource
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        // @Resource
        // private CaptchaAuthenticationFilter captchaAuthenticationFilter;

        @Resource
        private AuthenticationSuccessHandler authenticationSuccessHandler;

        @Resource
        private AuthenticationFailureHandler authenticationFailureHandler;

        @Resource
        private SimpleAccessDeniedHandler simpleAccessDeniedHandler;

        @Resource
        private SimpleAuthenticationEntryPoint simpleAuthenticationEntryPoint;

        @Resource
        private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

        @Resource
        private AccessDecisionManager accessDecisionManager;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            // AuthenticationConfiguration.getAuthenticationManager()
            super.configure(auth);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            super.configure(web);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors()
                    .and()
                    .authorizeRequests().anyRequest().authenticated()
                    // ??????????????????
                    //.withObjectPostProcessor(filterSecurityInterceptorObjectPostProcessor())
                    .and()
                    /**
                     * ????????????, ???????????????????????? ??????????????????????????????200 ????????????Handler??????????????????
                     */
                    .exceptionHandling()
                    .authenticationEntryPoint(simpleAuthenticationEntryPoint) // 401 unauthorized
                    .accessDeniedHandler(simpleAccessDeniedHandler) // 403 forbidden
                    .and()
                    /**
                     * ??????????????????
                     */
                    // .addFilterBefore(captchaAuthenticationFilter, PreLoginFilter.class)
                    /**
                     * jwt ???????????????, ??????session?????????
                     */
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    /**
                     * 1.??????????????????????????????????????????????????????
                     */
                    // ?????????????????? ???????????????type????????? ??????????????????????????? ????????? ?????????filter
                    .addFilterBefore(preLoginFilter, UsernamePasswordAuthenticationFilter.class)
                    .formLogin()
                    // // ????????????????????? ????????????????????????????????? ???????????????url, ?????????????????????????????? ??????????????? UsernamePasswordAuthenticationFilter
                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
                    // ?????? ???????????????????????????200 ??????????????????????????? -> ???????????????jwt token  ??????????????? ????????????
                    .successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)
                    .and()
                    // ???????????????????????????url ???????????????????????????
                    // .successForwardUrl("/login/success").failureForwardUrl("/login/failure")
                    .logout().addLogoutHandler(new CustomLogoutHandler()).logoutSuccessHandler(new CustomLogoutSuccessHandler());


                    /**
                     * 2.???????????? ????????? UsernamePasswordAuthenticationFilter ????????????
                     * ???????????????
                     */
                    // .addFilter(multiTypeUsernamePasswordAuthenticationFilter)
                    // .formLogin()
                    // .loginProcessingUrl(LOGIN_PROCESSING_URL);
        }

        /**
         * ????????? FilterSecurityInterceptor  ObjectPostProcessor ????????????????????????????????????????????????
         *
         * @return ObjectPostProcessor
         */
        private ObjectPostProcessor<FilterSecurityInterceptor> filterSecurityInterceptorObjectPostProcessor() {
            return new ObjectPostProcessor<FilterSecurityInterceptor>() {
                @Override
                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                    object.setAccessDecisionManager(accessDecisionManager);
                    object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                    return object;
                }
            };
        }
    }
}
