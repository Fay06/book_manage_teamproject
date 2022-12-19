package com.nobug.nobug_teamproject;

import com.nobug.nobug_teamproject.controller.*;
import com.nobug.nobug_teamproject.service.*;
import com.nobug.nobug_teamproject.unit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookControllerTest.class,
        BookListControllerTest.class,
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
