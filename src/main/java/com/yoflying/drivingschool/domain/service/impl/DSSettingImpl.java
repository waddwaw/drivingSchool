package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.DSSettingMapper;
import com.yoflying.drivingschool.domain.model.DSSetting;
import com.yoflying.drivingschool.domain.service.DSSettingService;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by liqiang on 16/12/14.
 */
@Repository
public class DSSettingImpl implements DSSettingService{

    @Resource
    DSSettingMapper dsSettingMapper;

    public int insertDssetting(DSSetting dsSetting) {
        return dsSettingMapper.insertDssetting(dsSetting);
    }

    public int updateDssetting(DSSetting dsSetting) {
        return dsSettingMapper.updateDssetting(dsSetting);
    }

    public DSSetting findOneDSSetting(Long dsId) {
        return dsSettingMapper.findOneDSSetting(dsId);
    }
}
