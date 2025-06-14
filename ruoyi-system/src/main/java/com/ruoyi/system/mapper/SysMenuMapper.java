package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysMenu;

/**
 * 選單表 資料層
 *
 * @author ruoyi
 */
public interface SysMenuMapper
{
    /**
     * 查詢系統選單列表
     *
     * @param menu 選單資訊
     * @return 選單列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 根據使用者所有許可權
     *
     * @return 許可權列表
     */
    public List<String> selectMenuPerms();

    /**
     * 根據使用者查詢系統選單列表
     *
     * @param menu 選單資訊
     * @return 選單列表
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * 根據角色ID查詢許可權
     * 
     * @param roleId 角色ID
     * @return 許可權列表
     */
    public List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * 根據使用者ID查詢許可權
     *
     * @param userId 使用者ID
     * @return 許可權列表
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根據使用者ID查詢選單
     *
     * @return 選單列表
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * 根據使用者ID查詢選單
     *
     * @param userId 使用者ID
     * @return 選單列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根據角色ID查詢選單樹資訊
     * 
     * @param roleId 角色ID
     * @param menuCheckStrictly 選單樹選擇項是否關聯顯示
     * @return 選中選單列表
     */
    public List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

    /**
     * 根據選單ID查詢資訊
     *
     * @param menuId 選單ID
     * @return 選單資訊
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * 是否存在選單子節點
     *
     * @param menuId 選單ID
     * @return 結果
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * 新增選單資訊
     *
     * @param menu 選單資訊
     * @return 結果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改選單資訊
     *
     * @param menu 選單資訊
     * @return 結果
     */
    public int updateMenu(SysMenu menu);

    /**
     * 刪除選單管理資訊
     *
     * @param menuId 選單ID
     * @return 結果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 校驗選單名稱是否唯一
     *
     * @param menuName 選單名稱
     * @param parentId 父選單ID
     * @return 結果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}
