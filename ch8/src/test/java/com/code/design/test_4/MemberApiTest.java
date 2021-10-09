package com.code.design.test_4;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class MemberApiTest extends IntegrationTestSupport {

    @Test
    void 회원가입_테스트_json_관리의_불편() throws Exception {
        this.mockMvc.perform(
                post("/members")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n"
                        + "  \"name\": \"yun\"\n"
                        + "}")
            )
            .andExpect(status().isOk());
    }

    @Test
    void 회원가입_테스트_객체기반으로_생성해야하는_단점_테스트_코드에서_밖에_사용_하지_않은_코드() throws Exception {
//        final String requestBody = objectMapper.writeValueAsString(new SignUpRequest("yun"));
//        this.mockMvc.perform(
//                post("/members")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(requestBody)
//            )
//            .andExpect(status().isOk());
    }

    @Test
    public void 회원가입_테스트() throws Exception {
        final String requestBody = readJson("/member-signup.json");
        this.mockMvc.perform(
                post("/members")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
            )
            .andExpect(status().isOk());
    }
}