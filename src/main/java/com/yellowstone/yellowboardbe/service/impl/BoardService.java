package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.request.board.PostBoardRequestDto;
import com.yellowstone.yellowboardbe.dto.response.board.GetBoardResponseDto;
import com.yellowstone.yellowboardbe.dto.response.board.PostBoardResponseDto;
import com.yellowstone.yellowboardbe.dto.response.board.PutFavoriteResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {

    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

}
