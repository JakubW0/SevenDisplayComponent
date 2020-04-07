package sample;

public class SevenSegmentModel {
    private int one;
    private int ten;
    private int hundred;
    private int thousand;
    private int value;

    public void setValueToSeparate(int value){
        this.value=value;
        separate();
    }

    private void separate(){
        thousand = value/1000 % 10;
        hundred = value/100 % 10;
        ten= value /10 % 10;
        one = value /1 % 10;
    }
    public int getOne(){
        return one;
    }
    public int getTen(){
        return ten;
    }
    public int getHundred(){
        return hundred;
    }
    public int getThousand(){
        return thousand;
    }


}
