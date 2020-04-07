package sample;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;


public class SevenSegmentController implements Initializable
{
    @FXML
    private Polygon segmentA1k,segmentA100,segmentA10,segmentA1;
    @FXML
    private Polygon segmentB1k,segmentB100,segmentB10,segmentB1;
    @FXML
    private Polygon segmentC1k,segmentC100,segmentC10,segmentC1;
    @FXML
    private Polygon segmentD1k,segmentD100,segmentD10,segmentD1;
    @FXML
    private Polygon segmentE1k,segmentE100,segmentE10,segmentE1;
    @FXML
    private Polygon segmentF1k,segmentF100,segmentF10,segmentF1;
    @FXML
    private Polygon segmentG1k,segmentG100,segmentG10,segmentG1;
    @FXML
    private Circle dot1k,dot100,dot10,dot1;
    @FXML
    private AnchorPane segment1kPane,segment100Pane,segment10Pane,segment1Pane,componentPane;

   private ObjectProperty<Paint> colorOn = new SimpleObjectProperty<>(Color.BLACK);
    private ObjectProperty<Paint> colorOFF = new SimpleObjectProperty<>(Color.WHITE);
   private ObjectProperty<Paint> colorDot = new SimpleObjectProperty<>(Color.WHITE);
   private ObjectProperty<Paint> colorPane = new SimpleObjectProperty<>(Color.TOMATO);

    private  Map<Integer, List<Polygon>> segmentMap = new HashMap<>();

    private FadeTransition fade = new FadeTransition();

  private List<Polygon> oneSegment = new ArrayList<>();
  private List<Polygon> tenSegment = new ArrayList<>();
  private List<Polygon> hundredSegment = new ArrayList<>();
  private List<Polygon> thousandSegment = new ArrayList<>();

    private List<String> binaryList = new ArrayList<String>(){{
       add("1111110"); //0
       add("0110000"); //1
       add("1101101"); //2
       add("1111001"); //3
       add("0110011"); //4
       add("1011011"); //5
       add("1011111"); //6
       add("1110000"); //7
       add("1111111"); //8
       add("1111011"); //9

   }};

