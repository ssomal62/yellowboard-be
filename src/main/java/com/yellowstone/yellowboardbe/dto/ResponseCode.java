package com.yellowstone.yellowboardbe.dto;

public interface ResponseCode {

    //Http Status 200
    String SUCCESS = "SU";

    //Http Status 400 - Bad Request : 잘못된 요청
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";

    //Http Status 401 - Unauthorized : 비인증(인증 수단이 없음)
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";

    //Http Status 403 - Forbidden : 권한 없음 (서버가 요청을 이해했지만 승인을 거부)
    String NO_PERMISSION = "NP";

    //Http Status 500 - Internal Server Error
    String DATABASE_ERROR = "DBE";
}
