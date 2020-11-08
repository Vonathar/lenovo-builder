package uk.caputo.lenovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.caputo.lenovo.components.HtmlComponent;
import uk.caputo.lenovo.components.HtmlComponentSettings;
import uk.caputo.lenovo.components.HtmlComponentStyles;
import uk.caputo.lenovo.components.SettingsParser;
import uk.caputo.lenovo.util.BlueprintReader;

@Configuration
public class AppConfig {

  @Bean
  @Scope("prototype")
  HtmlComponent htmlComponent() {
    return new HtmlComponent();
  }

  @Bean
  SettingsParser settingsParser() {
    return new SettingsParser();
  }

  @Bean
  HtmlComponentSettings htmlComponentSettings() {
    return new HtmlComponentSettings();
  }

  @Bean
  @Scope("prototype")
  HtmlComponentStyles htmlComponentStyles() {
    return new HtmlComponentStyles();
  }

  @Bean
  BlueprintReader blueprintReader() {
    return new BlueprintReader();
  }
}
