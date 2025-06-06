package com.ruoyi.framework.web.service;

import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.security.context.PermissionContextHolder;

/**
 * RuoYi首創 自定義許可權實現，ss取自SpringSecurity首字母
 * 
 * @author ruoyi
 */
@Service("ss")
public class PermissionService
{
    /**
     * 驗證使用者是否具備某許可權
     * 
     * @param permission 許可權字串
     * @return 使用者是否具備某許可權
     */
    public boolean hasPermi(String permission)
    {
        if (StringUtils.isEmpty(permission))
        {
            return false;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermissions()))
        {
            return false;
        }
        PermissionContextHolder.setContext(permission);
        return hasPermissions(loginUser.getPermissions(), permission);
    }

    /**
     * 驗證使用者是否不具備某許可權，與 hasPermi邏輯相反
     *
     * @param permission 許可權字串
     * @return 使用者是否不具備某許可權
     */
    public boolean lacksPermi(String permission)
    {
        return hasPermi(permission) != true;
    }

    /**
     * 驗證使用者是否具有以下任意一個許可權
     *
     * @param permissions 以 PERMISSION_DELIMETER 為分隔符的許可權列表
     * @return 使用者是否具有以下任意一個許可權
     */
    public boolean hasAnyPermi(String permissions)
    {
        if (StringUtils.isEmpty(permissions))
        {
            return false;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermissions()))
        {
            return false;
        }
        PermissionContextHolder.setContext(permissions);
        Set<String> authorities = loginUser.getPermissions();
        for (String permission : permissions.split(Constants.PERMISSION_DELIMETER))
        {
            if (permission != null && hasPermissions(authorities, permission))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 判斷使用者是否擁有某個角色
     * 
     * @param role 角色字串
     * @return 使用者是否具備某角色
     */
    public boolean hasRole(String role)
    {
        if (StringUtils.isEmpty(role))
        {
            return false;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getUser().getRoles()))
        {
            return false;
        }
        for (SysRole sysRole : loginUser.getUser().getRoles())
        {
            String roleKey = sysRole.getRoleKey();
            if (Constants.SUPER_ADMIN.equals(roleKey) || roleKey.equals(StringUtils.trim(role)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 驗證使用者是否不具備某角色，與 isRole邏輯相反。
     *
     * @param role 角色名稱
     * @return 使用者是否不具備某角色
     */
    public boolean lacksRole(String role)
    {
        return hasRole(role) != true;
    }

    /**
     * 驗證使用者是否具有以下任意一個角色
     *
     * @param roles 以 ROLE_NAMES_DELIMETER 為分隔符的角色列表
     * @return 使用者是否具有以下任意一個角色
     */
    public boolean hasAnyRoles(String roles)
    {
        if (StringUtils.isEmpty(roles))
        {
            return false;
        }
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getUser().getRoles()))
        {
            return false;
        }
        for (String role : roles.split(Constants.ROLE_DELIMETER))
        {
            if (hasRole(role))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 判斷是否包含許可權
     * 
     * @param permissions 許可權列表
     * @param permission 許可權字串
     * @return 使用者是否具備某許可權
     */
    private boolean hasPermissions(Set<String> permissions, String permission)
    {
        return permissions.contains(Constants.ALL_PERMISSION) || permissions.contains(StringUtils.trim(permission));
    }
}
