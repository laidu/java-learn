package org.laidu.learn.mybatis.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author laidu
 */
public class AppUser implements Serializable {


    private static final long serialVersionUID = 1L;

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

    private String idCardPolice;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Long getRegisterChannel() {
        return registerChannel;
    }

    public void setRegisterChannel(Long registerChannel) {
        this.registerChannel = registerChannel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCardDetailAddress() {
        return idCardDetailAddress;
    }

    public void setIdCardDetailAddress(String idCardDetailAddress) {
        this.idCardDetailAddress = idCardDetailAddress == null ? null : idCardDetailAddress.trim();
    }

    public Boolean getIsVerifyIdCard() {
        return isVerifyIdCard;
    }

    public void setIsVerifyIdCard(Boolean isVerifyIdCard) {
        this.isVerifyIdCard = isVerifyIdCard;
    }

    public String getIdCardCoverup() {
        return idCardCoverup;
    }

    public void setIdCardCoverup(String idCardCoverup) {
        this.idCardCoverup = idCardCoverup == null ? null : idCardCoverup.trim();
    }

    public String getIdCardCoverdown() {
        return idCardCoverdown;
    }

    public void setIdCardCoverdown(String idCardCoverdown) {
        this.idCardCoverdown = idCardCoverdown == null ? null : idCardCoverdown.trim();
    }

    public String getIdCardHold() {
        return idCardHold;
    }

    public void setIdCardHold(String idCardHold) {
        this.idCardHold = idCardHold == null ? null : idCardHold.trim();
    }

    public Boolean getIsOtherPictureAuth() {
        return isOtherPictureAuth;
    }

    public void setIsOtherPictureAuth(Boolean isOtherPictureAuth) {
        this.isOtherPictureAuth = isOtherPictureAuth;
    }

    public Boolean getIsBankcardAuth() {
        return isBankcardAuth;
    }

    public void setIsBankcardAuth(Boolean isBankcardAuth) {
        this.isBankcardAuth = isBankcardAuth;
    }

    public String getSignaturePic() {
        return signaturePic;
    }

    public void setSignaturePic(String signaturePic) {
        this.signaturePic = signaturePic == null ? null : signaturePic.trim();
    }

    public Boolean getIsAdditionalAuth() {
        return isAdditionalAuth;
    }

    public void setIsAdditionalAuth(Boolean isAdditionalAuth) {
        this.isAdditionalAuth = isAdditionalAuth;
    }

    public Boolean getIsEmergencyAuth() {
        return isEmergencyAuth;
    }

    public void setIsEmergencyAuth(Boolean isEmergencyAuth) {
        this.isEmergencyAuth = isEmergencyAuth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIdCardPolice() {
        return idCardPolice;
    }

    public void setIdCardPolice(String idCardPolice) {
        this.idCardPolice = idCardPolice == null ? null : idCardPolice.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openId=").append(openId);
        sb.append(", registerChannel=").append(registerChannel);
        sb.append(", username=").append(username);
        sb.append(", idCard=").append(idCard);
        sb.append(", name=").append(name);
        sb.append(", idCardDetailAddress=").append(idCardDetailAddress);
        sb.append(", isVerifyIdCard=").append(isVerifyIdCard);
        sb.append(", idCardCoverup=").append(idCardCoverup);
        sb.append(", idCardCoverdown=").append(idCardCoverdown);
        sb.append(", idCardHold=").append(idCardHold);
        sb.append(", isOtherPictureAuth=").append(isOtherPictureAuth);
        sb.append(", isBankcardAuth=").append(isBankcardAuth);
        sb.append(", signaturePic=").append(signaturePic);
        sb.append(", isAdditionalAuth=").append(isAdditionalAuth);
        sb.append(", isEmergencyAuth=").append(isEmergencyAuth);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", idCardPolice=").append(idCardPolice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}