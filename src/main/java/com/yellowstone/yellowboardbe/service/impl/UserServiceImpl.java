package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
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
}
