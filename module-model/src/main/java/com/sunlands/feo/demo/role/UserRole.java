package com.sunlands.feo.demo.role;

import com.sunlands.feo.demo.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role
 * @Description : 用户角色
 * @Author : chenlei
 * @Create Date : 2018年07月26日 16:35
 * ------------    --------------    ---------------------------------
 */
@Entity
@Table(name = "user_role")
@Data
public class UserRole extends BaseEntity {
    @ApiModelProperty("角色名字")
    @Column(name = "role_name")
    private String roleName;

    @ApiModelProperty("创建人")
    @Column(name = "creator")
    private String creator;

}
