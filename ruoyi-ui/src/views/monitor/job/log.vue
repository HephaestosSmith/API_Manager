<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任務名稱" prop="jobName">
        <el-input
          v-model="queryParams.jobName"
          placeholder="請輸入任務名稱"
          clearable
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任務組名" prop="jobGroup">
        <el-select
          v-model="queryParams.jobGroup"
          placeholder="請選擇任務組名"
          clearable
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.sys_job_group"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="執行狀態" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="請選擇執行狀態"
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
      <el-form-item label="執行時間">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="開始日期"
          end-placeholder="結束日期"
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
          v-hasPermi="['monitor:job:remove']"
        >刪除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          @click="handleClean"
          v-hasPermi="['monitor:job:remove']"
        >清空</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['monitor:job:export']"
        >匯出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-close"
          size="mini"
          @click="handleClose"
        >關閉</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="jobLogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日誌編號" width="80" align="center" prop="jobLogId" />
      <el-table-column label="任務名稱" align="center" prop="jobName" :show-overflow-tooltip="true" />
      <el-table-column label="任務組名" align="center" prop="jobGroup" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_group" :value="scope.row.jobGroup"/>
        </template>
      </el-table-column>
      <el-table-column label="呼叫目標字串" align="center" prop="invokeTarget" :show-overflow-tooltip="true" />
      <el-table-column label="日誌資訊" align="center" prop="jobMessage" :show-overflow-tooltip="true" />
      <el-table-column label="執行狀態" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="執行時間" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['monitor:job:query']"
          >詳細</el-button>
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

    <!-- 排程日誌詳細 -->
    <el-dialog title="排程日誌詳細" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px" size="mini">
        <el-row>
          <el-col :span="12">
            <el-form-item label="日誌序號：">{{ form.jobLogId }}</el-form-item>
            <el-form-item label="任務名稱：">{{ form.jobName }}</el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="任務分組：">{{ form.jobGroup }}</el-form-item>
            <el-form-item label="執行時間：">{{ form.createTime }}</el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="呼叫方法：">{{ form.invokeTarget }}</el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="日誌資訊：">{{ form.jobMessage }}</el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="執行狀態：">
              <div v-if="form.status == 0">正常</div>
              <div v-else-if="form.status == 1">失敗</div>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="異常資訊：" v-if="form.status == 1">{{ form.exceptionInfo }}</el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="open = false">關 閉</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getJob} from "@/api/monitor/job"
import { listJobLog, delJobLog, cleanJobLog } from "@/api/monitor/jobLog"

export default {
  name: "JobLog",
  dicts: ['sys_common_status', 'sys_job_group'],
  data() {
    return {
      // 遮罩層
      loading: true,
      // 選中陣列
      ids: [],
      // 非多個禁用
      multiple: true,
      // 顯示搜尋條件
      showSearch: true,
      // 總條數
      total: 0,
      // 排程日誌表格資料
      jobLogList: [],
      // 是否顯示彈出層
      open: false,
      // 日期範圍
      dateRange: [],
      // 表單引數
      form: {},
      // 查詢引數
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        jobName: undefined,
        jobGroup: undefined,
        status: undefined
      }
    }
  },
  created() {
    const jobId = this.$route.params && this.$route.params.jobId
    if (jobId !== undefined && jobId != 0) {
      getJob(jobId).then(response => {
        this.queryParams.jobName = response.data.jobName
        this.queryParams.jobGroup = response.data.jobGroup
        this.getList()
      })
    } else {
      this.getList()
    }
  },
  methods: {
    /** 查詢排程日誌列表 */
    getList() {
      this.loading = true
      listJobLog(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
          this.jobLogList = response.rows
          this.total = response.total
          this.loading = false
        }
      )
    },
    // 返回按鈕
    handleClose() {
      const obj = { path: "/monitor/job" }
      this.$tab.closeOpenPage(obj)
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
      this.handleQuery()
    },
    // 多選框選中資料
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.jobLogId)
      this.multiple = !selection.length
    },
    /** 詳細按鈕操作 */
    handleView(row) {
      this.open = true
      this.form = row
    },
    /** 刪除按鈕操作 */
    handleDelete(row) {
      const jobLogIds = this.ids
      this.$modal.confirm('是否確認刪除排程日誌編號為"' + jobLogIds + '"的資料項？').then(function() {
        return delJobLog(jobLogIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("刪除成功")
      }).catch(() => {})
    },
    /** 清空按鈕操作 */
    handleClean() {
      this.$modal.confirm('是否確認清空所有排程日誌資料項？').then(function() {
        return cleanJobLog()
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("清空成功")
      }).catch(() => {})
    },
    /** 匯出按鈕操作 */
    handleExport() {
      this.download('/monitor/jobLog/export', {
        ...this.queryParams
      }, `log_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
