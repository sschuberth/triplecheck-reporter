// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package testing;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChart3DDemo4 extends ApplicationFrame
{

	public StackedBarChart3DDemo4(String s)
	{
		super(s);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(100, 270));
		setContentPane(jpanel);
	}

	public static CategoryDataset createDataset(){
            // options
            final String 
                    param1 = "Licenses",
                    param2 = "Languages";
            
            DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
            defaultcategorydataset.addValue(10D, "Series 1", param1);
            defaultcategorydataset.addValue(4D, "Series 2", param1);
            defaultcategorydataset.addValue(15D, "Series 3", param1);
            defaultcategorydataset.addValue(14D, "Series 4", param1);

//            defaultcategorydataset.addValue(3D, "Series 4", param2);
//            defaultcategorydataset.addValue(14D, "Series 3", param2);
//            defaultcategorydataset.addValue(7D, "Series 2", param2);
//            defaultcategorydataset.addValue(5D, "Series 1", param2);

            return defaultcategorydataset;
	}

	private static JFreeChart createChart(CategoryDataset categorydataset){
            // options
            int color = 0xf8f8f8;
            
            // define the color for the background
            Color backgroundColor = new Color(0xf8f8f8); 
            
            JFreeChart chart = ChartFactory.createStackedBarChart("", "", "", categorydataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = (CategoryPlot)chart.getPlot();

            StackedBarRenderer stack = (StackedBarRenderer)plot.getRenderer();
            stack.setRenderAsPercentages(true);
            stack.setDrawBarOutline(false);
            stack.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{3}", NumberFormat.getIntegerInstance(), new DecimalFormat("0.0%")));
            stack.setBaseItemLabelsVisible(true);
            
            // change the background
            plot.setBackgroundPaint(backgroundColor);
            chart.setBackgroundPaint(backgroundColor);
            
            // margins
            chart.getLegend().setVisible(false);
            chart.setBorderVisible(false);
            chart.getPlot().setOutlineVisible(false);
            chart.getLegend().setFrame(BlockBorder.NONE);
        
            
            stack.setShadowVisible(false);
            
            return chart;
	}

	public static JPanel createDemoPanel()
	{
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	public static void main(String args[])
	{
		StackedBarChart3DDemo4 stackedbarchart3ddemo4 = new StackedBarChart3DDemo4("Stacked Bar Chart 3D Demo 4");
		stackedbarchart3ddemo4.pack();
		RefineryUtilities.centerFrameOnScreen(stackedbarchart3ddemo4);
		stackedbarchart3ddemo4.setVisible(true);
	}
}
