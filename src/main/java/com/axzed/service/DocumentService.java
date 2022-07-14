package com.axzed.service;

import com.axzed.bean.DocumentInfo;

import java.util.List;

public interface DocumentService {

    List<DocumentInfo> showAll();

    DocumentInfo findById(int id);

    int update(DocumentInfo documentInfo);

    int delete(int id);

    List<DocumentInfo> pageByCondition(DocumentInfo documentInfo);

    int save(DocumentInfo documentInfo);

    int deleteAll(int[] ids);

}
