package com.inc.playground.playgroundApp;

import com.inc.playground.playgroundApp.utils.Constants;
import com.inc.playground.playgroundApp.utils.EventsObjectInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by mostafawattad on 06/05/2016.
 */
public class EventsObject implements Serializable ,EventsObjectInterface {
    // TODO: 12/07/2016 mostafa: all functions should start with small case

    String id,name, formattedLocation, type, size, date, startTime, endTime, description, status, distance, maxSize;

    String isPublic;//1 indicate public, 0 indicate that members need approval
    ArrayList<String> members;

    ArrayList<String> approveList =  new ArrayList<>();;

    // TODO ADD EVENT MEMBERS (A LIST CONTAINING USERS)
    String creatorId;
    HashMap<String, String> location= new HashMap<String, String>();

    public String GetId() { return id; }

    public void SetId(String id) { this.id = id; }
    public String GetName() { return name; }

    public void SetName(String name) { this.name = name; }

    public String GetCreatorId() { return creatorId; }

    public void SetCreatorId(String creatorId) { this.creatorId = creatorId; }

    public String GetFormattedLocation() { return formattedLocation; }

    public void SetFormattedLocation(String location) { this.formattedLocation = location; }

    public HashMap<String, String> GetLocation() { return this.location; }

    public void SetPosition(String lat, String lon) {
        this.location.clear();
        this.location.put(Constants.LOCATION_LAT, lat);
        this.location.put(Constants.LOCATION_LON, lon);
    }

    public String GetType() { return type; }

    public void SetType(String type) { this.type = type; }

    public String GetSize() { return size; }

    public void SetSize(String size){ this.size = size;	} // size is the min attend

    public String GetDate() { return date; }

    public void SetDate(String date){ this.date = date;	}

    public String GetStartTime() { return startTime; }

    public void SetStartTime(String startTime) { this.startTime = startTime; }

    public String GetEndTime() { return endTime; }

    public void SetEndTime(String endTime) { this.endTime = endTime; }

    public String GetDescription() { return description; }

    public void SetDescription(String description) { this.description = description; }

    public String GetStatus() { return status; }

    public void SetStatus(String status) { this.status = status; }

    public String GetDistance() { return distance; }

    public void SetDistance(String distance) { this.distance= distance; }

    public ArrayList<String> GetMembers(){ return members; }

    public void SetMembers(ArrayList<String> members){ this.members = members; }

    public String getIsPublic() { // Todo:check that we use it
        return isPublic;
    }

    public void setIsPublic(String isPublic) {// Todo:check that we use it
        this.isPublic = isPublic;
    }

    public void setMaxSize(String maxSizeInput){
        this.maxSize = maxSizeInput;
    }

    public String getMaxSize(){
        return this.maxSize;
    }


    public ArrayList<String> getApproveList() {
        return approveList;
    }

    public void setApproveList(ArrayList<String> approveList) {
        this.approveList = new ArrayList<>();
        this.approveList = approveList;
    }

    public static Comparator<EventsObject> getCompByName()
    {
        Comparator comp = new Comparator<EventsObject>(){
            @Override
            public int compare(EventsObject s1, EventsObject s2)
            {
                return Float.compare(Float.parseFloat(s1.GetDistance()),(Float.parseFloat(s2.GetDistance())));
            }
        };
        return comp;
    }




}
