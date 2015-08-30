/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.collection;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danecek
 */
@XmlRootElement
public class MyBean {

    public MyBean() {
    }

    public MyBean(int x) {
        this.x = x;
    }

    public int x;

    @Override
    public String toString() {
        return "MyBean{" + "x=" + x + '}';
    }
}
