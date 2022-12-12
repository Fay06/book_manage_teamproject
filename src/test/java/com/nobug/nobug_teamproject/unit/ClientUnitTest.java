package com.nobug.nobug_teamproject.unit;


import com.nobug.nobug_teamproject.mapper.ClientMapper;
import com.nobug.nobug_teamproject.models.Client;
import com.nobug.nobug_teamproject.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientUnitTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientMapper clientMapper;

    @Test
    public void testGetClientName() {
        int clientID = 1000;
        Client client = new Client(clientID, "new Client");

        Mockito.when(clientMapper.searchClient("new Client")).thenReturn(client);

        assertEquals("new Client", (clientService.searchClient("new Client").getClientName()));
    }

    @Test
    public void testGetClientID() {
        int clientID = 1000;
        Client client = new Client(clientID, "new Client");

        Mockito.when(clientMapper.searchClient("new Client")).thenReturn(client);

        assertEquals(1000, (clientService.searchClient("new Client").getClientID()));
    }

}
