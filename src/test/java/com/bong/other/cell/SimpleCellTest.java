package com.bong.other.cell;

import org.junit.jupiter.api.Test;

class SimpleCellTest {

    @Test
    void simpleCellTest() {
        SimpleCell c3 = new SimpleCell("c3");
        SimpleCell c2 = new SimpleCell("c2");
        SimpleCell c1 = new SimpleCell("c1");

        c1.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);
    }

    @Test
    void arithmeticCellTest() {
        ArithmeticCell c3 = new ArithmeticCell("c3");
        SimpleCell c2 = new SimpleCell("c2");
        SimpleCell c1 = new SimpleCell("c1");

        // 메서드 참조를 Subscriber로 전달..! 이런 방식의 코드는 알아두면 유용할듯!
        // 여기서는 Subscriberrㅏ Functional Interface라 가능!
        // 메서드 참조를 전달해서 해당 메서드를 실행하지만, c3의 메서드 이기 때문에 c3 객체의 상태가 변경된다!
        // 한정적 인스턴스 메서드 참조 방식!
        c1.subscribe(c3::setLeft);
        c2.subscribe(c3::setRight);

        c1.onNext(10);
        c2.onNext(20);
    }

}