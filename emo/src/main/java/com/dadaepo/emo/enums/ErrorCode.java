package com.dadaepo.emo.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENUM_TYPE_INCONSISTENCY(400, "C003", "Wrong Type"),
    INTERNAL_SERVER_ERROR(400, "C004", "Other ERROR"),
    HANDLE_ACCESS_DENIED(403, "C005", "Access is Denied"),
    BUSINESS_LOGIC_ERROR(400, "C006", "Business logic error"),

    // Member
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    USERID_DUPLICATION(400, "M002", "Userid is Duplication"),
    LOGIN_INPUT_INVALID(400, "M003", "Login input is invalid"),

    // Emotion
    EMOTION_DUPLICATION(400, "E001", "Emotions were already registered"),
    DETAIL_SCOPE_FALSE(400, "E002", "The detail scope of this memo is false"),

    // Friend
    FRIEND_DUPLICATION(400, "F001", "You are already friend"),

    // Reaction
    REACTION_DUPLICATION(400, "R001", "Reaction was already registered")
            ;
    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
