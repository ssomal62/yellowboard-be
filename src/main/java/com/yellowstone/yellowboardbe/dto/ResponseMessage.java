package com.yellowstone.yellowboardbe.dto;

public interface ResponseMessage {

    //Http Status 200
    String SUCCESS = "Success.";

    //Http Status 400 - Bad Request : 잘못된 요청
    String VALIDATION_FAILED = "Validation failed";
    String DUPLICATE_EMAIL = "Duplicate email.";
    String DUPLICATE_NICKNAME = "Duplicate nickname.";
    String DUPLICATE_TEL_NUMBER = "Duplicate tel number.";
    String NOT_EXISTED_USER = "This user does not exist.";
    String NOT_EXISTED_BOARD = "This board does not exist.";

    //Http Status 401 - Unauthorized : 비인증(인증 수단이 없음)
    String SIGN_IN_FAIL = "Login information mismatch.";
    String AUTHORIZATION_FAIL = "Authorization failed.";

    //Http Status 403 - Forbidden : 권한 없음 (서버가 요청을 이해했지만 승인을 거부)
    String NO_PERMISSION = "Do not have permission.";

    //Http Status 500 - Internal Server Error
    String DATABASE_ERROR = "Database error";
}
