package uk.caputo.lenovo.components;

import org.springframework.stereotype.Component;
import uk.caputo.lenovo.ComponentType;
import uk.caputo.lenovo.controller.RequestSettings;

/**
 * A class used to parse all entries from a RequestSettings Map. All settings
 * parsed are used to directly call the setters in SettingsBuilder, preparing it
 * to instantiate a Settings object.
 *
 * @author Gianmarco Caputo
 */
@Component
public class SettingsParser {

  private final SettingsBuilder settingsBuilder;

  public SettingsParser(
      SettingsBuilder settingsBuilder) {
    this.settingsBuilder = settingsBuilder;
  }

  /**
   * Parses all entries from a RequestSettings Map, then updates the
   * corresponding fields in SettingsBuilder. Uses a default value for optional
   * fields which were not found in the RequestSettings.
   *
   * @param reqSettings the build settings for the component.
   */
  public void parse(RequestSettings reqSettings) {
    settingsBuilder.setType(ComponentType.from(reqSettings.get("type")))
        .setWrapperClassName(
            reqSettings.getOrDefault("wrapperClassName", "sec"))
        .setPrimaryFontSize(
            reqSettings.getOrDefault("primaryFontSize", "64px"))
        .setSecondaryFontSize(
            reqSettings.getOrDefault("secondaryFontSize", "20px"))
        .setBackgroundColour(
            reqSettings.getOrDefault("backgroundColour", "#FFFFFF"))
        .setBackgroundImageUrl(
            reqSettings.getOrDefault("backgroundImageUrl", null));
  }
}