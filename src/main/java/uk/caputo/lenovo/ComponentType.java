package uk.caputo.lenovo;

/**
 * An Enum that represents the legal types of HTML components.
 *
 * @author Gianmarco Caputo
 */
public enum ComponentType {
  HEADER;

  /**
   * Converts a String to a ComponentType enum.
   *
   * @param type a legal ComponentType value.
   * @return the ComponentType enum equivalent of the given String.
   */
  public static ComponentType from(String type) {
    return ComponentType.valueOf(type.toUpperCase());
  }
}
