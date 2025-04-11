package in.snuglog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    /**
     * ssr -> jsp, thymeleaf, mustache, freemarker
     *      // -> html rendering
     * spa ->
     *      vue -> vue+SSR = nuxt.js
     *      react -> react+SSR = next.js
     *      //-> javascript <-> API(JSON)
     * ============================================
     * GET, POST, PUT, DELETE, PATCH, OPTIONS, HEAD, TRACE, CONNECT
     *
     */

    /**
     * 글 등록
     *
     * @return
     */
//    @PostMapping("/v1/posts")

    @GetMapping("/v1/posts")
    public String get() {
        return "Hello World";
    }
}