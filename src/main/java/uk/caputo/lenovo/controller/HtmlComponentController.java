package uk.caputo.lenovo.controller;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.caputo.lenovo.components.HtmlComponent;
import uk.caputo.lenovo.config.AppConfig;

/**
 * A RestController that intercepts all requests to the "/components" endpoint.
 *
 * @author Gianmarco Caputo
 */
@RestController
public class HtmlComponentController {

  /**
   * Builds and return the HTML markup for the component. All the settings used
   * to build the component are passed in the request body.
   *
   * @param settings a Map built from the deserialized JSON.
   * @return the component's HTML markup, ready to be used.
   */
  @PostMapping("/components")
  public String getComponent(
      @RequestBody Map<String, String> settings) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfig.class);
    HtmlComponent component = (HtmlComponent) context.getBean("htmlComponent");
    component.setSettings(settings);
    return component.getHtmlMarkup();
  }
}
