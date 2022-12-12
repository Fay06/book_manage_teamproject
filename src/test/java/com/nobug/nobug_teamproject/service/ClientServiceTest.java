package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Client;
import com.nobug.nobug_teamproject.service.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {
    @Autowired
    ClientService clientService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getClient() {
        Client client = clientService.searchClient("fake_client");
        assertEquals(2, client.getClientID());
        assertEquals("fake_client", client.getClientName());
    }

    @Test
    public void getInvalidClient() {
        Client client = clientService.searchClient("non-exist");
        assertNull(client);
    }
}