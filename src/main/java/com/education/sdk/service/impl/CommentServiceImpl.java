package com.education.sdk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.sdk.dao.CommentDao;
import com.education.sdk.dto.CommentDTO;
import com.education.sdk.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description: 评论业务层实现类
* @author: wuming
* @create: 2025.02.18 16:24:07
*/
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, CommentDTO> implements CommentService {

    @Override
    public Page<CommentDTO> basePage(CommentDTO commentDTO) {
        if (null != commentDTO.getCurrent() && null != commentDTO.getPageSize())
            commentDTO.setCurrent((commentDTO.getCurrent() - 1) * commentDTO.getPageSize());
        List<CommentDTO> list = this.baseMapper.findList(commentDTO);
        int count = this.baseMapper.findPageCount(commentDTO);
        Page<CommentDTO> page = new Page<>();
        page.setTotal(count);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<CommentDTO> findList(CommentDTO commentDTO) {
        return this.baseMapper.findList(commentDTO);
    }

}
