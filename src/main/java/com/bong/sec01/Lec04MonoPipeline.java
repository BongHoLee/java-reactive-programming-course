package com.bong.sec01;

import reactor.core.publisher.Mono;

public class Lec04MonoPipeline {
    public static void main(String[] args) {

        // publisher
        // map, filter 등의 다양한 연산으로 파이프라인을 구성할 수 있다.
        Mono<Integer> mono = Mono.just("ball")
                .map(item -> item.length())
                .map(item -> item / 0);              // onError 발생을 위한 의도적 zero divide

        // subscribe를 호출하면 파이프라인 동작을 거쳐 Subscriber에 전달된다.
        mono.subscribe(
                item -> System.out.println("received : " + item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete!!!")
        );
    }
}
