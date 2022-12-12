package ch.zhaw.se2.model.connection; 

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Stations{
    public ArrayList<From> from;
    @JsonProperty("to") 
    public ArrayList<To> myto;
}
