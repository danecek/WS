/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.crud;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }

    public Integer id;
    public String name;

}
