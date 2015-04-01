package windowsevent;

import com.sun.jna.platform.win32.Advapi32Util.EventLogIterator;
import com.sun.jna.platform.win32.Advapi32Util.EventLogRecord;

/**
 * @author Kawsar Ahmed
 *
 */
public class EventCollector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventLogIterator iter = new EventLogIterator("Secuirity");
		System.out.println("Start:");
		while(iter.hasNext()) {
		    EventLogRecord record = iter.next();
//		    if(record.getSource().equals(new String("File System")) )
		    System.out.println(record.getRecordNumber()
		            + ": Event ID: " + record.getEventId()
		            + ", Event Type: " + record.getType()
		            + ", Event Source: " + record.getSource());
		}
	}
	
	public String getEvents() {
		EventLogIterator eventLogIterator = new EventLogIterator("Security");
		String eventsText = "";
		int i=10;
		while(eventLogIterator.hasNext() && i-- > 0) {
			EventLogRecord eventLogRecord = eventLogIterator.next();
			eventsText += "\n\r"+eventLogRecord.getRecordNumber()
		            + ": Event ID: " + eventLogRecord.getEventId()
		            + ", Event Type: " + eventLogRecord.getType()
		            + ", Event Source: " + eventLogRecord.getSource();
		}
		eventLogIterator.close();
		return eventsText;
		
	}

}
