package uk.caputo.lenovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.caputo.lenovo.components.HtmlComponent;
import uk.caputo.lenovo.components.HtmlComponentSettings;
import uk.caputo.lenovo.util.BlueprintReader;

@Configuration
public class AppConfig {

  @Bean
  @Scope("prototype")
  HtmlComponent htmlComponent() {
    return new HtmlComponent();
  }

  @Bean
  @Scope("prototype")
  HtmlComponentSettings htmlComponentSettings() {
    return new HtmlComponentSettings();
  }

  @Bean
  BlueprintReader blueprintReader() {
    return new BlueprintReader();
  }
}
