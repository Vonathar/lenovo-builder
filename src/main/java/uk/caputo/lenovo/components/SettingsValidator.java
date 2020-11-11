package uk.caputo.lenovo.components;

import java.net.URL;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * A class used to validate the fields in Settings. It exposes a single public
 * method that expects a built Settings object, and handles the validation
 * internally. Since certain types are expected to be present in multiple
 * fields, some of the validation methods accept an Array instead of a String.
 *
 * @author Gianmarco Caputo
 */
@Component
public class SettingsValidator {

  /**
   * Validates the syntax of multiple sizes.
   *
   * @param sizes the sizes to validate.
   * @throws ResponseStatusException a 422 status for illegal sizes.
   */
  private void validateSizes(String[] sizes) {
    String pattern = "\\d+(?>\\.?)\\d+(?>px|pt|%|vw|vh|rem|em)";
    for (String size : sizes) {
      if (!size.matches(pattern)) {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
            "Illegal size found: " + size);
      }
    }
  }

  /**
   * Validates the class name of the wrapper HTML tag.
   *
   * @param className the class name to validate.
   * @throws ResponseStatusException a 422 status for illegal class names.
   */
  private void validateWrapperClassName(String className) {
    String pattern = "^[^-][a-zA-Z0-9-]+$";
    if (!className.matches(pattern)) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
          "Illegal name for wrapper class found: " + className);
    }
  }

  /**
   * Validates the syntax of multiple colours.
   *
   * @param colours the colours to validate.
   * @throws ResponseStatusException a 422 status for illegal colours.
   */
  private void validateColours(String[] colours) {
    String pattern = "^(?>#(?>[a-zA-Z0-9]){6})|(?>rgb\\(\\d{0,3}(?>,\\s?\\d{0,3}){2}\\))$";
    for (String colour : colours) {
      if (!colour.matches(pattern)) {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
            "Illegal colour found: " + colour);
      }
    }
  }

  /**
   * Validates the syntax of a URL.
   *
   * @param url the URL to validate.
   * @throws ResponseStatusException a 422 status for illegal URLs.
   */
  private void validateUrl(String url) {
    if (url != null) {
      try {
        new URL(url).toURI();
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
            "Illegal URL found. Error: " + e.getMessage());
      }
    }
  }

  /**
   * Validates all fields in a Settings object.
   *
   * @param settings the Settings object to validate.
   */
  public void validate(Settings settings) {
    validateWrapperClassName(settings.getWrapperClassName());
    validateUrl(settings.getBackgroundImageUrl());
    validateSizes(new String[]{
        settings.getPrimaryFontSize(),
        settings.getSecondaryFontSize()});
    validateColours(new String[]{
        settings.getBackgroundColour()
    });
  }
}