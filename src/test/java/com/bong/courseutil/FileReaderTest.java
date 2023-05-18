package com.bong.courseutil;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class FileReaderTest {

    @Test
    void 없는_파일_전달시_예외발생() {
        // given
        String notExistsFileName = "notExists.txt";

        // when & then
        assertThatThrownBy(() -> {
            FileReader reader = new FileReader(notExistsFileName);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not exists file:");
    }

    @Test
    void consumer를_전달받아_스트림데이터를_넘긴다() {
        FileReader fileReader = new FileReader("file01.txt");
        fileReader.passDataStreamTo((streamData) -> {
            Mono<String> mono = Flux.fromStream(streamData).next();
            mono.subscribe(
                    Util.onNextConsumer(),
                    Util.onErrorConsumer(),
                    Util.onCompleteConsumer()
            );
        });
    }
}