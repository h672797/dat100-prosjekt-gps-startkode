package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
			
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		double ystep = MAPYSIZE / (Math.abs(maxlat-minlat));
		
		return ystep;

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		int teller = 0;
		
		double[] speeds = gpscomputer.speeds();
		
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double[] x = new double[gpspoints.length];
		double[] y = new double[gpspoints.length];
		double xStep = xstep();
		double yStep = ystep();
		
		for(int i = 0; i< x.length; i++) {
			x[i] = xStep * (gpspoints[i].getLongitude() - minlon);
			y[i] = yStep * (gpspoints[i].getLatitude() - minlat);
	
		}
		
		setColor(0, 0, 255);
		int a = drawCircle((int) (x[0] + 0.5), ybase - (int) (y[0] + 0.5),3);

		
		for(int i = 0; i<gpspoints.length; i++) {
			int tempY = (int) (y[i] + 0.5);
			int tempX = (int) (x[i] + 0.5);
			
			if (x[i] == x[gpspoints.length -1]) {
				setColor(0, 0, 255);
				fillCircle(MARGIN + tempX, ybase - tempY, 5);
			} else {
				setColor(0, 255, 0);
				fillCircle(MARGIN + tempX, ybase - tempY, 2);
			}
			
			moveCircle(a, MARGIN + tempX, ybase - tempY);
			
			if (i > 0) {
				int tempYLast = (int) (y[i -1] + 0.5);
				int tempXLast = (int) (x[i -1] + 0.5);
				
				if(gpspoints[i].getElevation() < gpspoints[i -1].getElevation()) {
					setColor(255, 0, 0);
					drawLine(MARGIN + tempX, ybase - tempY, MARGIN + tempXLast, ybase - tempYLast);
				} else {
					setColor(0,255,0);
					drawLine(MARGIN + tempX, ybase - tempY, MARGIN + tempXLast, ybase - tempYLast);
				}
				
				int speedGraph = (int) (speeds[i-1]);
				drawLine(650 + teller, 75, 650 + teller, 75 - speedGraph);
			}
		}
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		int pos = 0;
		// TODO - START
		
		String[] stats = new String[5];
		
		stats[0] = "Total time        :" + GPSUtils.formatTime(gpscomputer.totalTime());
		stats[1] = "Total distance :" + GPSUtils.formatDouble(gpscomputer.totalDistance()) + " km";
		stats[2] = "Total elevation :" + GPSUtils.formatDouble(gpscomputer.totalElevation()) + " m";
		stats[3] = "Max speed       :" + GPSUtils.formatDouble(gpscomputer.maxSpeed()) + " km/t";
		stats[4] = "Average speed:" + GPSUtils.formatDouble(gpscomputer.averageSpeed()) + " km/t";

		
		for(int i = 0; i < stats.length; i++) {
			pos = pos + TEXTDISTANCE;
			drawString(stats[i], MARGIN, pos);
		}
		
		
		
		
	}

}
