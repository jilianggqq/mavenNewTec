package edu.gqq.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Common methods for convertion among String, Date and LocalDateTime
 * 
 * @author peter Guan
 * @since 2015/06/01
 */
public final class DateUtils2 {

	// some constant string
	public static final String FOMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final String FOMAT_DATE2 = "MM/dd/yyyy";
	public static final String FOMAT_DATE3 = "yyyy-MM-dd";

	/**
	 * get local date time of now
	 * 
	 * @return
	 */
	public static LocalDateTime getDateTimeNow() {
		return LocalDateTime.now();
	}

	public static LocalDate getDateNow() {
		return LocalDate.now();
	}

	public static LocalTime getTimeNow() {
		return LocalTime.now();
	}

	/**
	 * to unix timestamp, from localDatetime
	 * 
	 * @param ldt
	 * @return
	 */
	public static long toUnixTime(LocalDateTime ldt) {
		return ldt.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	}

	public static long toUnixTime(int year, int month, int dayOfMonth, int hour, int minute, int second) {
		LocalDateTime specificDate = LocalDateTime.of(year, Month.of(month), dayOfMonth, hour, minute, second);
		return toUnixTime(specificDate);
	}

	/**
	 * convert localdate to unixtimestamp
	 * 
	 * @param ld
	 * @return
	 */
	public static long toUnixTime(LocalDate ld) {
		return toUnixTime(LocalDateTime.of(ld, LocalTime.MIN));
	}

	/**
	 * convert a datetime string to unixtime
	 * 
	 * @param dtStr
	 *            date string
	 * @param format
	 *            format template
	 * @return
	 */
	public static long toUnixTime(String dtStr, String format) {
		LocalDateTime dateTime = LocalDateTime.parse(dtStr, DateTimeFormatter.ofPattern(format));
		return toUnixTime(dateTime);
	}

	public static long toUnixTime(String dtStr) {
		// LocalDateTime dateTime = LocalDateTime.parse(dtStr, DateTimeFormatter.ofPattern(format));
		return toUnixTime(dtStr, FOMAT_DATE);
	}

	/**
	 * convert a date string(date string is not a datetime string) to unixtime
	 * 
	 * @param dtStr
	 *            date string
	 * @param format
	 * @return
	 */
	public static long toUnixTimeDate(String dtStr, String format) {
		LocalDate date = LocalDate.parse(dtStr, DateTimeFormatter.ofPattern(format));
		return toUnixTime(date);
	}

	public static long toUnixTimeDate(String dtStr) {
		LocalDate date = LocalDate.parse(dtStr);
		return toUnixTime(date);
	}

	public static long toUnixTimeNow() {
		return toUnixTime(getDateTimeNow());
	}

	/**
	 * get today's unix timestamp
	 * 
	 * @return
	 */
	public static long toUnixTimeToday() {
		return toUnixTime(LocalDate.now());
	}

	/**
	 * get today's string with yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getTodaySimplestr() {
		return LocalDate.now().toString();
	}

	/**
	 * convert unix timestamp to LocalDateTime
	 * 
	 * @param uTime
	 *            unix timestamp
	 * @return
	 */
	public static LocalDateTime fromUnixTime(long uTime) {
		Instant fromUnixTimestamp = Instant.ofEpochSecond(uTime);
		return LocalDateTime.ofInstant(fromUnixTimestamp, ZoneId.systemDefault());
	}

	/**
	 * convert unix timestamp to LocalDate
	 * 
	 * @param uTime
	 *            unix timestamp
	 * @return
	 */
	public static LocalDate fromUnixTimeDate(long uTime) {
		return fromUnixTime(uTime).toLocalDate();
	}

	/**
	 * convert unix timestamp to string(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param uTime
	 * @return
	 */
	public static String fromUnixTimeStr(long day) {
		return fromUnixTimeStr(day, FOMAT_DATE);
	}

	/**
	 * convert unix timestamp to string(format)
	 * 
	 * @param uTime
	 * @return
	 */
	public static String fromUnixTimeStr(long day, String format) {
		Instant fromUnixTimestamp = Instant.ofEpochSecond(day);
		LocalDateTime ldt = LocalDateTime.ofInstant(fromUnixTimestamp, ZoneId.systemDefault());
		return ldt.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * parse local date time to string
	 * 
	 * @param ldt
	 * @return
	 */
	public static String parseDateTimeToString(LocalDateTime ldt) {
		return ldt.format(DateTimeFormatter.ofPattern(FOMAT_DATE));
	}

	/**
	 * convert java.util.Date to String with format "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param dat
	 *            date
	 * @return
	 */
	public static String parseDateToString(Date dat) {
		SimpleDateFormat df = new SimpleDateFormat(FOMAT_DATE);
		return parseDateToString(dat, df);
	}

	/**
	 * convert java.util.Date to String with format
	 * 
	 * @param dat
	 *            date
	 * @param df
	 *            date format
	 * @return
	 */
	public static String parseDateToString(Date dat, DateFormat df) {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(dat);
	}

	/**
	 * convert string(yyyy-MM-dd) to Date
	 * 
	 * @param dtStr
	 * @return
	 */
	public static Date convertStringToDate(String dtStr) {
		return convertStringToDate(dtStr, "yyyyMMdd");
	}

	public static Date convertStringToDate(String dtStr, String format) {
		DateFormat format2 = new SimpleDateFormat(format);
		try {
			return format2.parse(dtStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date convertDateTimeToDate(LocalDateTime ldt) {
		return java.sql.Timestamp.valueOf(ldt);
	}

	public static LocalDateTime convertStringToLocalDateTime(String ds) {
		return LocalDateTime.of(LocalDate.parse(ds, DateTimeFormatter.ofPattern(FOMAT_DATE3)), LocalTime.MIN);
	}
	public static LocalDateTime convertStringToLocalDateTime(String ds, String format) {
		return LocalDateTime.of(LocalDate.parse(ds, DateTimeFormatter.ofPattern(format)), LocalTime.MIN);
	}
}