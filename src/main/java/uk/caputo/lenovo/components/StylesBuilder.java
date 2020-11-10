package uk.caputo.lenovo.components;

import org.springframework.stereotype.Component;

/**
 * A class used to parse and replace placeholder token from a blueprint. A
 * placeholder token is distinguished by a dollar sign ($).
 *
 * @author Gianmarco Caputo
 */
@Component
public class StylesBuilder {

  /**
   * Replaces all placeholder tokens from the component's blueprint with values
   * from the Settings object.
   *
   * @return The HTML markup with populated tokens.
   */
  public String replaceTokens(String markup, Settings settings) {
    return markup
        .replace("$wrapperClassName", settings.getWrapperClassName())
        .replace("$primaryFontSize", settings.getPrimaryFontSize())
        .replace("$secondaryFontSize", settings.getSecondaryFontSize());
  }
}