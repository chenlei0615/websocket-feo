package com.sunlands.feo.demo.user;

import com.sunlands.feo.demo.base.BaseEntity;
import com.sunlands.feo.demo.role.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.user
 * @Description : 用户模型
 * @Author : chenlei
 * @Create Date : 2018年07月26日 16:20
 * ------------    --------------    ---------------------------------
 */
@Entity
@Table(name="sys_user")
@Data
public class SysUser extends BaseEntity implements UserDetails {
    @ApiModelProperty("名字")
    @Column(name = "user_name")
    private String userName;

    @ApiModelProperty("密码")
    @Column(name="password")
    private String password;

    @ApiModelProperty("角色")
    Set<UserRole> roles =new HashSet<UserRole>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
