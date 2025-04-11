package in.snuglog.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 Hello World를 출력한다.")
    void test() throws Exception {
        // 글 제목
        // 글 내용

        // expected
        // Content-Type(http 요청 주고 받을때)
        //      application/json
        //      x-www-form-urlencoded, text/html;charset=UTF-8

        mockMvc.perform(
                    get("/v1/posts")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andDo(print()
        );
    }
}