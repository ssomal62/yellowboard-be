package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.response.search.GetPopularListResponseDto;
import com.yellowstone.yellowboardbe.repository.SearchLogRepository;
import com.yellowstone.yellowboardbe.repository.resultSet.GetPopularListResultSet;
import com.yellowstone.yellowboardbe.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchLogRepository searchLogRepository;

    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {
        List<GetPopularListResultSet> resultSets = new ArrayList<>();

        try {
            resultSets = searchLogRepository.getPopularList();
        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return GetPopularListResponseDto.success(resultSets);
    }
}
