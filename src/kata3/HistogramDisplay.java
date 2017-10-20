/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata3;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author usuario
 */
public class HistogramDisplay <T> extends ApplicationFrame{
    
    private final Histogram<T> histogram;
    
    public HistogramDisplay(Histogram<T> histogram){
        super("Histograma de emails");
        this.histogram=histogram;
        setContentPane(createPanel());
        pack();
        
    }
    
    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChar", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, true, rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataSet;
    }
}
