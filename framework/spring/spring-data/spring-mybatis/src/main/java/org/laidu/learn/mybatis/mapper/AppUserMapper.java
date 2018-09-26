package org.laidu.learn.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.laidu.learn.mybatis.model.AppUser;

@Mapper
public interface AppUserMapper {
    @Delete({
        "delete from ca_app_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into ca_app_user (id, open_id, ",
        "register_channel, username, ",
        "id_card, name, id_card_detail_address, ",
        "is_verify_id_card, id_card_coverup, ",
        "id_card_coverdown, id_card_hold, ",
        "is_other_picture_auth, is_bankcard_auth, ",
        "signature_pic, is_additional_auth, ",
        "is_emergency_auth, phone, ",
        "email, address, ",
        "user_status, create_time, ",
        "update_time, remark, ",
        "black_status, audit_time, ",
        "cash_black_status, cash_quota, ",
        "frozen_cash_quota, credit_quota, ",
        "frozen_credit_quota, audit_status, ",
        "id_card_police)",
        "values (#{id,jdbcType=BIGINT}, #{openId,jdbcType=VARCHAR}, ",
        "#{registerChannel,jdbcType=BIGINT}, #{username,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{idCardDetailAddress,jdbcType=VARCHAR}, ",
        "#{isVerifyIdCard,jdbcType=BIT}, #{idCardCoverup,jdbcType=VARCHAR}, ",
        "#{idCardCoverdown,jdbcType=VARCHAR}, #{idCardHold,jdbcType=VARCHAR}, ",
        "#{isOtherPictureAuth,jdbcType=BIT}, #{isBankcardAuth,jdbcType=BIT}, ",
        "#{signaturePic,jdbcType=VARCHAR}, #{isAdditionalAuth,jdbcType=BIT}, ",
        "#{isEmergencyAuth,jdbcType=BIT}, #{phone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{userStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{blackStatus,jdbcType=INTEGER}, #{auditTime,jdbcType=TIMESTAMP}, ",
        "#{cashBlackStatus,jdbcType=INTEGER}, #{cashQuota,jdbcType=DECIMAL}, ",
        "#{frozenCashQuota,jdbcType=DECIMAL}, #{creditQuota,jdbcType=DECIMAL}, ",
        "#{frozenCreditQuota,jdbcType=DECIMAL}, #{auditStatus,jdbcType=INTEGER}, ",
        "#{idCardPolice,jdbcType=LONGVARCHAR})"
    })
    int insert(AppUser record);

    @InsertProvider(type=AppUserSqlProvider.class, method="insertSelective")
    int insertSelective(AppUser record);

