package com.axzed.service.impl;

import com.axzed.bean.NoticeInfo;
import com.axzed.mapper.NoticeMapper;
import com.axzed.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<NoticeInfo> showAll() {
        try {
            List<NoticeInfo> noticeInfos = noticeMapper.showAll();
            return noticeInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有公告信息异常",e);
        }
    }

    @Override
    public NoticeInfo findById(int id) {
        try {
            NoticeInfo noticeInfo = noticeMapper.findById(id);
            return noticeInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id查询公告异常",e);
        }
    }

    @Override
    public int update(NoticeInfo noticeInfo) {
        try {
            int row = noticeMapper.update(noticeInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id修改公告异常",e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = noticeMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id删除公告异常",e);
        }
    }

    @Override
    public List<NoticeInfo> pageByCondition(NoticeInfo noticeInfo) {

        try {
            List<NoticeInfo> noticeInfos = noticeMapper.pageByCondition(noticeInfo);
            return noticeInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("分页查询公告列表异常",e);
        }
    }

    @Override
    public int save(NoticeInfo noticeInfo) {
        try {

            int row = noticeMapper.save(noticeInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增公告异常",e);
        }
    }

    @Override
    public int deleteAll(int[] ids) {
        return 0;
    }


}
