package uk.caputo.lenovo.components;

import org.springframework.stereotype.Component;
import uk.caputo.lenovo.ComponentType;

/**
 * A class that acts as a builder for the Settings object.
 * <p>
 * It exposes setters to update all fields, as well as a build method to
 * construct and return the new Settings object.
 *
 * @author Gianmarco Caputo
 */
@Component
public class SettingsBuilder {

  private final SettingsValidator settingsValidator;
  private ComponentType type;
  private String wrapperClassName;
  private String primaryFontSize;
  private String secondaryFontSize;
  private String backgroundColour;
  private String backgroundImageUrl;

  public SettingsBuilder(
      SettingsValidator settingsValidator) {
    this.settingsValidator = settingsValidator;
  }

  public SettingsBuilder setType(ComponentType type) {
    this.type = type;
    return this;
  }

  public SettingsBuilder setWrapperClassName(String wrapperClassName) {
    this.wrapperClassName = wrapperClassName;
    return this;
  }

  public SettingsBuilder setPrimaryFontSize(String primaryFontSize) {
    this.primaryFontSize = primaryFontSize;
    return this;
  }

  public SettingsBuilder setSecondaryFontSize(
      String secondaryFontSize) {
    this.secondaryFontSize = secondaryFontSize;
    return this;
  }

  public SettingsBuilder setBackgroundColour(String backgroundColour) {
    this.backgroundColour = backgroundColour;
    return this;
  }

  public SettingsBuilder setBackgroundImageUrl(String backgroundImageUrl) {
    this.backgroundImageUrl = backgroundImageUrl;
    return this;
  }

  /**
   * Instantiates, validates and returns a new Settings object.
   *
   * @return an instance of the Settings object.
   */
  public Settings build() {
    Settings settings = new Settings(type, wrapperClassName, primaryFontSize,
        secondaryFontSize, backgroundColour, backgroundImageUrl);
    settingsValidator.validate(settings);
    return settings;
  }
}