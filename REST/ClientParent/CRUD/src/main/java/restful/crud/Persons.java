/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danecek
 */
@XmlRootElement
public class Persons {

    @Override
    public String toString() {
        return "Persons{" + "persons=" + persons + '}';
    }

    @XmlElement(name = "person")
    public List<Person> persons = new ArrayList<>();

    public Persons() {

    }

    Persons(Collection<Person> values) {
        persons.addAll(values);
    }

}
