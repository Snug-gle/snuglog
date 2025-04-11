package in.snuglog.api.controller;

import in.snuglog.api.request.PostCreate;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    @PostMapping("/v1/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate postCreate) {
        log.info("params : {}", postCreate);
        return Map.of();
    }
}