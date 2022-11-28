package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.models.Client;
import com.nobug.nobug_teamproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("get")
    public ResponseEntity<Object> getClient(@RequestParam(value = "clientName", required = true) String clientName) {
        Client result = clientService.searchClient(clientName);
        if (result == null) {
            return new ResponseEntity<>("clientName Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
