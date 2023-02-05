package scrap;

import java.io.*;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import allc.dynasty;


public class scrapDynasty {
	public ArrayList<dynasty> list;
	public void saveJson() throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fileWriter = new FileWriter("Data\\Dynasty.json");
	    gson.toJson(list,fileWriter);
	    fileWriter.close();
	}
    public void run() throws IOException {
        ArrayList<dynasty> list = new ArrayList<>();
        Document doc = Jsoup.connect("https://accgroup.vn/lich-su-viet-nam-qua-cac-thoi-ky/").get();
        //System.out.println(doc);
        Elements elements = doc.select("p");
        elements = elements.select("strong");
        for(int i = 0; i < 18; i++)
        {
            if((i < 1)||(i >2)){
            dynasty item = new dynasty();
            String name = elements.get(i).text();
            addElementtoList(name, list);
            }
        }
        this.list=list;
    }
    public static void addElementtoList(String name, ArrayList<dynasty>list){
        int index = 0;
        int index1 = 0;
        int n = name.length();
        for(int i = 0; i < n; i++)
        {
            if(name.charAt(i) == '(')
            {
                index = i;
            }
            if(name.charAt(i) == ')')
            {
                index1 = i;
            }

        }
        String year = name.substring(index + 1, index1);
        String dynastyname = name.substring(0, index);
        year = year.replaceAll("\\s", "");
        int len = year.length();
        for(int i = 0; i < len; i++)
        {
            if(check(year.charAt(i)) == false)
            {
                year = removeCharAt(year,i);
                i--;
                len--;
            }
        }
        dynasty item = new dynasty();
        item.setNamedynasty(dynastyname);
        int chiso = 0;
        for(int i = 0; i < year.length(); i++)
        {
            if(!((48 <= year.charAt(i)) && (year.charAt(i) <= 57))){
                chiso = i;
            }
        }
        if(year.charAt(0) == '?'){
            String timeend = year.substring(chiso+1, len);
            item.setTimefrom(-2897);
            item.setTimeend(-Integer.parseInt(timeend));
            list.add(item);
        }
        else{
            String timefrom = year.substring(0, chiso);
            String timeend = year.substring(chiso+1, len);
            int fr = Integer.parseInt(timefrom);
            int end = Integer.parseInt(timeend);
            if(fr > end){
                fr = -fr;
                if(end > 39 )
                {
                    end = -end;
                }
            }
            item.setTimefrom(fr);
            item.setTimeend(end);

            list.add(item);
        }


    }
    public static boolean check(char s){
        if(s == '-') return true;
        if(s == '–') return true;
        if(s == '?') return true;
        if((48 <= s)&&(s <= 57)) return true;
        return false;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

}
