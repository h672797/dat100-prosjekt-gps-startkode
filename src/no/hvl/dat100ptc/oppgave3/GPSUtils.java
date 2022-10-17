package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {
		// TODO - START
		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		// returnerer en tabell av desimaltall inneholdende breddegradene for
		// GPS-punktene.
		// throw new UnsupportedOperationException(TODO.method());
		double[] latitudes = new double[gpspoints.length];
		int i;
		for (i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		// returnerer en tabell av desimaltall inneholdende lengdegradene for
		// GPS-punktene.

		// throw new UnsupportedOperationException(TODO.method());
		double[] longitudes = new double[gpspoints.length];
		int i;
		for (i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}

		return longitudes;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();

		double a = pow(sin((toRadians(latitude2) - toRadians(latitude1)) / 2), 2) + (cos(toRadians(latitude1))
				* cos(toRadians(latitude2)) * pow(sin((toRadians(longitude2) - toRadians(longitude1)) / 2), 2));

		double c = 2 * (atan2(sqrt(a), sqrt(1 - a)));

		d = R * c;

		return d;

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		double distance = distance(gpspoint1, gpspoint2) / 1000;
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = (distance / secs) * 3600;

		return speed;
		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		timestr = String.format("  %02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, (secs % 60));

		// TODO - SLUTT 
		return timestr;

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		// TODO - START
		Locale.setDefault(Locale.US);		
		str = String.format("%10.2f", d);
		
		// TODO - SLUTT
		System.out.println(str);
		return str;
	}
}
