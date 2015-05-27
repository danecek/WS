/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
//@XmlSeeAlso(Root.Element.class)
public class Root {

 //   @XmlElement
    public static final int CONST = 10;
    
    public static class Element  {

        private int content;

        public Element(int content) {
            this.content = content;
        }

        public int getContent() {
            return content;
        }

        /**
         * @param content the content to set
         */
        public void setContent(int content) {
            this.content = content;
        }
    }

    public Root() {
        Collections.addAll(elems, new Element(1), new Element(2));
    }
  //  @XmlElementWrapper(name = "wrapper")
    public List<Element> elems = new ArrayList<>();
    public int x = 20;

}
