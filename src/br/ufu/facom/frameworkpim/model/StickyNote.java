package br.ufu.facom.frameworkpim.model;

public class StickyNote {

    private String text;
    private int xpos;
    private int ypos;

    public StickyNote(String text) {
        this.text = text;
    }

    public StickyNote(String text, int xpos, int ypos) {
        this.text = text;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

}
