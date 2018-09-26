package org.laidu.learn.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    private Integer cashBlackStatus;

    private BigDecimal cashQuota;

    private BigDecimal frozenCashQuota;

    private BigDecimal creditQuota;

    private BigDecimal frozenCreditQuota;

    private Integer auditStatus;

    private String idCardPolice;

    private static final long serialVersionUID = 1L;
}