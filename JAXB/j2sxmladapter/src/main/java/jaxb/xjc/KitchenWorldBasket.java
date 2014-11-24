package jaxb.xjc;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="KitchenWorldBasketType")
public class KitchenWorldBasket {
    @XmlJavaTypeAdapter(AdapterPurchaseListToHashMap.class)
    HashMap basket = new HashMap();
    
    public KitchenWorldBasket(){}
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("KitchenWorldBasket:\n");
        
        // For QA consistency order the output. 
        TreeMap tMap = new TreeMap(basket);
        for(Iterator i=tMap.keySet().iterator(); i.hasNext();){
            Integer key = (Integer)i.next();
            buf.append("key: " + key.toString() + "\tvalue: " + tMap.get(key) +"\n");
        }     
        return buf.toString();
    }
}

