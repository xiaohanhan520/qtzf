package com.xh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Accessors(chain = true)
public class User implements Serializable {

    @TableId("id")
    private String id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("sale")
    private String sale;

    @TableField("login_time")
    private Date loginTime;

    @TableField("out_time")
    private Date outTime;
}
