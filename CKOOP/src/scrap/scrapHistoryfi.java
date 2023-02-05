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


import allc.hisfigu;

public class scrapHistoryfi {
	public ArrayList<hisfigu> list;
	public void saveJson() throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    FileWriter fileWriter1 = new FileWriter("Data\\Historyfigu.json");
	    gson.toJson(list,fileWriter1);
	    fileWriter1.close();
	    //String jsonData = gson.toJson(list);
	}
	public void run() throws IOException {
    	ArrayList<hisfigu> list=new ArrayList<>();
        
        Document doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam").get();
        Elements elements=doc.getElementsByClass("mw-parser-output");
        Elements elements2 = elements.select("table");
        Elements tableRowElements = elements2.select("tbody tr");
        for (int i = 30; i < 82; i++) {
        	
            Element row = tableRowElements.get(i);
            
            Elements rowItems = row.select("td");

            for (int j = 0; j < rowItems.size()-9; j++) {
            	hisfigu item=new hisfigu();
            	//System.out.println(i+rowItems.get(j).text());
            	item.setName(rowItems.get(1).text());
            	item.setDes(rowItems.get(6).text());
            	item.setRealname(rowItems.get(5).text());
            	list.add(item);
              
            }
            
        }
        		for (int i = 92; i < tableRowElements.size(); i++) {
        	
            Element row = tableRowElements.get(i);
            
            Elements rowItems = row.select("td");

            for (int j = 0; j < rowItems.size()-9; j++) {
            	hisfigu item=new hisfigu();
            	//System.out.println(i+rowItems.get(j).text());
            	item.setName(rowItems.get(1).text());
            	item.setDes(rowItems.get(6).text());
            	item.setRealname(rowItems.get(5).text());
            	list.add(item);
              
            }
            
        }          
        	this.list=list;
}
	public static void main(String[] args) throws IOException {
		scrapHistoryfi scrapHistoryfi = new scrapHistoryfi();
		scrapHistoryfi.run();
	}
}
