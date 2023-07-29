package sample.cafekiosk.unit.berverage;

public class Americano implements Berverage {
    @Override
    public int getPrice() {
        return 4000;
    }

    @Override
    public String getName() {
        return "아메리카노";
    }
}
