package com.education.sdk.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {

    private Long id;
    private Long orderId;
    private String userId;

    private String name;

    private String avatar;

    private Integer type;

    private String content;

    private Long parentId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
