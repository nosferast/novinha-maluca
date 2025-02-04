package com.ethan0pia.bots.CowKiller.UI;

import com.ethan0pia.bots.CowKiller.CowKiller;
import com.runemate.game.api.hybrid.util.Resources;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class CowInfoUI extends GridPane implements Initializable{

    @FXML
    private Label runtime, gpGained, hidesCollected, ratePH, gpPH;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setVisible(true);
    }

    // An object property is a container of an object, which can be added
    // listeners to. In this case the property contains our controller class
    // (this)

    public CowInfoUI(CowKiller bot) {
        FXMLLoader loader = new FXMLLoader();
        Future<InputStream> stream = bot.getPlatform().invokeLater(() -> Resources.getAsStream("com/ethan0pia/bots/CowKiller/UI/CowUI.fxml"));
        loader.setController(this);
        // NOTE: By setting the root to (this) you must change your .fxml to reflect fx:root
        loader.setRoot(this);
        try {
            loader.load(stream.get());
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // This method will update the text that is presented to the end user
    public void update(int rate, int count, String runTime, int leatherPrice, int gpRate) {
        try {
            gpPH.textProperty().set(""+gpRate);
            int gained = count*leatherPrice;
            gpGained.textProperty().set(""+gained);
            hidesCollected.textProperty().set(""+count);
            ratePH.textProperty().set(""+rate);
            runtime.textProperty().set("" + runTime);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
