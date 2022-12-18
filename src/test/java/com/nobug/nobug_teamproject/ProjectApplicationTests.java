package com.nobug.nobug_teamproject;

import com.nobug.nobug_teamproject.controller.RatingControllerTest;
import com.nobug.nobug_teamproject.service.*;
import com.nobug.nobug_teamproject.unit.BookListServiceUnitTest;
import com.nobug.nobug_teamproject.unit.BookServiceUnitTest;
import com.nobug.nobug_teamproject.unit.ClientUnitTest;
import com.nobug.nobug_teamproject.unit.RatingServiceUnitTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RatingControllerTest.class,
        BookListServiceTest.class,
        BookServiceTest.class,
        ClientServiceTest.class,
        RatingServiceTest.class,
        BookListServiceUnitTest.class,
        BookServiceUnitTest.class,
        ClientUnitTest.class,
        RatingServiceUnitTest.class
})
public class ProjectApplicationTests {
}
