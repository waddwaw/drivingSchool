package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.DSSetting;
import com.yoflying.drivingschool.domain.model.DsLeave;

import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
public interface DsLeaveService {


    int insertDsLeave(DsLeave dsLeave);


    int updateDsLeave(Integer status, Long coachId, Long dsId);


    List<DsLeave> findDsLeavebyDsIDandCoachId(Long dsId, Long coachId);


    List<DsLeave> findDsLeavebyDsIdALL(Long dsId);
}
