package com.axzed.controller;

import com.axzed.bean.AdminInfo;
import com.axzed.bean.DocumentInfo;
import com.axzed.common.CommonData;
import com.axzed.service.DocumentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * 执行文件上传
     */
    @RequestMapping("/upload")
    public String formUpload(List<MultipartFile> document,DocumentInfo documentInfo, HttpServletRequest request) {
        if (null != document && !document.isEmpty()) {
            for (MultipartFile file : document) {
                String originalFilename = file.getOriginalFilename();//test.png
                String realPath = request.getServletContext().getRealPath("/page/upload");
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                String newFileName = uuid + "_" + originalFilename;
                int hCode = originalFilename.hashCode();
                String dir1 = Integer.toHexString(hCode & 0xF);
                String dir2 = Integer.toHexString(hCode >>> 4 & 0xF);
                String savePath = realPath + File.separator + dir1 + File.separator + dir2;

                File filePath = new File(savePath,newFileName);
                //判断目录是否存在
                if (!filePath.exists()) {
                    filePath.mkdirs();//没有就创建
                }

                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(filePath);
                } catch (Exception e) {
                    e.printStackTrace();
                    return"error.jsp";
                }
                documentInfo.setFilename(originalFilename);
            }

            documentInfo.setCreateDate(new Date());

            AdminInfo admin =(AdminInfo)request.getSession().getAttribute("admin");

            documentInfo.setAdminInfo(admin);

            int row = documentService.save(documentInfo);

            if (row != 0){
                List<DocumentInfo> documentInfos = documentService.pageByCondition(null);
                request.setAttribute("documentInfos",documentInfos);
                return "/page/document/list.jsp";
            }else{
                request.setAttribute("errorMsg","新增操作不成功");
                return "/page/document/add.jsp";
            }
        } else {
            request.setAttribute("errorMsg","未上传文件");
            return"/page/document/add.jsp";
        }
    }

    @RequestMapping("/to_update")
    public String toUpdate(int id, Model model){
        DocumentInfo documentInfo =  documentService.findById(id);
        model.addAttribute("documentInfo",documentInfo);
        return "/page/document/update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public int Update(DocumentInfo documentInfo,Model model) {
        int row = documentService.update(documentInfo);
        return row;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(int id){
        int row = documentService.delete(id);
        return row;
    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return  "/page/document/add.jsp";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public int add(DocumentInfo documentInfo, HttpServletRequest request){
        Date date = new Date();
        documentInfo.setCreateDate(date);
        AdminInfo admin = (AdminInfo)request.getSession().getAttribute("admin");
        documentInfo.setAdminInfo(admin);
        int row = documentService.save(documentInfo);
        return row;
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(int[] ids){
        for (int id : ids) {
            documentService.delete(id);
        }
        return;
    }

    //多条件组合查询
    @RequestMapping("/pageByCondition")
    public String pageByCondition(@RequestParam(defaultValue = "1") int currentPage,
                                  DocumentInfo documentInfo,Model model,HttpServletRequest request){
        String path = request.getServletPath();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("?page");
        if (null != documentInfo.getTitle() && !"".equals(documentInfo.getTitle())){
            stringBuilder.append("&title="+documentInfo.getTitle());
        }
        String url = stringBuilder.toString();
        int pageSize = CommonData.pageSize;
        PageHelper.startPage(currentPage,pageSize);
        List<DocumentInfo> documentInfos = documentService.pageByCondition(documentInfo);
        model.addAttribute("documentInfos",documentInfos);
        PageInfo<DocumentInfo> pageInfo = new PageInfo<>(documentInfos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("title",documentInfo.getTitle());
        model.addAttribute("url",url);
        return "/page/document/list.jsp";
    }


}
