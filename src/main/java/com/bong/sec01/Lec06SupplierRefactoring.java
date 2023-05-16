package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {

        // 아무일도 일어나지 않는다.
        getName();

        // subscribe를 했으니 pipeline execute!
        getName().subscribe(Util.onNextConsumer());

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
