package com.bong.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {

        // publisher
        Mono<String> mono = Mono.just("ball");

        // 1. 파라미터 없는 subscribe. Publisher(mono)는 데이터를 발행
        // 하지만 onNext, onError, onComplete 이벤트에 대한 처리가 없기 때문에 아무런 동작이 발생하지 않는 것 처럼 보임
        //mono.subscribe();

        // 2. onNext, onError, onComplete 처리를 위한 매개변수를 받는 subscribe 메서드
        // 내부적으로 Subscriber가 생성자 파라미터로 받아 생성된다.
        // 즉, 아래 파라미터들은 Subscriber를 구성하는 파라미터들
        mono.subscribe(
                item -> System.out.println("received : " + item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete!!!")
        );
    }
}
