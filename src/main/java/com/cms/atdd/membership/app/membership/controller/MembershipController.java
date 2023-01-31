package com.cms.atdd.membership.app.membership.controller;

import com.cms.atdd.membership.app.membership.dto.MembershipAddResponse;
import com.cms.atdd.membership.app.membership.dto.MembershipDetailResponse;
import com.cms.atdd.membership.app.membership.dto.MembershipRequest;
import com.cms.atdd.membership.app.membership.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.cms.atdd.membership.app.membership.constants.MembershipConstants.USER_ID_HEADER;


@RestController
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @PostMapping("/api/v1/memberships")
    public ResponseEntity<MembershipAddResponse> addMembership(
            @RequestHeader(USER_ID_HEADER) final String userId,
            @RequestBody @Valid final MembershipRequest membershipRequest) {

        MembershipAddResponse membershipAddResponse = membershipService.addMembership(userId, membershipRequest.getMembershipType(), membershipRequest.getPoint());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(membershipAddResponse);
    }

    @GetMapping("/api/v1/memberships")
    public ResponseEntity<List<MembershipDetailResponse>> getMembershipList(
            @RequestHeader(USER_ID_HEADER) final String userId) {

        return ResponseEntity.ok(membershipService.getMembershipList(userId));
    }

    @GetMapping("/api/v1/memberships/{id}")
    public ResponseEntity<MembershipDetailResponse> getMembership(
            @RequestHeader(USER_ID_HEADER) final String userId,
            @PathVariable final Long id) {
        return ResponseEntity.ok(membershipService.getMembership(id, userId));
    }
}
