<template>
  <!-- 匯入表 -->
  <el-dialog title="匯入表" :visible.sync="visible" width="800px" top="5vh" append-to-body>
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true">
      <el-form-item label="表名稱" prop="tableName">
        <el-input
          v-model="queryParams.tableName"
          placeholder="請輸入表名稱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="表描述" prop="tableComment">
        <el-input
          v-model="queryParams.tableComment"
          placeholder="請輸入表描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜尋</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row>
      <el-table @row-click="clickRow" ref="table" :data="dbTableList" @selection-change="handleSelectionChange" height="260px">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="tableName" label="表名稱" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column prop="tableComment" label="表描述" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column prop="createTime" label="建立時間"></el-table-column>
        <el-table-column prop="updateTime" label="更新時間"></el-table-column>
      </el-table>
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
    </el-row>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="handleImportTable">確 定</el-button>
      <el-button @click="visible = false">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { listDbTable, importTable } from "@/api/tool/gen"
export default {
  data() {
    return {
      // 遮罩層
      visible: false,
      // 選中陣列值
      tables: [],
      // 總條數
      total: 0,
      // 表資料
      dbTableList: [],
      // 查詢引數
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tableName: undefined,
        tableComment: undefined
      }
    }
  },
  methods: {
    // 顯示彈框
    show() {
      this.getList()
      this.visible = true
    },
    clickRow(row) {
      this.$refs.table.toggleRowSelection(row)
    },
    // 多選框選中資料
    handleSelectionChange(selection) {
      this.tables = selection.map(item => item.tableName)
    },
    // 查詢表資料
    getList() {
      listDbTable(this.queryParams).then(res => {
        if (res.code === 200) {
          this.dbTableList = res.rows
          this.total = res.total
        }
      })
    },
    /** 搜尋按鈕操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按鈕操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    /** 匯入按鈕操作 */
    handleImportTable() {
      const tableNames = this.tables.join(",")
      if (tableNames == "") {
        this.$modal.msgError("請選擇要匯入的表")
        return
      }
      importTable({ tables: tableNames }).then(res => {
        this.$modal.msgSuccess(res.msg)
        if (res.code === 200) {
          this.visible = false
          this.$emit("ok")
        }
      })
    }
  }
}
</script>
