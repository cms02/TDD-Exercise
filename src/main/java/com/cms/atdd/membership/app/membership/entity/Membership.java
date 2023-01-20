package com.cms.atdd.membership.app.membership.entity;

import com.cms.atdd.membership.app.enums.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    @CreationTimestamp
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime updatedAt;



}
