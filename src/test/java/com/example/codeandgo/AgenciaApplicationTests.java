package com.example.codeandgo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.codeandgo.TestConfig.TestConfig;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class AgenciaApplicationTests {

    @Test
    void contextLoads() {
       
    }
}
