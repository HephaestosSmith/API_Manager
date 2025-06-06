<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="登入地址" prop="ipaddr">
        <el-input
          v-model="queryParams.ipaddr"
          placeholder="請輸入登入地址"
          clearable
          style="width: 240px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用者名稱稱" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="請輸入使用者名稱稱"
          clearable
          style="width: 240px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="狀態" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="登入狀態"
          clearable
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_common_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="登入時間">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="daterange"
          range-separator="-"
          start-placeholder="開始日期"
          end-placeholder="結束日期"
          :default-time="['00:00:00', '23:59:59']"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜尋</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['monitor:logininfor:remove']"
        >刪除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          @click="handleClean"
          v-hasPermi="['monitor:logininfor:remove']"
        >清空</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-unlock"
          size="mini"
          :disabled="single"
          @click="handleUnlock"
          v-hasPermi="['monitor:logininfor:unlock']"
        >解鎖</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['monitor:logininfor:export']"
        >匯出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table ref="tables" v-loading="loading" :data="list" @selection-change="handleSelectionChange" :default-sort="defaultSort" @sort-change="handleSortChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="訪問編號" align="center" prop="infoId" />
      <el-table-column label="使用者名稱稱" align="center" prop="userName" :show-overflow-tooltip="true" sortable="custom" :sort-orders="['descending', 'ascending']" />
      <el-table-column label="登入地址" align="center" prop="ipaddr" width="130" :show-overflow-tooltip="true" />
      <el-table-column label="登入地點" align="center" prop="loginLocation" :show-overflow-tooltip="true" />
      <el-table-column label="瀏覽器" align="center" prop="browser" :show-overflow-tooltip="true" />
      <el-table-column label="作業系統" align="center" prop="os" />
      <el-table-column label="登入狀態" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作資訊" align="center" prop="msg" :show-overflow-tooltip="true" />
      <el-table-column label="登入日期" align="center" prop="loginTime" sortable="custom" :sort-orders="['descending', 'ascending']" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.loginTime) }}</span>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import { list, delLogininfor, cleanLogininfor, unlockLogininfor } from "@/api/monitor/logininfor"

export default {
  name: "Logininfor",
  dicts: ['sys_common_status'],
  data() {
    return {
      // 遮罩層
      loading: true,
      // 選中陣列
      ids: [],
      // 非單個禁用
      single: true,
      // 非多個禁用
      multiple: true,
      // 選擇使用者名稱
      selectName: "",
      // 顯示搜尋條件
      showSearch: true,
      // 總條數
      total: 0,
      // 表格資料
      list: [],
      // 日期範圍
      dateRange: [],
      // 預設排序
      defaultSort: { prop: "loginTime", order: "descending" },
      // 查詢引數
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        ipaddr: undefined,
        userName: undefined,
        status: undefined
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查詢登入日誌列表 */
    getList() {
      this.loading = true
      list(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.list = response.rows
          this.total = response.total
          this.loading = false
        }
      )
    },
    /** 搜尋按鈕操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按鈕操作 */
    resetQuery() {
      this.dateRange = []
      this.resetForm("queryForm")
      this.queryParams.pageNum = 1
      this.$refs.tables.sort(this.defaultSort.prop, this.defaultSort.order)
    },
    /** 多選框選中資料 */
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.infoId)
      this.single = selection.length!=1
      this.multiple = !selection.length
      this.selectName = selection.map(item => item.userName)
    },
    /** 排序觸發事件 */
    handleSortChange(column, prop, order) {
      this.queryParams.orderByColumn = column.prop
      this.queryParams.isAsc = column.order
      this.getList()
    },
    /** 刪除按鈕操作 */
    handleDelete(row) {
      const infoIds = row.infoId || this.ids
      this.$modal.confirm('是否確認刪除訪問編號為"' + infoIds + '"的資料項？').then(function() {
        return delLogininfor(infoIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("刪除成功")
      }).catch(() => {})
    },
    /** 清空按鈕操作 */
    handleClean() {
      this.$modal.confirm('是否確認清空所有登入日誌資料項？').then(function() {
        return cleanLogininfor()
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("清空成功")
      }).catch(() => {})
    },
    /** 解鎖按鈕操作 */
    handleUnlock() {
      const username = this.selectName
      this.$modal.confirm('是否確認解鎖使用者"' + username + '"資料項?').then(function() {
        return unlockLogininfor(username)
      }).then(() => {
        this.$modal.msgSuccess("使用者" + username + "解鎖成功")
      }).catch(() => {})
    },
    /** 匯出按鈕操作 */
    handleExport() {
      this.download('monitor/logininfor/export', {
        ...this.queryParams
      }, `logininfor_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>

