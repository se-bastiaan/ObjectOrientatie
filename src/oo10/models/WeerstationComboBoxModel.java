package oo10.models;

import javax.swing.*;
import java.util.List;

/**
 * ComboboxModel for Weerstations
 */
public class WeerstationComboBoxModel extends DefaultComboBoxModel<Weerstation> {

    public void addAll(List<Weerstation> weerstationList) {
        for(Weerstation ws : weerstationList)
            addElement(ws);
    }

}
