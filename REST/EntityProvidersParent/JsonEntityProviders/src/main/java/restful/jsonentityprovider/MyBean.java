/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.jsonentityprovider;

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
    public String toString() {
        return "MyBean{" + anyString + ':' + anyNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        if (!Objects.equals(this.anyString, other.anyString)) {
            return false;
        }
        if (this.anyNumber != other.anyNumber) {
            return false;
        }
        return true;
    }
}
