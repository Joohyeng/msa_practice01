package com.example.apiboardquery;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BoardRepository extends ElasticsearchRepository<Board, Long> {
}