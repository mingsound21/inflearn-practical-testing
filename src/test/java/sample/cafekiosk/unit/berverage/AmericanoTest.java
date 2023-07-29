package sample.cafekiosk.unit.berverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AmericanoTest {
    @Test
    void getNameTest() throws Exception {
        //given
        Americano americano = new Americano();
        //when

        //then
        //assertEquals(americano.getName(), "아메리카노"); // JUnit
        assertThat(americano.getName()).isEqualTo("아메리카노"); // assertj - JUnit보다 직관적이다. 메서드 체이닝을 지원한다.
    }


    @Test
    void getPriceTest() throws Exception {
        //given
        Americano americano = new Americano();
        //when

        //then
        assertThat(americano.getPrice()).isEqualTo(4000);
    }

}