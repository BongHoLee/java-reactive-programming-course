package com.bong.courseutil;

import java.util.function.Consumer;

public class Util {

    // onNext 시그널에 대한 행동을 하는 Consumer
    public static <T> Consumer<T> onNextConsumer() {
        return o -> System.out.println("Received : " + o);
    }

    // onError 시그널에 대한 행동을 하는 Consumer
    public static Consumer<Throwable> onErrorConsumer() {
        return err -> System.out.println("Error : " + err.getMessage());
    }

    // onComplete 시그널에 대한 행동을 하는 Consumer
    public static Runnable onCompleteConsumer() {
        return () -> System.out.println("Completed");
    }
}
