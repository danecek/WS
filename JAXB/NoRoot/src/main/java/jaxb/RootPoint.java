package jaxb;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rootpoint", namespace = "http://points")
public class RootPoint extends Point {

    public RootPoint() {
    }

    public RootPoint(int x, int y) {
        super(x,y);
    }

}
