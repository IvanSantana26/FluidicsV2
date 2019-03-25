package com.example.fluidics.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluidics.R;
import com.example.fluidics.element.cardMetric;

public class MetricAdapter extends BaseAdapter {
    private Context context;

    public MetricAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return cardMetric.cardMetrics.length;
    }

    @Override
    public Object getItem(int position) {
        return cardMetric.getCardMetrics()[position];
    }

    @Override
    public long getItemId(int position) {
        return cardMetric.getCardMetrics()[position].getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card_metrics, parent, false);
        }
        ImageView cardImage = (ImageView) convertView.findViewById(R.id.ivMetric);
        TextView cardText = (TextView) convertView.findViewById(R.id.tvMetric);
        cardMetric currentCard = cardMetric.getCardMetrics()[position];

        cardImage.setImageResource(currentCard.getImageUrl());
        cardText.setText(currentCard.getName());

        return convertView;
    }
}
