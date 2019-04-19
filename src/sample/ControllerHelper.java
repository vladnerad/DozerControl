package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public abstract class ControllerHelper {

    public static void setUneditableFields(ArrayList<ComboBox<String>> comboBoxes, ArrayList<TextField> textFields){
        comboBoxes.forEach(cb -> cb.setDisable(true));
        textFields.forEach(tf -> tf.setEditable(false));
    }
}
