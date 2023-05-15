package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        // mono.just를 사용하는 경우, just 호출 시 getName()도 호출되어 데이터가 이미 생성된다
        // 하지만 우리가 원하는 것은 '구독자가 구독하는 시점에 lazy하게 데이터 생성'이 되는것을 원한다.
        // 즉, Mono.just는 '이미 데이터가 마련되어 있을 때'에만 사용해야 한다.
        Mono<String> mono = Mono.just(getName());

        // Mono.fromSupplier(Supplier)는 subscribe 시점에 데이터 생성 람다가 실행된다!
        // 즉, subscribe 시점에 Supplier가 Publisher에게 데이터를 제공한다.
        Mono<String> supplierMono = Mono.fromSupplier(() -> getName());
        supplierMono.subscribe(
                Util.onNextConsumer()
        );
    }

    private static String getName() {
        System.out.println("Generateing name..");
        return Util.faker().name().fullName();
    }
}
