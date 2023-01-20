package com.cms.atdd.membership.app.membership.repository;

import com.cms.atdd.membership.app.enums.MembershipType;
import com.cms.atdd.membership.app.membership.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByUserIdAndMembershipType(String userId, MembershipType membershipType);
}
