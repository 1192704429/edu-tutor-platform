package com.education.sdk.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.sdk.common.BaseController;
import com.education.sdk.common.BaseSelectEntity;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.CommentDTO;
import com.education.sdk.dto.OrdersDTO;
import com.education.sdk.dto.TeacherDTO;
import com.education.sdk.dto.UsersDTO;
import com.education.sdk.service.CommentService;
import com.education.sdk.service.OrdersService;
import com.education.sdk.service.TeacherService;
import com.education.sdk.service.UsersService;
import com.education.sdk.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 评论对外接口层
 * @author: wuming
 * @create: 2025.02.18 16:24:07
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController<CommentService, CommentDTO> {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private OrdersService ordersService;

    @Override
    @Resource(name = "commentService")
    protected void setBaseService(CommentService commentService) {
        this.baseService = commentService;
    }

    /**
     * 默认分页查询
     *
     * @param commentDTO
     * @return
     */
    @PostMapping("/page")
    public ReturnMsg page(@RequestBody CommentDTO commentDTO) {
        Page<CommentDTO> dtoPage = baseService.basePage(commentDTO);
        Page<CommentVO> dtoPage1 = new Page<>();
        BeanUtil.copyProperties(dtoPage, dtoPage1);
        List<CommentDTO> records = dtoPage.getRecords();
        List<CommentVO> commentVOS = records.stream().map(item -> {
            Long userId = item.getUserId();
            boolean isUser = (null != userId);
            CommentVO commentVO = new CommentVO();
            commentVO.setAvatar(isUser ? item.getAvatar() : item.getHeadImg());
            commentVO.setType(isUser ? 0 : 1);
            commentVO.setId(item.getId());
            commentVO.setUserId(isUser ? "user-" + item.getUserId() : "tea-" + item.getTeacherId());
            commentVO.setParentId(item.getParentId());
            commentVO.setOrderId(item.getOrderId());
            commentVO.setContent(item.getContent());
            commentVO.setName(isUser ? item.getNickName() : item.getName());
            commentVO.setCreateTime(item.getCreateTime());
            return commentVO;
        }).collect(Collectors.toList());
        dtoPage1.setRecords(commentVOS);
        return ReturnMsg.ok(dtoPage1);
    }

    /**
     * 根据XML中的sql语句进行查询
     *
     * @param commentDTO
     * @return
     */
    @PostMapping(value = "/findList")
    public ReturnMsg findList(@RequestBody CommentDTO commentDTO) {
        Long teacherIds = commentDTO.getTeacherIds();
        if (null != teacherIds) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setTeacherId(commentDTO.getTeacherIds());
            List<OrdersDTO> list = ordersService.findList(ordersDTO);
            if (CollectionUtil.isNotEmpty(list)) {
                String collected = list.stream().map(item -> item.getId() + "").collect(Collectors.joining(","));
                commentDTO.setOrderIds(collected);
            }
        }
        List<CommentDTO> commentDTOS = baseService.findList(commentDTO);
        List<CommentVO> commentVOS = commentDTOS.stream().map(item -> {
            Long userId = item.getUserId();
            boolean isUser = (null != userId);
            CommentVO commentVO = new CommentVO();
            commentVO.setAvatar(isUser ? item.getAvatar() : item.getHeadImg());
            commentVO.setType(isUser ? 0 : 1);
            commentVO.setId(item.getId());
            commentVO.setParentId(item.getParentId());
            commentVO.setUserId(isUser ? "user-" + item.getUserId() : "tea-" + item.getTeacherId());
            commentVO.setOrderId(item.getOrderId());
            commentVO.setContent(item.getContent());
            commentVO.setName(isUser ? item.getNickName() : item.getName());
            commentVO.setCreateTime(item.getCreateTime());
            return commentVO;
        }).collect(Collectors.toList());
        return ReturnMsg.ok(commentVOS);
    }

    @Override
    protected void beforeSave(CommentDTO entity) throws Exception {
        entity.setCreateTime(new Date());
        super.beforeSave(entity);
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

}

