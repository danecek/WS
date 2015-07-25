/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ItemsAdapter extends XmlAdapter<ItemsList, ItemsMap> {

    @Override
    public ItemsMap unmarshal(ItemsList value) {
        return null;
    }

    @Override
    public ItemsList marshal(ItemsMap b) {
        ItemsList courses = new ItemsList();
        for (Map.Entry e : b.items.entrySet()) {
            courses.addItem(e.toString());//.getKey().toString() + ':' + e.getValue());
        }
        return courses;
    }
}
