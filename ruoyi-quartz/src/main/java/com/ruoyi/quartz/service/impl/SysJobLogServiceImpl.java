package com.ruoyi.quartz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.quartz.domain.SysJobLog;
import com.ruoyi.quartz.mapper.SysJobLogMapper;
import com.ruoyi.quartz.service.ISysJobLogService;

/**
 * 定時任務排程日誌資訊 服務層
 * 
 * @author ruoyi
 */
@Service
public class SysJobLogServiceImpl implements ISysJobLogService
{
    @Autowired
    private SysJobLogMapper jobLogMapper;

    /**
     * 獲取quartz排程器日誌的計劃任務
     * 
     * @param jobLog 排程日誌資訊
     * @return 排程任務日誌集合
     */
    @Override
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog)
    {
        return jobLogMapper.selectJobLogList(jobLog);
    }

    /**
     * 透過排程任務日誌ID查詢排程資訊
     * 
     * @param jobLogId 排程任務日誌ID
     * @return 排程任務日誌物件資訊
     */
    @Override
    public SysJobLog selectJobLogById(Long jobLogId)
    {
        return jobLogMapper.selectJobLogById(jobLogId);
    }

    /**
     * 新增任務日誌
     * 
     * @param jobLog 排程日誌資訊
     */
    @Override
    public void addJobLog(SysJobLog jobLog)
    {
        jobLogMapper.insertJobLog(jobLog);
    }

    /**
     * 批次刪除排程日誌資訊
     * 
     * @param logIds 需要刪除的資料ID
     * @return 結果
     */
    @Override
    public int deleteJobLogByIds(Long[] logIds)
    {
        return jobLogMapper.deleteJobLogByIds(logIds);
    }

    /**
     * 刪除任務日誌
     * 
     * @param jobId 排程日誌ID
     */
    @Override
    public int deleteJobLogById(Long jobId)
    {
        return jobLogMapper.deleteJobLogById(jobId);
    }

    /**
     * 清空任務日誌
     */
    @Override
    public void cleanJobLog()
    {
        jobLogMapper.cleanJobLog();
    }
}
