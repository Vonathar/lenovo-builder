package uk.caputo.lenovo.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * A class used to parse and replace placeholder tokens from a blueprint.
 * <p>
 * A global placeholder token is distinguished by a dollar sign ($), while
 * tokens that are different in mobile are marked by a capital "M".
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
    markup = replaceGlobalTokens(markup, settings);
    markup = replaceMobileTokens(markup, settings);
    return markup;
  }

  /**
   * Replaces all global tokens with the corresponding value from settings.
   *
   * @param markup   the HTML blueprint with tokens.
   * @param settings the component settings.
   * @return The HTML markup with global tokens populated.
   */
  private String replaceGlobalTokens(String markup, Settings settings) {
    return markup
        .replace("$wrapperClassName", settings.getWrapperClassName())
        .replace("$primaryFontSize", settings.getPrimaryFontSize())
        .replace("$secondaryFontSize", settings.getSecondaryFontSize())
        .replace("$backgroundStyles", buildBackgroundStyles(settings));
  }

  /**
   * Replaces all mobile tokens with the corresponding value from settings.
   *
   * @param markup   the HTML blueprint with tokens.
   * @param settings the component settings.
   * @return The HTML markup with mobile tokens populated.
   */
  private String replaceMobileTokens(String markup, Settings settings) {
    return markup
        .replace("M_primaryFontSize",
            getMobileSize(settings.getPrimaryFontSize()))
        .replace("M_secondaryFontSize",
            getMobileSize(settings.getSecondaryFontSize()));
  }

  /**
   * Converts a given size to its mobile equivalent.
   * <p>
   * A mobile size is calculated by halving the original value. The unit of
   * measurement of the original size is preserved in the mobile one.
   *
   * @param originalSize the size from which the mobile one is calculated.
   * @return The mobile size, inclusive of the original unit of measurement.
   */
  private String getMobileSize(String originalSize) {
    Pattern pattern = Pattern.compile("(\\d+)(.+)");
    Matcher matcher = pattern.matcher(originalSize);
    String mobileSize = null;

    if (matcher.matches()) {
      String unit = matcher.group(2);
      String value = matcher.group(1);
      mobileSize = (Integer.parseInt(value) / 2) + unit;
    }
    return mobileSize;
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