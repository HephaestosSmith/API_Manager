package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * 字典 業務層
 * 
 * @author ruoyi
 */
public interface ISysDictTypeService
{
    /**
     * 根據條件分頁查詢字典型別
     * 
     * @param dictType 字典型別資訊
     * @return 字典型別集合資訊
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 根據所有字典型別
     * 
     * @return 字典型別集合資訊
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * 根據字典型別查詢字典資料
     * 
     * @param dictType 字典型別
     * @return 字典資料集合資訊
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根據字典型別ID查詢資訊
     * 
     * @param dictId 字典型別ID
     * @return 字典型別
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * 根據字典型別查詢資訊
     * 
     * @param dictType 字典型別
     * @return 字典型別
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * 批次刪除字典資訊
     * 
     * @param dictIds 需要刪除的字典ID
     */
    public void deleteDictTypeByIds(Long[] dictIds);

    /**
     * 載入字典快取資料
     */
    public void loadingDictCache();

    /**
     * 清空字典快取資料
     */
    public void clearDictCache();

    /**
     * 重置字典快取資料
     */
    public void resetDictCache();

    /**
     * 新增儲存字典型別資訊
     * 
     * @param dictType 字典型別資訊
     * @return 結果
     */
    public int insertDictType(SysDictType dictType);

    /**
     * 修改儲存字典型別資訊
     * 
     * @param dictType 字典型別資訊
     * @return 結果
     */
    public int updateDictType(SysDictType dictType);

    /**
     * 校驗字典型別稱是否唯一
     * 
     * @param dictType 字典型別
     * @return 結果
     */
    public boolean checkDictTypeUnique(SysDictType dictType);
}
