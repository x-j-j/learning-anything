package com.xjj.learning.maven.accountweb;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class controller {
    private int i;

    @GetMapping(value = "test")
    public void test(){
        System.out.println("ok");
        new webMethod().testCaptchaMethod();
    }
}
