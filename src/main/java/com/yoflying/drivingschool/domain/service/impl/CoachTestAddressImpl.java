package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.CoachTestaAddressMapper;
import com.yoflying.drivingschool.domain.model.CoachTestaAddress;
import com.yoflying.drivingschool.domain.service.CoachTestAddressService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by arvin on 2016/12/23.
 */
@Repository
public class CoachTestAddressImpl implements CoachTestAddressService{

    @Resource
    CoachTestaAddressMapper coachTestaAddressMapper;
    public int insertCoachTestAddress(CoachTestaAddress coachTestaAddress) {
        return coachTestaAddressMapper.insertCoachTestAddress(coachTestaAddress);
    }

    public List<CoachTestaAddress> findCTAByUserIdAndCoures(Long userId) {
        return coachTestaAddressMapper.findCTAByUserIdAndCoures(userId);
    }
}
