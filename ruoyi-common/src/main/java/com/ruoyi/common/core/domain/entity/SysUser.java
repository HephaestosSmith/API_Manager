package com.ruoyi.common.core.domain.entity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;

/**
 * 使用者物件 sys_user
 * 
 * @author ruoyi
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 使用者ID */
    @Schema(description = "使用者序號")
    @Excel(name = "使用者序號", type = Type.EXPORT, cellType = ColumnType.NUMERIC, prompt = "使用者編號")
    private Long userId;

    /** 部門ID */
    @Schema(description = "部門編號")
    @Excel(name = "部門編號", type = Type.IMPORT)
    private Long deptId;

    /** 使用者賬號 */
    @Schema(description = "登入名稱")
    @Excel(name = "登入名稱")
    private String userName;

    /** 使用者暱稱 */
    @Schema(description = "使用者名稱稱")
    @Excel(name = "使用者名稱稱")
    private String nickName;

    /** 使用者郵箱 */
    @Schema(description = "使用者郵箱")
    @Excel(name = "使用者郵箱")
    private String email;

    /** 手機號碼 */
    @Schema(description = "手機號碼")
    @Excel(name = "手機號碼", cellType = ColumnType.TEXT)
    private String phonenumber;

    /** 使用者性別 */
    @Schema(description = "使用者性別")
    @Excel(name = "使用者性別", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 使用者頭像 */
    private String avatar;

    /** 密碼 */
    private String password;

    /** 賬號狀態（0正常 1停用） */
    @Schema(description = "賬號狀態")
    @Excel(name = "賬號狀態", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 刪除標誌（0代表存在 2代表刪除） */
    private String delFlag;

    /** 最後登入IP */
    @Schema(description = "最後登入IP")
    @Excel(name = "最後登入IP", type = Type.EXPORT)
    private String loginIp;

    /** 最後登入時間 */
    @Schema(description = "最後登入時間")
    @Excel(name = "最後登入時間", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /** 密碼最後更新時間 */
    private Date pwdUpdateDate;

    /** 部門物件 */
    @Schema(description = "部門物件，包含部門名稱與負責人")
    @Excels({
            @Excel(name = "部門名稱", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部門負責人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /** 角色物件 */
    private List<SysRole> roles;

    /** 角色組 */
    private Long[] roleIds;

    /** 崗位組 */
    private Long[] postIds;

    /** 角色ID */
    private Long roleId;

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    @Xss(message = "使用者暱稱不能包含指令碼字元")
    @Size(min = 0, max = 30, message = "使用者暱稱長度不能超過30個字元")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Xss(message = "使用者賬號不能包含指令碼字元")
    @NotBlank(message = "使用者賬號不能為空")
    @Size(min = 0, max = 30, message = "使用者賬號長度不能超過30個字元")
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Email(message = "郵箱格式不正確")
    @Size(min = 0, max = 50, message = "郵箱長度不能超過50個字元")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手機號碼長度不能超過11個字元")
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public Date getPwdUpdateDate()
    {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Date pwdUpdateDate)
    {
        this.pwdUpdateDate = pwdUpdateDate;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("pwdUpdateDate", getPwdUpdateDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}
