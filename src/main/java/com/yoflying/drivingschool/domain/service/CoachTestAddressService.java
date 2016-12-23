package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.CoachTestaAddress;

import java.util.List;

/**
 * Created by arvin on 2016/12/23.
 */
public interface CoachTestAddressService {

    int insertCoachTestAddress(CoachTestaAddress coachTestaAddress);

    List<CoachTestaAddress> findCTAByUserIdAndCoures(Long userId);
}
