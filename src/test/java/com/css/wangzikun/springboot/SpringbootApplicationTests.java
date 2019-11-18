package com.css.wangzikun.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
        Map<String,String> map1 = new HashMap<>();
        map1.put("a","aaa");
        System.out.println(map1.keySet());
    }

}
