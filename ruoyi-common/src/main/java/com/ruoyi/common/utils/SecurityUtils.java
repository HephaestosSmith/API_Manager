package com.ruoyi.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.PatternMatchUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;

/**
 * 安全服務工具類
 * 
 * @author ruoyi
 */
public class SecurityUtils
{

    /**
     * 使用者ID
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getUserId();
        }
        catch (Exception e)
        {
            throw new ServiceException("獲取使用者ID異常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 獲取部門ID
     **/
    public static Long getDeptId()
    {
        try
        {
            return getLoginUser().getDeptId();
        }
        catch (Exception e)
        {
            throw new ServiceException("獲取部門ID異常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 獲取使用者賬戶
     **/
    public static String getUsername()
    {
        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            throw new ServiceException("獲取使用者賬戶異常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 獲取使用者
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new ServiceException("獲取使用者資訊異常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 獲取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密碼
     *
     * @param password 密碼
     * @return 加密字串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判斷密碼是否相同
     *
     * @param rawPassword 真實密碼
     * @param encodedPassword 加密後字元
     * @return 結果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否為管理員
     * 
     * @param userId 使用者ID
     * @return 結果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    /**
     * 驗證使用者是否具備某許可權
     * 
     * @param permission 許可權字串
     * @return 使用者是否具備某許可權
     */
    public static boolean hasPermi(String permission)
    {
        return hasPermi(getLoginUser().getPermissions(), permission);
    }

    /**
     * 判斷是否包含許可權
     * 
     * @param authorities 許可權列表
     * @param permission 許可權字串
     * @return 使用者是否具備某許可權
     */
    public static boolean hasPermi(Collection<String> authorities, String permission)
    {
        return authorities.stream().filter(StringUtils::hasText)
                .anyMatch(x -> Constants.ALL_PERMISSION.equals(x) || PatternMatchUtils.simpleMatch(x, permission));
    }

    /**
     * 驗證使用者是否擁有某個角色
     * 
     * @param role 角色標識
     * @return 使用者是否具備某角色
     */
    public static boolean hasRole(String role)
    {
        List<SysRole> roleList = getLoginUser().getUser().getRoles();
        Collection<String> roles = roleList.stream().map(SysRole::getRoleKey).collect(Collectors.toSet());
        return hasRole(roles, role);
    }

    /**
     * 判斷是否包含角色
     * 
     * @param roles 角色列表
     * @param role 角色
     * @return 使用者是否具備某角色許可權
     */
    public static boolean hasRole(Collection<String> roles, String role)
    {
        return roles.stream().filter(StringUtils::hasText)
                .anyMatch(x -> Constants.SUPER_ADMIN.equals(x) || PatternMatchUtils.simpleMatch(x, role));
    }

}
