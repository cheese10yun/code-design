package com.code.design.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MemberApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void signUp_test_이메일이_중복_아닌_경우() throws Exception {
        //given
        final SignUpRequest dto = new SignUpRequest("asd@asd.com");

        //when
        final ResultActions resultActions = requestSignUp(dto);

        //then
        resultActions
            .andExpect(status().isOk());
    }

    @Test
    public void signUp_test_이메일이_형식_아닌_경우() throws Exception {
        //given
        final SignUpRequest dto = new SignUpRequest("asdasd.com");

        //when
        final ResultActions resultActions = requestSignUp(dto);

        //then
        resultActions
            .andExpect(status().isBadRequest());
    }

    @Test
    public void signUp_test_이메일이_중복된_경우() throws Exception {
        //given
        final String email = "yun@test.com";
        memberRepository.save(new Member(email));
        final SignUpRequest dto = new SignUpRequest(email);

        //when
        final ResultActions resultActions = requestSignUp(dto);

        //then
        resultActions
            .andExpect(status().isBadRequest());
    }

    private ResultActions requestSignUp(SignUpRequest dto) throws Exception {
        return mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andDo(print());
    }
}