package uk.caputo.lenovo.util;

import java.io.File;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import uk.caputo.lenovo.ComponentType;

/**
 * A class used to read HTML files from resources.
 * <p>
 * All HTML blueprints must be located in the /html directory of resources, and
 * must have the lowercase ComponentType as filename.
 *
 * @author Gianmarco Caputo
 */
@Component
public class BlueprintReader {

  /**
   * Returns the blueprint for a given ComponentType.
   */
  public String loadBlueprint(ComponentType type) {
    String fileName = type.toString().toLowerCase();
    StringBuilder blueprint = new StringBuilder();
    try {
      File templateFile = new File(
          String.format("src/main/resources/html/%s.html", fileName));
      Scanner scanner = new Scanner(templateFile);
      while (scanner.hasNextLine()) {
        blueprint.append(scanner.nextLine());
      }
    } catch (Exception e) {
      System.out.println("Error while parsing HTML blueprint: " + e);
    }
    return blueprint.toString();
  }
}