<template>
  <!-- 授權使用者 -->
  <el-dialog title="選擇使用者" :visible.sync="visible" width="800px" top="5vh" append-to-body>
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true">
      <el-form-item label="使用者名稱稱" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="請輸入使用者名稱稱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手機號碼" prop="phonenumber">
        <el-input
          v-model="queryParams.phonenumber"
          placeholder="請輸入手機號碼"
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
      <el-table @row-click="clickRow" ref="table" :data="userList" @selection-change="handleSelectionChange" height="260px">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="使用者名稱稱" prop="userName" :show-overflow-tooltip="true" />
        <el-table-column label="使用者暱稱" prop="nickName" :show-overflow-tooltip="true" />
        <el-table-column label="郵箱" prop="email" :show-overflow-tooltip="true" />
        <el-table-column label="手機" prop="phonenumber" :show-overflow-tooltip="true" />
        <el-table-column label="狀態" align="center" prop="status">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
          </template>
        </el-table-column>
        <el-table-column label="建立時間" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
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
    </el-row>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="handleSelectUser">確 定</el-button>
      <el-button @click="visible = false">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { unallocatedUserList, authUserSelectAll } from "@/api/system/role"
export default {
  dicts: ['sys_normal_disable'],
  props: {
    // 角色編號
    roleId: {
      type: [Number, String]
    }
  },
  data() {
    return {
      // 遮罩層
      visible: false,
      // 選中陣列值
      userIds: [],
      // 總條數
      total: 0,
      // 未授權使用者資料
      userList: [],
      // 查詢引數
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        roleId: undefined,
        userName: undefined,
        phonenumber: undefined
      }
    }
  },
  methods: {
    // 顯示彈框
    show() {
      this.queryParams.roleId = this.roleId
      this.getList()
      this.visible = true
    },
    clickRow(row) {
      this.$refs.table.toggleRowSelection(row)
    },
    // 多選框選中資料
    handleSelectionChange(selection) {
      this.userIds = selection.map(item => item.userId)
    },
    // 查詢表資料
    getList() {
      unallocatedUserList(this.queryParams).then(res => {
        this.userList = res.rows
        this.total = res.total
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
    /** 選擇授權使用者操作 */
    handleSelectUser() {
      const roleId = this.queryParams.roleId
      const userIds = this.userIds.join(",")
      if (userIds == "") {
        this.$modal.msgError("請選擇要分配的使用者")
        return
      }
      authUserSelectAll({ roleId: roleId, userIds: userIds }).then(res => {
        this.$modal.msgSuccess(res.msg)
        this.visible = false
        this.$emit("ok")
      }) 
    }
  }
}
</script>
