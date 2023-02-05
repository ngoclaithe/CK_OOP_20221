package scrap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import allc.festival;

public class scrapFestival {
	public ArrayList<festival> list;
	public void saveJson() throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    FileWriter fileWriter1 = new FileWriter("Data\\Festival.json");
	    gson.toJson(list,fileWriter1);
	    fileWriter1.close();
	}
	
	public void run() throws IOException {
		
    	ArrayList<festival> list=new ArrayList<>();        
        Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam").get();
        Elements elements=doc.getElementsByClass("mw-parser-output");        
        Elements elements2 = elements.select("table.prettytable.wikitable");
        Elements tableRowElements = elements2.select("tbody tr");
   		for (int i = 1; i < tableRowElements.size(); i++) {
        	
            Element row = tableRowElements.get(i);
            
            Elements rowItems = row.select("td");

            for (int j = 0; j < rowItems.size()-5; j++) {
            	festival item=new festival();
            	item.setTime(rowItems.get(0).text());
            	item.setPlace(rowItems.get(1).text());
            	item.setName(rowItems.get(2).text());            	
            	item.setHistoryfi(rowItems.get(4).text());
            	list.add(item);
              
            }
            
        }
   		this.list=list;
   		}
	public static void main(String[] args) throws IOException {
		scrapFestival scrapFestival = new scrapFestival();
		scrapFestival.run();
		scrapFestival.saveJson();
		
	}

}
