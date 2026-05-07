package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.TeacherDTO;
import com.education.sdk.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.education.sdk.common.BaseSelectEntity;
import java.util.ArrayList;
import com.education.sdk.service.TypesService;
import com.education.sdk.dto.TypesDTO;
import javax.annotation.Resource;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.education.sdk.common.BaseSelectEntity;
import cn.hutool.core.collection.CollectionUtil;
import java.util.Date;
/**
* @description: 教师管理对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController<TeacherService, TeacherDTO> {

    @Autowired
    private TypesService typesService;

    @Override
    @Resource(name = "teacherService")
    protected void setBaseService(TeacherService teacherService) {
        this.baseService = teacherService;
    }

    /**
    * 默认分页查询
    * @param teacherDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TeacherDTO teacherDTO) {
        return ReturnMsg.ok(baseService.basePage(teacherDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param teacherDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TeacherDTO teacherDTO) {
        return ReturnMsg.ok(baseService.findList(teacherDTO));
    }

    @Override
    protected void beforeSave(TeacherDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

    @GetMapping("/all/types")
    public ReturnMsg allTypes() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<TypesDTO> dtos = typesService.list();
            for (TypesDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getTypeName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

}

