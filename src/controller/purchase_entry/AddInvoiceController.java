package controller.purchase_entry;

import app.utils.DBUtils;
import app.utils.HelperMethods;
import app.utils.NameHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AddInvoiceController {

    @FXML public Button selectBtn;
    @FXML public DatePicker dateOfPurchaseDatePicker;
    @FXML public Button confirmBtn;
    @FXML public Button cancelBtn;
    @FXML public Label selectedSupplierLabel;


    public void addInvoice(String supplier, String dateOfPurchase){
        String sqlQuery = "INSERT INTO invoices (supplier, date_of_purchase)" +
                "VALUES (?, ?)";
        try(Connection c = DBUtils.getConnection();
            PreparedStatement pstm = c.prepareStatement(sqlQuery)){
            pstm.setString(1, supplier);
            pstm.setString(2, dateOfPurchase);
            pstm.execute();
            c.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private boolean validateFields(){
        return dateOfPurchaseDatePicker.getValue() != null &&
                !selectedSupplierLabel.getText().equals("Label");
    }

    public void selectOnClick(ActionEvent actionEvent) throws IOException {
        Stage window = HelperMethods.openWindow("purchase_entry/select-supplier.fxml",
                "Something");
        window.setOnHidden((e) ->{
            selectedSupplierLabel.setText(NameHolder.supplierName);
        });
    }

    public void cancelOnClick(ActionEvent actionEvent){
        ((Stage) cancelBtn.getScene().getWindow()).close();
    }

    public void confirmOnClick(ActionEvent actionEvent){
        if (validateFields()){
            addInvoice(selectedSupplierLabel.getText(),
                    dateOfPurchaseDatePicker.getValue().
                            format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            ((Stage) cancelBtn.getScene().getWindow()).close();
        }
        else{
            HelperMethods.invalidFieldsAlert((Stage) cancelBtn.getScene().getWindow());
        }
    }
}
