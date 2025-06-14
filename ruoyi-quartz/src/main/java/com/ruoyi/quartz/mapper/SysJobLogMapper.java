package com.ruoyi.quartz.mapper;

import java.util.List;
import com.ruoyi.quartz.domain.SysJobLog;

/**
 * 排程任務日誌資訊 資料層
 * 
 * @author ruoyi
 */
public interface SysJobLogMapper
{
    /**
     * 獲取quartz排程器日誌的計劃任務
     * 
     * @param jobLog 排程日誌資訊
     * @return 排程任務日誌集合
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);

    /**
     * 查詢所有排程任務日誌
     *
     * @return 排程任務日誌列表
     */
    public List<SysJobLog> selectJobLogAll();

    /**
     * 透過排程任務日誌ID查詢排程資訊
     * 
     * @param jobLogId 排程任務日誌ID
     * @return 排程任務日誌物件資訊
     */
    public SysJobLog selectJobLogById(Long jobLogId);

    /**
     * 新增任務日誌
     * 
     * @param jobLog 排程日誌資訊
     * @return 結果
     */
    public int insertJobLog(SysJobLog jobLog);

    /**
     * 批次刪除排程日誌資訊
     * 
     * @param logIds 需要刪除的資料ID
     * @return 結果
     */
    public int deleteJobLogByIds(Long[] logIds);

    /**
     * 刪除任務日誌
     * 
     * @param jobId 排程日誌ID
     * @return 結果
     */
    public int deleteJobLogById(Long jobId);

    /**
     * 清空任務日誌
     */
    public void cleanJobLog();
}
