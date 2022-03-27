package CEMS.src.application;

import java.time.LocalDateTime;
import java.util.HashMap;

public class EventForm extends Form{

    public static int COUNT_FOR_IDS;
    private Event event;
    private int formID;

    public EventForm(RequestType requestType, HashMap<Object, Object> hmData){
        this.formID = ++COUNT_FOR_IDS;

        createEvent(hmData);

    }

    public Event getEvent(){
        return event;
    }

    public void createEvent(HashMap<Object, Object> hmData){

        String eventName = (String)hmData.get("EventName");
        String eventDesc = (String)hmData.get("EventDescription");
        Club eventClub = (Club)hmData.get("EventClub");//pending confirmation of data type
        LocalDateTime eventDateTime = (LocalDateTime)hmData.get("EventDateTime");
        String[] emailGroup = (String[])hmData.get("EventEmailGroup");//pending confirmation of data type

        this.event = new Event(eventName, eventDesc, eventClub, eventDateTime, emailGroup);

    }

//	@Override
//	public void addField(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Object getField(Object Key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setField(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected boolean delete(HashMap<Object, Object> requestData) {
//		// TODO Auto-generated method stub
//		return false;
//	}



}
