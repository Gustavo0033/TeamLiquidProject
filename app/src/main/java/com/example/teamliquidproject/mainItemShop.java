package com.example.teamliquidproject;

public class mainItemShop {
    private int id2;
    private int textStringId2;
    private int drawbleid2;
    private int color2;

    public mainItemShop(int id2, int textStringId2, int drawbleid2, int color2) {
        this.id2 = id2;
        this.textStringId2 = textStringId2;
        this.drawbleid2 = drawbleid2;
        this.color2 = color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor2() {
        return color2;
    }

    public void setDrawbleid2(int drawbleid2) {
        this.drawbleid2 = drawbleid2;
    }

    public int getDrawbleid2() {
        return drawbleid2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId2() {
        return id2;
    }

    public void setTextStringId2(int textStringId2) {
        this.textStringId2 = textStringId2;
    }

    public int getTextStringId2() {
        return textStringId2;
    }
}
