package com.ruoyi.system.service.impl;

import org.springframework.stereotype.Service;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysUserOnlineService;

/**
 * 線上使用者 服務層處理
 * 
 * @author ruoyi
 */
@Service
public class SysUserOnlineServiceImpl implements ISysUserOnlineService
{
    /**
     * 透過登入地址查詢資訊
     * 
     * @param ipaddr 登入地址
     * @param user 使用者資訊
     * @return 線上使用者資訊
     */
    @Override
    public SysUserOnline selectOnlineByIpaddr(String ipaddr, LoginUser user)
    {
        if (StringUtils.equals(ipaddr, user.getIpaddr()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 透過使用者名稱稱查詢資訊
     * 
     * @param userName 使用者名稱稱
     * @param user 使用者資訊
     * @return 線上使用者資訊
     */
    @Override
    public SysUserOnline selectOnlineByUserName(String userName, LoginUser user)
    {
        if (StringUtils.equals(userName, user.getUsername()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 透過登入地址/使用者名稱稱查詢資訊
     * 
     * @param ipaddr 登入地址
     * @param userName 使用者名稱稱
     * @param user 使用者資訊
     * @return 線上使用者資訊
     */
    @Override
    public SysUserOnline selectOnlineByInfo(String ipaddr, String userName, LoginUser user)
    {
        if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUsername()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 設定線上使用者資訊
     * 
     * @param user 使用者資訊
     * @return 線上使用者
     */
    @Override
    public SysUserOnline loginUserToUserOnline(LoginUser user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUser()))
        {
            return null;
        }
        SysUserOnline sysUserOnline = new SysUserOnline();
        sysUserOnline.setTokenId(user.getToken());
        sysUserOnline.setUserName(user.getUsername());
        sysUserOnline.setIpaddr(user.getIpaddr());
        sysUserOnline.setLoginLocation(user.getLoginLocation());
        sysUserOnline.setBrowser(user.getBrowser());
        sysUserOnline.setOs(user.getOs());
        sysUserOnline.setLoginTime(user.getLoginTime());
        if (StringUtils.isNotNull(user.getUser().getDept()))
        {
            sysUserOnline.setDeptName(user.getUser().getDept().getDeptName());
        }
        return sysUserOnline;
    }
}
