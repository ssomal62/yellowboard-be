package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.request.user.PatchNicknameRequestDto;
import com.yellowstone.yellowboardbe.dto.request.user.PatchProfileImageRequestDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchNicknameResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.PatchProfileResponseDto;
import com.yellowstone.yellowboardbe.entity.UserEntity;
import com.yellowstone.yellowboardbe.repository.UserRepository;
import com.yellowstone.yellowboardbe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        UserEntity userEntity = null;
        try {

            userEntity = userRepository.findByEmail(email);

            if(userEntity == null) return GetUserResponseDto.notExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }
        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetSignInUserResponseDto.notExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();

        }

        return GetSignInUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email) {
        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetSignInUserResponseDto.notExistUser();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            userEntity.setNickname(nickname);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }

        return PatchNicknameResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileResponseDto> patchNickname(PatchProfileImageRequestDto dto, String email) {
        UserEntity userEntity = null;

        try {
            userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return GetSignInUserResponseDto.notExistUser();

            String profileImage = dto.getProfileImage();
            userEntity.setProfileImage(profileImage);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseDto.databaseError();
        }

        return PatchProfileResponseDto.success();
    }
}
