package com.example.apiboardquery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/query")
public class BoardQueryController {
    private final BoardFeignClient boardFeignClient;

    @KafkaListener(topics="board-created", groupId = "board-query-group-01")
    public void consume(@Header(KafkaHeaders.RECEIVED_KEY) Long key,
                        @Payload Long boardIdx) {
        BoardDto.RegRes result = boardFeignClient.getBoard(boardIdx);
        System.out.println("result : "+ result.getTitle());
    }
}