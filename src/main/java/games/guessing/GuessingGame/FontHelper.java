package games.guessing.GuessingGame;

import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;

/**
 * FontHelper
 */
public final class FontHelper {
  private static Map<String, String> availableFonts = new HashMap<String, String>();

  static {
    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    for (int i = 0; i < fonts.length; i++) {
      availableFonts.put(fonts[i], fonts[i]);
    }
  }

  private FontHelper() {
  }

  /***
   * Returns the fontName if available or SansSerif otherwise
   * @param fontNames
   * @return The first available font family name
   */
  public static String getFirstAvailableFontName(String... fontNames) {
    for (String fontName : fontNames) {
      if (availableFonts.containsKey(fontName)) {
        return availableFonts.get(fontName);
      }
    }

    return "SansSerif";
  }
}