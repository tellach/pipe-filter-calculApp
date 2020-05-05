import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class Snippet extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "src/view.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);


		Pipe pipeGuiToCalcule = new BlockingQueue();
		Pipe pipeCalculeToTrace = new BlockingQueue();
		Pipe pipeCaLculeToGui = new BlockingQueue();
		Pipe pipeTraceToGui = new BlockingQueue();

		GuiFilter guiFilter=new GuiFilter(pipeTraceToGui, pipeGuiToCalcule);
		Filter calculeFilter  = new CalculeFilter(pipeGuiToCalcule, pipeCalculeToTrace);
		Filter traceFilter    = new TraceFilter(pipeCalculeToTrace, pipeTraceToGui);

		Thread guiThread     = new Thread( guiFilter );
		Thread calculeThread = new Thread( calculeFilter );
		Thread traceThread   = new Thread( traceFilter );

		loader.setController(guiFilter);

		//guiThread.start();
		calculeThread.start();
		traceThread.start();

		VBox root = (VBox) loader.load(fxmlStream);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.show();


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pipe pipeGuiToCalcule = new BlockingQueue();
//		Pipe pipeCalculeToTrace = new BlockingQueue();
//		Pipe pipeCaLculeToGui = new BlockingQueue();
//		Pipe pipeTraceToGui = new BlockingQueue();
//
//
//		//Filter guiFilter      = new GuiFilter(pipeTraceToGui, pipeGuiToCalcule);
//		Filter calculeFilter  = new CalculeFilter(pipeGuiToCalcule, pipeCalculeToTrace);
//		Filter traceFilter    = new TraceFilter(pipeCalculeToTrace, pipeTraceToGui);
//
//
//		Thread guiThread     = new Thread( guiFilter );
//		Thread calculeThread = new Thread( calculeFilter );
//		Thread traceThread   = new Thread( traceFilter );
//
//
//		//guiThread.start();
//		calculeThread.start();
//		traceThread.start();

		launch(args);

	}
}