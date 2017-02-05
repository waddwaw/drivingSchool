package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.entity.LoveEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liqiang on 17/2/5.
 */
public interface LoveMapper {

    @Select("SELECT * FROM ds_love WHERE uuid = #{uuid}")
    LoveEntity findLove(@Param("uuid") String uuid);

    @Insert("INSERT INTO ds_love (uuid,me,youname,mp3,time,showmian,showmian2,showmian3,showmian4,showmian5,showmian6,showmian7,showmian8,showmian9,lovetitle)" +
            " VALUES(#{uuid},#{me},#{youname},#{mp3},#{time},#{showmian},#{showmian2},#{showmian3},#{showmian4},#{showmian5},#{showmian6},#{showmian7},#{showmian8},#{showmian9},#{lovetitle})")
    int insertLove(LoveEntity loveEntity);
}
