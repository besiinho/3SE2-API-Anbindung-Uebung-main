package ch.zhaw.se2.model.connection; 

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.ArrayList; 

public class Journey{
    public Object name;
    public String category;
    public Object subcategory;
    public Object categoryCode;
    public String number;
    public String operator;
    @JsonProperty("to") 
    public String myto;
    public ArrayList<PassList> passList;
    public Object capacity1st;
    public Object capacity2nd;
}
