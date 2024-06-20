package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.request.auth.SignInRequestDto;
import com.yellowstone.yellowboardbe.dto.request.auth.SignUpRequestDto;
import com.yellowstone.yellowboardbe.dto.response.auth.SignInResponseDto;
import com.yellowstone.yellowboardbe.dto.response.auth.SignUpResponseDto;
import com.yellowstone.yellowboardbe.entity.UserEntity;
import com.yellowstone.yellowboardbe.provider.JwtProvider;
import com.yellowstone.yellowboardbe.repository.UserRepository;
import com.yellowstone.yellowboardbe.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final JwtProvider jwtProvider;
    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try {

        String email = dto.getEmail();
        boolean existedEmail = userRepository.existsByEmail(email);
        if(existedEmail) return SignUpResponseDto.duplicateEmail();

        String nickname = dto.getNickname();
        boolean existedNickname = userRepository.existsByNickname(nickname);
        if(existedNickname) return SignUpResponseDto.duplicateNickname();

        String telNumber = dto.getTelNumber();
        boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
        if(existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

        String password = dto.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        dto.setPassword(encodePassword);

        UserEntity userEntity = new UserEntity(dto);
        userRepository.save(userEntity);


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        String token = null;

        try {

            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return SignInResponseDto.signInFailed();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched) return SignInResponseDto.signInFailed();

            token = jwtProvider.create(email);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);
    }
}
