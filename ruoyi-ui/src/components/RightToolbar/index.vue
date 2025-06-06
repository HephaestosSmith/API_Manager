<template>
  <div class="top-right-btn" :style="style">
    <el-row>
      <el-tooltip class="item" effect="dark" :content="showSearch ? '隱藏搜尋' : '顯示搜尋'" placement="top" v-if="search">
        <el-button size="mini" circle icon="el-icon-search" @click="toggleSearch()" />
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="重新整理" placement="top">
        <el-button size="mini" circle icon="el-icon-refresh" @click="refresh()" />
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="顯隱列" placement="top" v-if="columns">
        <el-button size="mini" circle icon="el-icon-menu" @click="showColumn()" v-if="showColumnsType == 'transfer'"/>
        <el-dropdown trigger="click" :hide-on-click="false" style="padding-left: 12px" v-if="showColumnsType == 'checkbox'">
          <el-button size="mini" circle icon="el-icon-menu" />
          <el-dropdown-menu slot="dropdown">
            <!-- 全選/反選 按鈕 -->
            <el-dropdown-item>
              <el-checkbox :indeterminate="isIndeterminate" v-model="isChecked" @change="toggleCheckAll"> 列展示 </el-checkbox>
            </el-dropdown-item>
            <div class="check-line"></div>
            <template v-for="item in columns">
              <el-dropdown-item :key="item.key">
                <el-checkbox v-model="item.visible" @change="checkboxChange($event, item.label)" :label="item.label" />
              </el-dropdown-item>
            </template>
          </el-dropdown-menu>
        </el-dropdown>
      </el-tooltip>
    </el-row>
    <el-dialog :title="title" :visible.sync="open" append-to-body>
      <el-transfer
        :titles="['顯示', '隱藏']"
        v-model="value"
        :data="columns"
        @change="dataChange"
      ></el-transfer>
    </el-dialog>
  </div>
</template>
<script>
export default {
  name: "RightToolbar",
  data() {
    return {
      // 顯隱資料
      value: [],
      // 彈出層標題
      title: "顯示/隱藏",
      // 是否顯示彈出層
      open: false
    }
  },
  props: {
    /* 是否顯示檢索條件 */
    showSearch: {
      type: Boolean,
      default: true
    },
    /* 顯隱列資訊 */
    columns: {
      type: Array
    },
    /* 是否顯示檢索圖示 */
    search: {
      type: Boolean,
      default: true
    },
    /* 顯隱列型別（transfer穿梭框、checkbox核取方塊） */
    showColumnsType: {
      type: String,
      default: "checkbox"
    },
    /* 右外邊距 */
    gutter: {
      type: Number,
      default: 10
    },
  },
  computed: {
    style() {
      const ret = {}
      if (this.gutter) {
        ret.marginRight = `${this.gutter / 2}px`
      }
      return ret
    },
    isChecked: {
      get() {
        return this.columns.every((col) => col.visible)
      },
      set() {}
    },
    isIndeterminate() {
      return this.columns.some((col) => col.visible) && !this.isChecked
    }
  },
  created() {
    if (this.showColumnsType == 'transfer') {
      // 顯隱列初始預設隱藏列
      for (let item in this.columns) {
        if (this.columns[item].visible === false) {
          this.value.push(parseInt(item))
        }
      }
    }
  },
  methods: {
    // 搜尋
    toggleSearch() {
      this.$emit("update:showSearch", !this.showSearch)
    },
    // 重新整理
    refresh() {
      this.$emit("queryTable")
    },
    // 右側列表元素變化
    dataChange(data) {
      for (let item in this.columns) {
        const key = this.columns[item].key
        this.columns[item].visible = !data.includes(key)
      }
    },
    // 開啟顯隱列dialog
    showColumn() {
      this.open = true
    },
    // 單勾選
    checkboxChange(event, label) {
      this.columns.filter(item => item.label == label)[0].visible = event
    },
    // 切換全選/反選
    toggleCheckAll() {
      const newValue = !this.isChecked
      this.columns.forEach((col) => (col.visible = newValue))
    }
  },
}
</script>
<style lang="scss" scoped>
::v-deep .el-transfer__button {
  border-radius: 50%;
  padding: 12px;
  display: block;
  margin-left: 0px;
}
::v-deep .el-transfer__button:first-child {
  margin-bottom: 10px;
}
.check-line {
  width: 90%;
  height: 1px;
  background-color: #ccc;
  margin: 3px auto;
}
</style>
