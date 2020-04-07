package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    CustomSevenSegmentComponent custom;
    @FXML
    Button btn,btn1;
    @FXML
    ColorPicker pickerOn,pickerOFF,pickerBackground;
    @FXML
    Slider sliderValue;

    public void Controller() {
    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void onBtn() throws InterruptedException {
 custom.startAlarm();


    }
    @FXML
    public void onBtn1() throws InterruptedException {
        custom.stopAlarm();


    }
    @FXML
    public void OnPickerOn(){
        custom.setColorOnSegment(pickerOn.getValue());
    }
    @FXML
    public void OnPickerOFF(){
        custom.setColorOFFSegment(pickerOFF.getValue());
    }
    @FXML
    public  void OnPickerBackground(){
        custom.setBackgroundSegment(pickerBackground.getValue());
    }
    @FXML
    public void onDrag(){
        custom.setValue((int)sliderValue.getValue());
        System.out.println(sliderValue.getValue());
    }

}


