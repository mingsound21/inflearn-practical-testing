package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.berverage.Berverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {
    private final List<Berverage> berverages = new ArrayList<>();
    private final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
    private final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);


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
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalTime currentTime = currentDateTime.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("주문시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(LocalDateTime.now(), berverages);
    }

    // 위 함수 검증시, 테스트를 실행시키는 시각에 따라서 테스트 결과가 달라진다.
    // 테스트하기 어려운 영역을 구분하고 분리하여, 현재 주문 시각을 인자값으로 받도록 수정하였다.
    // 우리가 검증하려는 것은 LocalDateTime.now()가 제대로 동작하는지가 아니라, 어떤 시각이 주어졌을 때, 운영시각 안에 해당시각이 포함되어있는지 작성한 코드가 제대로 돌아가는지를 검증하는 것.
    // 테스트하기 어려운 영역
        // 1. 관측할 때 마다 다른 값에 의존하는 코드 : 현재 날짜/시간, 랜덤값, 전역변수/함수, 사용자 입력
        // 2. 외부 세계에 영향을 주는 코드 : 표준 출력, 메세지 발송, DB에 기록
    // 테스트 하기 좋은 함수 : 같은 입력에는 항상 같은 결과가 나오는 함수, 외부 세상과 단절된 함수
    public Order createOrder(LocalDateTime currentDateTime){
        LocalTime currentTime = currentDateTime.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("주문시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(LocalDateTime.now(), berverages);
    }
}
