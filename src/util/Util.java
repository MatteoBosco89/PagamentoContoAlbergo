package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static Date toDate(String s) throws ParseException {
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s);
		return d;
	}
	
	public static String dateToString(Date d) {
		DateFormat f = new SimpleDateFormat("dd MMM yyyy");
		return f.format(d);
	}

}
