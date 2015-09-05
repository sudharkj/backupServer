package com.jsrk.backup.server.globals;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Contains functions related to time-zones
 */
public class TimeZoneConvertor {

	/**
	 * Gets server's date, converts to GMT from locale and returns it.
	 * 
	 * @return Current GMT date
	 */
	public static Date getCurrentGMTDate() {
		Calendar calendar = Calendar.getInstance(Locale.getDefault());
		TimeZone systemTimeZone = TimeZone.getDefault();
		float systemTimeZoneOffset = ((float) systemTimeZone
				.getOffset(new Date().getTime())) / (1000 * 60 * 60);

		return convertLocaleToGmtDate(calendar, systemTimeZoneOffset);
	}

	/**
	 * Converts locale to GMT date.
	 * 
	 * @param locale
	 *            Locale calendar to be converted
	 * @param timeZone
	 *            Time zone offset from GMT
	 * @return Converted date
	 */
	public static Date convertLocaleToGmtDate(Calendar locale, Float timeZone) {

		int minutes = (int) (timeZone * 60);
		locale.add(Calendar.MINUTE, -minutes);

		return locale.getTime();

	}

}
