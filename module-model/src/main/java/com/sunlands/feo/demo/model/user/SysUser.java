package com.sunlands.feo.demo.model.user;

import com.sunlands.feo.demo.base.BaseEntity;
import com.sunlands.feo.demo.model.role.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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
    private String username;

    @ApiModelProperty("密码")
    @Column(name="password")
    private String password;

    @ApiModelProperty("角色")
    @ManyToMany(targetEntity = UserRole.class, fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    Set<UserRole> roles =new HashSet<UserRole>();


    @Transient
    private Set<UserRole> authorities = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities=new HashSet<>();
        Set<UserRole> roles=getRoles();
        for(UserRole role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
