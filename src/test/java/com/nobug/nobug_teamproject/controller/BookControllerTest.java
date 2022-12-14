package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.service.BookService;
import com.nobug.nobug_teamproject.service.ClientService;
import com.nobug.nobug_teamproject.service.RatingService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ClientService clientService;

    private String token = "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzUxMiJ9.eyJjbGllbnQiOiJmYWtlX2NsaWVudCJ9.P5yuxIa8n-T47SYKuqShwn_AS4CCkV6OOIYi5EDQ5V_C3zrMSufcGXoo18121hGt-Q3aXuSjEpebpwtKkRT1-w";
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before()
    public void setup()
    {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void searchBookIDSuccess() throws Exception {
        String expectedRes = "[{\"bookID\":2,\"bookName\":\"To Kill a Mockingbird\",\"category\":\"Southern Gothic\"}]";
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("bookID", "2")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals(expectedRes, res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookIDNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("bookID", "1")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("BookID Not Found", res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookNameSuccess() throws Exception {
        String expectedRes = "[{\"bookID\":2,\"bookName\":\"To Kill a Mockingbird\",\"category\":\"Southern Gothic\"}]";
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("bookName", "To Kill a Mockingbird")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals(expectedRes, res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookNameNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("bookName", "test something")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("BookName Not Found", res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookCategorySuccess() throws Exception {
        String expectedRes = "[{\"bookID\":2,\"bookName\":\"To Kill a Mockingbird\",\"category\":\"Southern Gothic\"}]";
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("category", "Southern Gothic")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals(expectedRes, res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookCategoryNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("category", "test something")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("Category Not Found", res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookInvalid() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("size", "-1")
        ).andDo(print()).andExpect(status().isBadRequest()).andReturn();
        assertEquals("Invalid Parameter: Size", res.getResponse().getContentAsString());
    }

    @Test
    public void searchBookNameSizeOK() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("size", "5")
                .param("bookName", "Test for Rating")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void searchBookCategorySizeOK() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("size", "5")
                .param("category", "test")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void searchAllBookSizeOK() throws Exception {
        MvcResult res = mockMvc.perform(get("/book/get")
                .param("size", "5")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    @Transactional
    public void addBookSuccess() throws Exception {
        mockMvc.perform(post("/book/add")
                .param("bookName", "controller test")
                .param("category", "category")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void deleteBookSuccess() throws Exception {
        MvcResult res = mockMvc.perform(delete("/book/delete")
                .param("bookID", "2")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("Book Deleted", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void deleteBookNotFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/book/delete")
                .param("bookID", "1")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("Book Not Found", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    public void updateBookSuccess() throws Exception {
        mockMvc.perform(put("/book/update")
                .param("bookID", "2")
                .param("bookName", "controller test")
                .param("category", "category")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void updateBookNotFound() throws Exception {
        mockMvc.perform(put("/book/update")
                .param("bookID", "1")
                .param("bookName", "controller test")
                .param("category", "category")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
    }
}
