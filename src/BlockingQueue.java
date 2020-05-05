
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue extends Pipe {
   
 Queue<Operation> _inData = new LinkedList<Operation>();
 
 public synchronized  void dataIN (Operation in){
     _inData.add(in);
     notify(); 
 }
     
 public synchronized Operation dataOUT (){
	 if(_inData.isEmpty())
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return _inData.poll();
 }
	 
}
	
	
