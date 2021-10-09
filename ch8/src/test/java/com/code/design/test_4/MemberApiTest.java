package com.code.design.test_4;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class MemberApiTest extends IntegrationTestSupport {

    @Test
    public void 회원가입_테스트() throws Exception {
        this.mockMvc.perform(
                post("/members")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n"
                        + "  \"name\": \"yun\"\n"
                        + "}")
            )
            .andExpect(status().isOk());
    }
}