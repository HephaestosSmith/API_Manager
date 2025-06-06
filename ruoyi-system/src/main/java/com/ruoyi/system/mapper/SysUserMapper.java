package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 使用者表 資料層
 * 
 * @author ruoyi
 */
public interface SysUserMapper
{
    /**
     * 根據條件分頁查詢使用者列表
     * 
     * @param sysUser 使用者資訊
     * @return 使用者資訊集合資訊
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 根據條件分頁查詢已配使用者角色列表
     * 
     * @param user 使用者資訊
     * @return 使用者資訊集合資訊
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根據條件分頁查詢未分配使用者角色列表
     * 
     * @param user 使用者資訊
     * @return 使用者資訊集合資訊
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 透過使用者名稱查詢使用者
     * 
     * @param userName 使用者名稱
     * @return 使用者物件資訊
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 透過使用者ID查詢使用者
     * 
     * @param userId 使用者ID
     * @return 使用者物件資訊
     */
    public SysUser selectUserById(Long userId);

    /**
     * 新增使用者資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int insertUser(SysUser user);

    /**
     * 修改使用者資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int updateUser(SysUser user);

    /**
     * 修改使用者頭像
     * 
     * @param userName 使用者名稱
     * @param avatar 頭像地址
     * @return 結果
     */
    public int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * 重置使用者密碼
     * 
     * @param userName 使用者名稱
     * @param password 密碼
     * @return 結果
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * 透過使用者ID刪除使用者
     * 
     * @param userId 使用者ID
     * @return 結果
     */
    public int deleteUserById(Long userId);

    /**
     * 批次刪除使用者資訊
     * 
     * @param userIds 需要刪除的使用者ID
     * @return 結果
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * 校驗使用者名稱稱是否唯一
     * 
     * @param userName 使用者名稱稱
     * @return 結果
     */
    public SysUser checkUserNameUnique(String userName);

    /**
     * 校驗手機號碼是否唯一
     *
     * @param phonenumber 手機號碼
     * @return 結果
     */
    public SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校驗email是否唯一
     *
     * @param email 使用者郵箱
     * @return 結果
     */
    public SysUser checkEmailUnique(String email);
}
