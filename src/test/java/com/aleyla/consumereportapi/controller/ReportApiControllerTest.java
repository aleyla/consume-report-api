package com.aleyla.consumereportapi.controller;

import com.aleyla.consumereportapi.model.entity.UserEntity;
import com.aleyla.consumereportapi.enums.Role;
import com.aleyla.consumereportapi.repository.transaction.TransactionRepository;
import com.aleyla.consumereportapi.model.request.ClientInfoRequest;
import com.aleyla.consumereportapi.model.request.LoginRequest;
import com.aleyla.consumereportapi.security.jwt.TokenCreator;
import com.aleyla.consumereportapi.util.Constants;
import com.aleyla.consumereportapi.service.TransactionService;
import com.aleyla.consumereportapi.util.DBInitializerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReportApiControllerTest {

    public static final String PASSWORD = "12345";
    public static final String TEST_MAIL_COM = "test@mail.com";

    @Autowired
    TransactionService transactionService;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    TokenCreator tokenCreator;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    DBInitializerUtil initializerUtil;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    public void setup() {
        ReportApiController transactionResource = new ReportApiController(transactionService, authenticationManagerBuilder, tokenCreator);
        this.mockMvc = MockMvcBuilders.standaloneSetup(transactionResource)
                                      .setCustomArgumentResolvers(pageableArgumentResolver).build();
    }

    @BeforeEach
    public void initDefaultUser() {
        UserEntity test = new UserEntity();
        test.setId(1L);
        test.setPassword(initializerUtil.getPassword(PASSWORD));
        test.setEmail(TEST_MAIL_COM);
        test.setRole(Role.ADMIN);
        initializerUtil.saveUser(test);
    }


    @Test
    public void can_login() throws Exception {

        MvcResult mvcLogin = mockMvc.perform(post("/api/v3/merchant/user/login")
                                                     .contentType(MediaType.APPLICATION_JSON)
                                                     .content(new ObjectMapper().writeValueAsString(new LoginRequest(TEST_MAIL_COM, PASSWORD))))
                                    .andExpect(status().isOk()).andReturn();

        String token = mvcLogin.getResponse().getHeader(Constants.AUTHORIZATION_HEADER);

        assertThat(token).contains(Constants.AUTHORIZATION_KEY);
    }

    @Test
    void can_not_login_un_valid_email() throws Exception {
        mockMvc.perform(post("/api/v3/merchant/user/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(new LoginRequest("mail", "123"))))
               .andExpect(status().isBadRequest()).andReturn();

    }

    @Test
    void can_not_request_without_token() throws Exception {
        mockMvc.perform(post("/api/v3/client")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(new ClientInfoRequest())))
               .andExpect(status().isBadRequest()).andReturn();

    }
}