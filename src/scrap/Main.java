package scrap;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.sun.tools.javac.util.List;

import allc.hisfigu;
import sun.net.www.URLConnection;
 
 
public class Main {
	public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
          longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
        /* // If you have StringUtils, you can use it to calculate the edit distance:
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) /
                                   (double) longerLength; */
        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;

      }

      // Example implementation of the Levenshtein Edit Distance
      // See http://rosettacode.org/wiki/Levenshtein_distance#Java
      public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
          int lastValue = i;
          for (int j = 0; j <= s2.length(); j++) {
            if (i == 0)
              costs[j] = j;
            else {
              if (j > 0) {
                int newValue = costs[j - 1];
                if (s1.charAt(i - 1) != s2.charAt(j - 1))
                  newValue = Math.min(Math.min(newValue, lastValue),
                      costs[j]) + 1;
                costs[j - 1] = lastValue;
                lastValue = newValue;
              }
            }
          }
          if (i > 0)
            costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
      }


      public static void printSimilarity(String s, String t) {
            System.out.println(String.format(
              "%.3f is the similarity between \"%s\" and \"%s\"", similarity(s, t), s, t));
          }

    public static void main(String[] args) throws IOException {
    	String s="Vua Hungg Vuong ten gi";
    	String t ="Hung Due Vuong";
    	printSimilarity(s, t);
    	
//    	scrapEventhistory scrapEventhistory = new scrapEventhistory();
//    	scrapEventhistory.run();
//    	scrapHistoricalplace scrapHistoricalplace = new scrapHistoricalplace();
//    	scrapHistoricalplace.run();
//    	scrapHistoryfi scrapHistoryfi = new scrapHistoryfi();
//		scrapHistoryfi.run();
//		scrapFestival scrapFestival = new scrapFestival();
//		scrapFestival.run();    
//    	deleteJson deleteJson=new deleteJson();
//    	deleteJson.run();
    	
    	

   
    }
    
}    
    
