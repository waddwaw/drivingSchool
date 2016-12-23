package com.yoflying.drivingschool;

import com.yoflying.drivingschool.task.ApporintmentTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by arvin on 2016/12/23.
 */
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("single")
public class TestTask {

    @Test
    public void task() {
        ApporintmentTask apporintmentTask = new ApporintmentTask();
        apporintmentTask.appointmentTask();
    }
}
