/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moxy;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danecek
 */
@XmlRootElement(namespace = "oldnamespace")
public class Address {

    public Address() {
    }

    public Address(String street, int no) {
        this.street = street;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", no=" + no + '}';
    }

    public String street;
    public int no;

}
