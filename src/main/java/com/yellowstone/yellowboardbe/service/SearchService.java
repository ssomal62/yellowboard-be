package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.response.search.GetPopularListResponseDto;
import com.yellowstone.yellowboardbe.dto.response.search.GetRelationListResponseDto;
import org.springframework.http.ResponseEntity;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
}
