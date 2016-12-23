package com.yoflying.drivingschool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liqiang on 16/12/18.
 */
//@ContextConfiguration(locations = {"classpath:spring/spring**.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("single")
public class TestDb {

    @Test
    public void test() {
        System.out.println("111");
    }
}
