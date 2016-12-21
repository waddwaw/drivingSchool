package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.TokenMapper;
import com.yoflying.drivingschool.domain.model.Token;
import com.yoflying.drivingschool.domain.service.TokenService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by arvin on 2016/12/21.
 */
@Repository
public class TokenImpl implements TokenService{
    @Resource
    TokenMapper tokenMapper;

    public int insertToken(Token token) {
        return tokenMapper.insertToken(token);
    }

    public Token findTokenBycategoryAndCode(String category, String tokenCode) {
        return tokenMapper.findTokenBycategoryAndCode(category, tokenCode);
    }
}
