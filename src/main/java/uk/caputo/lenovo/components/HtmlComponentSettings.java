package uk.caputo.lenovo.components;

import java.util.Map;
import uk.caputo.lenovo.ComponentType;

/**
 * An object that represents all the available settings for an HTML component.
 *
 * @author Gianmarco Caputo
 */
public class HtmlComponentSettings {

  private ComponentType type;

  public HtmlComponentSettings() {

  }

  /**
   * Populates all available settings using the values from a Map.
   *
   * @param settings the key:value pairs for component settings.
   */
  public void buildSettings(Map<String, String> settings) {
    this.type = ComponentType.from(settings.get("type"));
  }

  public ComponentType getType() {
    return type;
  }

}