package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class mainSceneController {

    int n = 90;
    CheckBox[] boxes = new CheckBox[n];

    @FXML
    private GridPane gridPane;

    @FXML
    private Button saveButton;

    @FXML
    void initialize(){
        this.initCheckBoxes();
    }

    void startSave() {
        System.out.println(countSelected());
    }

    int countSelected() {
        int counter = 0;
        for (CheckBox box : boxes) {
            if (box.isSelected()) {
                counter++;
            }
        }
        return counter;
    }

    @FXML
    void initCheckBoxes() {
        for(int i = 0; i < n; i++) {
            boxes[i] = new CheckBox();
            boxes[i].setText(String.valueOf(i + 1));
            //gridPane.getChildren().add(boxes[i]);
            gridPane.add(boxes[i], i % 6, i / 6);
        }
    }
    @FXML
    void onClickSaveButton(ActionEvent event) {
        this.startSave();
    }
    
}
