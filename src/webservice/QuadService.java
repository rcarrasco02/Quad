package webservice;

import equations.*;

public class QuadService {
	private QuadEquation eq;
	private QuadEquationPlotter qplotter;
/*	
	public QuadService(double a, double b, double c){
		eq = new QuadEquation(a, b, c);
		qplotter = new QuadEquationPlotter(eq);
	}
*/	
	public String getResults(double a, double b, double c){
		eq = new QuadEquation(a, b, c);
		qplotter = new QuadEquationPlotter(eq);
		return eq.toString();
	}
	
	public String getPlotB64(double a, double b, double c){
		eq = new QuadEquation(a, b, c);
		qplotter = new QuadEquationPlotter(eq);
		return qplotter.toPNGBase64();
	}
}
