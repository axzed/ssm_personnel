package com.axzed.service.impl;

import com.axzed.bean.DocumentInfo;
import com.axzed.mapper.DocumentMapper;
import com.axzed.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;


    @Override
    public List<DocumentInfo> showAll() {
        try {
            List<DocumentInfo> documentInfos = documentMapper.showAll();
            return documentInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有公告信息异常",e);
        }
    }

    @Override
    public DocumentInfo findById(int id) {
        try {
            DocumentInfo documentInfo = documentMapper.findById(id);
            return documentInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id查询公告异常",e);
        }
    }

    @Override
    public int update(DocumentInfo documentInfo) {
        try {
            int row = documentMapper.update(documentInfo);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id修改公告异常",e);
        }
    }

    @Override
    public int delete(int id) {
        try {
            int row = documentMapper.delete(id);
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("根据id删除公告异常",e);
        }
    }

    @Override
    public List<DocumentInfo> pageByCondition(DocumentInfo documentInfo) {
        try {
            List<DocumentInfo> documentInfos = documentMapper.pageByCondition(documentInfo);
            return documentInfos;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("分页查询公告列表异常",e);
        }
    }

    @Override
    public int save(DocumentInfo documentInfo) {
        try {
            int row = documentMapper.save(documentInfo);
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
