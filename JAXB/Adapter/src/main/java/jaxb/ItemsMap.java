package jaxb;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(ItemsAdapter.class)
public class ItemsMap {

    public Map<Integer, String> items = new HashMap<>();

    void addItems(int key, String value) {
        items.put(key, value);
    }
}
