package com.ruoyi.common.utils.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Excel資料格式處理介面卡
 * 
 * @author ruoyi
 */
public interface ExcelHandlerAdapter
{
    /**
     * 格式化
     * 
     * @param value 單元格資料值
     * @param args excel註解args引數組
     * @param cell 單元格物件
     * @param wb 工作簿物件
     *
     * @return 處理後的值
     */
    Object format(Object value, String[] args, Cell cell, Workbook wb);
}
