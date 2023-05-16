package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {

        // 시간이 많이 소요되는 Runnable을 수행하고
        // 완료 시 알림을 받거나 이후 로직(email 전송 등)을 수행 - 동기적 수행이 필요한 부분에 적합하다!
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNextConsumer(),
                        Util.onErrorConsumer(),
                        () -> {
                            System.out.println("process is done, Sending emails...");
                        });

    }

    // 시간이 많이 소요되는 연산을 수행하는 Runnable
    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operations completed");
        };
    }
}
