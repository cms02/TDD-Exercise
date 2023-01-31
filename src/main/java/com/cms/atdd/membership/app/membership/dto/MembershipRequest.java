package com.cms.atdd.membership.app.membership.dto;

import com.cms.atdd.membership.app.enums.MembershipType;
import com.cms.atdd.membership.app.membership.validation.ValidationGroups;
import com.cms.atdd.membership.app.membership.validation.ValidationGroups.MembershipAccumulateMarker;
import com.cms.atdd.membership.app.membership.validation.ValidationGroups.MembershipAddMarker;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MembershipRequest {

    @NotNull(groups = {MembershipAddMarker.class, MembershipAccumulateMarker.class})
    @Min(value = 0, groups = {MembershipAddMarker.class, MembershipAccumulateMarker.class})
    private final Integer point;

    @NotNull(groups = {MembershipAddMarker.class})
    private final MembershipType membershipType;
}
