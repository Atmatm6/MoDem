package atmatm6.modem;

import atmatm6.modem.logging.MoDemConfigurationFactory;
import atmatm6.modem.reading.AdventureReader;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationFactory;

import java.io.IOException;

public class MoDem extends Application{
    public static Logger log;
    /* TODO: Setting debug will do different things like:
       TODO: Allowing changes to the save
       TODO: Changing areas with special commands */
    public static boolean isDebug = false;
    public static final ConfigurationFactory cf = new MoDemConfigurationFactory();

    public static void main(String[] args) throws IOException {
        ConfigurationFactory.setConfigurationFactory(cf);
        log = LogManager.getLogger("MoDem");
        int lenth = args.length;
        if(lenth != 0)if (args[0].equals("123abc")) isDebug = true;
        AdventureReader.initDirections();
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene sceneMain = new Scene(root, 480, 480);
        // Starting here is where to insert different things.
        TextField whatDo = new TextField();
        TextArea advBox = new TextArea();
        whatDo.setMinHeight(30);
        whatDo.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                // TODO: Handle text adventure change
                advBox.appendText(whatDo.getText() +"\n");
            }
        });

        advBox.setEditable(false);
        advBox.setMinHeight(sceneMain.getHeight()-30);
        advBox.textProperty().addListener((observable, oldValue, newValue) -> {advBox.setScrollTop(Double.MIN_VALUE);});
        /**
         * this will scroll to the top
         * use Double.MAX_VALUE to scroll to the bottom
         */

        // Ending here is where to insert different things.
        // Root editing also starts here.
        sceneMain.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            advBox.setMinWidth(newSceneWidth.doubleValue());
        });
        sceneMain.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            advBox.setMinHeight(newSceneHeight.doubleValue()-30);
        });
        root.getChildren().addAll(whatDo, advBox);
        //Root editing ends here.
        primaryStage.setTitle("MoDem");
        primaryStage.setScene(sceneMain);
        primaryStage.show();
    }
}