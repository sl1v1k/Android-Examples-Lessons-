package com.example.listview;

public class CustomData {

    private int drawableId;
    private String text;

    public CustomData(int drawableId, String text) {
        this.drawableId = drawableId;
        this.text = text;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getText() {
        return text;
    }
}
