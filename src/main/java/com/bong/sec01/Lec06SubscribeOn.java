package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SubscribeOn {
    public static void main(String[] args) {

        // 아무일도 일어나지 않는다.
        getName();

        // subscribe를 했으니 pipeline execute!
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNextConsumer());

        // 아무일도 일어나지 않는다.
        getName();

        Util.sleepSeconds(5);
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
