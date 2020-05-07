import java.awt.print.Book;
import java.util.Arrays;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import sun.plugin.dom.html.HTMLBodyElement;

public class GuiFilter extends Filter {

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    @FXML
    private TextField number1;
    @FXML
    private TextField number2;
    @FXML
    private Label result;
    @FXML
    private ListView listView;


    public GuiFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    public Operation getData() {
        return _dataINPipe.dataOUT();
    }

    public void sendData(Operation operation) {
        _dataOUTPipe.dataIN(operation);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        execute();
    }

    @Override
    synchronized void execute() {

    }

    @FXML
    private void handleSum(ActionEvent event) {
        try {
            int x = Integer.parseInt(number1.getText());
            int y = Integer.parseInt(number2.getText());
            Operation operationS = new Operation(x, "Somme", y);
            sendData(operationS);
            result.setText(getData().toString());
        } catch (NumberFormatException e) {
            result.setText("Entrer deux numéros valides");
        }
    }

    @FXML
    private void handleProduct(ActionEvent event) {
        try {
            int x = Integer.parseInt(number1.getText());
            int y = Integer.parseInt(number2.getText());
            Operation operationS = new Operation(x, "Produit", y);
            sendData(operationS);
            result.setText(getData().toString());
        } catch (NumberFormatException e) {
            result.setText("Entrer deux numéros valides");
        }
    }

    @FXML
    private void handleFact(ActionEvent event) {
        try {
            int x = Integer.parseInt(number1.getText());
            Operation operationS = new Operation(x, "Factoriel", 0);
            sendData(operationS);
            result.setText(getData().toString());
        } catch (NumberFormatException e) {
            result.setText("Entrer un numéro valide");
        }
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void trace(ActionEvent event) {

        ObservableList<String> trace = FXCollections.observableArrayList();
        Operation operationT = new Operation(0, "Trace", 0);
        sendData(operationT);
        String[] list = (getData().toString()).split("/n");
        trace.addAll(list);
        listView.setItems(trace);
        listView.setVisible(true);

    }
}
 