    private Map<Integer, String> decoderMap = new HashMap<Integer, String>(){{
        put(0,binaryList.get(0));
        put(1,binaryList.get(1));
        put(2,binaryList.get(2));
        put(3,binaryList.get(3));
        put(4,binaryList.get(4));
        put(5,binaryList.get(5));
        put(6,binaryList.get(6));
        put(7,binaryList.get(7));
        put(8,binaryList.get(8));
        put(9,binaryList.get(9));
    }};



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
       initMapSegment();
       dot1k.fillProperty().set(colorDot.getValue());
       dot100.fillProperty().set(colorDot.getValue());
       dot10.fillProperty().set(colorDot.getValue());
       dot1.fillProperty().set(colorDot.getValue());

    }

    public void setValue(int thousand, int hundred, int ten, int one) {
        if (thousand > 0) {
            for (int i = 0; i < 7; i++) {
                if (decoderMap.get(thousand).charAt(i) == '1') {
                    segmentMap.get(3).get(i).fillProperty().bind(colorOn);
                } else if (decoderMap.get(thousand).charAt(i) == '0') {
                    segmentMap.get(3).get(i).fillProperty().bind(colorOFF);
                }
            }
        }
        if (hundred > 0) {
            for (int i = 0; i < 7; i++) {
                if (decoderMap.get(hundred).charAt(i) == '1') {
                    segmentMap.get(2).get(i).fillProperty().bind(colorOn);
                } else if (decoderMap.get(hundred).charAt(i) == '0') {
                    segmentMap.get(2).get(i).fillProperty().bind(colorOFF);
                }
            }
        }
        if (ten > 0) {
            for (int i = 0; i < 7; i++) {
                if (decoderMap.get(ten).charAt(i) == '1') {
                    segmentMap.get(1).get(i).fillProperty().bind(colorOn);
                } else if (decoderMap.get(ten).charAt(i) == '0') {
                    segmentMap.get(1).get(i).fillProperty().bind(colorOFF);
                }
            }
        }
        if (one > 0) {
            for (int i = 0; i < 7; i++) {
                if (decoderMap.get(one).charAt(i) == '1') {
                    segmentMap.get(0).get(i).fillProperty().bind(colorOn);
                } else if (decoderMap.get(one).charAt(i) == '0') {
                    segmentMap.get(0).get(i).fillProperty().bind(colorOFF);
                }
            }
        }
    }


        public void bindColorOn(ObjectProperty<Paint> value){
        colorOn =value ;
                for(int i=0; i < 7;i++){
                    if(decoderMap.get(1).charAt(i) == '1'){
                        segmentMap.get(3).get(i).fillProperty().bind(value);
                    }

                }


                for(int i=0; i < 7;i++){
                    if(decoderMap.get(2).charAt(i) == '1'){
                        segmentMap.get(2).get(i).fillProperty().bind(value);
                    }

                }

                for(int i=0; i < 7;i++){
                    if(decoderMap.get(3).charAt(i) == '1'){
                        segmentMap.get(1).get(i).fillProperty().bind(value);
                    }

                }


                for(int i=0; i < 7;i++){
                    if(decoderMap.get(4).charAt(i) == '1'){
                        segmentMap.get(0).get(i).fillProperty().bind(value);
                    }

                }


        }
    public void bindColorOff(ObjectProperty<Paint> value){
        colorOFF = value;
        for(int i=0; i < 7;i++){

             if(decoderMap.get(1).charAt(i) == '0'){
                segmentMap.get(3).get(i).fillProperty().bind(value);
            }
        }


        for(int i=0; i < 7;i++){

             if(decoderMap.get(2).charAt(i) == '0'){
                segmentMap.get(2).get(i).fillProperty().bind(value);
            }
        }

        for(int i=0; i < 7;i++){

             if(decoderMap.get(3).charAt(i) == '0'){
                segmentMap.get(1).get(i).fillProperty().bind(value);
            }
        }


        for(int i=0; i < 7;i++){

             if(decoderMap.get(4).charAt(i) == '0'){
                segmentMap.get(0).get(i).fillProperty().bind(value);
            }
        }
    }
    public void bindColorPane(String string){
        segment1Pane.styleProperty().set("-fx-background-color: #"+string);
        segment10Pane.styleProperty().set("-fx-background-color: #"+string);
        segment100Pane.styleProperty().set("-fx-background-color: #"+string);
        segment1kPane.styleProperty().set("-fx-background-color: #"+string);

    }

    public void setColorOnSegment(Paint value, int thousand, int hundred, int ten, int one){
        this.colorOn.set(value);
        setValue(thousand,hundred,ten,one);
    }
    public void setColorOFFSegment(Paint value, int thousand, int hundred, int ten, int one){
        this.colorOFF.set(value);
        setValue(thousand,hundred,ten,one);
    }

    public void startAlarm() {
        fade.setDuration(Duration.millis(1000));
        fade.setNode(componentPane);
        fade.setByValue(0.99);
        fade.setToValue(0.01);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();
    }
    public void stopAlarm(){
        fade.stop();
        componentPane.setOpacity(1);
    }


    public Paint getColorOn() {
        return colorOn.get();
    }

    public ObjectProperty<Paint> colorOnProperty() {
        return colorOn;
    }

    public void setColorOn(Paint colorOn) {
        this.colorOn.set(colorOn);
    }

    public Paint getColorOFF() {
        return colorOFF.get();
    }

    public ObjectProperty<Paint> colorOFFProperty() {
        return colorOFF;
    }

    public void setColorOFF(Paint colorOFF) {
        this.colorOFF.set(colorOFF);
    }

    public Paint getColorDot() {
        return colorDot.get();
    }

    public ObjectProperty<Paint> colorDotProperty() {
        return colorDot;
    }

    public void setColorDot(Paint colorDot) {
        this.colorDot.set(colorDot);
    }



    private void initOneSegment(){
       oneSegment.add(segmentA1);
       oneSegment.add(segmentB1);
       oneSegment.add(segmentC1);
       oneSegment.add(segmentD1);
       oneSegment.add(segmentE1);
       oneSegment.add(segmentF1);
       oneSegment.add(segmentG1);
   }
    private void initTenSegment(){
        tenSegment.add(segmentA10);
        tenSegment.add(segmentB10);
        tenSegment.add(segmentC10);
        tenSegment.add(segmentD10);
        tenSegment.add(segmentE10);
        tenSegment.add(segmentF10);
        tenSegment.add(segmentG10);
    }
    private void initHundredSegment(){
        hundredSegment.add(segmentA100);
        hundredSegment.add(segmentB100);
        hundredSegment.add(segmentC100);
        hundredSegment.add(segmentD100);
        hundredSegment.add(segmentE100);
        hundredSegment.add(segmentF100);
        hundredSegment.add(segmentG100);
    }
    private void initThousandSegment(){
        thousandSegment.add(segmentA1k);
        thousandSegment.add(segmentB1k);
        thousandSegment.add(segmentC1k);
        thousandSegment.add(segmentD1k);
        thousandSegment.add(segmentE1k);
        thousandSegment.add(segmentF1k);
        thousandSegment.add(segmentG1k);
    }
    private void initMapSegment(){
        initOneSegment();
        initTenSegment();
        initHundredSegment();
        initThousandSegment();
        segmentMap.put(0,oneSegment);
        segmentMap.put(1,tenSegment);
        segmentMap.put(2,hundredSegment);
        segmentMap.put(3,thousandSegment);
    }



    public Polygon getSegmentA1k() {
        return segmentA1k;
    }

    public void setSegmentA1k(Polygon segmentA1k) {
        this.segmentA1k = segmentA1k;
    }

    public Polygon getSegmentA100() {
        return segmentA100;
    }

    public void setSegmentA100(Polygon segmentA100) {
        this.segmentA100 = segmentA100;
    }

    public Polygon getSegmentA10() {
        return segmentA10;
    }

    public void setSegmentA10(Polygon segmentA10) {
        this.segmentA10 = segmentA10;
    }

    public Polygon getSegmentA1() {
        return segmentA1;
    }

    public void setSegmentA1(Polygon segmentA1) {
        this.segmentA1 = segmentA1;
    }

    public Polygon getSegmentB1k() {
        return segmentB1k;
    }

    public void setSegmentB1k(Polygon segmentB1k) {
        this.segmentB1k = segmentB1k;
    }

    public Polygon getSegmentB100() {
        return segmentB100;
    }

    public void setSegmentB100(Polygon segmentB100) {
        this.segmentB100 = segmentB100;
    }

    public Polygon getSegmentB10() {
        return segmentB10;
    }

    public void setSegmentB10(Polygon segmentB10) {
        this.segmentB10 = segmentB10;
    }

    public Polygon getSegmentB1() {
        return segmentB1;
    }

    public void setSegmentB1(Polygon segmentB1) {
        this.segmentB1 = segmentB1;
    }

    public Polygon getSegmentC1k() {
        return segmentC1k;
    }

    public void setSegmentC1k(Polygon segmentC1k) {
        this.segmentC1k = segmentC1k;
    }

    public Polygon getSegmentC100() {
        return segmentC100;
    }

    public void setSegmentC100(Polygon segmentC100) {
        this.segmentC100 = segmentC100;
    }

    public Polygon getSegmentC10() {
        return segmentC10;
    }

    public void setSegmentC10(Polygon segmentC10) {
        this.segmentC10 = segmentC10;
    }

    public Polygon getSegmentC1() {
        return segmentC1;
    }

    public void setSegmentC1(Polygon segmentC1) {
        this.segmentC1 = segmentC1;
    }

    public Polygon getSegmentD1k() {
        return segmentD1k;
    }

    public void setSegmentD1k(Polygon segmentD1k) {
        this.segmentD1k = segmentD1k;
    }

    public Polygon getSegmentD100() {
        return segmentD100;
    }

    public void setSegmentD100(Polygon segmentD100) {
        this.segmentD100 = segmentD100;
    }

    public Polygon getSegmentD10() {
        return segmentD10;
    }

    public void setSegmentD10(Polygon segmentD10) {
        this.segmentD10 = segmentD10;
    }

    public Polygon getSegmentD1() {
        return segmentD1;
    }

    public void setSegmentD1(Polygon segmentD1) {
        this.segmentD1 = segmentD1;
    }

    public Polygon getSegmentE1k() {
        return segmentE1k;
    }

    public void setSegmentE1k(Polygon segmentE1k) {
        this.segmentE1k = segmentE1k;
    }

    public Polygon getSegmentE100() {
        return segmentE100;
    }

    public void setSegmentE100(Polygon segmentE100) {
        this.segmentE100 = segmentE100;
    }

    public Polygon getSegmentE10() {
        return segmentE10;
    }

    public void setSegmentE10(Polygon segmentE10) {
        this.segmentE10 = segmentE10;
    }

    public Polygon getSegmentE1() {
        return segmentE1;
    }

    public void setSegmentE1(Polygon segmentE1) {
        this.segmentE1 = segmentE1;
    }

    public Polygon getSegmentF1k() {
        return segmentF1k;
    }

    public void setSegmentF1k(Polygon segmentF1k) {
        this.segmentF1k = segmentF1k;
    }

    public Polygon getSegmentF100() {
        return segmentF100;
    }

    public void setSegmentF100(Polygon segmentF100) {
        this.segmentF100 = segmentF100;
    }

    public Polygon getSegmentF10() {
        return segmentF10;
    }

    public void setSegmentF10(Polygon segmentF10) {
        this.segmentF10 = segmentF10;
    }

    public Polygon getSegmentF1() {
        return segmentF1;
    }

    public void setSegmentF1(Polygon segmentF1) {
        this.segmentF1 = segmentF1;
    }

    public Polygon getSegmentG1k() {
        return segmentG1k;
    }

    public void setSegmentG1k(Polygon segmentG1k) {
        this.segmentG1k = segmentG1k;
    }

    public Polygon getSegmentG100() {
        return segmentG100;
    }

    public void setSegmentG100(Polygon segmentG100) {
        this.segmentG100 = segmentG100;
    }

    public Polygon getSegmentG10() {
        return segmentG10;
    }

    public void setSegmentG10(Polygon segmentG10) {
        this.segmentG10 = segmentG10;
    }

    public Polygon getSegmentG1() {
        return segmentG1;
    }

    public void setSegmentG1(Polygon segmentG1) {
        this.segmentG1 = segmentG1;
    }
    public Circle getDot1k() {
        return dot1k;
    }

    public void setDot1k(Circle dot1k) {
        this.dot1k = dot1k;
    }

    public Circle getDot100() {
        return dot100;
    }

    public void setDot100(Circle dot100) {
        this.dot100 = dot100;
    }

    public Circle getDot10() {
        return dot100;
    }

    public void setDot10(Circle dot10) {
        this.dot10 = dot10;
    }

    public Circle getDot1() {
        return dot1;
    }

    public void setDot1(Circle dot1) {
        this.dot1 = dot1;
    }





}