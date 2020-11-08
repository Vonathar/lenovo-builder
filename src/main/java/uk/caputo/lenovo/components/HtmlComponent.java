package uk.caputo.lenovo.components;

import org.springframework.beans.factory.annotation.Autowired;
import uk.caputo.lenovo.util.BlueprintReader;

/**
 * A class that represents a customisable HTML component.
 * <p>
 * The components are built from a generic blueprint, located in the /resources
 * directory. Before the HTML markup can be built, the class requires a valid
 * HtmlComponentSettings object with all the necessary configuration variables.
 *
 * @author Gianmarco Caputo
 */
public class HtmlComponent {

  @Autowired
  private BlueprintReader blueprintReader;
  @Autowired
  private HtmlComponentStyles styles;
  @Autowired
  private HtmlComponentSettings settings;
  private String htmlMarkup;

  /**
   * Builds and returns the HTML markup for the component.
   *
   * @return the built HTML markup.
   */
  public String getHtmlMarkup() {
    loadBlueprint();
    buildStyles();
    return htmlMarkup;
  }

  /**
   * Initialises htmlMarkup with a generic blueprint of the component type.
   */
  private void loadBlueprint() {
    setHtmlMarkup(blueprintReader.getContent(this.settings.getType()));
  }

  /**
   * Populates all template tokens in htmlMarkup with values from settings.
   */
  private void buildStyles() {
    setHtmlMarkup(styles.build(htmlMarkup));
  }

  private void setHtmlMarkup(String htmlMarkup) {
    this.htmlMarkup = htmlMarkup;
  }
}