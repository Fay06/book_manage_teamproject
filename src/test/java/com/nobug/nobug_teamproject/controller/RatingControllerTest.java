package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.service.BookService;
import com.nobug.nobug_teamproject.service.ClientService;
import com.nobug.nobug_teamproject.service.RatingService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class RatingControllerTest {
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
    void searchRatingSuccess() throws Exception {
        String expectedRes = "{\"ratingID\":0,\"bookID\":2,\"rating\":3.0}";
        MvcResult res = mockMvc.perform(get("/rating/get")
                .param("bookID", "2")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals(expectedRes, res.getResponse().getContentAsString());
    }

    @Test
    void searchRatingBookNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/rating/get")
                .param("bookID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("Book Not Found", res.getResponse().getContentAsString());
    }

    @Test
    void searchRatingRatingNotFound() throws Exception {
        MvcResult res = mockMvc.perform(get("/rating/get")
                .param("bookID", "6")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("Rating Not Found", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void addRatingSuccess() throws Exception {
        mockMvc.perform(post("/rating/add")
                .param("bookID", "2")
                .param("rating", "3")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @Transactional
    void addRatingBookNotFound() throws Exception {
        MvcResult res = mockMvc.perform(post("/rating/add")
                .param("bookID", "0")
                .param("rating", "3")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("Book Not Found", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void addRatingRatingInvalid() throws Exception {
        MvcResult res = mockMvc.perform(post("/rating/add")
                .param("bookID", "2")
                .param("rating", "6")
        ).andDo(print()).andExpect(status().isBadRequest()).andReturn();
        assertEquals("Rating should be from 0 to 5 inclusively", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void deleteRatingSuccess() throws Exception {
        MvcResult res = mockMvc.perform(delete("/rating/delete")
                .param("ratingID", "1")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("Deleted", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void deleteRatingNotFound() throws Exception {
        MvcResult res = mockMvc.perform(delete("/rating/delete")
                .param("ratingID", "0")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("RatingID Not Found", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void updateRatingSuccess() throws Exception {
        MvcResult res = mockMvc.perform(put("/rating/update")
                .param("ratingID", "1")
                .param("rating", "5")
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        assertEquals("Updated", res.getResponse().getContentAsString());
    }

    @Test
    @Transactional
    void updateRatingNotFound() throws Exception {
        MvcResult res = mockMvc.perform(put("/rating/update")
                .param("ratingID", "0")
                .param("rating", "5")
        ).andDo(print()).andExpect(status().isNotFound()).andReturn();
        assertEquals("RatingID Not Found", res.getResponse().getContentAsString());
    }
}