package in.snuglog.api.controller;

import in.snuglog.api.request.PostCreate;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(PostController.class);

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

    @PostMapping("/v1/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate postCreate,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            FieldError firstFieldError = fieldErrors.getFirst();
            String fieldName = firstFieldError.getField();
            String errorMessage = firstFieldError.getDefaultMessage();

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }
        logger.info("params : {}", postCreate);
        return Map.of();
    }
}