/**
 *
 *  @author Domański Krzysztof S19270
 *
 */

package zad1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {
	public static String passed(String from, String to) {
		String result = "Od ";
		try {
    	int years;
		int months;
		int days;
		double weeks;
		int week;
		if(!to.contains("T")) {
			LocalDate ldf = LocalDate.parse(from);
			LocalDate ldt = LocalDate.parse(to);
			result += ldf.format(DateTimeFormatter.ofPattern("d MMMM yyyy (EEEE)", new Locale("pl"))) + " do ";
			result += ldt.format(DateTimeFormatter.ofPattern("d MMMM yyyy (EEEE)", new Locale("pl"))) + "\n";
			days = (int)(ChronoUnit.DAYS.between(ldf, ldt));
			if (days != 1) result += " - mija: " + days + " dni, tygodni ";// + weeks + "\n";
			else result += " - mija: " + days + " dzien, tygodni ";// + weeks + "\n";
			weeks = days / (double)7;
			week = days / 7;
			if(days % 7 != 0) result += String.format("%.2f", weeks);
			else result += week;//String.format("%d", weeks);;
			years = (int)(ChronoUnit.YEARS.between(ldf, ldt));
			ldf = ldf.plusYears(years);
			months = (int)(ChronoUnit.MONTHS.between(ldf, ldt));
			ldf = ldf.plusMonths(months);
			days = (int)(ChronoUnit.DAYS.between(ldf, ldt));
			if(years > 0 || months > 0 || days > 0) {
				result += "\n - kalendarzowo: ";
				if(years == 1) result += "1 rok";
				else if (years <= 4 && years > 1) result += years + " lata";
				else if(years > 4)result += years + " lat";
				if((years > 0) && (months > 0 || days > 0)) result += ", ";
				if (months > 4) result += months + " miesiecy";
				else if (months == 1) result += "1 miesiac";
				else if (months <= 4 && months > 1) result += months + " miesiace";
				if (months > 0 && days > 0) result += ", ";
				if(days == 1) result += "1 dzien";
				else if(days > 0) result += days + " dni";
			}
		}
		else {
			int hours;
			int minutes;
			LocalDateTime ldtf = LocalDateTime.parse(from);
			ZonedDateTime zdf = ZonedDateTime.of(ldtf, ZoneId.of("Europe/Warsaw"));
			result += zdf.format(DateTimeFormatter.ofPattern("d MMMM yyyy (EEEE) 'godz.' HH:mm", new Locale("pl"))) + " do ";
			LocalDateTime ldtt = LocalDateTime.parse(to);
			ZonedDateTime zdt = ZonedDateTime.of(ldtt, ZoneId.of("Europe/Warsaw"));
			result += zdt.format(DateTimeFormatter.ofPattern("d MMMM yyyy (EEEE) 'godz.' HH:mm", new Locale("pl"))) + "\n";
			days = (int)(ChronoUnit.DAYS.between(zdf, zdt));
			if (days != 1) result += " - mija: " + days + " dni, tygodni ";// + weeks + "\n";
			else result += " - mija: " + days + " dzien, tygodni ";// + weeks + "\n";
			weeks = days / (double)7;
			week = days / 7;
			if(days % 7 != 0) result += String.format("%.2f", weeks);
			else result += week;//String.format("%d", weeks);;
			hours = (int)(ChronoUnit.HOURS.between(zdf, zdt));
			minutes = (int)(ChronoUnit.MINUTES.between(zdf, zdt));
			result += "\n - godzin: " + hours + ", minut: " + minutes;
			years = (int)(ChronoUnit.YEARS.between(zdf, zdt));
			ldtf = ldtf.plusYears(years);
			months = (int)(ChronoUnit.MONTHS.between(zdf, zdt));
			ldtf = ldtf.plusMonths(months);
			days = (int)(ChronoUnit.DAYS.between(zdf, zdt));
			if(years > 0 || months > 0 || days > 0) {
				result += "\n - kalendarzowo: ";
				if(years == 1) result += "1 rok";
				else if (years <= 4 && years > 1) result += years + " lata";
				else if(years > 4)result += years + " lat";
				if((years > 0) && (months > 0 || days > 0)) result += ", ";
				if (months > 4) result += months + " miesiecy";
				else if (months == 1) result += "1 miesiac";
				else if (months <= 4 && months > 1) result += months + " miesiace";
				if (months > 0 && days > 0) result += ", ";
				if(days == 1) result += "1 dzien";
				else if(days > 0) result += days + " dni";
			}
		}
		}
		catch(DateTimeParseException i) {
			result = "***" + i.toString();
		}
		return result;
	}
}
