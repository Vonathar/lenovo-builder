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
   * @param markup   the HTML blueprint with tokens.
   * @param settings the component settings.
   * @return The HTML markup with populated tokens.
   */
  public String replaceTokens(String markup, Settings settings) {
    return markup
        .replace("$wrapperClassName", settings.getWrapperClassName())
        .replace("$primaryFontSize", settings.getPrimaryFontSize())
        .replace("$secondaryFontSize", settings.getSecondaryFontSize())
        .replace("$backgroundStyles", buildBackgroundStyles(settings));
  }

  /**
   * Builds the CSS declaration for the component background. The background
   * image is used if available, or the background colour as a fallback.
   *
   * @param settings the component settings.
   * @return The CSS declaration for the background style.
   */
  private String buildBackgroundStyles(Settings settings) {
    if (settings.getBackgroundImageUrl() != null) {
      return String.format("background-image: url(\"%s\")",
          settings.getBackgroundImageUrl());
    } else {
      return String
          .format("background-color: %s", settings.getBackgroundColour());
    }
  }
}