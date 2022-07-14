package com.axzed.mapper;

import com.axzed.bean.NoticeInfo;

import java.util.List;

public interface NoticeMapper {

    List<NoticeInfo> showAll();

    NoticeInfo findById(int id);

    int update(NoticeInfo noticeInfo);

    int delete(int id);

    //根据条件查询所有管理员信息
    List<NoticeInfo> pageByCondition(NoticeInfo noticeInfo);

    int save(NoticeInfo noticeInfo);

    int deleteAll(int[] ids);

}
