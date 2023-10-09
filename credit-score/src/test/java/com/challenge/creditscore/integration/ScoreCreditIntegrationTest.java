package com.challenge.creditscore.integration;

import com.challenge.creditscore.adapters.out.CreateScoreCreditAdapter;
import com.challenge.creditscore.adapters.out.FindUserByCpfAdapter;
import com.challenge.creditscore.adapters.out.repository.ScoreCreditRepository;
import com.challenge.creditscore.adapters.out.repository.entity.ScoreCreditEntity;
import com.challenge.creditscore.application.config.CreateScoreCreditConfig;
import com.challenge.creditscore.application.core.domain.User;
import com.challenge.creditscore.config.AbstractMongoDBTestContainerConfig;
import com.challenge.creditscore.utils.TestFileLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ScoreCreditIntegrationTest extends AbstractMongoDBTestContainerConfig {

    @Autowired
    private WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private ScoreCreditRepository scoreCreditRepository;
    @Autowired
    private CreateScoreCreditConfig createScoreCreditConfig;

    @Autowired
    private CreateScoreCreditAdapter createScoreCreditAdapter;


    @MockBean
    FindUserByCpfAdapter findUserByCpfAdapter;


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        scoreCreditRepository.deleteAll();
    }

    @Test
    public void given_ScoreCredit_whenCreateScoreCredit_thenReturnVoid() throws Exception {
        TestFileLoader testFileLoader = new TestFileLoader();
        testFileLoader.setBaseDirectory("/complete_scenarios/create/");
        testFileLoader.setObjectMapper(objectMapper);
        String content = testFileLoader.loadString("score_credit_request.json");


        MockHttpServletRequestBuilder result = MockMvcRequestBuilders.post("/api/v1/scores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions response = mockMvc.perform(result);

        response.andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void given_GenerateScoreCredit_thenReturnScore() throws Exception {

        TestFileLoader testFileLoader = new TestFileLoader();

        testFileLoader.setObjectMapper(objectMapper);

        ScoreCreditEntity scoreCreditEntity = testFileLoader.loadObject("/complete_scenarios/create/score_credit_entity.json", ScoreCreditEntity.class);
        scoreCreditRepository.save(scoreCreditEntity);
        User user = testFileLoader.loadObject("/complete_scenarios/find/find_user_critical_data.json", User.class);
        String cpf = "1234567890";
        given(findUserByCpfAdapter.find(cpf)).willReturn(user);


        ResultActions response = mockMvc.perform(get("/api/v1/scores?".concat("cpf=" + cpf)).accept(MediaType.APPLICATION_JSON));


        response.andExpect(status().isOk())
                .andDo(print());



    }
}
