package com.ruoyi.common.constant;

import java.util.Locale;
import io.jsonwebtoken.Claims;

/**
 * 通用常量資訊
 * 
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * 系統語言
     */
    public static final Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    /**
     * www主域
     */
    public static final String WWW = "www.";

    /**
     * http請求
     */
    public static final String HTTP = "http://";

    /**
     * https請求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功標識
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失敗標識
     */
    public static final String FAIL = "1";

    /**
     * 登入成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 登出
     */
    public static final String LOGOUT = "Logout";

    /**
     * 註冊
     */
    public static final String REGISTER = "Register";

    /**
     * 登入失敗
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 所有許可權標識
     */
    public static final String ALL_PERMISSION = "*:*:*";

    /**
     * 管理員角色許可權標識
     */
    public static final String SUPER_ADMIN = "admin";

    /**
     * 角色許可權分隔符
     */
    public static final String ROLE_DELIMETER = ",";

    /**
     * 許可權標識分隔符
     */
    public static final String PERMISSION_DELIMETER = ",";

    /**
     * 驗證碼有效期（分鐘）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌字首
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌字首
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 使用者ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 使用者名稱稱
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 使用者頭像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 建立時間
     */
    public static final String JWT_CREATED = "created";

    /**
     * 使用者許可權
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 資源對映路徑 字首
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 遠端方法呼叫
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 遠端方法呼叫
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 遠端方法呼叫
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * 自動識別json物件白名單配置（僅允許解析的包名，範圍越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.ruoyi" };

    /**
     * 定時任務白名單配置（僅允許訪問的包名，如其他需要可以自行新增）
     */
    public static final String[] JOB_WHITELIST_STR = { "com.ruoyi.quartz.task" };

    /**
     * 定時任務違規的字元
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.ruoyi.common.utils.file", "com.ruoyi.common.config", "com.ruoyi.generator" };
}
