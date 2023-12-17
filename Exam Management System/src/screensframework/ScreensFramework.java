
package screensframework;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Libetoe
 */
public class ScreensFramework extends Application {
    public static String screenID = "main";
    public static String screenFile = "HomeScreen.fxml";
    public static String screen1ID = "screen1";
    public static String screen1File = "Screen1.fxml";
    public static String screen2ID = "screen2";
    public static String screen2File = "Screen2.fxml";
    public static String screen3ID = "screen3";
    public static String screen3File = "Screen3.fxml";
    public static String screen4ID = "screen4";
    public static String screen4File = "Screen4.fxml";
    public static String screen5ID = "screen5";
    public static String screen5File = "Screen5.fxml";
    public static String screen6ID = "screen6";
    public static String screen6File = "Screen6.fxml";
    public static String screen7ID = "screen7";
    public static String screen7File = "Screen7.fxml";
    public static String screen8ID = "screen8";
    public static String screen8File = "Screen8.fxml";
    public static String screen9ID = "screen9";
    public static String screen9File = "Screen9.fxml";
    public static String screen10ID = "screen10";
    public static String screen10File = "Screen10.fxml";
    public static String screen11ID = "screen11";
    public static String screen11File = "Screen11.fxml";
    public static String screen12ID = "screen12";
    public static String screen12File = "Screen12.fxml";
    public static String screen13ID = "screen13";
    public static String screen13File = "Screen13.fxml";
    public static String screen14ID = "screen14";
    public static String screen14File = "Screen14.fxml";
    public static String screen15ID = "screen15";
    public static String screen15File = "Screen15.fxml";
    public static String screen16ID = "screen16";
    public static String screen16File = "Screen16.fxml";
    public static String screen17ID = "screen17";
    public static String screen17File = "Screen17.fxml";
    public static String screen18ID = "screen18";
    public static String screen18File = "Screen18.fxml";
    public static String screen19ID = "screen19";
    public static String screen19File = "Screen19.fxml";
    public static String screen20ID = "screen20";
    public static String screen20File = "Screen20.fxml";
    public static String screen21ID = "screen21";
    public static String screen21File = "Screen21.fxml";
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screenID, ScreensFramework.screenFile);
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        mainContainer.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
        mainContainer.loadScreen(ScreensFramework.screen7ID, ScreensFramework.screen7File);
        mainContainer.loadScreen(ScreensFramework.screen8ID, ScreensFramework.screen8File);
        mainContainer.loadScreen(ScreensFramework.screen9ID, ScreensFramework.screen9File);
        mainContainer.loadScreen(ScreensFramework.screen10ID, ScreensFramework.screen10File);
        mainContainer.loadScreen(ScreensFramework.screen11ID, ScreensFramework.screen11File);
        mainContainer.loadScreen(ScreensFramework.screen12ID, ScreensFramework.screen12File);
        mainContainer.loadScreen(ScreensFramework.screen13ID, ScreensFramework.screen13File);
        mainContainer.loadScreen(ScreensFramework.screen14ID, ScreensFramework.screen14File);
        mainContainer.loadScreen(ScreensFramework.screen15ID, ScreensFramework.screen15File);
        mainContainer.loadScreen(ScreensFramework.screen16ID, ScreensFramework.screen16File);
        mainContainer.loadScreen(ScreensFramework.screen17ID, ScreensFramework.screen17File);
        mainContainer.loadScreen(ScreensFramework.screen18ID, ScreensFramework.screen18File);
        mainContainer.loadScreen(ScreensFramework.screen19ID, ScreensFramework.screen19File);
        mainContainer.loadScreen(ScreensFramework.screen20ID, ScreensFramework.screen20File);
        mainContainer.loadScreen(ScreensFramework.screen21ID, ScreensFramework.screen2File);
        
        mainContainer.setScreen(ScreensFramework.screenID);
        
        Group root = new Group(); 
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
