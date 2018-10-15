package org.laidu.learn.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.laidu.learn.mybatis.entity.AppUser;

@Mapper
public interface AppUserMapper {
    @Delete({
        "delete from ca_app_user",
        "where id = #{id}"
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
        "id_card_police)",
        "values (#{id}, #{openId}, ",
        "#{registerChannel}, #{username}, ",
        "#{idCard}, #{name}, #{idCardDetailAddress}, ",
        "#{isVerifyIdCard}, #{idCardCoverup}, ",
        "#{idCardCoverdown}, #{idCardHold}, ",
        "#{isOtherPictureAuth}, #{isBankcardAuth}, ",
        "#{signaturePic}, #{isAdditionalAuth}, ",
        "#{isEmergencyAuth}, #{phone}, ",
        "#{email}, #{address}, ",
        "#{userStatus}, #{createTime}, ",
        "#{updateTime}, #{remark}, ",
        "#{blackStatus}, #{auditTime}, ",
        "#{idCardPolice})"
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
        "audit_time, id_card_police",
        "from ca_app_user",
        "where id = #{id}"
    })
    AppUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=AppUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppUser record);

    @Update({
        "update ca_app_user",
        "set open_id = #{openId},",
          "register_channel = #{registerChannel},",
          "username = #{username},",
          "id_card = #{idCard},",
          "name = #{name},",
          "id_card_detail_address = #{idCardDetailAddress},",
          "is_verify_id_card = #{isVerifyIdCard},",
          "id_card_coverup = #{idCardCoverup},",
          "id_card_coverdown = #{idCardCoverdown},",
          "id_card_hold = #{idCardHold},",
          "is_other_picture_auth = #{isOtherPictureAuth},",
          "is_bankcard_auth = #{isBankcardAuth},",
          "signature_pic = #{signaturePic},",
          "is_additional_auth = #{isAdditionalAuth},",
          "is_emergency_auth = #{isEmergencyAuth},",
          "phone = #{phone},",
          "email = #{email},",
          "address = #{address},",
          "user_status = #{userStatus},",
          "create_time = #{createTime},",
          "update_time = #{updateTime},",
          "remark = #{remark},",
          "black_status = #{blackStatus},",
          "audit_time = #{auditTime},",
          "id_card_police = #{idCardPolice}",
        "where id = #{id}"
    })
    int updateByPrimaryKeyWithBLOBs(AppUser record);

    @Update({
        "update ca_app_user",
        "set open_id = #{openId},",
          "register_channel = #{registerChannel},",
          "username = #{username},",
          "id_card = #{idCard},",
          "name = #{name},",
          "id_card_detail_address = #{idCardDetailAddress},",
          "is_verify_id_card = #{isVerifyIdCard},",
          "id_card_coverup = #{idCardCoverup},",
          "id_card_coverdown = #{idCardCoverdown},",
          "id_card_hold = #{idCardHold},",
          "is_other_picture_auth = #{isOtherPictureAuth},",
          "is_bankcard_auth = #{isBankcardAuth},",
          "signature_pic = #{signaturePic},",
          "is_additional_auth = #{isAdditionalAuth},",
          "is_emergency_auth = #{isEmergencyAuth},",
          "phone = #{phone},",
          "email = #{email},",
          "address = #{address},",
          "user_status = #{userStatus},",
          "create_time = #{createTime},",
          "update_time = #{updateTime},",
          "remark = #{remark},",
          "black_status = #{blackStatus},",
          "audit_time = #{auditTime}",
        "where id = #{id}"
    })
    int updateByPrimaryKey(AppUser record);
}