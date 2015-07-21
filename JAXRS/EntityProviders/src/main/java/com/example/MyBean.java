/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean {

    @XmlElement
    public String anyString;
    @XmlElement
    public int anyNumber;

    public MyBean(String anyString, int anyNumber) {
        this.anyString = anyString;
        this.anyNumber = anyNumber;
    }

    public MyBean() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.anyString);
        hash = 83 * hash + this.anyNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyBean other = (MyBean) obj;
        return true;
    }

    @Override
    public String toString() {
        return "MyBean{" + anyString + '\'' + anyNumber + '}';
    }
}
