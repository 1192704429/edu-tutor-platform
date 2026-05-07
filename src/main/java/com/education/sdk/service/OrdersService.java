package com.education.sdk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.sdk.dto.OrdersDTO;
import java.util.List;
/**
* @description: 预约订单业务层接口
* @author: wuming
* @create: 2025.02.28 10:20:21
*/
public interface OrdersService extends IService<OrdersDTO> {

    /**
    * 默认分页方法
    * @param ordersDTO
    * @return
    */
    Page<OrdersDTO> basePage(OrdersDTO ordersDTO);


    /**
    * 根据XML中的sql语句进行查询
    * @param ordersDTO
    * @return
    */
    List<OrdersDTO> findList(OrdersDTO ordersDTO);

}
