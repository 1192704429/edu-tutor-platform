package com.education.sdk.controller;

import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.TypesDTO;
import com.education.sdk.service.TypesService;
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
* @description: 服务方式管理对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/types")
public class TypesController extends BaseController<TypesService, TypesDTO> {


    @Override
    @Resource(name = "typesService")
    protected void setBaseService(TypesService typesService) {
        this.baseService = typesService;
    }

    /**
    * 默认分页查询
    * @param typesDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody TypesDTO typesDTO) {
        return ReturnMsg.ok(baseService.basePage(typesDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param typesDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody TypesDTO typesDTO) {
        return ReturnMsg.ok(baseService.findList(typesDTO));
    }

    @Override
    protected void beforeSave(TypesDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
    }

}

