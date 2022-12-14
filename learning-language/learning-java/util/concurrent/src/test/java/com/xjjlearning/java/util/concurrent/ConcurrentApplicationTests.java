package com.xjjlearning.java.util.concurrent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 上面的所有代码留着复习的时候重新写一遍, 一两天复习一章
@SpringBootTest
class ConcurrentApplicationTests {

    @Test
    void contextLoads() {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("2");
        sb.delete(1, 1);
        System.out.println(sb);
    }

}
