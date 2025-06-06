package com.ruoyi.quartz.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.service.ISysJobService;
import com.ruoyi.quartz.util.CronUtils;
import com.ruoyi.quartz.util.ScheduleUtils;

/**
 * 排程任務資訊操作處理
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/job")
public class SysJobController extends BaseController
{
    @Autowired
    private ISysJobService jobService;

    /**
     * 查詢定時任務列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysJob sysJob)
    {
        startPage();
        List<SysJob> list = jobService.selectJobList(sysJob);
        return getDataTable(list);
    }

    /**
     * 匯出定時任務列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:export')")
    @Log(title = "定時任務", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysJob sysJob)
    {
        List<SysJob> list = jobService.selectJobList(sysJob);
        ExcelUtil<SysJob> util = new ExcelUtil<SysJob>(SysJob.class);
        util.exportExcel(response, list, "定時任務");
    }

    /**
     * 獲取定時任務詳細資訊
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:query')")
    @GetMapping(value = "/{jobId}")
    public AjaxResult getInfo(@PathVariable("jobId") Long jobId)
    {
        return success(jobService.selectJobById(jobId));
    }

    /**
     * 新增定時任務
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:add')")
    @Log(title = "定時任務", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysJob job) throws SchedulerException, TaskException
    {
        if (!CronUtils.isValid(job.getCronExpression()))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，Cron表示式不正確");
        }
        else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，目標字串不允許'rmi'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[] { Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS }))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，目標字串不允許'ldap(s)'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[] { Constants.HTTP, Constants.HTTPS }))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，目標字串不允許'http(s)'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), Constants.JOB_ERROR_STR))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，目標字串存在違規");
        }
        else if (!ScheduleUtils.whiteList(job.getInvokeTarget()))
        {
            return error("新增任務'" + job.getJobName() + "'失敗，目標字串不在白名單內");
        }
        job.setCreateBy(getUsername());
        return toAjax(jobService.insertJob(job));
    }

    /**
     * 修改定時任務
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:edit')")
    @Log(title = "定時任務", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysJob job) throws SchedulerException, TaskException
    {
        if (!CronUtils.isValid(job.getCronExpression()))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，Cron表示式不正確");
        }
        else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，目標字串不允許'rmi'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[] { Constants.LOOKUP_LDAP, Constants.LOOKUP_LDAPS }))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，目標字串不允許'ldap(s)'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), new String[] { Constants.HTTP, Constants.HTTPS }))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，目標字串不允許'http(s)'呼叫");
        }
        else if (StringUtils.containsAnyIgnoreCase(job.getInvokeTarget(), Constants.JOB_ERROR_STR))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，目標字串存在違規");
        }
        else if (!ScheduleUtils.whiteList(job.getInvokeTarget()))
        {
            return error("修改任務'" + job.getJobName() + "'失敗，目標字串不在白名單內");
        }
        job.setUpdateBy(getUsername());
        return toAjax(jobService.updateJob(job));
    }

    /**
     * 定時任務狀態修改
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:changeStatus')")
    @Log(title = "定時任務", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysJob job) throws SchedulerException
    {
        SysJob newJob = jobService.selectJobById(job.getJobId());
        newJob.setStatus(job.getStatus());
        return toAjax(jobService.changeStatus(newJob));
    }

    /**
     * 定時任務立即執行一次
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:changeStatus')")
    @Log(title = "定時任務", businessType = BusinessType.UPDATE)
    @PutMapping("/run")
    public AjaxResult run(@RequestBody SysJob job) throws SchedulerException
    {
        boolean result = jobService.run(job);
        return result ? success() : error("任務不存在或已過期！");
    }

    /**
     * 刪除定時任務
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:remove')")
    @Log(title = "定時任務", businessType = BusinessType.DELETE)
    @DeleteMapping("/{jobIds}")
    public AjaxResult remove(@PathVariable Long[] jobIds) throws SchedulerException
    {
        jobService.deleteJobByIds(jobIds);
        return success();
    }
}
