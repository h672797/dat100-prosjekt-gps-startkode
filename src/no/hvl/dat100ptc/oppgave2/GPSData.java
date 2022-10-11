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
		GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
	
		boolean sattinn = insertGPS(gpspoint);
		
		return sattinn;
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		for(int i = 0; i<gpspoints.length; i++) {
			System.out.println(gpspoints[i].toString());
		}
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
