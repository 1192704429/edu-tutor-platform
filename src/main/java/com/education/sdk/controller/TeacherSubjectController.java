package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.TeacherSubjectDTO;
import com.education.sdk.service.TeacherSubjectService;
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
* @description: 老师绑定学科对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/teacherSubject")
public class TeacherSubjectController extends BaseController<TeacherSubjectService, TeacherSubjectDTO> {


    @Override
    @Resource(name = "teacherSubjectService")
    protected void setBaseService(TeacherSubjectService teacherSubjectService) {
        this.baseService = teacherSubjectService;
    }

    /**
    * 默认分页查询
    * @param teacherSubjectDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TeacherSubjectDTO teacherSubjectDTO) {
        return ReturnMsg.ok(baseService.basePage(teacherSubjectDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param teacherSubjectDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TeacherSubjectDTO teacherSubjectDTO) {
        return ReturnMsg.ok(baseService.findList(teacherSubjectDTO));
    }

    @Override
    protected void beforeSave(TeacherSubjectDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

