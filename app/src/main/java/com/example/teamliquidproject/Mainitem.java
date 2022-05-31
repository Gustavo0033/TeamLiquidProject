package com.example.teamliquidproject;

public class Mainitem {
    private int id;
    private int textStringId;
    private int drawbleid;
    private int color;

    public Mainitem(int id, int drawbleid, int textStringId, int color) {
        this.id = id;
        this.drawbleid = drawbleid;
        this.textStringId = textStringId;
        this.color = color;
    }

    public void setColor(int color) {
        this.color = color;
  }

    public void setDrawbleid(int drawbleid) {
        this.drawbleid = drawbleid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTextStringId(int textStringId) {
        this.textStringId = textStringId;
    }

    public int getColor() {
        return color;
    }

    public int getDrawbleid() {
        return drawbleid;
    }

    public int getTextStringId() {
        return textStringId;
    }

    public int getId() {
        return id;
    }
}
