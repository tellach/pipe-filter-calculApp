import java.io.*;

import java.io.File;  // Import the File class
import java.util.Scanner;


public  class TraceFilter extends Filter {

    final static String FILE_NAME = "Tracker.txt";

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public TraceFilter(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}
    
    public Operation getData(){ return _dataINPipe.dataOUT(); }
     
    public void sendData( Operation operation){
        _dataOUTPipe.dataIN(operation);
    }

    @Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub

        createFile(FILE_NAME);

        while (true) {
		    Operation operation = getData();
		    if(operation.name.equals("Trace")) {
                lireop(operation.operandGauche, FILE_NAME);
            }else{
                saveop(operation, FILE_NAME);
            }
            sendData(operation);
		}
	}

	public void createFile(String fileName){
        try {
            File file = new File(fileName);
            if(file.createNewFile())
                System.out.println("File created: " + file.getName());
            else
                System.out.println("File already exists.");
        }catch (IOException ioException){

            System.out.println("An error occurred.");
            ioException.printStackTrace();
        }
    }

	public void saveop(Operation operation, String fileName){

        try {
            //FileWriter(File file, boolean append)
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.write(operation.toString()+"\n");
            fileWriter.close();
        } catch (IOException ioException) {
            System.out.println("An error occurred.");
            ioException.printStackTrace();
        }
    }

    public void lireop(int nb, String fileName){
	    //nb : c'est le nombre d'operations
        try{
            File file = new File(fileName);
            Scanner lecteur = new Scanner(file);
            int compteur = 0;
            System.out.println("****Tracker.txt****");
            while(lecteur.hasNextLine() && compteur<nb){
                //sendData(lecteur.nextLine());
                System.out.println(lecteur.nextLine());
                compteur++;
            }
            System.out.println("*******************");
            lecteur.close();

        } catch (IOException ioException) {
            System.out.println("An error occurred.");
            ioException.printStackTrace();
        }
    }

}
 