package com.ppk.problems;

import java.util.HashMap;
import java.util.Map;

public class MapLookUpWithStringManipulation {

	static Map<String, String> translations = new HashMap<>();
    static {
        translations.put("en",                 "Red Color Flyknit");
        translations.put("en_GB",              "Red Colour Flyknit");

        translations.put("fr",                 "Couleur Rouge Flyknit");
        translations.put("fr_FR",              "France Rouge Flyknit");
        translations.put("fr_FR_paris",        "France Bleue Flyknit");
        translations.put("fr_FR_paris_louvre", "Louvre France Bleue Flyknit");
    }

    public static String getTranslation(String locale) {
        // Complete this function to return the proper translation
      if(translations.containsKey(locale))
          return translations.get(locale);
      
      int tokenSize = locale.split("_").length;
      String token = locale;
      for(int i = 0; i < tokenSize - 1; i++){
      
        token = token.substring(0, token.lastIndexOf("_"));
        if(translations.containsKey(token))
          return translations.get(token);
        
      }
      
      return null;
    }

    public static void main(String[] args) {
//
        assertEquals("Red Color Flyknit", getTranslation("en"));
        assertEquals("Red Colour Flyknit", getTranslation("en_GB"));
        assertEquals("France Bleue Flyknit", getTranslation("fr_FR_paris"));
        assertEquals("Louvre France Bleue Flyknit",   getTranslation("fr_FR_paris_louvre"));
        assertEquals(null, getTranslation("de_DE"));

        assertEquals("Red Color Flyknit", getTranslation("en_US"));
        assertEquals("Couleur Rouge Flyknit", getTranslation("fr_CA"));
        assertEquals("France Rouge Flyknit", getTranslation("fr_FR_lyon"));
        assertEquals("Red Colour Flyknit", getTranslation("en_GB_london_soho"));

    }

    // Can ignore this piece - just for some output
    public static void assertEquals(String expected, String actual) {
        boolean areEqual = (actual == null && expected == null)
                || (actual != null && actual.equals(expected));
        String output = String.format("%s == %s : %s", expected, actual, areEqual ? "SUCCESS" : "FAILURE");
        System.out.println(output);
    }

}
