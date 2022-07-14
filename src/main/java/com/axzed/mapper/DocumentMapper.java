package com.axzed.mapper;

import com.axzed.bean.DocumentInfo;

import java.util.List;

public interface DocumentMapper {

    List<DocumentInfo> showAll();

    DocumentInfo findById(int id);

    int update(DocumentInfo documentInfo);

    int delete(int id);

    //根据条件查询所有管理员信息
    List<DocumentInfo> pageByCondition(DocumentInfo documentInfo);

    int save(DocumentInfo documentInfo);

    int deleteAll(int[] ids);

}
