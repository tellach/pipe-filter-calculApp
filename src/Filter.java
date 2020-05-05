

public abstract class Filter  implements Runnable{
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public Operation getData(){

        return _dataINPipe.dataOUT();
    }
     
    public void sendData( Operation operation){

        _dataOUTPipe.dataIN(operation);
    }

    abstract void execute();
}
 
