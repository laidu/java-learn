package org.laidu.learn.mybatis.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.laidu.learn.mybatis.entity.AppUser;

public class AppUserSqlProvider {

    public String insertSelective(AppUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ca_app_user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOpenId() != null) {
            sql.VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterChannel() != null) {
            sql.VALUES("register_channel", "#{registerChannel,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCard() != null) {
            sql.VALUES("id_card", "#{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardDetailAddress() != null) {
            sql.VALUES("id_card_detail_address", "#{idCardDetailAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIsVerifyIdCard() != null) {
            sql.VALUES("is_verify_id_card", "#{isVerifyIdCard,jdbcType=BIT}");
        }
        
        if (record.getIdCardCoverup() != null) {
            sql.VALUES("id_card_coverup", "#{idCardCoverup,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardCoverdown() != null) {
            sql.VALUES("id_card_coverdown", "#{idCardCoverdown,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardHold() != null) {
            sql.VALUES("id_card_hold", "#{idCardHold,jdbcType=VARCHAR}");
        }
        
        if (record.getIsOtherPictureAuth() != null) {
            sql.VALUES("is_other_picture_auth", "#{isOtherPictureAuth,jdbcType=BIT}");
        }
        
        if (record.getIsBankcardAuth() != null) {
            sql.VALUES("is_bankcard_auth", "#{isBankcardAuth,jdbcType=BIT}");
        }
        
        if (record.getSignaturePic() != null) {
            sql.VALUES("signature_pic", "#{signaturePic,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAdditionalAuth() != null) {
            sql.VALUES("is_additional_auth", "#{isAdditionalAuth,jdbcType=BIT}");
        }
        
        if (record.getIsEmergencyAuth() != null) {
            sql.VALUES("is_emergency_auth", "#{isEmergencyAuth,jdbcType=BIT}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getUserStatus() != null) {
            sql.VALUES("user_status", "#{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getBlackStatus() != null) {
            sql.VALUES("black_status", "#{blackStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.VALUES("audit_time", "#{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIdCardPolice() != null) {
            sql.VALUES("id_card_police", "#{idCardPolice,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AppUser record) {
        SQL sql = new SQL();
        sql.UPDATE("ca_app_user");
        
        if (record.getOpenId() != null) {
            sql.SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegisterChannel() != null) {
            sql.SET("register_channel = #{registerChannel,jdbcType=BIGINT}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCard() != null) {
            sql.SET("id_card = #{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardDetailAddress() != null) {
            sql.SET("id_card_detail_address = #{idCardDetailAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getIsVerifyIdCard() != null) {
            sql.SET("is_verify_id_card = #{isVerifyIdCard,jdbcType=BIT}");
        }
        
        if (record.getIdCardCoverup() != null) {
            sql.SET("id_card_coverup = #{idCardCoverup,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardCoverdown() != null) {
            sql.SET("id_card_coverdown = #{idCardCoverdown,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCardHold() != null) {
            sql.SET("id_card_hold = #{idCardHold,jdbcType=VARCHAR}");
        }
        
        if (record.getIsOtherPictureAuth() != null) {
            sql.SET("is_other_picture_auth = #{isOtherPictureAuth,jdbcType=BIT}");
        }
        
        if (record.getIsBankcardAuth() != null) {
            sql.SET("is_bankcard_auth = #{isBankcardAuth,jdbcType=BIT}");
        }
        
        if (record.getSignaturePic() != null) {
            sql.SET("signature_pic = #{signaturePic,jdbcType=VARCHAR}");
        }
        
        if (record.getIsAdditionalAuth() != null) {
            sql.SET("is_additional_auth = #{isAdditionalAuth,jdbcType=BIT}");
        }
        
        if (record.getIsEmergencyAuth() != null) {
            sql.SET("is_emergency_auth = #{isEmergencyAuth,jdbcType=BIT}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getUserStatus() != null) {
            sql.SET("user_status = #{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getBlackStatus() != null) {
            sql.SET("black_status = #{blackStatus,jdbcType=INTEGER}");
        }
        
        if (record.getAuditTime() != null) {
            sql.SET("audit_time = #{auditTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIdCardPolice() != null) {
            sql.SET("id_card_police = #{idCardPolice,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}