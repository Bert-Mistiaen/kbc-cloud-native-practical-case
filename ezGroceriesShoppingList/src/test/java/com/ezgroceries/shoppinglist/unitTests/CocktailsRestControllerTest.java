package com.ezgroceries.shoppinglist.unitTests;


import com.ezgroceries.shoppinglist.controllers.CocktailsController;
import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.internal.bytebuddy.implementation.FixedValue.value;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = CocktailsController.class)
public class CocktailsRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CocktailService cocktailService;

    @Test
    public void testGetCocktails() throws Exception {
        Cocktails cocktail = new Cocktails("testCocktail1","normal","pour and drink","", new String[]{"salt","gin"});
        List<Cocktails> cocktails = Arrays.asList(cocktail);

        Mockito.when(cocktailService.getAllCocktails()).thenReturn(cocktails);

        mockMvc.perform(get("/getCocktails"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", Matchers.is("testCocktail1")));
    }

    @Test
    public void testCocktails() throws Exception {
        Cocktails cocktail = new Cocktails("Russian Tequila","normal","pour and drink","", new String[]{"salt","gin"});
        Set<Cocktails> cocktails = new HashSet<>();
        cocktails.add(cocktail);

        given(cocktailService.getCocktailsOpenFeign("Russian")).willReturn(cocktails);

        mockMvc.perform(get("/cocktails")
                .param("search", "Russian")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(cocktail.getName()));

    }



}
