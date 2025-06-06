package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 使用者 業務層
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根據條件分頁查詢使用者列表
     * 
     * @param user 使用者資訊
     * @return 使用者資訊集合資訊
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 根據條件分頁查詢已分配使用者角色列表
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
     * 根據使用者ID查詢使用者所屬角色組
     * 
     * @param userName 使用者名稱
     * @return 結果
     */
    public String selectUserRoleGroup(String userName);

    /**
     * 根據使用者ID查詢使用者所屬崗位組
     * 
     * @param userName 使用者名稱
     * @return 結果
     */
    public String selectUserPostGroup(String userName);

    /**
     * 校驗使用者名稱稱是否唯一
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public boolean checkUserNameUnique(SysUser user);

    /**
     * 校驗手機號碼是否唯一
     *
     * @param user 使用者資訊
     * @return 結果
     */
    public boolean checkPhoneUnique(SysUser user);

    /**
     * 校驗email是否唯一
     *
     * @param user 使用者資訊
     * @return 結果
     */
    public boolean checkEmailUnique(SysUser user);

    /**
     * 校驗使用者是否允許操作
     * 
     * @param user 使用者資訊
     */
    public void checkUserAllowed(SysUser user);

    /**
     * 校驗使用者是否有資料許可權
     * 
     * @param userId 使用者id
     */
    public void checkUserDataScope(Long userId);

    /**
     * 新增使用者資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int insertUser(SysUser user);

    /**
     * 註冊使用者資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public boolean registerUser(SysUser user);

    /**
     * 修改使用者資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int updateUser(SysUser user);

    /**
     * 使用者授權角色
     * 
     * @param userId 使用者ID
     * @param roleIds 角色組
     */
    public void insertUserAuth(Long userId, Long[] roleIds);

    /**
     * 修改使用者狀態
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int updateUserStatus(SysUser user);

    /**
     * 修改使用者基本資訊
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int updateUserProfile(SysUser user);

    /**
     * 修改使用者頭像
     * 
     * @param userName 使用者名稱
     * @param avatar 頭像地址
     * @return 結果
     */
    public boolean updateUserAvatar(String userName, String avatar);

    /**
     * 重置使用者密碼
     * 
     * @param user 使用者資訊
     * @return 結果
     */
    public int resetPwd(SysUser user);

    /**
     * 重置使用者密碼
     * 
     * @param userName 使用者名稱
     * @param password 密碼
     * @return 結果
     */
    public int resetUserPwd(String userName, String password);

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
     * 匯入使用者資料
     * 
     * @param userList 使用者資料列表
     * @param isUpdateSupport 是否更新支援，如果已存在，則進行更新資料
     * @param operName 操作使用者
     * @return 結果
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);
}
