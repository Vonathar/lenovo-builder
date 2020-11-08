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

  public String build(String html) {

    return html.replace("$wrapperClassName", settings.getWrapperClassName())
               .replace("$primaryFontSize", settings.getPrimaryFontSize())
               .replace("$secondaryFontSize", settings.getSecondaryFontSize());
  }

}
