// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package cnu.eslab.fileTest;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class EnergyPredictorChart extends ApplicationFrame
{

	public EnergyPredictorChart(String s)
	{
		super(s);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(660, 230));
		setContentPane(jpanel);
	}

	private static CategoryDataset createDataset()
	{
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		defaultcategorydataset.addValue(3.2D, "S1", "MYPEOPLE");
		defaultcategorydataset.addValue(10.2D, "S1", "KAKAo-Talk");
		defaultcategorydataset.addValue(7.3D, "S1", "Media-Youtube");
		defaultcategorydataset.addValue(5.1D, "S1", "Game-Anagry-brids");
		defaultcategorydataset.addValue(8.6D, "S1", "Naver Web Browser");
		defaultcategorydataset.addValue(5.1D, "S1", "Google-Maps");
		return defaultcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset)
	{
		JFreeChart jfreechart = ChartFactory.createBarChart("", "Application name", "Time(hour)", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
		TextTitle texttitle = new TextTitle("", new Font("Dialog", 0, 10));
		texttitle.setPosition(RectangleEdge.BOTTOM);
		jfreechart.addSubtitle(texttitle);
		ChartUtilities.applyCurrentTheme(jfreechart);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		categoryplot.setDomainGridlinesVisible(true);
		categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(0.8F);
		
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
		barrenderer.setDrawBarOutline(false);
		//수치값을 표시하는 것 마진을 9로 설정한다.
		barrenderer.setItemLabelAnchorOffset(9D);
		barrenderer.setBaseItemLabelsVisible(true);
		barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	

		numberaxis.setUpperMargin(0.10000000000000001D);
		
		
		StandardCategoryToolTipGenerator standardcategorytooltipgenerator = new StandardCategoryToolTipGenerator("{1}: {2} projects", new DecimalFormat("0"));
		barrenderer.setBaseToolTipGenerator(standardcategorytooltipgenerator);
		GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
		barrenderer.setSeriesPaint(0, gradientpaint);
		return jfreechart;
	}

	public static JPanel createDemoPanel()
	{
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	public static void main(String args[])
	{
		EnergyPredictorChart barchartdemo11 = new EnergyPredictorChart("JFreeChart: BarChartDemo11.java");
		barchartdemo11.pack();
		RefineryUtilities.centerFrameOnScreen(barchartdemo11);
		barchartdemo11.setVisible(true);
	}
}
