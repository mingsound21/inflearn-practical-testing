package sample.cafekiosk.unit.berverage;

public class Latte implements Berverage{
    @Override
    public int getPrice() {
        return 4500;
    }

    @Override
    public String getName() {
        return "Latte";
    }
}
