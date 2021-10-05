package com.code.design.order;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestInstance(Lifecycle.PER_CLASS)
class OrderApiTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .addFilters(new CharacterEncodingFilter("UTF-8", true))
            .alwaysDo(print())
            .build();
    }

    @Test
    public void 무통장_결제_주문() throws Exception {
        final String requestBody = "{\n"
            + "  \"price\": 100.00,\n"
            + "  \"payment\": {\n"
            + "    \"paymentMethod\": \"BANK_TRANSFER\",\n"
            + "    \"account\": {\n"
            + "      \"number\": \"110-202034-2234\",\n"
            + "      \"bankCode\": \"2003\",\n"
            + "      \"holder\" : \"홍길동\"\n"
            + "    }\n"
            + "  },\n"
            + "  \"address\": {\n"
            + "    \"city\": \"NOWON-GU\",\n"
            + "    \"state\": \"SEOUL\",\n"
            + "    \"zipCode\": \"09876\"\n"
            + "  }\n"
            + "}";

        requestOrder(requestBody)
            .andExpect(status().isOk());
    }

    @Test
    public void 카드_결제_주문() throws Exception {
        final String requestBody = ""
            + "{\n"
            + "  \"price\": 100.00,\n"
            + "  \"payment\": {\n"
            + "    \"paymentMethod\": \"CARD\",\n"
            + "    \"card\": {\n"
            + "      \"number\": \"25523-22394\",\n"
            + "      \"brand\": \"삼성카드\",\n"
            + "      \"csv\" : \"322\"\n"
            + "    }\n"
            + "  },\n"
            + "  \"address\": {\n"
            + "    \"city\": \"NOWON-GU\",\n"
            + "    \"state\": \"SEOUL\",\n"
            + "    \"zipCode\": \"09876\"\n"
            + "  }\n"
            + "}";

        requestOrder(requestBody)
            .andExpect(status().isOk());
    }

    private ResultActions requestOrder(final String requestBody) throws Exception {
        return mockMvc.perform(
            post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        );
    }
}