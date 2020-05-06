import java.awt.print.Book;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import sun.plugin.dom.html.HTMLBodyElement;

public  class GuiFilter extends Filter {

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
     
    public Operation getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( Operation operation){ _dataOUTPipe.dataIN(operation); }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
        /*
        while(true) {
            affichageMenu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Choix? ");
            String choix = sc.next();

            int operandG, operandD;

            switch (choix) {
                case "0":
                    // Terminate JVM
                    System.exit(0);
                    break;
                case "1":

                    System.out.print("OperandeG ? ");
                    operandG = sc.nextInt();
                    System.out.print("OperandeD ? ");
                    operandD = Integer.parseInt(sc.next());
                    Operation operationS = new Operation(operandG, "Somme", operandD);
                    sendData(operationS);
                    break;

                case "2":
                    System.out.print("OperandeG ? ");
                    operandG = sc.nextInt();
                    System.out.print("OperandeD ? ");
                    operandD = sc.nextInt();
                    Operation operationP = new Operation(operandG, "Produit", operandD);
                    sendData(operationP);
                    break;

                case "3":
                    System.out.print("Operande ? ");
                    operandG = sc.nextInt();
                    Operation operationF = new Operation(operandG, "Factorielle", 0);
                    sendData(operationF);
                    break;

                case "4":
                    //Send a message to TraceFilter Through GuiToCalcule & CalculeToTrace pipes
                    System.out.print("Nombre de ligne ? ");
                    operandG = sc.nextInt();
                    Operation operationT = new Operation(operandG,"Trace",0);
                    sendData(operationT);
                    break;
                default:
                    System.out.println("Arret du programme");
                    System.exit(0);
            }
            System.out.println("Resultat: " + getData());
        }

         */
	}

    @FXML
    private void handleSum(ActionEvent event) {
        ObservableList<String> results=FXCollections.observableArrayList();
        int x = Integer.parseInt(number1.getText());
        int y = Integer.parseInt(number2.getText());
        Operation operationS = new Operation(x, "Somme", y);
        sendData(operationS);
        results.addAll(getData().toString());
        listView.setItems(results);
        listView.setVisible(true);
        //result.setText(getData().toString());
    }
    @FXML
    private void handleProduct(ActionEvent event) {
        ObservableList<String> results=FXCollections.observableArrayList();
        int x = Integer.parseInt(number1.getText());
        int y = Integer.parseInt(number2.getText());
        Operation operationS = new Operation(x, "Produit", y);
        sendData(operationS);
        results.addAll(getData().toString());
        listView.setItems(results);
        listView.setVisible(true);
        //result.setText(getData().toString());
    }
    @FXML
    private void handleFact(ActionEvent event) {
        ObservableList<String> results=FXCollections.observableArrayList();
        int x = Integer.parseInt(number1.getText());
        Operation operationS = new Operation(x, "Factorielle", 0);
        sendData(operationS);
        results.addAll(getData().toString());
        listView.setItems(results);
        listView.setVisible(true);
        //result.setText(getData().toString());
    }

    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    private void trace(ActionEvent event) {

        ObservableList<String> trace=FXCollections.observableArrayList();
        int x = Integer.parseInt(number1.getText());
        Operation operationT = new Operation(x,"Trace",0);
        sendData(operationT);
        String[] list = (getData().toString()).split("/n");
        trace.addAll(list);
        listView.setItems(trace);
        listView.setVisible(true);

    }



//	public void affichageMenu(){
//        System.out.println("===============");
//        System.out.println("0:Quittez ");
//        System.out.println("1:Somme ");
//        System.out.println("2:Produit ");
//        System.out.println("3:Factorielle ");
//        System.out.println("4:Trace ");
//        System.out.println("===============");
//    }
}
 