package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.DsLeaveMapper;
import com.yoflying.drivingschool.domain.model.DSSetting;
import com.yoflying.drivingschool.domain.model.DsLeave;
import com.yoflying.drivingschool.domain.service.DsLeaveService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
@Repository
public class DsLeaveServiceImpl implements DsLeaveService{
    @Resource
    DsLeaveMapper dsLeaveMapper;

    public int insertDsLeave(DsLeave dsLeave) {
        return dsLeaveMapper.insertDsLeave(dsLeave);
    }

    public int updateDsLeave(Integer status, Long coachId, Long dsId) {
        return dsLeaveMapper.updateDsLeave(status, coachId, dsId);
    }

    public DSSetting findDsLeavebyDsIDandCoachId(Long dsId, Long coachId) {
        return dsLeaveMapper.findDsLeavebyDsIDandCoachId(dsId, coachId);
    }

    public List<DSSetting> findDsLeavebyDsIdALL(Long dsId) {
        return dsLeaveMapper.findDsLeavebyDsIdALL(dsId);
    }
}
