package windowsevent;

import com.sun.jna.platform.win32.Advapi32Util.EventLogIterator;
import com.sun.jna.platform.win32.Advapi32Util.EventLogRecord;

public class EventVeiwer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventLogIterator iter = new EventLogIterator("Application");
		while(iter.hasNext()) {
		    EventLogRecord record = iter.next();
		    System.out.println(record.getRecordNumber()
		            + ": Event ID: " + record.getEventId()
		            + ", Event Type: " + record.getType()
		            + ", Event Source: " + record.getSource());
		}
	}

}
