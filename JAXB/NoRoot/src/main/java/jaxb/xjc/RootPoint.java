package jaxb.xjc;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mypoint", namespace = "http://points")
public class RootPoint {

    public RootPoint() {
    }

    public RootPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private int x;
    private int y;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
