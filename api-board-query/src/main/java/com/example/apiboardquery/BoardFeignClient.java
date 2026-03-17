package com.example.apiboardquery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="boardFeignClient", url="http://localhost:8081")
public interface BoardFeignClient {
    @GetMapping("/board/command/{idx}")
    public BoardDto.RegRes getBoard(@PathVariable Long idx);
}