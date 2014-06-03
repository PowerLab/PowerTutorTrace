package cnu.eslab.fileTest;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {

	public static void main(String[] args) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(25, "series1", "group1");
		dataset.addValue(21, "series1", "group2");
		dataset.addValue(16, "series2", "group1");
		dataset.addValue(18, "series2", "group2");
		dataset.addValue(30, "series3", "group1");
		dataset.addValue(28, "series3", "group2");
		
		JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", "Series", "Value", dataset, 
																					PlotOrientation.VERTICAL , true, true, false);
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
