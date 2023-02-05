package scrap;
import java.io.File;

public class deleteJson {
	public void run() {
        try {
            File file = new File("Data\\Dynasty.json");
            File file1 = new File("Data\\Historyfigu.json");
            File file2 = new File("Data\\Eventhistory.json");
            File file3 = new File("Data\\Festival.json");
            File file4 = new File("Data\\Historicalplace.json");
            file.delete();
            file1.delete();
            file2.delete();
            file3.delete();
            file4.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
