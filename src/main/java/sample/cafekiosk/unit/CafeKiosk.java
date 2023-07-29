package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.berverage.Berverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {
    private final List<Berverage> berverages = new ArrayList<>();


    public void add(Berverage berverage) {
        berverages.add(berverage);
    }

    public void add(Berverage berverage, int count) {
        if(count <= 0){
            throw new IllegalArgumentException("음료는 1잔이상 주문하실 수 있습니다.");
        }

        for(int i = 0; i < count ; i++){
            berverages.add(berverage);
        }

    }


    public void remove(Berverage berverage) {
        berverages.remove(berverage);
    }

    public void clear() {
        berverages.clear();
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Berverage berverage : berverages) {
            totalPrice += berverage.getPrice();
        }
        return totalPrice;
    }

    public Order createOrder(){
        return new Order(LocalDateTime.now(), berverages);
    }
}
