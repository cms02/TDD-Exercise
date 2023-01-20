package com.cms.atdd.membership.app.membership.dto;

import com.cms.atdd.membership.app.enums.MembershipType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MembershipAddResponse {
    private final Long id;
    private final MembershipType membershipType;
}
