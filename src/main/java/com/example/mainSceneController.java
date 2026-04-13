package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class mainSceneController {

    int n = 90;
    CheckBox[] boxes = new CheckBox[n];

    @FXML
    private GridPane gridPane;

    @FXML
    private Button saveButton;

    @FXML
    private TextField checkboxCounter;

    @FXML
    void initialize(){
        this.initCheckBoxes();
    }

    void startSave() {
        if (countSelected() == 5) {
            System.out.println("mentés");
            Storage.writeToFile(generateLine());
        }else {
            System.err.println("hiba. 5 szám kell kereken");
        }
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

    String generateLine() {
        StringBuilder sb = new StringBuilder();
        for (CheckBox box : boxes) {
            if (box.isSelected()) {
                sb.append(box.getText());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @FXML
    void initCheckBoxes() {
        for(int i = 0; i < n; i++) {
            boxes[i] = new CheckBox();
            boxes[i].setText(String.valueOf(i + 1));
            boxes[i].selectedProperty().addListener((observable, oldValue, newValue) -> {
                int count = this.countSelected();
                checkboxCounter.setText(String.valueOf(count));
            });
            //gridPane.getChildren().add(boxes[i]);
            gridPane.add(boxes[i], i % 6, i / 6);
        }
    }
    @FXML
    void onClickSaveButton(ActionEvent event) {
        this.startSave();
    }
    
}
