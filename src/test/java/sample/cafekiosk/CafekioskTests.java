package sample.cafekiosk;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.CafeKiosk;
import sample.cafekiosk.unit.berverage.Americano;

class CafekioskTests {

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBerverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBerverages().get(0).getName());
    }
    // 잘못된 테스트 코드
    // 이유 : 상황을 만들어 콘솔에 결과를 찍어내 결국엔 콘솔을 보고 검증을 한 것은 기계가 아닌 사람 = 자동화된 테스트가 아님
    // 문제점 1. 최종 단계에 사람의 개입이 필요
    // 문제점 2. 테스트코드를 작성한 내가 아닌 다른사람이 보기에는 어떤 것을 검증해야하고, 어떤 상황이 맞는 상황이고 틀린 상황인지 파악 불가능
}
