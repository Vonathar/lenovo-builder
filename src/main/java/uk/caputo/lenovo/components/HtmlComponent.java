package uk.caputo.lenovo.components;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import uk.caputo.lenovo.util.BlueprintReader;

/**
 * A component that represents a customisable HTML component.
 * <p>
 * The components are built from a generic blueprint, located in the /resources
 * directory. Before the HTML markup can be built, the class requires a valid
 * HtmlComponentSettings object that holds all the necessary configuration
 * variables in a Map, which is part of the RequestBody in the controller.
 *
 * @author Gianmarco Caputo
 */
public class HtmlComponent {

  @Autowired
  private BlueprintReader blueprintReader;
  @Autowired
  private HtmlComponentSettings settings;
  private String htmlMarkup;

  public HtmlComponent() {
  }

  /**
   * Builds and returns the HTML markup for the component.
   *
   * @return the built HTML markup.
   */
  public String getHtmlMarkup() {
    loadBlueprint();
    return htmlMarkup;
  }

  private void setHtmlMarkup(String htmlMarkup) {
    this.htmlMarkup = htmlMarkup;
  }

  /**
   * Initialises htmlMarkup with a generic blueprint of the component type.
   */
  private void loadBlueprint() {
    setHtmlMarkup(blueprintReader.getContent(this.settings.getType()));
  }

  /**
   * Builds the settings for the component using the key:value pairs received in
   * the body of the request.
   *
   * @param requestedSettings the key:value pairs for the component settings.
   */
  public void setSettings(Map<String, String> requestedSettings) {
    settings.buildSettings(requestedSettings);
  }
}