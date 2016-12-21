package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.Token;

/**
 * Created by arvin on 2016/12/21.
 */
public interface TokenService {

    int insertToken(Token token);

    Token findTokenBycategoryAndCode(String category, String tokenCode);
}