    @Select({
        "select",
        "id, open_id, register_channel, username, id_card, name, id_card_detail_address, ",
        "is_verify_id_card, id_card_coverup, id_card_coverdown, id_card_hold, is_other_picture_auth, ",
        "is_bankcard_auth, signature_pic, is_additional_auth, is_emergency_auth, phone, ",
        "email, address, user_status, create_time, update_time, remark, black_status, ",
        "audit_time, cash_black_status, cash_quota, frozen_cash_quota, credit_quota, ",
        "frozen_credit_quota, audit_status, id_card_police",
        "from ca_app_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_channel", property="registerChannel", jdbcType=JdbcType.BIGINT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_detail_address", property="idCardDetailAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_verify_id_card", property="isVerifyIdCard", jdbcType=JdbcType.BIT),
        @Result(column="id_card_coverup", property="idCardCoverup", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_coverdown", property="idCardCoverdown", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card_hold", property="idCardHold", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_other_picture_auth", property="isOtherPictureAuth", jdbcType=JdbcType.BIT),
        @Result(column="is_bankcard_auth", property="isBankcardAuth", jdbcType=JdbcType.BIT),
        @Result(column="signature_pic", property="signaturePic", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_additional_auth", property="isAdditionalAuth", jdbcType=JdbcType.BIT),
        @Result(column="is_emergency_auth", property="isEmergencyAuth", jdbcType=JdbcType.BIT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="black_status", property="blackStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_time", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cash_black_status", property="cashBlackStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="cash_quota", property="cashQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="frozen_cash_quota", property="frozenCashQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="credit_quota", property="creditQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="frozen_credit_quota", property="frozenCreditQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="id_card_police", property="idCardPolice", jdbcType=JdbcType.LONGVARCHAR)
    })
    AppUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=AppUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppUser record);

    @Update({
        "update ca_app_user",
        "set open_id = #{openId,jdbcType=VARCHAR},",
          "register_channel = #{registerChannel,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "id_card_detail_address = #{idCardDetailAddress,jdbcType=VARCHAR},",
          "is_verify_id_card = #{isVerifyIdCard,jdbcType=BIT},",
          "id_card_coverup = #{idCardCoverup,jdbcType=VARCHAR},",
          "id_card_coverdown = #{idCardCoverdown,jdbcType=VARCHAR},",
          "id_card_hold = #{idCardHold,jdbcType=VARCHAR},",
          "is_other_picture_auth = #{isOtherPictureAuth,jdbcType=BIT},",
          "is_bankcard_auth = #{isBankcardAuth,jdbcType=BIT},",
          "signature_pic = #{signaturePic,jdbcType=VARCHAR},",
          "is_additional_auth = #{isAdditionalAuth,jdbcType=BIT},",
          "is_emergency_auth = #{isEmergencyAuth,jdbcType=BIT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "user_status = #{userStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "black_status = #{blackStatus,jdbcType=INTEGER},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "cash_black_status = #{cashBlackStatus,jdbcType=INTEGER},",
          "cash_quota = #{cashQuota,jdbcType=DECIMAL},",
          "frozen_cash_quota = #{frozenCashQuota,jdbcType=DECIMAL},",
          "credit_quota = #{creditQuota,jdbcType=DECIMAL},",
          "frozen_credit_quota = #{frozenCreditQuota,jdbcType=DECIMAL},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "id_card_police = #{idCardPolice,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(AppUser record);

    @Update({
        "update ca_app_user",
        "set open_id = #{openId,jdbcType=VARCHAR},",
          "register_channel = #{registerChannel,jdbcType=BIGINT},",
          "username = #{username,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "id_card_detail_address = #{idCardDetailAddress,jdbcType=VARCHAR},",
          "is_verify_id_card = #{isVerifyIdCard,jdbcType=BIT},",
          "id_card_coverup = #{idCardCoverup,jdbcType=VARCHAR},",
          "id_card_coverdown = #{idCardCoverdown,jdbcType=VARCHAR},",
          "id_card_hold = #{idCardHold,jdbcType=VARCHAR},",
          "is_other_picture_auth = #{isOtherPictureAuth,jdbcType=BIT},",
          "is_bankcard_auth = #{isBankcardAuth,jdbcType=BIT},",
          "signature_pic = #{signaturePic,jdbcType=VARCHAR},",
          "is_additional_auth = #{isAdditionalAuth,jdbcType=BIT},",
          "is_emergency_auth = #{isEmergencyAuth,jdbcType=BIT},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "user_status = #{userStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "black_status = #{blackStatus,jdbcType=INTEGER},",
          "audit_time = #{auditTime,jdbcType=TIMESTAMP},",
          "cash_black_status = #{cashBlackStatus,jdbcType=INTEGER},",
          "cash_quota = #{cashQuota,jdbcType=DECIMAL},",
          "frozen_cash_quota = #{frozenCashQuota,jdbcType=DECIMAL},",
          "credit_quota = #{creditQuota,jdbcType=DECIMAL},",
          "frozen_credit_quota = #{frozenCreditQuota,jdbcType=DECIMAL},",
          "audit_status = #{auditStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AppUser record);
}