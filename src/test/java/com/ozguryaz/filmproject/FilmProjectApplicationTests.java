package com.ozguryaz.filmproject;

import com.ozguryaz.filmproject.service.IFilmService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FilmProjectApplicationTests {
    @Autowired
    IFilmService iFilmService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHello() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));

    }
    @Test
    public void deleteFilm() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/delete/{id}",2))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
