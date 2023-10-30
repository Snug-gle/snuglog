package in.snuglog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/v1/posts")
    public String get() {
        return "Hello World";
    }
}