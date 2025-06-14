package com.ruoyi.framework.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * druid 配置屬性
 * 
 * @author ruoyi
 */
@Configuration
public class DruidProperties
{
    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.druid.connectTimeout}")
    private int connectTimeout;

    @Value("${spring.datasource.druid.socketTimeout}")
    private int socketTimeout;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private int maxEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;

    public DruidDataSource dataSource(DruidDataSource datasource)
    {
        /** 配置初始化大小、最小、最大 */
        datasource.setInitialSize(initialSize);
        datasource.setMaxActive(maxActive);
        datasource.setMinIdle(minIdle);

        /** 配置獲取連線等待超時的時間 */
        datasource.setMaxWait(maxWait);
        
        /** 配置驅動連線超時時間，檢測資料庫建立連線的超時時間，單位是毫秒 */
        datasource.setConnectTimeout(connectTimeout);
        
        /** 配置網路超時時間，等待資料庫操作完成的網路超時時間，單位是毫秒 */
        datasource.setSocketTimeout(socketTimeout);

        /** 配置間隔多久才進行一次檢測，檢測需要關閉的空閒連線，單位是毫秒 */
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        /** 配置一個連線在池中最小、最大生存的時間，單位是毫秒 */
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);

        /**
         * 用來檢測連線是否有效的sql，要求是一個查詢語句，常用select 'x'。如果validationQuery為null，testOnBorrow、testOnReturn、testWhileIdle都不會起作用。
         */
        datasource.setValidationQuery(validationQuery);
        /** 建議配置為true，不影響效能，並且保證安全性。申請連線的時候檢測，如果空閒時間大於timeBetweenEvictionRunsMillis，執行validationQuery檢測連線是否有效。 */
        datasource.setTestWhileIdle(testWhileIdle);
        /** 申請連線時執行validationQuery檢測連線是否有效，做了這個配置會降低效能。 */
        datasource.setTestOnBorrow(testOnBorrow);
        /** 歸還連線時執行validationQuery檢測連線是否有效，做了這個配置會降低效能。 */
        datasource.setTestOnReturn(testOnReturn);
        return datasource;
    }
}
