package com.axzed.mapper;


import com.axzed.bean.JobInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {

    List<JobInfo> showAll();

    JobInfo findById(int id);

    int modify(JobInfo jobInfo);

    int delete(@Param("id") int id);

    int add(JobInfo jobInfo);

    List<JobInfo> pageByCondition(JobInfo jobInfo);

}
