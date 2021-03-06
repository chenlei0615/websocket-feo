package com.sunlands.feo.demo.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.base
 * @Description : 抽象类基类
 * @Author : chenlei
 * @Create Date : 2018年07月26日 16:27
 * ------------    --------------    ---------------------------------
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator  = "sys_strategy")
    @GenericGenerator(name = "sys_strategy", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private Timestamp createTime=new Timestamp(System.currentTimeMillis());

    @ApiModelProperty("修改时间")
    @Column(name = "modify_time")
    private Timestamp modifyTime=new Timestamp(System.currentTimeMillis());

    @ApiModelProperty("是否删除")
    @Column(name = "deleted")
    private boolean deleted;


}
