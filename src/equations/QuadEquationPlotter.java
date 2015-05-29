package equations;

import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;

public class QuadEquationPlotter {

	private QuadEquation q;

	public QuadEquationPlotter(QuadEquation q){
		this.q = q;
	}
	
	public String toPNGBase64(){
		double[] qparams = {q.getC(), q.getB(), q.getA()};
		String out;
		Function2D p = new PolynomialFunction2D(qparams);
		XYDataset dataset = DatasetUtilities.sampleFunction2D(p, -20.0, 20.0, 100, "Quadratic");
		JFreeChart chart = ChartFactory.createXYLineChart("Parábola", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);

		//byte[] buf = EncoderUtil.encode(chart.createBufferedImage(500, 300), ImageFormat.PNG);
		try{
			byte[] buf = ChartUtilities.encodeAsPNG(chart.createBufferedImage(600, 300) );
			out = new sun.misc.BASE64Encoder().encode(buf);
		}catch(IOException e){
			e.printStackTrace();
			out = "";
		}
		return out;
	}
	
	public String toHtmlImgTag(){
		String out = "";
		String base64 = this.toPNGBase64();
		if(!base64.equals("")){
			out += "<img src=\"data:image/png;base64,";
			out += base64;
			out += "\" />";
		}
		else{
			out += "<img alt=\"Eroor generando la imágen\" />";
		}
		return out;
	}
}
