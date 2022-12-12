package ch.zhaw.se2.model.connection; 

import java.util.Date;

public class PassList{
    public Station station;
    public Date arrival;
    public int arrivalTimestamp;
    public Date departure;
    public int departureTimestamp;
    public int delay;
    public String platform;
    public Prognosis prognosis;
    public Object realtimeAvailability;
    public Location location;
}
