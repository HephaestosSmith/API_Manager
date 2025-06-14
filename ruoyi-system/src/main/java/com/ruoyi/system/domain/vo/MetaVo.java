package com.ruoyi.system.domain.vo;

import com.ruoyi.common.utils.StringUtils;

/**
 * 路由顯示資訊
 * 
 * @author ruoyi
 */
public class MetaVo
{
    /**
     * 設定該路由在側邊欄和麵包屑中展示的名字
     */
    private String title;

    /**
     * 設定該路由的圖示，對應路徑src/assets/icons/svg
     */
    private String icon;

    /**
     * 設定為true，則不會被 <keep-alive>快取
     */
    private boolean noCache;

    /**
     * 內鏈地址（http(s)://開頭）
     */
    private String link;

    public MetaVo()
    {
    }

    public MetaVo(String title, String icon)
    {
        this.title = title;
        this.icon = icon;
    }

    public MetaVo(String title, String icon, boolean noCache)
    {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
    }

    public MetaVo(String title, String icon, String link)
    {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }

    public MetaVo(String title, String icon, boolean noCache, String link)
    {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
        if (StringUtils.ishttp(link))
        {
            this.link = link;
        }
    }

    public boolean isNoCache()
    {
        return noCache;
    }

    public void setNoCache(boolean noCache)
    {
        this.noCache = noCache;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }
}
