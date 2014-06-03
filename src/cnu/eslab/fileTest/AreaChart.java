package cnu.eslab.fileTest;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class AreaChart {

    public static void main(String[] args) {

		 XYSeries series = new XYSeries("Linux Users");
		 series.add(2000, 100.0);
		 series.add(2001, 111.0);
		 series.add(2002, 120.0);
		 series.add(2003, 140.0);
		 XYDataset dataset = new XYSeriesCollection(series);
		
		 JFreeChart chart = ChartFactory.createXYAreaChart("Area Test", "Var",  "Frequence", dataset,
		             																		org.jfree.chart.plot.PlotOrientation.VERTICAL, true,
																							true, false);
		
		TextTitle subTitle = new TextTitle("Sub Title");
			
		chart.setBackgroundPaint(Color.WHITE);
		chart.addSubtitle(subTitle);
		
		ChartPanel chartPanel = new ChartPanel(chart);
			
		JFrame f = new JFrame("Exam");
		f.setSize(500, 500);
		f.getContentPane().add(chartPanel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			
    }
}

