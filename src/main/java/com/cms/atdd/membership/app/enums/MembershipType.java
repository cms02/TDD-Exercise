package com.cms.atdd.membership.app.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MembershipType {

    NAVER("네이버"),
    LINE("라인"),
    KAKAO("카카오"),
    ;

    private final String companyName;
}
