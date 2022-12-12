package ch.zhaw.se2.model.connection; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.ArrayList; 
public class Connection{
    public From from;
    @JsonProperty("to") 
    public To myto;
    public String duration;
    public int transfers;
    public Object service;
    public ArrayList<String> products;
    public Object capacity1st;
    public Object capacity2nd;
    public ArrayList<Section> sections;
}
