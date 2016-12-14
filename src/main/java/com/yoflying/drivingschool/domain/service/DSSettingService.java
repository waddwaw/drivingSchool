package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.DSSetting;
import org.apache.ibatis.annotations.Param;



/**
 * Created by liqiang on 16/12/14.
 */
public interface DSSettingService {

    int insertDssetting(DSSetting dsSetting);


    int updateDssetting(DSSetting dsSetting);


    DSSetting findOneDSSetting(Long dsId);
}
