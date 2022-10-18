package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
			
		for (int i = 0; i<gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}
		
		// TODO - SLUTT
		return distance;
	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;
		
		for (int i = 0; i < gpspoints.length; i++) {

			double høgde = gpspoints[i].getElevation();

			if (høgde > elevation) {

				elevation += (høgde - elevation);
			}
		}
		// throw new UnsupportedOperationException(TODO.method());
		return elevation;

	}

	// beregn total tiden for hele turen (i sekunder)
	// last -first
	public int totalTime() {

		int time = 0;
		time = gpspoints[gpspoints.length -1].getTime() - gpspoints[0].getTime();
		return time;
			
		}
		
		//throw new UnsupportedOperationException(TODO.method());

		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {

		// TODO - START // OPPGAVE - START
			 
		double[] gh = new double [gpspoints.length-1]; //står i opg at nye tabellen skal være n(antall datapunker)-1
		
		
		for(int i=0; i < gpspoints.length-1; i++) { //en for løkke slik at den fortsetter handlingen til tabellen er ferdig
			gh[i] = GPSUtils.speed(gpspoints[i],gpspoints[i+1]); //for hver ny verdi skal den hente tallet fra et punkt til punktet etter det
						
		}
		
		return gh;
		
		

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	
	// returnerer den største hastigheten vi har beveget oss med mellom to punkter på ruten.
	public double maxSpeed() {

		double maxspeed = 0;

		// TODO - START
		int i = 0;
		for ( i = 0; i < gpspoints.length-1; i++) {
			double f1 = GPSUtils.speed(gpspoints[i], gpspoints [i+1]);
			if (f1 > maxspeed ) {
				maxspeed = f1;
			}
		} 
		return maxspeed;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}
	// returnerer gjennomsnittshastigheten vi har beveget oss med total sett for hele ruten
	public double averageSpeed() {

		double average = 0;
		double conv = 3.6; //conversion

		// TODO - START
		// m/s --> km/t
		average = totalDistance()/totalTime();
		average = average * conv;
		
		return average; //km/t
		
		
		

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling, general
	 * 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0 bicycling,
	 * 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9 mph, racing or
	 * leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph, racing/not drafting
	 * or >19 mph drafting, very fast, racing general 12.0 bicycling, >20 mph,
	 * racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;
		double speedmph = speed * MS;
		double hours = ((double) secs/3600);

		// TODO - START

		if(speedmph < 10) {
			met = 4.0;
		}else if(speedmph >= 10 && speedmph < 12) {
			met = 6.0;
		}else if(speedmph >= 12 && speedmph < 14) {
			met = 8.0;
		}else if(speedmph >= 14 && speedmph < 16) {
			met = 10.0;
		}else if(speedmph >= 16 && speedmph < 20) {
			met = 12.0;
		} else if(speedmph >= 20) {
			met = 16.0;
		}
		
		
		
		kcal = met * weight * hours;
		
		return kcal;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		double[] kcalTab = new double[gpspoints.length-1];
		
		
		// går igjennom alle punktene og legger de sammen, 
		// getTime= tiden fra punktet før i - tid fra punkt i for å finne tiden det tok mellom punktene. speed har allerede regnet ut hastigheten mellom de to punktene
		for(int i = 0; i < gpspoints.length-1; i++) {
			kcalTab[i] = kcal(weight, gpspoints[i+1].getTime() - gpspoints[i].getTime(), GPSUtils.speed(gpspoints[i], gpspoints[i+1]));
			totalkcal += kcalTab[i];
		}
		return totalkcal;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START
		System.out.println("Total Time: " + totalTime());
		System.out.println("Total Distance: " + totalDistance());
		System.out.println("Total Elevation: " + totalElevation());
		System.out.println("Max Speed: " + maxSpeed());
		System.out.println("Avergave speed: " + averageSpeed());
		System.out.println("Energy: " + totalKcal(WEIGHT));

		

		// TODO - SLUTT
		
	}

}
