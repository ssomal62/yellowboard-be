package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.response.search.GetPopularListResponseDto;
import org.springframework.http.ResponseEntity;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
}
