package com.ezgroceries.shoppinglist.unitTests;


import com.ezgroceries.shoppinglist.controllers.CocktailsController;
import com.ezgroceries.shoppinglist.model.Cocktails;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Cocktails coctail = new Cocktails("testCocktail1","normal","pour and drink","", new String[]{"salt","gin"});
        List<Cocktails> cocktails = Arrays.asList(coctail);

        Mockito.when(cocktailService.getAllCocktails()).thenReturn(cocktails);

        mockMvc.perform(get("/getCocktails"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("testCocktail1")));

    }

    @Test
    public void testCocktails() throws Exception {
        Cocktails coctail = new Cocktails("testCocktail1","normal","pour and drink","", new String[]{"salt","gin"});
        Set<Cocktails> cocktails = new HashSet<Cocktails>();
        cocktails.add(coctail);

        Mockito.when(cocktailService.getCocktailsListByNameLike("test")).thenReturn(cocktails);

        mockMvc.perform(get("/cocktails").param("search", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("testCocktail1")));

    }



}
