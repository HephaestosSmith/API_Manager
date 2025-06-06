<template>
  <div class="app-container">
    <el-row :gutter="10">
      <el-col :span="8">
        <el-card style="height: calc(100vh - 125px)">
          <div slot="header">
            <span><i class="el-icon-collection"></i> 快取列表</span>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
              icon="el-icon-refresh-right"
              @click="refreshCacheNames()"
            ></el-button>
          </div>
          <el-table
            v-loading="loading"
            :data="cacheNames"
            :height="tableHeight"
            highlight-current-row
            @row-click="getCacheKeys"
            style="width: 100%"
          >
            <el-table-column
              label="序號"
              width="60"
              type="index"
            ></el-table-column>

            <el-table-column
              label="快取名稱"
              align="center"
              prop="cacheName"
              :show-overflow-tooltip="true"
              :formatter="nameFormatter"
            ></el-table-column>

            <el-table-column
              label="備註"
              align="center"
              prop="remark"
              :show-overflow-tooltip="true"
            />
            <el-table-column
              label="操作"
              width="60"
              align="center"
              class-name="small-padding fixed-width"
            >
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="handleClearCacheName(scope.row)"
                ></el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card style="height: calc(100vh - 125px)">
          <div slot="header">
            <span><i class="el-icon-key"></i> 鍵名列表</span>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
              icon="el-icon-refresh-right"
              @click="refreshCacheKeys()"
            ></el-button>
          </div>
          <el-table
            v-loading="subLoading"
            :data="cacheKeys"
            :height="tableHeight"
            highlight-current-row
            @row-click="handleCacheValue"
            style="width: 100%"
          >
            <el-table-column
              label="序號"
              width="60"
              type="index"
            ></el-table-column>
            <el-table-column
              label="快取鍵名"
              align="center"
              :show-overflow-tooltip="true"
              :formatter="keyFormatter"
            >
            </el-table-column>
            <el-table-column
              label="操作"
              width="60"
              align="center"
              class-name="small-padding fixed-width"
            >
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-delete"
                  @click="handleClearCacheKey(scope.row)"
                ></el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="8">
        <el-card :bordered="false" style="height: calc(100vh - 125px)">
          <div slot="header">
            <span><i class="el-icon-document"></i> 快取內容</span>
            <el-button
              style="float: right; padding: 3px 0"
              type="text"
              icon="el-icon-refresh-right"
              @click="handleClearCacheAll()"
              >清理全部</el-button
            >
          </div>
          <el-form :model="cacheForm">
            <el-row :gutter="32">
              <el-col :offset="1" :span="22">
                <el-form-item label="快取名稱:" prop="cacheName">
                  <el-input v-model="cacheForm.cacheName" :readOnly="true" />
                </el-form-item>
              </el-col>
              <el-col :offset="1" :span="22">
                <el-form-item label="快取鍵名:" prop="cacheKey">
                  <el-input v-model="cacheForm.cacheKey" :readOnly="true" />
                </el-form-item>
              </el-col>
              <el-col :offset="1" :span="22">
                <el-form-item label="快取內容:" prop="cacheValue">
                  <el-input
                    v-model="cacheForm.cacheValue"
                    type="textarea"
                    :rows="8"
                    :readOnly="true"
                  />
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { listCacheName, listCacheKey, getCacheValue, clearCacheName, clearCacheKey, clearCacheAll } from "@/api/monitor/cache"

export default {
  name: "CacheList",
  data() {
    return {
      cacheNames: [],
      cacheKeys: [],
      cacheForm: {},
      loading: true,
      subLoading: false,
      nowCacheName: "",
      tableHeight: window.innerHeight - 200
    }
  },
  created() {
    this.getCacheNames()
  },
  methods: {
    /** 查詢快取名稱列表 */
    getCacheNames() {
      this.loading = true
      listCacheName().then(response => {
        this.cacheNames = response.data
        this.loading = false
      })
    },
    /** 重新整理快取名稱列表 */
    refreshCacheNames() {
      this.getCacheNames()
      this.$modal.msgSuccess("重新整理快取列表成功")
    },
    /** 清理指定名稱快取 */
    handleClearCacheName(row) {
      clearCacheName(row.cacheName).then(response => {
        this.$modal.msgSuccess("清理快取名稱[" + row.cacheName + "]成功")
        this.getCacheKeys()
      })
    },
    /** 查詢快取鍵名列表 */
    getCacheKeys(row) {
      const cacheName = row !== undefined ? row.cacheName : this.nowCacheName
      if (cacheName === "") {
        return
      }
      this.subLoading = true
      listCacheKey(cacheName).then(response => {
        this.cacheKeys = response.data
        this.subLoading = false
        this.nowCacheName = cacheName
      })
    },
    /** 重新整理快取鍵名列表 */
    refreshCacheKeys() {
      this.getCacheKeys()
      this.$modal.msgSuccess("重新整理鍵名列表成功")
    },
    /** 清理指定鍵名快取 */
    handleClearCacheKey(cacheKey) {
      clearCacheKey(cacheKey).then(response => {
        this.$modal.msgSuccess("清理快取鍵名[" + cacheKey + "]成功")
        this.getCacheKeys()
      })
    },
    /** 列表字首去除 */
    nameFormatter(row) {
      return row.cacheName.replace(":", "")
    },
    /** 鍵名字首去除 */
    keyFormatter(cacheKey) {
      return cacheKey.replace(this.nowCacheName, "")
    },
    /** 查詢快取內容詳細 */
    handleCacheValue(cacheKey) {
      getCacheValue(this.nowCacheName, cacheKey).then(response => {
        this.cacheForm = response.data
      })
    },
    /** 清理全部快取 */
    handleClearCacheAll() {
      clearCacheAll().then(response => {
        this.$modal.msgSuccess("清理全部快取成功")
      })
    }
  }
}
</script>
