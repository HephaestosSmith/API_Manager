package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 部門管理 服務層
 * 
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 查詢部門管理資料
     * 
     * @param dept 部門資訊
     * @return 部門資訊集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查詢部門樹結構資訊
     * 
     * @param dept 部門資訊
     * @return 部門樹資訊集合
     */
    public List<TreeSelect> selectDeptTreeList(SysDept dept);

    /**
     * 構建前端所需要樹結構
     * 
     * @param depts 部門列表
     * @return 樹結構列表
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * 構建前端所需要下拉樹結構
     * 
     * @param depts 部門列表
     * @return 下拉樹結構列表
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * 根據角色ID查詢部門樹資訊
     * 
     * @param roleId 角色ID
     * @return 選中部門列表
     */
    public List<Long> selectDeptListByRoleId(Long roleId);

    /**
     * 根據部門ID查詢資訊
     * 
     * @param deptId 部門ID
     * @return 部門資訊
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 根據ID查詢所有子部門（正常狀態）
     * 
     * @param deptId 部門ID
     * @return 子部門數
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在部門子節點
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * 查詢部門是否存在使用者
     * 
     * @param deptId 部門ID
     * @return 結果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 校驗部門名稱是否唯一
     * 
     * @param dept 部門資訊
     * @return 結果
     */
    public boolean checkDeptNameUnique(SysDept dept);

    /**
     * 校驗部門是否有資料許可權
     * 
     * @param deptId 部門id
     */
    public void checkDeptDataScope(Long deptId);

    /**
     * 新增儲存部門資訊
     * 
     * @param dept 部門資訊
     * @return 結果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改儲存部門資訊
     * 
     * @param dept 部門資訊
     * @return 結果
     */
    public int updateDept(SysDept dept);

    /**
     * 刪除部門管理資訊
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int deleteDeptById(Long deptId);
}
