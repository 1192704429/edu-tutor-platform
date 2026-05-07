package com.education.sdk.controller;

import cn.hutool.core.util.StrUtil;
import com.education.sdk.common.BaseController;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.common.util.MailUtil;
import com.education.sdk.dto.OrdersDTO;
import com.education.sdk.service.OrdersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.education.sdk.common.BaseSelectEntity;
import java.util.ArrayList;
import com.education.sdk.service.UsersService;
import com.education.sdk.dto.UsersDTO;
import com.education.sdk.service.TeacherService;
import com.education.sdk.dto.TeacherDTO;
import com.education.sdk.service.SubjectService;
import com.education.sdk.dto.SubjectDTO;
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
* @description: 预约订单对外接口层
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<OrdersService, OrdersDTO> {

    @Autowired
    private UsersService usersService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TypesService typesService;

    @Override
    @Resource(name = "ordersService")
    protected void setBaseService(OrdersService ordersService) {
        this.baseService = ordersService;
    }

    /**
    * 默认分页查询
    * @param ordersDTO
    * @return
    */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.basePage(ordersDTO));
    }

    /**
    * 根据XML中的sql语句进行查询
    * @param ordersDTO
    * @return
    */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody OrdersDTO ordersDTO) {
        return ReturnMsg.ok(baseService.findList(ordersDTO));
    }

    @Autowired
    private MailUtil mailUtil;


    @Override
    protected void beforeSave(OrdersDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        TeacherDTO teacherDTO = teacherService.getById(entity.getTeacherId());
        if(StrUtil.isNotEmpty(teacherDTO.getEmail())) {
            new Thread(() -> {
                mailUtil.sendSimpleMail(teacherDTO.getEmail(), "家教预约订单提醒", "收到用户预约订单，请前往【我的订单】页面进行处理~");
            }).start();
        }
        super.beforeSave(entity);
    }

    @GetMapping("/all/users")
    public ReturnMsg allUsers() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<UsersDTO> dtos = usersService.list();
            for (UsersDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getNickName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/teacher")
    public ReturnMsg allTeacher() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<TeacherDTO> dtos = teacherService.list();
            for (TeacherDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
    }

    @GetMapping("/all/subject")
    public ReturnMsg allSubject() {
        List<BaseSelectEntity> list = new ArrayList<>();
        List<SubjectDTO> dtos = subjectService.list();
            for (SubjectDTO dto : dtos) {
            BaseSelectEntity baseSelectEntity = new BaseSelectEntity();
            baseSelectEntity.setKey(dto.getId());
            baseSelectEntity.setValue(dto.getSubjectName());
            list.add(baseSelectEntity);
        }
        return ReturnMsg.ok(list);
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

