package org.laidu.learn.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    private Long id;

    private String openId;

    private Long registerChannel;

    private String username;

    private String idCard;

    private String name;

    private String idCardDetailAddress;

    private Boolean isVerifyIdCard;

    private String idCardCoverup;

    private String idCardCoverdown;

    private String idCardHold;

    private Boolean isOtherPictureAuth;

    private Boolean isBankcardAuth;

    private String signaturePic;

    private Boolean isAdditionalAuth;

    private Boolean isEmergencyAuth;

    private String phone;

    private String email;

    private String address;

    private Integer userStatus;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private Integer blackStatus;

    private Date auditTime;

    private String idCardPolice;

    private static final long serialVersionUID = 1L;
}