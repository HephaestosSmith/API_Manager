package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

/**
 * 公告 服務層
 * 
 * @author ruoyi
 */
public interface ISysNoticeService
{
    /**
     * 查詢公告資訊
     * 
     * @param noticeId 公告ID
     * @return 公告資訊
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查詢公告列表
     * 
     * @param notice 公告資訊
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增公告
     * 
     * @param notice 公告資訊
     * @return 結果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告資訊
     * @return 結果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 刪除公告資訊
     * 
     * @param noticeId 公告ID
     * @return 結果
     */
    public int deleteNoticeById(Long noticeId);
    
    /**
     * 批次刪除公告資訊
     * 
     * @param noticeIds 需要刪除的公告ID
     * @return 結果
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}
