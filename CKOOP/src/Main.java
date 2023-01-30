import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import sun.net.www.URLConnection;
 
 
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<E> list=new ArrayList<>();
           
        
        Document doc = Jsoup.connect("https://nguoikesu.com/nhan-vat").get();
        //System.out.println(doc);
        Elements elements=doc.getElementsByClass("item-content");
        //System.out.println(elements);
    for (Element e : elements)
    {
    	E item=new E();
    	//e.childNode(0).childNode(0).outerHtml();
    	item.setTitle(e.child(0).child(0).child(0).text());
    	item.setDes(e.text());
    	list.add(item);
    	//System.out.println(e.child(0).child(0).child(0).text());
    	
    }
    Gson gson=new Gson();
    String jsonData=gson.toJson(list);
    //System.out.println(jsonData);
    for(int i=0;i<list.size();i++)
    {
    	System.out.println(i+"/"+"Nhan Vat:"+list.get(i).getTitle()+"/"+"Mo ta:"+list.get(i).getDes());
    	
    }
    }
    
}