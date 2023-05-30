package com.bong.sec01.assignment;

import com.bong.courseutil.Util;
import reactor.core.publisher.Mono;

public class AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(
                        Util.onNextConsumer(),
                        Util.onErrorConsumer(),
                        Util.onCompleteConsumer()
                );

        FileService.read("file03.txt")
                .subscribe(
                        Util.onNextConsumer(),
                        Util.onErrorConsumer(),
                        Util.onCompleteConsumer()
                );

    }
}
