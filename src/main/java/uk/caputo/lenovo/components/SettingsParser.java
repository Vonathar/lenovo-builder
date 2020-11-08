package uk.caputo.lenovo.components;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import uk.caputo.lenovo.ComponentType;

/**
 * An object that represents all the available settings for an HTML component.
 *
 * @author Gianmarco Caputo
 */
public class SettingsParser {

  @Autowired
  HtmlComponentSettings settings;

  /**
   * Builds a new formatted HashMap with all available settings parsed from a
   * Map. For optional settings, a default value is used when appropriate.
   *
   * @param reqSettings the key:value pairs for component settings.
   */
  public void parseSettings(Map<String, String> reqSettings) {

    settings.setType(ComponentType.from(reqSettings.get("type")));
    settings.setWrapperClassName(reqSettings.getOrDefault("wrapperClassName",
                                                          "sec"));
    settings.setPrimaryFontSize(reqSettings.getOrDefault("primaryFontSize",
                                                         "64px"));
    settings.setSecondaryFontSize(reqSettings.getOrDefault("secondaryFontSize",
                                                           "20px"));

    if (reqSettings.containsKey("backgroundImageUrl")) {
      try {
        settings.setBackgroundImageUrl(
            new URL(reqSettings.get("backgroundImageUrl")));
      } catch (MalformedURLException e) {
        System.out.println("Invalid URL received for backgroundImageUrl: "
                               + reqSettings.get("backgroundImageUrl"));
      }
    } else {
      settings.setBackgroundColour(reqSettings.getOrDefault("backgroundColour",
                                                            "#FFFFFF"));
    }

  }

}