package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.SubjectDTO;
import com.education.sdk.service.SubjectService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.education.sdk.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 学科管理对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController<SubjectService, SubjectDTO> {


    @Override
    @Resource(name = "subjectService")
    protected void setBaseService(SubjectService subjectService) {
        this.baseService = subjectService;
    }

    /**
    * 默认分页查询
    * @param subjectDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody SubjectDTO subjectDTO) {
        return ReturnMsg.ok(baseService.basePage(subjectDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param subjectDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody SubjectDTO subjectDTO) {
        return ReturnMsg.ok(baseService.findList(subjectDTO));
    }

    @Override
    protected void beforeSave(SubjectDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

