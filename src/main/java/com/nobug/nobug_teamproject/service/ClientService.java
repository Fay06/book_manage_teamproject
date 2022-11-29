package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.ClientMapper;
import com.nobug.nobug_teamproject.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientMapper clientMapper;

    public Client searchClient(String clientName){
        return clientMapper.searchClient(clientName);
    }

}
