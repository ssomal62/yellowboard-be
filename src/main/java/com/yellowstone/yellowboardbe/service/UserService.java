package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.request.user.PatchNicknameRequestDto;
import com.yellowstone.yellowboardbe.dto.request.user.PatchProfileImageRequestDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchNicknameResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchProfileResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileResponseDto> patchNickname(PatchProfileImageRequestDto dto, String email);
}
