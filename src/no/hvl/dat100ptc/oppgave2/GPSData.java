package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		gpspoints = new GPSPoint[n];
		antall = 0;
		//throw new UnsupportedOperationException(TODO.construtor("GPSData"));

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		// TODO - START
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint; 
			antall++;
			inserted = true;
		}
		//throw new UnsupportedOperationException(TODO.method());
			return inserted; 
		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		// TODO - START
		//GPSPoint gpspoint = new GPSPoint(Integer.parseInt(time), Integer.parseInt(latitude), Integer.parseInt(longitude), Integer.parseInt(elevation));		
		//int tid = GPSDataConverter.toSeconds(time);
		
		
		//GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		GPSPoint gpspoint;
		
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		boolean insert = insertGPS(gpspoint);
		
		return insert;
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		// System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
