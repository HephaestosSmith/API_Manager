package com.ruoyi.generator.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.generator.domain.GenTable;

/**
 * 業務 服務層
 * 
 * @author ruoyi
 */
public interface IGenTableService
{
    /**
     * 查詢業務列表
     * 
     * @param genTable 業務資訊
     * @return 業務集合
     */
    public List<GenTable> selectGenTableList(GenTable genTable);

    /**
     * 查詢據庫列表
     * 
     * @param genTable 業務資訊
     * @return 資料庫表集合
     */
    public List<GenTable> selectDbTableList(GenTable genTable);

    /**
     * 查詢據庫列表
     * 
     * @param tableNames 表名稱組
     * @return 資料庫表集合
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查詢所有表資訊
     * 
     * @return 表資訊集合
     */
    public List<GenTable> selectGenTableAll();

    /**
     * 查詢業務資訊
     * 
     * @param id 業務ID
     * @return 業務資訊
     */
    public GenTable selectGenTableById(Long id);

    /**
     * 修改業務
     * 
     * @param genTable 業務資訊
     * @return 結果
     */
    public void updateGenTable(GenTable genTable);

    /**
     * 刪除業務資訊
     * 
     * @param tableIds 需要刪除的表資料ID
     * @return 結果
     */
    public void deleteGenTableByIds(Long[] tableIds);

    /**
     * 建立表
     *
     * @param sql 建立表語句
     * @return 結果
     */
    public boolean createTable(String sql);

    /**
     * 匯入表結構
     *
     * @param tableList 匯入表列表
     * @param operName 操作人員
     */
    public void importGenTable(List<GenTable> tableList, String operName);

    /**
     * 預覽程式碼
     * 
     * @param tableId 表編號
     * @return 預覽資料列表
     */
    public Map<String, String> previewCode(Long tableId);

    /**
     * 生成程式碼（下載方式）
     * 
     * @param tableName 表名稱
     * @return 資料
     */
    public byte[] downloadCode(String tableName);

    /**
     * 生成程式碼（自定義路徑）
     * 
     * @param tableName 表名稱
     * @return 資料
     */
    public void generatorCode(String tableName);

    /**
     * 同步資料庫
     * 
     * @param tableName 表名稱
     */
    public void synchDb(String tableName);

    /**
     * 批次生成程式碼（下載方式）
     * 
     * @param tableNames 表陣列
     * @return 資料
     */
    public byte[] downloadCode(String[] tableNames);

    /**
     * 修改儲存引數校驗
     * 
     * @param genTable 業務資訊
     */
    public void validateEdit(GenTable genTable);
}
