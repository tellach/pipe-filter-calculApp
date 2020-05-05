
import java.util.LinkedList;
import java.util.Queue;

public class PipeQueue extends Pipe {
   
 Queue<Operation> _inData = new LinkedList<Operation>();
 
 public void dataIN (Operation in){
     _inData.add(in);
 }
     
 public Operation dataOUT (){
      return _inData.poll();
 }
	 
}
	
	
