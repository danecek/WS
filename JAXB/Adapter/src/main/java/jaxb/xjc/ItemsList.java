package jaxb.xjc;

import java.util.ArrayList;
import java.util.Collection;

public class ItemsList {

    public Collection<String> item = new ArrayList<>();

    public void addItem(String w) {
        item.add(w);
    }
}
