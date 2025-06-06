package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISysDictDataService;

/**
 * 字典 業務層處理
 * 
 * @author ruoyi
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService
{
    @Autowired
    private SysDictDataMapper dictDataMapper;

    /**
     * 根據條件分頁查詢字典資料
     * 
     * @param dictData 字典資料資訊
     * @return 字典資料集合資訊
     */
    @Override
    public List<SysDictData> selectDictDataList(SysDictData dictData)
    {
        return dictDataMapper.selectDictDataList(dictData);
    }

    /**
     * 根據字典型別和字典鍵值查詢字典資料資訊
     * 
     * @param dictType 字典型別
     * @param dictValue 字典鍵值
     * @return 字典標籤
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue)
    {
        return dictDataMapper.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根據字典資料ID查詢資訊
     * 
     * @param dictCode 字典資料ID
     * @return 字典資料
     */
    @Override
    public SysDictData selectDictDataById(Long dictCode)
    {
        return dictDataMapper.selectDictDataById(dictCode);
    }

    /**
     * 批次刪除字典資料資訊
     * 
     * @param dictCodes 需要刪除的字典資料ID
     */
    @Override
    public void deleteDictDataByIds(Long[] dictCodes)
    {
        for (Long dictCode : dictCodes)
        {
            SysDictData data = selectDictDataById(dictCode);
            dictDataMapper.deleteDictDataById(dictCode);
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
    }

    /**
     * 新增儲存字典資料資訊
     * 
     * @param data 字典資料資訊
     * @return 結果
     */
    @Override
    public int insertDictData(SysDictData data)
    {
        int row = dictDataMapper.insertDictData(data);
        if (row > 0)
        {
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }

    /**
     * 修改儲存字典資料資訊
     * 
     * @param data 字典資料資訊
     * @return 結果
     */
    @Override
    public int updateDictData(SysDictData data)
    {
        int row = dictDataMapper.updateDictData(data);
        if (row > 0)
        {
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(data.getDictType());
            DictUtils.setDictCache(data.getDictType(), dictDatas);
        }
        return row;
    }
}
