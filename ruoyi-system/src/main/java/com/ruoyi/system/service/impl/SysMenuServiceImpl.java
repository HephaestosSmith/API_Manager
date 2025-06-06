package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.vo.MetaVo;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.mapper.SysMenuMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysRoleMenuMapper;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 選單 業務層處理
 * 
 * @author ruoyi
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService
{
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    /**
     * 根據使用者查詢系統選單列表
     * 
     * @param userId 使用者ID
     * @return 選單列表
     */
    @Override
    public List<SysMenu> selectMenuList(Long userId)
    {
        return selectMenuList(new SysMenu(), userId);
    }

    /**
     * 查詢系統選單列表
     * 
     * @param menu 選單資訊
     * @return 選單列表
     */
    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId)
    {
        List<SysMenu> menuList = null;
        // 管理員顯示所有選單資訊
        if (SysUser.isAdmin(userId))
        {
            menuList = menuMapper.selectMenuList(menu);
        }
        else
        {
            menu.getParams().put("userId", userId);
            menuList = menuMapper.selectMenuListByUserId(menu);
        }
        return menuList;
    }

    /**
     * 根據使用者ID查詢許可權
     * 
     * @param userId 使用者ID
     * @return 許可權列表
     */
    @Override
    public Set<String> selectMenuPermsByUserId(Long userId)
    {
        List<String> perms = menuMapper.selectMenuPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (StringUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根據角色ID查詢許可權
     * 
     * @param roleId 角色ID
     * @return 許可權列表
     */
    @Override
    public Set<String> selectMenuPermsByRoleId(Long roleId)
    {
        List<String> perms = menuMapper.selectMenuPermsByRoleId(roleId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms)
        {
            if (StringUtils.isNotEmpty(perm))
            {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根據使用者ID查詢選單
     * 
     * @param userId 使用者名稱稱
     * @return 選單列表
     */
    @Override
    public List<SysMenu> selectMenuTreeByUserId(Long userId)
    {
        List<SysMenu> menus = null;
        if (SecurityUtils.isAdmin(userId))
        {
            menus = menuMapper.selectMenuTreeAll();
        }
        else
        {
            menus = menuMapper.selectMenuTreeByUserId(userId);
        }
        return getChildPerms(menus, 0);
    }

    /**
     * 根據角色ID查詢選單樹資訊
     * 
     * @param roleId 角色ID
     * @return 選中選單列表
     */
    @Override
    public List<Long> selectMenuListByRoleId(Long roleId)
    {
        SysRole role = roleMapper.selectRoleById(roleId);
        return menuMapper.selectMenuListByRoleId(roleId, role.isMenuCheckStrictly());
    }

    /**
     * 構建前端路由所需要的選單
     * 
     * @param menus 選單列表
     * @return 路由列表
     */
    @Override
    public List<RouterVo> buildMenus(List<SysMenu> menus)
    {
        List<RouterVo> routers = new LinkedList<RouterVo>();
        for (SysMenu menu : menus)
        {
            RouterVo router = new RouterVo();
            router.setHidden("1".equals(menu.getVisible()));
            router.setName(getRouteName(menu));
            router.setPath(getRouterPath(menu));
            router.setComponent(getComponent(menu));
            router.setQuery(menu.getQuery());
            router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
            List<SysMenu> cMenus = menu.getChildren();
            if (StringUtils.isNotEmpty(cMenus) && UserConstants.TYPE_DIR.equals(menu.getMenuType()))
            {
                router.setAlwaysShow(true);
                router.setRedirect("noRedirect");
                router.setChildren(buildMenus(cMenus));
            }
            else if (isMenuFrame(menu))
            {
                router.setMeta(null);
                List<RouterVo> childrenList = new ArrayList<RouterVo>();
                RouterVo children = new RouterVo();
                children.setPath(menu.getPath());
                children.setComponent(menu.getComponent());
                children.setName(getRouteName(menu.getRouteName(), menu.getPath()));
                children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache()), menu.getPath()));
                children.setQuery(menu.getQuery());
                childrenList.add(children);
                router.setChildren(childrenList);
            }
            else if (menu.getParentId().intValue() == 0 && isInnerLink(menu))
            {
                router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon()));
                router.setPath("/");
                List<RouterVo> childrenList = new ArrayList<RouterVo>();
                RouterVo children = new RouterVo();
                String routerPath = innerLinkReplaceEach(menu.getPath());
                children.setPath(routerPath);
                children.setComponent(UserConstants.INNER_LINK);
                children.setName(getRouteName(menu.getRouteName(), routerPath));
                children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), menu.getPath()));
                childrenList.add(children);
                router.setChildren(childrenList);
            }
            routers.add(router);
        }
        return routers;
    }

    /**
     * 構建前端所需要樹結構
     * 
     * @param menus 選單列表
     * @return 樹結構列表
     */
    @Override
    public List<SysMenu> buildMenuTree(List<SysMenu> menus)
    {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        List<Long> tempList = menus.stream().map(SysMenu::getMenuId).collect(Collectors.toList());
        for (Iterator<SysMenu> iterator = menus.iterator(); iterator.hasNext();)
        {
            SysMenu menu = (SysMenu) iterator.next();
            // 如果是頂級節點, 遍歷該父節點的所有子節點
            if (!tempList.contains(menu.getParentId()))
            {
                recursionFn(menus, menu);
                returnList.add(menu);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = menus;
        }
        return returnList;
    }

    /**
     * 構建前端所需要下拉樹結構
     * 
     * @param menus 選單列表
     * @return 下拉樹結構列表
     */
    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus)
    {
        List<SysMenu> menuTrees = buildMenuTree(menus);
        return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 根據選單ID查詢資訊
     * 
     * @param menuId 選單ID
     * @return 選單資訊
     */
    @Override
    public SysMenu selectMenuById(Long menuId)
    {
        return menuMapper.selectMenuById(menuId);
    }

    /**
     * 是否存在選單子節點
     * 
     * @param menuId 選單ID
     * @return 結果
     */
    @Override
    public boolean hasChildByMenuId(Long menuId)
    {
        int result = menuMapper.hasChildByMenuId(menuId);
        return result > 0;
    }

    /**
     * 查詢選單使用數量
     * 
     * @param menuId 選單ID
     * @return 結果
     */
    @Override
    public boolean checkMenuExistRole(Long menuId)
    {
        int result = roleMenuMapper.checkMenuExistRole(menuId);
        return result > 0;
    }

    /**
     * 新增儲存選單資訊
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    @Override
    public int insertMenu(SysMenu menu)
    {
        return menuMapper.insertMenu(menu);
    }

    /**
     * 修改儲存選單資訊
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    @Override
    public int updateMenu(SysMenu menu)
    {
        return menuMapper.updateMenu(menu);
    }

    /**
     * 刪除選單管理資訊
     * 
     * @param menuId 選單ID
     * @return 結果
     */
    @Override
    public int deleteMenuById(Long menuId)
    {
        return menuMapper.deleteMenuById(menuId);
    }

    /**
     * 校驗選單名稱是否唯一
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    @Override
    public boolean checkMenuNameUnique(SysMenu menu)
    {
        Long menuId = StringUtils.isNull(menu.getMenuId()) ? -1L : menu.getMenuId();
        SysMenu info = menuMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());
        if (StringUtils.isNotNull(info) && info.getMenuId().longValue() != menuId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 獲取路由名稱
     * 
     * @param menu 選單資訊
     * @return 路由名稱
     */
    public String getRouteName(SysMenu menu)
    {
        // 非外鏈並且是一級目錄（型別為目錄）
        if (isMenuFrame(menu))
        {
            return StringUtils.EMPTY;
        }
        return getRouteName(menu.getRouteName(), menu.getPath());
    }

    /**
     * 獲取路由名稱，如沒有配置路由名稱則取路由地址
     * 
     * @param name 路由名稱
     * @param path 路由地址
     * @return 路由名稱（駝峰格式）
     */
    public String getRouteName(String name, String path)
    {
        String routerName = StringUtils.isNotEmpty(name) ? name : path;
        return StringUtils.capitalize(routerName);
    }

    /**
     * 獲取路由地址
     * 
     * @param menu 選單資訊
     * @return 路由地址
     */
    public String getRouterPath(SysMenu menu)
    {
        String routerPath = menu.getPath();
        // 內鏈開啟外網方式
        if (menu.getParentId().intValue() != 0 && isInnerLink(menu))
        {
            routerPath = innerLinkReplaceEach(routerPath);
        }
        // 非外鏈並且是一級目錄（型別為目錄）
        if (0 == menu.getParentId().intValue() && UserConstants.TYPE_DIR.equals(menu.getMenuType())
                && UserConstants.NO_FRAME.equals(menu.getIsFrame()))
        {
            routerPath = "/" + menu.getPath();
        }
        // 非外鏈並且是一級目錄（型別為選單）
        else if (isMenuFrame(menu))
        {
            routerPath = "/";
        }
        return routerPath;
    }

    /**
     * 獲取元件資訊
     * 
     * @param menu 選單資訊
     * @return 元件資訊
     */
    public String getComponent(SysMenu menu)
    {
        String component = UserConstants.LAYOUT;
        if (StringUtils.isNotEmpty(menu.getComponent()) && !isMenuFrame(menu))
        {
            component = menu.getComponent();
        }
        else if (StringUtils.isEmpty(menu.getComponent()) && menu.getParentId().intValue() != 0 && isInnerLink(menu))
        {
            component = UserConstants.INNER_LINK;
        }
        else if (StringUtils.isEmpty(menu.getComponent()) && isParentView(menu))
        {
            component = UserConstants.PARENT_VIEW;
        }
        return component;
    }

    /**
     * 是否為選單內部跳轉
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    public boolean isMenuFrame(SysMenu menu)
    {
        return menu.getParentId().intValue() == 0 && UserConstants.TYPE_MENU.equals(menu.getMenuType())
                && menu.getIsFrame().equals(UserConstants.NO_FRAME);
    }

    /**
     * 是否為內鏈元件
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    public boolean isInnerLink(SysMenu menu)
    {
        return menu.getIsFrame().equals(UserConstants.NO_FRAME) && StringUtils.ishttp(menu.getPath());
    }

    /**
     * 是否為parent_view元件
     * 
     * @param menu 選單資訊
     * @return 結果
     */
    public boolean isParentView(SysMenu menu)
    {
        return menu.getParentId().intValue() != 0 && UserConstants.TYPE_DIR.equals(menu.getMenuType());
    }

    /**
     * 根據父節點的ID獲取所有子節點
     * 
     * @param list 分類表
     * @param parentId 傳入的父節點ID
     * @return String
     */
    public List<SysMenu> getChildPerms(List<SysMenu> list, int parentId)
    {
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator(); iterator.hasNext();)
        {
            SysMenu t = (SysMenu) iterator.next();
            // 一、根據傳入的某個父節點ID,遍歷該父節點的所有子節點
            if (t.getParentId() == parentId)
            {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 遞迴列表
     * 
     * @param list 分類表
     * @param t 子節點
     */
    private void recursionFn(List<SysMenu> list, SysMenu t)
    {
        // 得到子節點列表
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子節點列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t)
    {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext())
        {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判斷是否有子節點
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t)
    {
        return getChildList(list, t).size() > 0;
    }

    /**
     * 內鏈域名特殊字元替換
     * 
     * @return 替換後的內鏈域名
     */
    public String innerLinkReplaceEach(String path)
    {
        return StringUtils.replaceEach(path, new String[] { Constants.HTTP, Constants.HTTPS, Constants.WWW, ".", ":" },
                new String[] { "", "", "", "/", "/" });
    }
}
