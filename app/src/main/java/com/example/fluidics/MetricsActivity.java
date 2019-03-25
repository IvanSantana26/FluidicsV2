package com.example.fluidics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.fluidics.adapter.MetricAdapter;

public class MetricsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrics);
        GridView gridView = (GridView) findViewById(R.id.gvCards);
        MetricAdapter adapter = new MetricAdapter(this);
        gridView.setAdapter(adapter);
        System.out.println("Asd");
    }
}
