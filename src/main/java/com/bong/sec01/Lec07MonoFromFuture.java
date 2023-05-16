package com.bong.sec01;

import com.bong.courseutil.Util;
import java.util.concurrent.CompletableFuture;
import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {

        // CompletableFuture로부터 Mono를 생성
        // 구독 시 별도의 ThreadPool에서 실행된다
        Mono.fromFuture(getName())
                .log()
                .subscribe(Util.onNextConsumer());

        Util.sleepSeconds(2);
    }

    // CompletableFuture를 반환
    private static CompletableFuture<String> getName() {
        return CompletableFuture
                .supplyAsync(() -> Util.faker().name().fullName());
    }
}
