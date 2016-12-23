package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by arvin on 2016/12/21.
 */
@MapperScan
public interface TokenMapper {

    @Insert("INSERT INTO user_token (userId,category,tokenCode)" +
            " VALUES( #{userId},#{category},#{tokenCode})")
    int insertToken(Token token);

    @Select("SELECT * FROM user_token WHERE category = #{category} and  tokenCode = #{tokenCode}")
    Token findTokenBycategoryAndCode(@Param("tokenCode") String tokenCode);
}
