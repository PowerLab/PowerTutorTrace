// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package cnu.eslab.fileTest;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.*;

public class StatisticalBarChartDemo1 extends ApplicationFrame
{

	public StatisticalBarChartDemo1(String s)
	{
		super(s);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(jpanel);
	}

	private static CategoryDataset createDataset()
	{
		DefaultStatisticalCategoryDataset defaultstatisticalcategorydataset = new DefaultStatisticalCategoryDataset();
		defaultstatisticalcategorydataset.add(1883.0D, 204.68268124098825D, "Running", "MYPEOPLE");
		defaultstatisticalcategorydataset.add(588.0D, 469.3719207622032D, "Running", "KAKAo-Talk");
		defaultstatisticalcategorydataset.add(826.0D, 162.9110186574254D, "Running", "Youtube");
		defaultstatisticalcategorydataset.add(1186.0D, 274.72713735632306D, "Running", "Angry-Birds");
		defaultstatisticalcategorydataset.add(693.0D, 435.64549808301706D, "Running", "Naver");
		defaultstatisticalcategorydataset.add(1178.0D, 1726.5060092568458D, "Running", "Google-Maps");
		/*
		defaultstatisticalcategorydataset.add(20.0D, 92.91931984253867D, "Sleep", "MYPEOPLE");
		defaultstatisticalcategorydataset.add(40.0D, 136.517398158623D, "Sleep", "KAKAo-Talk");
		defaultstatisticalcategorydataset.add(22.0D, 119.02520741422802D, "Sleep", "Youtube");
		defaultstatisticalcategorydataset.add(0D, 0D, "Sleep", "Angry-Birds");
		defaultstatisticalcategorydataset.add(0D, 0.0, "Sleep", "Naver");
		defaultstatisticalcategorydataset.add(7.0D, 23.958297101421877D, "Sleep", "Google-Maps");
*/		return defaultstatisticalcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset)
	{
		JFreeChart jfreechart = ChartFactory.createLineChart("", "Application Name", "Power(mW)", categorydataset, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(false);
		
		StatisticalBarRenderer statisticalbarrenderer = new StatisticalBarRenderer();
		statisticalbarrenderer.setDrawBarOutline(false);
		statisticalbarrenderer.setErrorIndicatorPaint(Color.black);
		statisticalbarrenderer.setIncludeBaseInRange(false);
		categoryplot.setRenderer(statisticalbarrenderer);
		
		ChartUtilities.applyCurrentTheme(jfreechart);
		statisticalbarrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		statisticalbarrenderer.setBaseItemLabelsVisible(true);
		statisticalbarrenderer.setBaseItemLabelPaint(Color.yellow);
		statisticalbarrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE6, TextAnchor.BOTTOM_CENTER));
		GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
		GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
		statisticalbarrenderer.setSeriesPaint(0, gradientpaint);
		statisticalbarrenderer.setSeriesPaint(1, gradientpaint1);
		return jfreechart;
	}

	public static JPanel createDemoPanel()
	{
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	public static void main(String args[])
	{
		StatisticalBarChartDemo1 statisticalbarchartdemo1 = new StatisticalBarChartDemo1("Statistical Bar Chart Demo");
		statisticalbarchartdemo1.pack();
		RefineryUtilities.centerFrameOnScreen(statisticalbarchartdemo1);
		statisticalbarchartdemo1.setVisible(true);
	}
}
