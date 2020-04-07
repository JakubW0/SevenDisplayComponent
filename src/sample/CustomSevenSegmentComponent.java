package sample;


import javafx.beans.property.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class CustomSevenSegmentComponent extends AnchorPane
{
    SevenSegmentController controller;
    SevenSegmentModel model = new SevenSegmentModel();
    ObjectProperty<Paint> segmentOn = new SimpleObjectProperty<>(Color.PINK);
    ObjectProperty<Paint> segmentOff = new SimpleObjectProperty<>(Color.YELLOW);
    ObjectProperty<Paint> backgroundSegment = new SimpleObjectProperty<>(Color.BLACK);

    public CustomSevenSegmentComponent()
    {
        super();
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));

            controller = new SevenSegmentController();

            loader.setController(controller);
            Node n =  loader.load();
            this.getChildren().add(n);


            controller.bindColorOff(segmentOff);
            controller.bindColorOn(segmentOn);



        }
        catch (IOException iex)
        {

        }
    }
    public void setValue(int value){
        model.setValueToSeparate(value);
        controller.setValue(model.getThousand(),model.getHundred(),model.getTen(),model.getOne());

    }
    public void startAlarm(){
        controller.startAlarm();
    }
    public void stopAlarm(){
        controller.stopAlarm();
    }

    public void setColorOnSegment(Color color){
        controller.setColorOnSegment(color,model.getThousand(),model.getHundred(),model.getTen(),model.getOne());
    }
    public void setColorOFFSegment(Color color){
        controller.setColorOFFSegment(color,model.getThousand(),model.getHundred(),model.getTen(),model.getOne());
   }

    public final Paint getSegmentOn()
    {
        return segmentOn.get();
    }

    public ObjectProperty<Paint> segmentOnProperty()
    {
        return segmentOn;
    }

    public final void setSegmentOn(Paint segmentOn)
    {
        this.segmentOn.set(segmentOn);
    }

    public final Paint getSegmentOff()
    {
        return segmentOff.get();
    }

    public ObjectProperty<Paint> segmentOffProperty()
    {
        return segmentOff;
    }

    public final void setSegmentOff(Paint value)
    {
        this.segmentOff.set(value);
    }

    public final Paint getBackgroundSegment()
    {
        return backgroundSegment.get();
    }

    public ObjectProperty<Paint> backgroundSegmentProperty()
    {
        return backgroundSegment;
    }

    public final void setBackgroundSegment(Paint value)
    {
        this.backgroundSegment.set(value);
        controller.bindColorPane(backgroundSegment.get().toString().substring(2,8)); //pierw się inicjalizują kontrolki z JavyFX a dopiero potem ładuję CSS,

    }
}