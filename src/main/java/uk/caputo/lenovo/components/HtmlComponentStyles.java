package uk.caputo.lenovo.components;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * An object that represents the CSS declarations for an HTML component.
 *
 * @author Gianmarco Caputo
 */
public class HtmlComponentStyles {

  @Autowired
  HtmlComponentSettings settings;

  /**
   * Replaces all placeholder tokens from the component's blueprint.
   *
   * @param html the HTML blueprint with placeholder tokens
   * @return the HTML markup with the given settings instead of the tokens.
   */
  public String build(String html) {
    return html.replace("$wrapperClassName", settings.getWrapperClassName())
        .replace("$primaryFontSize", settings.getPrimaryFontSize())
        .replace("$secondaryFontSize", settings.getSecondaryFontSize());
  }

}
