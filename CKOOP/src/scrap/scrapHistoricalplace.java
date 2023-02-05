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

import allc.historicalplace;

public class scrapHistoricalplace {
	public ArrayList<historicalplace> list;
	public void saveJson() throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter2 = new FileWriter("Data\\Historicalplace.json");
        gson.toJson(list,fileWriter2);
        fileWriter2.close();
	}
	public void run() throws IOException
	{
		 
		 ArrayList<historicalplace> list=new ArrayList<>(); 
	     Document doc2 = Jsoup.connect("https://wiki.edu.vn/wiki/index.php?title=Di_t%C3%ADch_l%E1%BB%8Bch_s%E1%BB%AD_v%C4%83n_h%C3%B3a_qu%E1%BB%91c_gia").get();
	     Elements elements2=doc2.select("table.wikitable.sortable");
	        Elements tableRowElements = elements2.select("tbody tr");
	        for (int i = 0; i < tableRowElements.size(); i++) {
	        	
	            Element row = tableRowElements.get(i);
	            
	            Elements rowItems = row.select("td");
	            
	            //System.out.println(rowItems.size());
	            for (int j = 0; j < rowItems.size()-5; j++) {
	            	historicalplace item=new historicalplace();
	            	item.setName(rowItems.get(0).text());
	            	item.setPlace(rowItems.get(1).text());
	            	list.add(item);
	              
	            }

	            
	            
	        }
	        this.list=list;
	}

}
