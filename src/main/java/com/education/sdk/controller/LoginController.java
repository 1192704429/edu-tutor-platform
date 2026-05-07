package com.education.sdk.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.sdk.common.ReturnMsg;
import com.education.sdk.dto.ManageDTO;
import com.education.sdk.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 后台管理登录控制器
 * @author: wuming
 * @Create: 2025.02.28 10:20:21
 */
@RestController
@RequestMapping("/manage/login")
public class LoginController {

    static Map<String, String> userInfoMap = new HashMap<>();

    @Autowired
    private ManageService manageService;

    @PostMapping
    public ReturnMsg manageLogin(@RequestBody Map<String, String> param) {
        if (StrUtil.isEmpty(param.get("username")) || StrUtil.isEmpty(param.get("password"))) {
            return ReturnMsg.error("用户名或密码错误!");
        }
        ManageDTO manageDTO = new ManageDTO();
        manageDTO.setUserName(param.get("username"));
        manageDTO.setPassWord(param.get("password"));
        QueryWrapper<ManageDTO> manageDTOQueryWrapper = new QueryWrapper<>(manageDTO);
        manageDTOQueryWrapper.last("limit 1");
        ManageDTO adminDTOS = manageService.getOne(manageDTOQueryWrapper);
        if (adminDTOS == null) return ReturnMsg.error("用户名或密码错误!");
        Map<String, Object> map = new HashMap<>();
        map.put("avatar", StrUtil.isNotBlank(adminDTOS.getPhotoImg()) ? adminDTOS.getPhotoImg() : "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", adminDTOS.getName() + ",你好!");
        map.put("name", adminDTOS.getName());
        map.put("id", adminDTOS.getId());
        map.put("roles", Arrays.asList("admin"));
        Map<String, String> returnMap = new HashMap<>();
        String uuid = UUID.randomUUID().toString();
        returnMap.put("token", uuid);
        userInfoMap.put(uuid, JSON.toJSONString(map));
        return ReturnMsg.ok(returnMap);
    }

    @GetMapping
    public ReturnMsg getUserInfo(@RequestParam("token") String token) {
        if (!userInfoMap.containsKey(token)) return ReturnMsg.error(401,"尚未登录,请重新登录!");
        return ReturnMsg.ok(JSON.parse(userInfoMap.get(token)));
    }

    @GetMapping("/logout")
    public ReturnMsg logout(@RequestParam("token") String token) {
        userInfoMap.remove(token);
        return ReturnMsg.ok();
    }

}
