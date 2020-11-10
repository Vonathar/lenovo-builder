package uk.caputo.lenovo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.caputo.lenovo.components.MarkupBuilder;
import uk.caputo.lenovo.components.SettingsParser;

/**
 * A RestController that intercepts all requests to the "/components" endpoint.
 * The request body is expected to include the JSON settings used to create a
 * Settings POJO using the builder pattern.
 *
 * @author Gianmarco Caputo
 */
@RestController
public class ComponentController {

  private final SettingsParser settingsParser;
  private final MarkupBuilder markupBuilder;

  public ComponentController(
      SettingsParser settingsParser, MarkupBuilder markupBuilder) {
    this.settingsParser = settingsParser;
    this.markupBuilder = markupBuilder;
  }

  /**
   * Parses all settings from the request body, then builds and returns the HTML
   * markup for the requested component.
   *
   * @param reqSettings a Map built from the deserialized JSON request.
   * @return the complete HTML markup for the component.
   */
  @PostMapping("/components")
  public String getComponent(@RequestBody RequestSettings reqSettings) {
    settingsParser.parse(reqSettings);
    return markupBuilder.getMarkup();
  }
}
