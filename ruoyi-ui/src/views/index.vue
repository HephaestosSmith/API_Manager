<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>後臺管理框架</h2>
        <p>
          一直想做一款後臺管理系統，看了很多優秀的開源專案但是發現沒有合適自己的。於是利用空閒休息時間開始自己寫一套後臺系統。如此有了若依管理系統，她可以用於所有的Web應用程式，如網站管理後臺，網站會員中心，CMS，CRM，OA等等，當然，您也可以對她進行深度定製，以做出更強系統。所有前端後臺程式碼封裝過後十分精簡易上手，出錯機率低。同時支援移動客戶端訪問。系統會陸續更新一些實用功能。
        </p>
        <p>
          <b>當前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-tag type="danger">&yen;免費開源</el-tag>
        </p>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本號
      version: "3.9.0"
    }
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank")
    }
  }
}
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

