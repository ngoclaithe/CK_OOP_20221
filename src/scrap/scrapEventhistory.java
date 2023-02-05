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

import allc.eventhistory;

public class scrapEventhistory {
	public static void addElementtoList(Document doc, ArrayList<eventhistory> list) {
	    Elements elements = doc.getElementsByClass("click");
	    for (Element e : elements) {
	        String str = e.text();
	        int n = str.length();
	        int index = 0;
	        int index1 = 0;
	        for (int i = 0; i < n; i++) {
	            if (str.charAt(i) == '(') {
	                index = i;
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            if (str.charAt(i) == ')') {
	                index1 = i;
	            }
	        }
	        if (index1 - index > 4) {
	            if (index != 0) {
	                String content = str.substring(0, index - 1);
	                String time = str.substring(index + 1, n - 1);
	                eventhistory item = new eventhistory();
	                item.setTime(time);
	                item.setContent(content);
	                String s = time.replaceAll("\\s", "");
	                int cnt = 0;
	                int chiso = 0;
	                int len = s.length();
	                for(int i = 0; i < len; i++)
	                {
	                    if(s.charAt(i) == '-')
	                    {
	                        cnt++;
	                        chiso = i;
	                    }
	                }
	                if(cnt == 0)
	                {
	                    int s1 = Integer.parseInt(s);
	                    item.setFromyear(s1);
	                    item.setToyear(s1);
	                    list.add(item);
	                }
	                else if(cnt == 1)
	                {
	                    if(chiso == 0){
	                        int s1 = Integer.parseInt(s);
	                        item.setFromyear(s1);
	                        item.setToyear(s1);
	                        list.add(item);
	                    }
	                    else{
	                        String s1 = s.substring(0,chiso);
	                        String s2 = s.substring(chiso+1,len);
	                        int i1 = Integer.parseInt(s1);
	                        int i2 = Integer.parseInt(s2);
	                        item.setFromyear(i1);
	                        item.setToyear(i2);
	                        list.add(item);
	                    }
	                }
	                else if(cnt == 2){
	                    String s1 = s.substring(0,chiso);
	                    String s2 = s.substring(chiso+1,len);
	                    int i1 = Integer.parseInt(s1);
	                    int i2 = Integer.parseInt(s2);
	                    item.setFromyear(i1);
	                    item.setToyear(i2);
	                    list.add(item);
	                }
	                else
	                {   String s1 = s.substring(0,chiso-1);
	                    String s2 = s.substring(chiso,len);
	                    int i1 = Integer.parseInt(s1);
	                    int i2 = Integer.parseInt(s2);
	                    item.setFromyear(i1);
	                    item.setToyear(i2);
	                    list.add(item);
	                }
	            }
	        }
	    }
	}

	public ArrayList<eventhistory> list;
	public void saveJson() throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    FileWriter fileWriter1 = new FileWriter("Data\\Eventhistory.json");
	    gson.toJson(list,fileWriter1);
	    fileWriter1.close();
	}

	public void run() throws IOException { 
		ArrayList<eventhistory> list = new ArrayList<>();
    ArrayList<Document> docList = new ArrayList<>();

    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=2").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=3").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=4").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=5").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=6").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=7").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=8").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=9").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=10").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=11").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=12").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=13").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=14").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=15").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=16").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=17").get());
    docList.add(Jsoup.connect("https://thuvienlichsu.com/su-kien?page=18").get());

    for (Document doc : docList) {
        addElementtoList(doc, list);
    }

    this.list=list;

    
}


}
