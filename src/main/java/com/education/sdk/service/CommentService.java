package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.CommentDTO;

import java.util.List;

/**
* @description: 评论业务层接口
* @author: wuming
* @create: 2025.02.18 16:24:07
*/
public interface CommentService extends IService<CommentDTO> {

    /**
    * 默认分页方法
    * @param commentDTO
    * @return
    */
    Page<CommentDTO> basePage(CommentDTO commentDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param commentDTO
    * @return
    */
    List<CommentDTO> findList(CommentDTO commentDTO);

}
