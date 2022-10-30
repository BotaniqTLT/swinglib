package DTO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class MapComboBoxModel<K,V> extends DefaultComboBoxModel {


    public MapComboBoxModel(Map<K,V> map) {
        super(prepareArray(map));


    }

    private static <K, V> Object[] prepareArray(Map<K,V> map) {
        ArrayList<Container<K,V>> tmp = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            tmp.add(new Container<>(entry.getKey(),entry.getValue()));
        }
        return tmp.toArray();
    }

    public Container<K,V> getSelectedContainer(){

        return ( Container<K,V>) getSelectedItem();
    }
}
