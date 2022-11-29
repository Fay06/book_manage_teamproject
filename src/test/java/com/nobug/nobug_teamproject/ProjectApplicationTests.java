package com.nobug.nobug_teamproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
        String test = "passed";
        assertEquals("passed", test);
    }

}
