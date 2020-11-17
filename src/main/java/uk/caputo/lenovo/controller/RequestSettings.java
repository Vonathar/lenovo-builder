package uk.caputo.lenovo.controller;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RequestSettings extends HashMap<String, String> {

  /**
   * Calls the inherited get method after ensuring that the key exists in the
   * RequestSettings. If the key is not found, the request is terminated with a
   * 422 status.
   *
   * @param key the key of the requested value.
   * @return the value found for the given key.
   * @throws ResponseStatusException a 422 status when the key is missing.
   */
  @Override
  public String get(Object key) {
    if (super.containsKey(key)) {
      return super.get(key);
    } else {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
          "Request body is missing required value: " + key);
    }
  }
}
