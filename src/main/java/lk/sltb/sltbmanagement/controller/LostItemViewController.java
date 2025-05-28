package lk.sltb.sltbmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.sltb.sltbmanagement.dto.EmployeeDto;
import lk.sltb.sltbmanagement.dto.LostItemDto;
import lk.sltb.sltbmanagement.model.LostItemModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LostItemViewController implements Initializable {

    private final LostItemModel model = new LostItemModel();
    public TextField txtEmployeeId;
    public TextField txtType;
    public TextField txtDes;
    public TextField txtReport;
    public TextField txtLocation;
    public TextField txtDate;
    public TextField txtTime;
    public Label lblId;

    public void SaveOnAction(ActionEvent actionEvent) {
        String itemId = lblId.getText();
        String itemType = txtType.getText();
        String description = txtDes.getText();
        String reportedBy = txtReport.getText();
        String location = txtLocation.getText();
        String time = txtTime.getText();
        String date = txtDate.getText();
        String empId = txtEmployeeId.getText();


        LostItemDto lostItemDto = new LostItemDto(itemId, itemType, description, reportedBy, location, time, date, empId);

        try {


            String isSaved = model.saveLostItem(lostItemDto);
            new Alert(Alert.AlertType.CONFIRMATION, isSaved).show();


        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to Save Customer").show();
        }


    }


    private void loadNextId() throws SQLException, ClassNotFoundException {
        String nextId= model.getNextLostId();

        lblId.setText(nextId);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
  try {

      loadNextId();

  } catch (Exception e) {
      e.printStackTrace();
      new Alert(Alert.AlertType.ERROR, "Fail to Save Customer").show();


  }
    }
}
