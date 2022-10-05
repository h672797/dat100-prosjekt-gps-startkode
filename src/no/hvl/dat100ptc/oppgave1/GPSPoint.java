package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	int time; 
	double latitude;
	double longitude;
	double elevation;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		this.time = time; 
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		

		// Fjern linjene med throw new etterhvert som metodene implementeres
		//throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

	}

	// TODO - get/set metoder
	public int getTime() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return time; 
	}

	public void setTime(int time) {
				
		//throw new UnsupportedOperationException(TODO.method());
		this.time = time;
	}

	public double getLatitude() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return latitude;
	}

	public void setLatitude(double latitude) {
		
		//throw new UnsupportedOperationException(TODO.method());
		this.latitude = latitude; 
	}

	public double getLongitude() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return longitude;
	}

	public void setLongitude(double longitude) {
		
		//throw new UnsupportedOperationException(TODO.method());
		this.longitude = longitude;
	}

	public double getElevation() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return elevation;
	}

	public void setElevation(double elevation) {
		
		//throw new UnsupportedOperationException(TODO.method());
		this.elevation = elevation;
	}
	
	public String toString() {
		
		String str;
		
		// TODO - start

		throw new UnsupportedOperationException(TODO.method());

		// TODO - slutt
		
	}
}
