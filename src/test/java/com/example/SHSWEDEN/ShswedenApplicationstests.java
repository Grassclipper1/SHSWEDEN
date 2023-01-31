package com.example.SHSWEDEN;

import com.example.SHSWEDEN.Repos.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ShswedenApplicationstests {

@Autowired
 UserRepository repository;

  @Autowired
   MockMvc mvc;

  @Autowired
   ObjectMapper mapper;

  //Integration Test

   @Test
  public void contextLoads() {
   }
  @Test
   public void TestGoToMainpage() throws Exception {
       mvc.perform(
                       MockMvcRequestBuilders.get("/")
              )
               .andExpect(status().is2xxSuccessful())
               .andExpect(MockMvcResultMatchers.content().string(containsString("Välkommen till Second Circle")));
    }

   @Test
   public void TestGoToCreateUser() throws Exception {
       mvc.perform(
                        MockMvcRequestBuilders.get("/signup"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(model().attribute("user", notNullValue()))
               .andExpect(MockMvcResultMatchers.content().string(containsString("Förnamn")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Efternamn")))
               .andExpect(MockMvcResultMatchers.content().string(containsString("Användarnamn")))
               .andExpect(MockMvcResultMatchers.content().string(containsString("Adress")));
   }
}