package com.xh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("login_log")
@Accessors(chain = true)
public class LoginLog implements Serializable {

    @TableField("id")
    private String id;

    @TableField("login_name")
    private String loginName;

    @TableField("login_ip")
    private String loginIp;

    @TableField("status")
    private String status;

    @TableField("time")
    private Date time;
}
