package uk.caputo.lenovo.util;

import java.io.File;
import java.util.Scanner;
import uk.caputo.lenovo.ComponentType;

/**
 * A class used to read content stored in HTML files in the resources folder.
 *
 * @author Gianmarco Caputo
 */
public class BlueprintReader {

  public BlueprintReader() {
  }

  /**
   * Reads and returns the content of a given HTML file. All files should be
   * located in the /html directory in order to be found.
   *
   * @param type the type of the file to parse.
   * @return the HTML blueprint as it is in the file.
   */
  public String getContent(ComponentType type) {
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