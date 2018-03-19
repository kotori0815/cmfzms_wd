package com.baizhi;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by wd199 on 2017/6/26.
 */
public class MySchedler {

    public static void main(String[] args) {

        try {
            StdSchedulerFactory factory = new StdSchedulerFactory();
            Scheduler scheduler = factory.getScheduler();
            JobDetail build = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "default").build();
            Date date = DateBuilder.futureDate(30, DateBuilder.IntervalUnit.SECOND);
            Trigger trigger=TriggerBuilder.newTrigger().startAt(date).build();
            scheduler.scheduleJob(build,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
