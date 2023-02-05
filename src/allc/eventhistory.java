package allc;

public class eventhistory {
    private String time;

    private int fromyear;

    private int toyear;
    private String content;

    public eventhistory(){

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFromyear(){
        return fromyear;
    }

    public void setFromyear(int fromyear){
        this.fromyear = fromyear;
    }

    public int getToyear(){
        return toyear;
    }

    public void setToyear(int toyear){
        this.toyear = toyear;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

