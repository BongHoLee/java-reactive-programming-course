package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06BlockMethod {
    public static void main(String[] args) {

        // 아무일도 일어나지 않는다.
        getName();

        // subscribe를 했으니 pipeline execute!
        // block 메서드로 결과를 반환받을 때 까지 현재 메서드를 차단(3초)
        String result = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(result);

        // 위에서 block 메서드가 호출되었기 때문에 3초 뒤 실행된다.
        // 아무일도 일어나지 않는다.
        getName();
    }

    private static Mono<String> getName() {

        System.out.println("entered getName method");

        // 파이프라인 build
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");

            // 3초 sleep
            Util.sleepSeconds(3);

            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
