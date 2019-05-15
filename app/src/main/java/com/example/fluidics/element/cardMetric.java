package com.example.fluidics.element;

import com.example.fluidics.R;

public class cardMetric {
    private int id;
    private String name;
    private int imageUrl;

    public cardMetric(int id, String name, int imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static cardMetric[] cardMetrics = {
            new cardMetric(1, "Energia", R.drawable.ener_edit),
            new cardMetric(2, "Temperatura", R.drawable.imagetempe),
            new cardMetric(3, "Dioxido", R.drawable.coimagen),
            new cardMetric(4, "Oxígeno", R.drawable.oxige),
         //   new cardMetric(5, "PaginaWeb", R.drawable.oxige),
    };

    public static cardMetric getById(int id) {

        for (cardMetric cardMetric : cardMetrics) {
            if (cardMetric.getId() == id) {
                return cardMetric;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static cardMetric[] getCardMetrics() {
        return cardMetrics;
    }

    public static void setCardMetrics(cardMetric[] cardMetrics) {
        cardMetric.cardMetrics = cardMetrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
