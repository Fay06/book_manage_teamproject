package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.service.BookListService;
import com.nobug.nobug_teamproject.service.BookService;
import com.nobug.nobug_teamproject.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class BookListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookListService bookListService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup()
    {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void searchBookListSuccess() throws Exception {
        MvcResult res = mockMvc.perform(get("/booklist/get/name")
                .param("bookListID", "50")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void searchBookListBookNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/booklist/get/name")
                .param("bookListID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void searchBookFromListSuccess() throws Exception {
        MvcResult res = mockMvc.perform(get("/booklist/get/book")
                .param("bookListID", "5")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void searchBookFromListNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/booklist/get/book")
                .param("bookListID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void searchBookFromListEmpty() throws Exception {
        MvcResult res = mockMvc.perform(get("/booklist/get/book")
                .param("bookListID", "50")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("BookList Empty", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void addBookListSuccess() throws Exception {
        mockMvc.perform(post("/booklist/add")
                .param("bookListName", "Controller Test")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void addBookToListSuccess() throws Exception {
        mockMvc.perform(post("/booklist/add")
                .param("bookListID", "5")
                .param("bookID", "654")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void addBookToListBookNotFound() throws Exception {
        mockMvc.perform(post("/booklist/add")
                .param("bookListID", "5")
                .param("bookID", "0")
        ).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void addBookToListBookListNotFound() throws Exception {
        mockMvc.perform(post("/booklist/add")
                .param("bookListID", "0")
                .param("bookID", "654")
        ).andDo(print()).andExpect(status().isNotFound());
    }


    @Test
    @Transactional
    public void deleteBookSuccess() throws Exception {
        MvcResult res = mockMvc.perform(delete("/booklist/delete")
                .param("bookListID", "5")
                .param("bookID", "652")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("Deleted", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void deleteBookNotFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/booklist/delete")
                .param("bookListID", "5")
                .param("bookID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    @Transactional
    public void deleteBookBookListNotFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/booklist/delete")
                .param("bookListID", "0")
                .param("bookID", "652")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    @Transactional
    public void deleteBookListSuccess() throws Exception {
        MvcResult res = mockMvc.perform(delete("/booklist/delete")
                .param("bookListID", "50")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    @Transactional
    public void deleteBookListNotFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/booklist/delete")
                .param("bookListID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    @Transactional
    public void updateRatingSuccess() throws Exception {
        MvcResult res = mockMvc.perform(put("/booklist/update")
                .param("bookListID", "50")
                .param("bookListName", "Controller Test")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("BookList Updated", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void updateRatingNotFound() throws Exception {
        MvcResult res = mockMvc.perform(put("/booklist/update")
                .param("bookListID", "1")
                .param("bookListName", "Controller Test")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }
}