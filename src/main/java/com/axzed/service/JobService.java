package com.axzed.service;

import com.axzed.bean.AdminInfo;
import com.axzed.bean.JobInfo;

import java.util.List;

public interface JobService {

    List<JobInfo> showAll();

    JobInfo findById(int id);

    int modify(JobInfo jobInfo);

    int delete(int id);

    void add(JobInfo jobInfo);

    List<JobInfo> pageByCondition(JobInfo jobInfo);
}
