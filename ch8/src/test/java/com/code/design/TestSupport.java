package com.code.design;

import io.micrometer.core.instrument.util.IOUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSupport {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @BeforeEach
    void setUp(
        final WebApplicationContext context
    ) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .alwaysDo(MockMvcResultHandlers.print())
            .build();
    }

    protected String readJson(final String path) throws IOException {
        return IOUtils.toString(resourceLoader.getResource("classpath:" + path).getInputStream(),
            StandardCharsets.UTF_8);
    }
}
