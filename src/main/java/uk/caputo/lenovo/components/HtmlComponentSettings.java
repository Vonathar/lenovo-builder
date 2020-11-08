package uk.caputo.lenovo.components;

import java.net.URL;
import uk.caputo.lenovo.ComponentType;

/**
 * A class that represents the available settings of a component. All settings
 * are injected by SettingsParser during runtime.
 *
 * @author Gianmarco Caputo
 */
public class HtmlComponentSettings {

  private ComponentType type;
  private String wrapperClassName;
  private String primaryFontSize;
  private String secondaryFontSize;
  private String backgroundColour;
  private URL backgroundImageUrl;

  public String getSecondaryFontSize() {
    return secondaryFontSize;
  }

  public void setSecondaryFontSize(String secondaryFontSize) {
    this.secondaryFontSize = secondaryFontSize;
  }

  public ComponentType getType() {
    return type;
  }

  public void setType(ComponentType type) {
    this.type = type;
  }

  public String getWrapperClassName() {
    return wrapperClassName;
  }

  public void setWrapperClassName(String wrapperClassName) {
    this.wrapperClassName = wrapperClassName;
  }

  public String getPrimaryFontSize() {
    return primaryFontSize;
  }

  public void setPrimaryFontSize(String primaryFontSize) {
    this.primaryFontSize = primaryFontSize;
  }

  public URL getBackgroundImageUrl() {
    return backgroundImageUrl;
  }

  public void setBackgroundImageUrl(URL backgroundImageUrl) {
    this.backgroundImageUrl = backgroundImageUrl;
  }

  public String getBackgroundColour() {
    return backgroundColour;
  }

  public void setBackgroundColour(String backgroundColour) {
    this.backgroundColour = backgroundColour;
  }
}
