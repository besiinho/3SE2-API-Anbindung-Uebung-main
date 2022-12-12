package ch.zhaw.se2.model.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Root{
    public ArrayList<Connection> connections;
    public From from;
    @JsonProperty("to") 
    public To myto;
    public Stations stations;
}
