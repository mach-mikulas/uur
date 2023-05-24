package com.example.uur_5;

import javafx.beans.property.*;
import javafx.scene.paint.Color;


public class Colors {


    private static DoubleProperty RED_COLOR = new SimpleDoubleProperty(0);
    private static DoubleProperty GREEN_COLOR = new SimpleDoubleProperty(0);
    private static DoubleProperty BLUE_COLOR = new SimpleDoubleProperty(0);

    public Color getColor() {
        Color barva = Color.rgb(RED_COLOR.intValue(), GREEN_COLOR.intValue(), BLUE_COLOR.intValue(), 1);
        return barva;
    }

    public DoubleProperty getRed() {
        return RED_COLOR;
    }

    public DoubleProperty getGreen() {
        return GREEN_COLOR;
    }

    public DoubleProperty getBlue() {
        return BLUE_COLOR;
    }


}
