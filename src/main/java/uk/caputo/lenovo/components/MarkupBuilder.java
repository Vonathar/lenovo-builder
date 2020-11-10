package uk.caputo.lenovo.components;

import org.springframework.stereotype.Component;
import uk.caputo.lenovo.util.BlueprintReader;

/**
 * A class used to build the HTML markup for a component.
 * <p>
 * The initial markup is loaded from generic blueprints, located in the
 * /resources directory; once the blueprint is loaded, the various tokens are
 * dynamically populated with the settings received in the request body.
 */
@Component
public class MarkupBuilder {

  private final BlueprintReader blueprintReader;
  private final StylesBuilder stylesBuilder;
  private final SettingsBuilder settingsBuilder;

  public MarkupBuilder(BlueprintReader blueprintReader,
      StylesBuilder stylesBuilder, SettingsBuilder settingsBuilder) {
    this.blueprintReader = blueprintReader;
    this.stylesBuilder = stylesBuilder;
    this.settingsBuilder = settingsBuilder;
  }

  /**
   * Builds and returns the HTML markup of the component.
   * <p>
   * It instantiates a new Settings object, then gets a blueprint for its type.
   * Once the blueprint loads, it replaces its placeholder tokens with the
   * values of the fields in the Settings object.
   *
   * @return the HTML markup of the component.
   */
  public String getMarkup() {
    Settings settings = settingsBuilder.build();
    String markup = blueprintReader.loadBlueprint(settings.getType());
    markup = stylesBuilder.replaceTokens(markup, settings);
    return markup;
  }
}
