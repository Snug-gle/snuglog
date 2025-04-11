package in.snuglog.api.common.error;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;

/**
 * ErrorResponse class represents the structure of an error response. It contains a code and a
 * message to provide information about the error.
 * <p>
 * { "code": "ERROR_CODE", "message": "Error message" "validation": { "title": "제목을 입력해주세요." } }
 */

public record ErrorResponse(
    String code,
    String message,
    Map<String, String> validation
) {

  public ErrorResponse(
      String code,
      String message
  ) {
    this(code, message, new HashMap<>());
  }

  public void addValidation(String field, String message) {
    this.validation.put(field, message);
  }
}
