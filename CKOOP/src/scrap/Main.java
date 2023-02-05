package scrap;
import java.io.BufferedReader;
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

import sun.net.www.URLConnection;
 
 
public class Main {


    public static void main(String[] args) throws IOException {
    	scrapEventhistory scrapEventhistory = new scrapEventhistory();
    	scrapEventhistory.run();
    	scrapHistoricalplace scrapHistoricalplace = new scrapHistoricalplace();
    	scrapHistoricalplace.run();
    	scrapHistoryfi scrapHistoryfi = new scrapHistoryfi();
		scrapHistoryfi.run();
		scrapFestival scrapFestival = new scrapFestival();
		scrapFestival.run();       

   
    }
    
}    
    
