package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 讀取專案相關配置
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "ruoyi")
public class RuoYiConfig
{
    /** 專案名稱 */
    private String name;

    /** 版本 */
    private String version;

    /** 版權年份 */
    private String copyrightYear;

    /** 上傳路徑 */
    private static String profile;

    /** 獲取地址開關 */
    private static boolean addressEnabled;

    /** 驗證碼型別 */
    private static String captchaType;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        RuoYiConfig.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        RuoYiConfig.addressEnabled = addressEnabled;
    }

    public static String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        RuoYiConfig.captchaType = captchaType;
    }

    /**
     * 獲取匯入上傳路徑
     */
    public static String getImportPath()
    {
        return getProfile() + "/import";
    }

    /**
     * 獲取頭像上傳路徑
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }

    /**
     * 獲取下載路徑
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 獲取上傳路徑
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}
