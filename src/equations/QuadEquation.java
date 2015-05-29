package equations;

public class QuadEquation {
	
	public static final int REAL = 0, IMAG = 1;	
	
	private double a, b, c;
	private double[] result;	
	
	public QuadEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
		this.result = this.solveQuad(); 
	}
	
	@Override
	public String toString(){
		String res = "";
		if(result[2] == QuadEquation.REAL){
			res = String.format("X1 = %s , X2 = %s", Double.toString(this.result[0]), Double.toString(this.result[1]) );
		}
		else if(result[2] == QuadEquation.IMAG){
			res = String.format("X1 = %s + i , X2 = %s + i", Double.toString(this.result[0]), Double.toString(this.result[1]) );
		}
		else if(result[2] == -1){
			res = "\'a\' debe ser distinto de 0";
		}
		else{
			res = "Resultado desconocido";
		}
		return res;
	}
	
	
	
	public double getA(){
		return this.a;
	}
	public double getB(){
		return this.b;
	}
	public double getC(){
		return this.c;
	}
	
	private double[] solveQuad(){
		double[] res = new double[3];
		/*
		 * 
		 *       -b +- sqrt{ b^2 -4 [a][c] } 
		 *   x = ------------------------------
		 *                 2[a]
		 *                 
		 * */
		
		if(a != 0){
			double discr = Math.pow(this.b, 2)-(4*this.a*this.c);
			res[0] = (-b+Math.sqrt(-discr))/(2*a);//( (0-this.b) + Math.sqrt(discr) ) / (2*this.a);
			res[1] = (-b-Math.sqrt(-discr))/(2*a);//( (0-this.b) - Math.sqrt(discr) ) / (2*this.a);
			if(discr < 0){
				res[2] = QuadEquation.REAL;
			}
			else{
				res[2] = QuadEquation.IMAG;
			}
		}
		else if(a==0){
			res[0] = -(this.c/this.b);
			res[1] = Double.NaN;
			res[2] = QuadEquation.REAL;
		}
		
		return res;
	}
}
