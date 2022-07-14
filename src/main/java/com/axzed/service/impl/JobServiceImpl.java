package com.axzed.service.impl;

import com.axzed.bean.JobInfo;
import com.axzed.mapper.JobMapper;
import com.axzed.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobInfo> showAll() {
        try {
            List<JobInfo> jobInfos = jobMapper.showAll();
            return jobInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询职位列表异常", e);
        }
    }

    @Override
    public JobInfo findById(int id) {
        try {
            JobInfo jobInfo = jobMapper.findById(id);
            return jobInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询职位信息异常", e);
        }
    }

    @Override
    public int modify(JobInfo jobInfo) {
        try {
            int row = jobMapper.modify(jobInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改职位信息异常", e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = jobMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("职位删除异常", e);
        }
    }

    @Override
    public int add(JobInfo jobInfo) {
        try {
            int row = jobMapper.add(jobInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("职位删除异常", e);
        }
    }


    @Override
    public List<JobInfo> pageByCondition(JobInfo jobInfo) {
        try {
            List<JobInfo> jobInfos = jobMapper.pageByCondition(jobInfo);
            return jobInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("职位模块分页条件查询异常",e);
        }
    }
}
