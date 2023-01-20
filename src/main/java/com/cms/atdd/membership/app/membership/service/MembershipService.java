package com.cms.atdd.membership.app.membership.service;

import com.cms.atdd.membership.app.enums.MembershipType;
import com.cms.atdd.membership.app.membership.dto.MembershipAddResponse;
import com.cms.atdd.membership.app.membership.entity.Membership;
import com.cms.atdd.membership.app.membership.repository.MembershipRepository;
import com.cms.atdd.membership.exception.MembershipErrorResult;
import com.cms.atdd.membership.exception.MembershipException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    public MembershipAddResponse addMembership(final String userId, final MembershipType membershipType, final Integer point) {
        final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);
        if (result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATED_MEMBERSHIP_REGISTER);
        }

        final Membership membership = Membership.builder()
                .userId(userId)
                .point(point)
                .membershipType(membershipType)
                .build();

        final Membership savedMembership =membershipRepository.save(membership);

        return MembershipAddResponse.builder()
                .id(savedMembership.getId())
                .membershipType(savedMembership.getMembershipType())
                .build();
    }
}


