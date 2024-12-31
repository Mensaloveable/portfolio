package com.loveable.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@ToString
public class User /*implements UserDetails */ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String uuid;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    @JsonIgnore
    @Column(name = "pin")
    private String password;
    private String address;
    private String blacklistReason;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdOn;

    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    @LastModifiedDate
    private Date modifiedOn;

    private Integer modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    @LastModifiedDate
    private Date deletedOn;

    private Boolean deletedFlag = false;
    private Integer deletedBy;
    private String pinResetToken;
    private Date pinResetTokenTimeStamp;
    private int failedLoginAttempts = 0;
    private String subscriptionActivationLink;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.emptyList();
//    }

//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return (status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("active"));
//    }

    public void incrementFailedLoginAttempts() {
        failedLoginAttempts++;
    }

    public void resetFailedLoginAttempts() {
        failedLoginAttempts = 0;
    }
}
