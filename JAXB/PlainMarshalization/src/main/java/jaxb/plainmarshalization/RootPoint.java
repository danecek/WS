/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.plainmarshalization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mypoint", namespace = "http://points")
public class RootPoint {

    private int x;
    public int y;

    public RootPoint() {
    }

    public RootPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @XmlElement
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

}
