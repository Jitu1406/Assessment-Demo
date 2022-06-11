package com.assessment.breeds.breedsdemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestWebApp extends BreedsDemoApplicationTests{

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testBreed(){
        try {

            mockMvc.perform(get("/")).andExpect(status().isOk())
                    .andExpect(jsonPath("$.breedId").isNotEmpty())
                    .andExpect(jsonPath("$.breedId").isString())
                    .andExpect(jsonPath("$.breedId").exists())
                    .andExpect(jsonPath("$.breedName").isNotEmpty())
                    .andExpect(jsonPath("$.breedName").isString())
                    .andExpect(jsonPath("$.breedName").exists())
                    .andExpect(jsonPath("$.breedGroup").isString())
                    .andExpect(jsonPath("$.breedGroup").exists())
                    .andExpect(jsonPath("$.weight").isNumber())
                    .andExpect(jsonPath("$.weight").exists());

            mockMvc.perform(get("/save/new-cat")).andExpect(status().isOk())
                    .andExpect(jsonPath("$.breedId").isNotEmpty())
                    .andExpect(jsonPath("$.breedId").isString())
                    .andExpect(jsonPath("$.breedId").exists())
                    .andExpect(jsonPath("$.breedName").isNotEmpty())
                    .andExpect(jsonPath("$.breedName").isString())
                    .andExpect(jsonPath("$.breedName").exists())
                    .andExpect(jsonPath("$.breedGroup").isNotEmpty())
                    .andExpect(jsonPath("$.breedGroup").isString())
                    .andExpect(jsonPath("$.breedGroup").exists())
                    .andExpect(jsonPath("$.weight").isNotEmpty())
                    .andExpect(jsonPath("$.weight").isNumber())
                    .andExpect(jsonPath("$.weight").exists());

            mockMvc.perform(get("/deleteCat")).andExpect(status().isOk())
                    .andExpect(jsonPath("$.breedId").isNotEmpty())
                    .andExpect(jsonPath("$.breedId").isString())
                    .andExpect(jsonPath("$.breedId").exists());

            mockMvc.perform(get("/cat")).andExpect(status().isOk())
                    .andExpect(jsonPath("$.breedId").isNotEmpty())
                    .andExpect(jsonPath("$.breedId").isString())
                    .andExpect(jsonPath("$.breedId").isString())
                    .andExpect(jsonPath("$.breedId").exists());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
