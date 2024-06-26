package com.yellowstone.yellowboardbe.controller;

import com.yellowstone.yellowboardbe.dto.request.user.PatchNicknameRequestDto;
import com.yellowstone.yellowboardbe.dto.request.user.PatchProfileImageRequestDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchNicknameResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchProfileResponseDto;
import com.yellowstone.yellowboardbe.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }

    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
            @PathVariable("email") String email
    ) {
        ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
        return response;
    }

    @PatchMapping("/nickname")
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(
            @RequestBody @Valid PatchNicknameRequestDto requestBody,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

    @PatchMapping("/profile-image")
    public ResponseEntity<? super PatchProfileResponseDto> patchProfileImage(
            @RequestBody @Valid PatchProfileImageRequestDto requestBody,
            @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PatchProfileResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

}
