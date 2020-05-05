
public class Snippet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipe pipeGuiToCalcule = new BlockingQueue();
		Pipe pipeCalculeToTrace = new BlockingQueue();
		Pipe pipeCaLculeToGui = new BlockingQueue();
		Pipe pipeTraceToGui = new BlockingQueue();


		Filter guiFilter      = new GuiFilter(pipeTraceToGui, pipeGuiToCalcule);
		Filter calculeFilter  = new CalculeFilter(pipeGuiToCalcule, pipeCalculeToTrace);
		Filter traceFilter    = new TraceFilter(pipeCalculeToTrace, pipeTraceToGui);


		Thread guiThread     = new Thread( guiFilter );
		Thread calculeThread = new Thread( calculeFilter );
		Thread traceThread   = new Thread( traceFilter );


		guiThread.start();
		calculeThread.start();
		traceThread.start();


	}
}