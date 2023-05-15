package com.bong.sec01;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(3)
                .subscribe(
                        Util.onNextConsumer(),
                        Util.onErrorConsumer(),
                        Util.onCompleteConsumer()
                );
    }


    private static Mono<String> userRepository(int userId) {

        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
