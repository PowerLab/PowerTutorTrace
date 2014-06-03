package cnu.eslab.fileTest;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
	
	public static void main(String[] args) {
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("One", 300 );
		data.setValue("Two", 500.25 );
		data.setValue("Three", 200.54 );
		data.setValue("Four", 100.25 );
		
		JFreeChart chart = ChartFactory.createPieChart("Test Pie Chart", data, true, true, false);
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
