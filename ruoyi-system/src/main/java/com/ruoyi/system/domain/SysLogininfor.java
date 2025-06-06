package com.ruoyi.system.domain;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系統訪問記錄表 sys_logininfor
 * 
 * @author ruoyi
 */
public class SysLogininfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Schema(description = "序號")
    @Excel(name = "序號", cellType = ColumnType.NUMERIC)
    private Long infoId;

    /** 使用者賬號 */
    @Schema(description = "使用者賬號")
    @Excel(name = "使用者賬號")
    private String userName;

    /** 登入狀態 0成功 1失敗 */
    @Schema(description = "登入狀態")
    @Excel(name = "登入狀態", readConverterExp = "0=成功,1=失敗")
    private String status;

    /** 登入IP地址 */
    @Schema(description = "登入地址")
    @Excel(name = "登入地址")
    private String ipaddr;

    /** 登入地點 */
    @Schema(description = "登入地點")
    @Excel(name = "登入地點")
    private String loginLocation;

    /** 瀏覽器型別 */
    @Schema(description = "瀏覽器")
    @Excel(name = "瀏覽器")
    private String browser;

    /** 作業系統 */
    @Schema(description = "作業系統")
    @Excel(name = "作業系統")
    private String os;

    /** 提示訊息 */
    @Schema(description = "提示訊息")
    @Excel(name = "提示訊息")
    private String msg;

    /** 訪問時間 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "訪問時間")
    @Excel(name = "訪問時間", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public Long getInfoId()
    {
        return infoId;
    }

    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIpaddr()
    {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr)
    {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation()
    {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation)
    {
        this.loginLocation = loginLocation;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }
}
