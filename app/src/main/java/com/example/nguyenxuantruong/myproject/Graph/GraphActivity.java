package com.example.nguyenxuantruong.myproject.Graph;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.nguyenxuantruong.myproject.R;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by nguyenxuantruong on 5/8/17.
 */

public class GraphActivity extends Activity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);

        linearLayout = (LinearLayout) findViewById(R.id.graph);


        //line1
        int[] x = {1,2,3,4,5,6,7,8,9};
        int[] y = {12,7,20,4,10,8,12,6,11,18};

        TimeSeries series = new TimeSeries("Line1");

        for (int i=0;i<x.length;i++){
            series.add(x[i],y[i]);
        }

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();


        XYMultipleSeriesRenderer mrenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer();


        renderer.setLineWidth(1);
        renderer.setColor(Color.GREEN);
        // Include low and max value
        renderer.setDisplayBoundingPoints(true);
        // we add point markers
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setPointStrokeWidth(6);

        //line1
        int[] x1 = {1,2,3,4,5,6,7,8,9};
        int[] y1 = {12,3,23,34,6,15,7,23,11,9};

        TimeSeries series1 = new TimeSeries("Line2ß");

        for (int i=0;i<x1.length;i++){
            series1.add(x1[i],y1[i]);
        }

        dataset.addSeries(series1);
        dataset.addSeries(series);

        XYSeriesRenderer renderer1 = new XYSeriesRenderer();
        renderer1.setLineWidth(1);
        renderer1.setColor(Color.RED);
        // Include low and max value
        renderer1.setDisplayBoundingPoints(true);
        // we add point markers
        renderer1.setPointStyle(PointStyle.DIAMOND);
        renderer1.setPointStrokeWidth(6);


        //build
        mrenderer.addSeriesRenderer(renderer);
        mrenderer.addSeriesRenderer(renderer1);
        mrenderer.setChartTitle("Thống kê chi tiêu trong tháng");

        GraphicalView graphicalView = ChartFactory.getLineChartView(this,dataset,mrenderer);
        linearLayout.addView(graphicalView);
    }

}