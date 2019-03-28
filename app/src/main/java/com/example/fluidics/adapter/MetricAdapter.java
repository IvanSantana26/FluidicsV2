package com.example.fluidics.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluidics.Desc_energia;
import com.example.fluidics.DescripcionDiox;
import com.example.fluidics.DescripcionO;
import com.example.fluidics.DescripcionTemp;
import com.example.fluidics.R;
import com.example.fluidics.Registro;
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
        convertView.setOnClickListener(view -> {

            if (cardMetric.cardMetrics[position].getId() == 1) {
                System.out.println("card de energia");
                Intent desc_energia = new Intent(context, Desc_energia.class);
                context.startActivity(desc_energia);
            }
            if (cardMetric.cardMetrics[position].getId() == 2) {
                System.out.println("card de temperatura");
                Intent descripcion_temp = new Intent(context, DescripcionTemp.class);
                context.startActivity(descripcion_temp);
            }
            if (cardMetric.cardMetrics[position].getId() == 3) {
                System.out.println("card de Dioxido");
                Intent descripcion_diox = new Intent(context, DescripcionDiox.class);
                context.startActivity(descripcion_diox);
            }
            if (cardMetric.cardMetrics[position].getId() == 4) {
                System.out.println("card de Oxigeno");
                Intent descripcion_o = new Intent(context, DescripcionO.class);
                context.startActivity(descripcion_o);
            }

        });
        return convertView;
    }
}
