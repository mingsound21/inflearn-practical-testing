package sample.cafekiosk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.CafeKiosk;
import sample.cafekiosk.unit.berverage.Americano;
import sample.cafekiosk.unit.berverage.Latte;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CafekioskTests {

    @Test
    @DisplayName("사람이 직접 테스트 결과를 콘솔에서 확인 후 검증")
    void add_manual_test() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBerverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBerverages().get(0).getName());
    }
    // 잘못된 테스트 코드
    // 이유 : 상황을 만들어 콘솔에 결과를 찍어내 결국엔 콘솔을 보고 검증을 한 것은 기계가 아닌 사람 = 자동화된 테스트가 아님
    // 문제점 1. 최종 단계에 사람의 개입이 필요
    // 문제점 2. 테스트코드를 작성한 내가 아닌 다른사람이 보기에는 어떤 것을 검증해야하고, 어떤 상황이 맞는 상황이고 틀린 상황인지 파악 불가능

    @Test
    @DisplayName("한 개의 음료 추가 단위 테스트")
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        assertThat(cafeKiosk.getBerverages().size()).isEqualTo(1);
        assertThat(cafeKiosk.getBerverages()).hasSize(1); // 위와 같은 리스트 크기 검증
        assertThat(cafeKiosk.getBerverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    @DisplayName("여러개의 음료 추가 단위 테스트 - 성공") // 경계값 : 1개 추가, 2개 추가
    void addSeveralBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano 아메리카노 = new Americano();

        cafeKiosk.add(아메리카노, 2);

        assertThat(cafeKiosk.getBerverages()).hasSize(2); // 위와 같은 리스트 크기 검증
        assertThat(cafeKiosk.getBerverages().get(0)).isEqualTo(아메리카노);
        assertThat(cafeKiosk.getBerverages().get(1)).isEqualTo(아메리카노);
    }

    @Test
    @DisplayName("여러개의 음료 추가 단위 테스트 - 실패") // 경계값 : count = 0
    void addZeroBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano 아메리카노 = new Americano();

        assertThatThrownBy(() -> cafeKiosk.add(아메리카노, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔이상 주문하실 수 있습니다.");
    }

    @Test
    @DisplayName("한 개의 음료 삭제 단위 테스트")
    void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano 아메리카노 = new Americano();

        cafeKiosk.add(아메리카노);
        assertThat(cafeKiosk.getBerverages()).hasSize(1);

        cafeKiosk.remove(아메리카노);
        assertThat(cafeKiosk.getBerverages().size()).isEqualTo(0);
        assertThat(cafeKiosk.getBerverages()).hasSize(0);
        assertThat(cafeKiosk.getBerverages()).isEmpty(); // 빈 리스트인지 검증
    }

    @Test
    @DisplayName("모든 음료 삭제 단위 테스트")
    void clear() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano 아메리카노 = new Americano();
        Latte 라떼 = new Latte();

        cafeKiosk.add(아메리카노);
        cafeKiosk.add(라떼);
        assertThat(cafeKiosk.getBerverages()).hasSize(2);

        cafeKiosk.clear();
        assertThat(cafeKiosk.getBerverages()).isEmpty(); // 빈 리스트인지 검증
    }

}
