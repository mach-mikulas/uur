package com.example.uur_7_ukol;

import javafx.scene.paint.Color;

public class Font {
    String fontName;
    Color fontColor;
    int fontSize;
    FontStyle fontStyle;
    boolean fontVisibility;

    public Font(String fontName, Color fontColor, int fontSize, FontStyle fontStyle, boolean fontVisibility) {
        this.fontName = fontName;
        this.fontColor = fontColor;
        this.fontSize = fontSize;
        this.fontStyle = fontStyle;
        this.fontVisibility = fontVisibility;
    }
}
