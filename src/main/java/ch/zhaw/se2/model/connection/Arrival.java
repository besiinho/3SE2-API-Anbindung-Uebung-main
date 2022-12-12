package ch.zhaw.se2.model.connection;

import java.util.Date;

public class Arrival{
    public Station station;
    public Date arrival;
    public int arrivalTimestamp;
    public Object departure;
    public Object departureTimestamp;
    public int delay;
    public String platform;
    public Prognosis prognosis;
    public Object realtimeAvailability;
    public Location location;
}
