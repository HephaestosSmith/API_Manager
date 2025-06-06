package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * 崗位資訊 服務層
 * 
 * @author ruoyi
 */
public interface ISysPostService
{
    /**
     * 查詢崗位資訊集合
     * 
     * @param post 崗位資訊
     * @return 崗位列表
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * 查詢所有崗位
     * 
     * @return 崗位列表
     */
    public List<SysPost> selectPostAll();

    /**
     * 透過崗位ID查詢崗位資訊
     * 
     * @param postId 崗位ID
     * @return 角色物件資訊
     */
    public SysPost selectPostById(Long postId);

    /**
     * 根據使用者ID獲取崗位選擇框列表
     * 
     * @param userId 使用者ID
     * @return 選中崗位ID列表
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * 校驗崗位名稱
     * 
     * @param post 崗位資訊
     * @return 結果
     */
    public boolean checkPostNameUnique(SysPost post);

    /**
     * 校驗崗位編碼
     * 
     * @param post 崗位資訊
     * @return 結果
     */
    public boolean checkPostCodeUnique(SysPost post);

    /**
     * 透過崗位ID查詢崗位使用數量
     * 
     * @param postId 崗位ID
     * @return 結果
     */
    public int countUserPostById(Long postId);

    /**
     * 刪除崗位資訊
     * 
     * @param postId 崗位ID
     * @return 結果
     */
    public int deletePostById(Long postId);

    /**
     * 批次刪除崗位資訊
     * 
     * @param postIds 需要刪除的崗位ID
     * @return 結果
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * 新增儲存崗位資訊
     * 
     * @param post 崗位資訊
     * @return 結果
     */
    public int insertPost(SysPost post);

    /**
     * 修改儲存崗位資訊
     * 
     * @param post 崗位資訊
     * @return 結果
     */
    public int updatePost(SysPost post);
}
