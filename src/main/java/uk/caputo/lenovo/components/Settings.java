package uk.caputo.lenovo.components;

import java.net.URL;
import uk.caputo.lenovo.ComponentType;

/**
 * A class that represents the build settings of a component.
 * <p>
 * This class is constructed by SettingsBuilder, and is not managed by Spring.
 * Only getters are exposed to enforce immutability.
 *
 * @author Gianmarco Caputo
 */
public class Settings {

  private final ComponentType type;
  private final String wrapperClassName;
  private final String primaryFontSize;
  private final String secondaryFontSize;
  private final String backgroundColour;
  private final URL backgroundImageUrl;

  public Settings(ComponentType type, String wrapperClassName,
      String primaryFontSize, String secondaryFontSize,
      String backgroundColour, URL backgroundImageUrl) {
    this.type = type;
    this.wrapperClassName = wrapperClassName;
    this.primaryFontSize = primaryFontSize;
    this.secondaryFontSize = secondaryFontSize;
    this.backgroundColour = backgroundColour;
    this.backgroundImageUrl = backgroundImageUrl;
  }

  public ComponentType getType() {
    return type;
  }

  public String getWrapperClassName() {
    return wrapperClassName;
  }

  public String getPrimaryFontSize() {
    return primaryFontSize;
  }

  public String getSecondaryFontSize() {
    return secondaryFontSize;
  }

  public String getBackgroundColour() {
    return backgroundColour;
  }

  public URL getBackgroundImageUrl() {
    return backgroundImageUrl;
  }

}