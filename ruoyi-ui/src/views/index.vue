<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>若依後臺管理框架</h2>
        <p>
          一直想做一款後臺管理系統，看了很多優秀的開源專案但是發現沒有合適自己的。於是利用空閒休息時間開始自己寫一套後臺系統。如此有了若依管理系統，她可以用於所有的Web應用程式，如網站管理後臺，網站會員中心，CMS，CRM，OA等等，當然，您也可以對她進行深度定製，以做出更強系統。所有前端後臺程式碼封裝過後十分精簡易上手，出錯機率低。同時支援移動客戶端訪問。系統會陸續更新一些實用功能。
        </p>
        <p>
          <b>當前版本:</b> <span>v{{ version }}</span>
        </p>
        <p>
          <el-tag type="danger">&yen;免費開源</el-tag>
        </p>
        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"
            >訪問碼雲</el-button
          >
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('http://ruoyi.vip')"
            >訪問主頁</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>技術選型</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>後端技術</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>前端技術</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>聯絡資訊</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官網：<el-link
                href="http://www.ruoyi.vip"
                target="_blank"
                >http://www.ruoyi.vip</el-link
              >
            </p>
            <p>
              <i class="el-icon-user-solid"></i> QQ群：<s> 滿937441 </s> <s> 滿887144332 </s>
              <s> 滿180251782 </s> <s> 滿104180207 </s> <s> 滿186866453 </s> <s> 滿201396349 </s>
              <s> 滿101456076 </s> <s> 滿101539465 </s> <s> 滿264312783 </s> <s> 滿167385320 </s> 
              <s> 滿104748341 </s> <s> 滿160110482 </s> <s> 滿170801498 </s> <s> 滿108482800 </s> 
              <s> 滿101046199 </s> <s> 滿136919097 </s> <s> 滿143961921 </s> <s> 滿174951577 </s> 
              <s> 滿161281055 </s> <s> 滿138988063 </s> <s> 滿151450850 </s> <s> 滿224622315 </s>
              <s> 滿287842588 </s> <s> 滿187944233 </s> <a href="http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=G6r5KGCaa3pqdbUSXNIgYloyb8e0_L0D&authKey=4w8tF1eGW7%2FedWn%2FHAypQksdrML%2BDHolQSx7094Agm7Luakj9EbfPnSTxSi2T1LQ&noverify=0&group_code=228578329" target="_blank">228578329</a>
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> 微信：<a
                href="javascript:;"
                >/ *若依</a
              >
            </p>
            <p>
              <i class="el-icon-money"></i> 支付寶：<a
                href="javascript:;"
                class="支付寶資訊"
                >/ *若依</a
              >
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日誌</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.9.0 - 2025-05-28">
              <ol>
                <li>最佳化選單搜尋查詢頁</li>
                <li>導航欄顯示暱稱&設定</li>
                <li>選單管理新增路由名稱</li>
                <li>新增底部版權資訊&開關</li>
                <li>分配角色禁用不允許勾選</li>
                <li>Excel匯入匯出支援多圖片</li>
                <li>新增頁籤圖示顯示開關功能</li>
                <li>上傳元件新增拖動排序屬性</li>
                <li>顯隱列元件支援全選/全不選</li>
                <li>初始密碼支援自定義修改策略</li>
                <li>賬號密碼支援自定義更新週期</li>
                <li>程式碼生成列表支援按時間排序</li>
                <li>支援富文字複製貼上圖片上傳至url</li>
                <li>支援檔案&圖片元件自定義地址&引數</li>
                <li>升級tomcat到最新版本9.0.105</li>
                <li>升級oshi到最新版本6.8.1</li>
                <li>升級fastjson到最新版2.0.57</li>
                <li>升級commons.io到最新版本2.19.0</li>
                <li>package.json移除runjs依賴</li>
                <li>package.json移除eslint依賴</li>
                <li>package.json移除vue-meta依賴</li>
                <li>修復程式碼生成主子表校驗必填失效問題</li>
                <li>最佳化前端樹結構效能問題</li>
                <li>最佳化前端處理路由函式程式碼</li>
                <li>最佳化檔案上傳元件新增型別</li>
                <li>最佳化頂部選單搜尋欄為多層級顯示</li>
                <li>最佳化檔案&圖片上傳元件新增disabled屬性</li>
                <li>最佳化空指標異常時無法獲取錯誤資訊問題</li>
                <li>最佳化定時任務字元包含多個括號導致資料錯誤</li>
                <li>最佳化登入&註冊頁表頭使用VUE_APP_TITLE配置值</li>
                <li>最佳化匯出Excel日期格式雙擊離開後與設定的格式不一致問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.9 - 2024-12-30">
              <ol>
                <li>使用者管理支援分欄拖動</li>
                <li>修改主題樣式本地讀取</li>
                <li>使用者頭像http(s)連結支援</li>
                <li>使用者管理過濾掉已禁用部門</li>
                <li>支援自定義顯示Excel屬性列</li>
                <li>操作日誌記錄DELETE請求引數</li>
                <li>白名單支援對萬用字元路徑匹配</li>
                <li>校檢檔名是否包含特殊字元</li>
                <li>程式碼生成建立表遮蔽違規的字元</li>
                <li>選單麵包屑導航支援多層級顯示</li>
                <li>Excel註解支援wrapText是否允許內容換行</li>
                <li>程式碼生成新增配置是否允許檔案覆蓋到本地</li>
                <li>修復角色禁用許可權不失效問題</li>
                <li>修復程式碼生成上級選單顯示問題</li>
                <li>修復匯出子列表物件只能在最後的問題</li>
                <li>修復TopNav無法正確獲取active的問題</li>
                <li>修復預設關閉Tags-Views內鏈頁面打不開</li>
                <li>升級oshi到最新版本6.6.5</li>
                <li>升級tomcat到最新版本9.0.96</li>
                <li>升級fastjson到最新版2.0.53</li>
                <li>升級logback到最新版本1.2.13</li>
                <li>升級spring-framework到最新版本5.3.39</li>
                <li>升級quill到最新版本2.0.2</li>
                <li>升級axios到最新版本0.28.1</li>
                <li>最佳化身份證脫敏正則</li>
                <li>最佳化許可權更新後同步快取</li>
                <li>最佳化查詢時間範圍日期格式</li>
                <li>最佳化引數鍵值更換為多行文字</li>
                <li>最佳化匯入帶標題檔案關閉清理</li>
                <li>最佳化上傳圖片帶域名不增加字首</li>
                <li>最佳化特殊字元密碼修改失敗問題</li>
                <li>最佳化無使用者編號不校驗資料許可權</li>
                <li>最佳化TopNav內鏈選單點選沒有高亮</li>
                <li>最佳化選單管理切換Mini佈局錯亂問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.8 - 2024-06-30">
              <ol>
                <li>選單管理新增路由名稱</li>
                <li>新增資料脫敏過濾註解</li>
                <li>使用者密碼新增非法字元驗證</li>
                <li>限制使用者運算元據許可權範圍</li>
                <li>程式碼生成新增建立表結構功能</li>
                <li>定時任務白名單配置範圍縮小</li>
                <li>最佳化程式碼生成主子表關聯查詢方式</li>
                <li>Excel註解新增屬性comboReadDict</li>
                <li>Excel註解ColumnType型別新增文字</li>
                <li>新增國際化資原始檔配置</li>
                <li>升級oshi到最新版本6.6.1</li>
                <li>升級druid到最新版本1.2.23</li>
                <li>升級core-js到最新版本3.37.1</li>
                <li>更新HttpUtils中的User-Agent</li>
                <li>更新compressionPlugin到6.1.2以相容node18+</li>
                <li>升級spring-security到安全版本，防止漏洞風險</li>
                <li>升級spring-framework到安全版本，防止漏洞風險</li>
                <li>最佳化自定義XSS註解匹配方式</li>
                <li>最佳化快取監控鍵名列表排序顯示</li>
                <li>最佳化定時任務日誌預設按時間排序</li>
                <li>最佳化預設檔案大小超過2G無效的問題</li>
                <li>最佳化查表特殊字元使用反斜槓進行轉義</li>
                <li>最佳化定時任務cron表示式小時配置顯示錯誤問題</li>
                <li>最佳化多個自定資料許可權使用in查詢,避免多次拼接</li>
                <li>最佳化匯入Excel時設定dictType屬性重複查快取問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.7 - 2023-12-08">
              <ol>
                <li>操作日誌記錄部門名稱</li>
                <li>全域性資料儲存使用者編號</li>
                <li>新增程式設計式判斷資源訪問許可權</li>
                <li>操作日誌列表新增IP地址查詢</li>
                <li>定時任務新增頁去除狀態選項</li>
                <li>程式碼生成支援選擇前端模板型別</li>
                <li>顯隱列元件支援核取方塊彈出型別</li>
                <li>通用排序屬性orderBy引數限制長度</li>
                <li>Excel自定義資料處理器增加單元格/工作簿物件</li>
                <li>升級oshi到最新版本6.4.8</li>
                <li>升級druid到最新版本1.2.20</li>
                <li>升級fastjson到最新版2.0.43</li>
                <li>升級pagehelper到最新版1.4.7</li>
                <li>升級commons.io到最新版本2.13.0</li>
                <li>升級element-ui到最新版本2.15.14</li>
                <li>修復五級路由快取無效問題</li>
                <li>修復外鏈帶埠出現的異常</li>
                <li>修復樹模板父級編碼變數錯誤</li>
                <li>修復字典表詳情頁面搜尋問題</li>
                <li>修復內鏈iframe沒有傳遞引數問題</li>
                <li>修復自定義字典樣式不生效的問題</li>
                <li>修復字典快取刪除方法引數錯誤問題</li>
                <li>修復Excel匯入資料臨時檔案無法刪除問題</li>
                <li>修復未登入帶引數訪問成功後引數丟失問題</li>
                <li>修復HeaderSearch元件跳轉query引數丟失問題</li>
                <li>修復程式碼生成匯入後必填項與資料庫不匹配問題</li>
                <li>修復Excels匯入時無法獲取到dictType字典值問題</li>
                <li>最佳化下載zip方法新增遮罩層</li>
                <li>最佳化頭像上傳引數新增檔名稱</li>
                <li>最佳化字典標籤支援自定義分隔符</li>
                <li>最佳化選單管理型別為按鈕狀態可選</li>
                <li>最佳化前端防重複提交資料大小限制</li>
                <li>最佳化TopNav選單沒有圖示svg不顯示</li>
                <li>最佳化數字金額大寫轉換精度丟失問題</li>
                <li>最佳化富文字Editor元件檢驗圖片格式</li>
                <li>最佳化頁簽在Firefox瀏覽器被遮擋的問題</li>
                <li>最佳化個人中心/基本資料修改時資料顯示問題</li>
                <li>最佳化快取監控圖表支援跟隨螢幕大小自適應調整</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.6 - 2023-06-30">
              <ol>
                <li>支援登入IP黑名單限制</li>
                <li>新增監控頁面圖示顯示</li>
                <li>操作日誌新增消耗時間屬性</li>
                <li>遮蔽定時任務bean違規的字元</li>
                <li>日誌管理使用索引提升查詢效能</li>
                <li>日誌註解支援排除指定的請求引數</li>
                <li>支援自定義隱藏屬性列過濾子物件</li>
                <li>升級oshi到最新版本6.4.3</li>
                <li>升級druid到最新版本1.2.16</li>
                <li>升級fastjson到最新版2.0.34</li>
                <li>升級spring-boot到最新版本2.5.15</li>
                <li>升級element-ui到最新版本2.15.13</li>
                <li>移除apache/commons-fileupload依賴</li>
                <li>修復頁面切換時佈局錯亂的問題</li>
                <li>修復匿名註解Anonymous空指標問題</li>
                <li>修復路由跳轉被阻止時內部產生報錯資訊問題</li>
                <li>修復isMatchedIp的引數判斷產生空指標的問題</li>
                <li>修復使用者多角色資料許可權可能出現許可權抬升的情況</li>
                <li>修復開啟TopNav後一級選單路由引數設定無效問題</li>
                <li>修復DictTag元件value沒有匹配的值時則展示value</li>
                <li>最佳化檔案下載出現的異常</li>
                <li>最佳化選擇圖示元件高亮回顯</li>
                <li>最佳化彈窗後導航欄偏移的問題</li>
                <li>最佳化修改密碼日誌儲存明文問題</li>
                <li>最佳化頁籤欄關閉其他出現的異常問題</li>
                <li>最佳化頁籤關閉左側選項排除首頁選項</li>
                <li>最佳化關閉當前tab頁跳轉最右側tab頁</li>
                <li>最佳化快取列表清除操作提示不變的問題</li>
                <li>最佳化字元未使用下劃線不進行駝峰式處理</li>
                <li>最佳化使用者匯入更新時需獲取使用者編號問題</li>
                <li>最佳化側邊欄的平臺標題與VUE_APP_TITLE保持同步</li>
                <li>最佳化匯出Excel時設定dictType屬性重複查快取問題</li>
                <li>連線池Druid支援新的配置connectTimeout和socketTimeout</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.5 - 2023-01-01">
              <ol>
                <li>定時任務違規的字元</li>
                <li>重置時取消部門選中</li>
                <li>新增返回警告訊息提示</li>
                <li>忽略不必要的屬性資料返回</li>
                <li>修改引數鍵名時移除前快取配置</li>
                <li>匯入更新使用者資料前校驗資料許可權</li>
                <li>相容Excel下拉框內容過多無法顯示的問題</li>
                <li>升級echarts到最新版本5.4.0</li>
                <li>升級core-js到最新版本3.25.3</li>
                <li>升級oshi到最新版本6.4.0</li>
                <li>升級kaptcha到最新版2.3.3</li>
                <li>升級druid到最新版本1.2.15</li>
                <li>升級fastjson到最新版2.0.20</li>
                <li>升級pagehelper到最新版1.4.6</li>
                <li>最佳化彈窗內容過多展示不全問題</li>
                <li>最佳化swagger-ui靜態資源使用快取</li>
                <li>開啟TopNav沒有子選單隱藏側邊欄</li>
                <li>刪除fuse無效選項maxPatternLength</li>
                <li>最佳化匯出物件的子列表為空會出現[]問題</li>
                <li>最佳化編輯頭像時透明部分會變成黑色問題</li>
                <li>最佳化小螢幕上修改頭像介面佈局錯位的問題</li>
                <li>修復程式碼生成勾選屬性無效問題</li>
                <li>修復檔案上傳元件格式驗證問題</li>
                <li>修復回顯資料字典陣列異常問題</li>
                <li>修復sheet超出最大行數異常問題</li>
                <li>修復Log註解GET請求記錄不到引數問題</li>
                <li>修復排程日誌點選多次資料不變化的問題</li>
                <li>修復主題顏色在Drawer元件不會載入問題</li>
                <li>修復檔名包含特殊字元的檔案無法下載問題</li>
                <li>修復table中更多按鈕切換主題色未生效修復問題</li>
                <li>修復某些特性的環境生成程式碼變亂碼TXT檔案問題</li>
                <li>修復程式碼生成圖片/檔案/單選時選擇必填無法校驗問題</li>
                <li>修復某些特性的情況使用者編輯對話方塊中角色和部門無法修改問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.4 - 2022-09-26">
              <ol>
                <li>資料邏輯刪除不進行唯一驗證</li>
                <li>Excel註解支援匯出物件的子列表方法</li>
                <li>Excel註解支援自定義隱藏屬性列</li>
                <li>Excel註解支援backgroundColor屬性設定背景色</li>
                <li>支援配置密碼最大錯誤次數/鎖定時間</li>
                <li>登入日誌新增解鎖賬戶功能</li>
                <li>通用下載方法新增config配置選項</li>
                <li>支援多許可權字元匹配角色資料許可權</li>
                <li>頁面內嵌iframe切換tab不重新整理資料</li>
                <li>操作日誌記錄支援排除敏感屬性欄位</li>
                <li>修復多檔案上傳報錯出現的異常問題</li>
                <li>修復圖片預覽元件src屬性為null值控制檯報錯問題</li>
                <li>升級oshi到最新版本6.2.2</li>
                <li>升級fastjson到最新版2.0.14</li>
                <li>升級pagehelper到最新版1.4.3</li>
                <li>升級core-js到最新版本3.25.2</li>
                <li>升級element-ui到最新版本2.15.10</li>
                <li>最佳化任務過期不執行排程</li>
                <li>最佳化字典資料使用store存取</li>
                <li>最佳化修改資料頭像被覆蓋的問題</li>
                <li>最佳化修改使用者登入賬號重複驗證</li>
                <li>最佳化程式碼生成同步後值NULL問題</li>
                <li>最佳化定時任務支援執行父類方法</li>
                <li>最佳化使用者個人資訊介面防止修改部門</li>
                <li>最佳化佈局設定使用el-drawer抽屜顯示</li>
                <li>最佳化沒有許可權的使用者編輯部門缺少資料</li>
                <li>最佳化日誌註解記錄限制請求地址的長度</li>
                <li>最佳化excel/scale屬性匯出單元格數值型別</li>
                <li>最佳化日誌操作中重置按鈕時重複查詢的問題</li>
                <li>最佳化多個相同角色資料導致許可權SQL重複問題</li>
                <li>最佳化表格上右側工具條（搜尋按鈕顯隱&右側樣式凸出）</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.3 - 2022-06-27">
              <ol>
                <li>新增快取列表選單功能</li>
                <li>程式碼生成樹表新增(展開/摺疊)</li>
                <li>Excel註解支援color字型顏色</li>
                <li>新增Anonymous匿名訪問不鑑權註解</li>
                <li>使用者頭像上傳限制只能為圖片格式</li>
                <li>介面使用泛型使其看到響應屬性欄位</li>
                <li>檢查定時任務bean所在包名是否為白名單配置</li>
                <li>新增頁籤openPage支援傳遞引數</li>
                <li>使用者快取資訊新增部門ancestors祖級列表</li>
                <li>升級element-ui到最新版本2.15.8</li>
                <li>升級oshi到最新版本6.1.6</li>
                <li>升級druid到最新版本1.2.11</li>
                <li>升級fastjson到最新版2.0.8</li>
                <li>升級spring-boot到最新版本2.5.14</li>
                <li>降級jsencrypt版本相容IE瀏覽器</li>
                <li>刪除多餘的salt欄位</li>
                <li>新增獲取不帶字尾檔名稱方法</li>
                <li>新增獲取配置檔案中的屬性值方法</li>
                <li>新增內容編碼/解碼方便外掛整合使用</li>
                <li>字典型別必須以字母開頭，且只能為（小寫字母，數字，下滑線）</li>
                <li>最佳化設定分頁引數預設值</li>
                <li>最佳化對空字串引數處理的過濾</li>
                <li>最佳化顯示順序orderNum型別為整型</li>
                <li>最佳化表單構建按鈕不顯示正則校驗</li>
                <li>最佳化字典資料回顯樣式下拉框顯示值</li>
                <li>最佳化R響應成功狀態碼與全域性保持一致</li>
                <li>最佳化druid開啟wall過濾器出現的異常問題</li>
                <li>最佳化使用者管理左側樹型元件增加選中高亮保持</li>
                <li>最佳化新增使用者與角色資訊&使用者與崗位資訊邏輯</li>
                <li>最佳化預設不啟用壓縮檔案快取防止node_modules過大</li>
                <li>修復字典資料顯示不全問題</li>
                <li>修復操作日誌查詢型別條件為0時會查到所有資料</li>
                <li>修復Excel註解prompt/combo同時使用不生效問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.2 - 2022-04-01">
              <ol>
                <li>前端支援設定是否需要防止資料重複提交</li>
                <li>開啟TopNav沒有子選單情況隱藏側邊欄</li>
                <li>側邊欄選單名稱過長懸停顯示標題</li>
                <li>使用者訪問控制時校驗資料許可權，防止越權</li>
                <li>匯出Excel時遮蔽公式，防止CSV注入風險</li>
                <li>元件ImagePreview支援多圖預覽顯示</li>
                <li>元件ImageUpload支援多圖同時選擇上傳</li>
                <li>元件FileUpload支援多檔案同時選擇上傳</li>
                <li>服務監控新增執行引數資訊顯示</li>
                <li>定時任務目標字串過濾特殊字元</li>
                <li>定時任務目標字串驗證包名白名單</li>
                <li>程式碼生成列表圖片支援預覽</li>
                <li>程式碼生成編輯修改開啟新頁籤</li>
                <li>程式碼生成新增Java型別Boolean</li>
                <li>程式碼生成子表支援日期/字典配置</li>
                <li>程式碼生成同步保留必填/型別選項</li>
                <li>升級oshi到最新版本6.1.2</li>
                <li>升級fastjson到最新版1.2.80</li>
                <li>升級pagehelper到最新版1.4.1</li>
                <li>升級spring-boot到最新版本2.5.11</li>
                <li>升級spring-boot-mybatis到最新版2.2.2</li>
                <li>新增遺漏的分頁引數合理化屬性</li>
                <li>修改npm即將過期的註冊源地址</li>
                <li>修復分頁元件請求兩次問題</li>
                <li>修復通用檔案下載介面跨域問題</li>
                <li>修復Xss註解欄位值為空時的異常問題</li>
                <li>修復選項卡點選右鍵重新整理丟失引數問題</li>
                <li>修復表單清除元素位置未垂直居中問題</li>
                <li>修復服務監控中執行引數顯示條件錯誤</li>
                <li>修復匯入Excel時字典欄位型別為Long轉義為空問題</li>
                <li>修復登入超時重新整理頁面跳轉登入頁面還提示重新登入問題</li>
                <li>最佳化載入字典快取資料</li>
                <li>最佳化IP地址獲取到多個的問題</li>
                <li>最佳化任務佇列滿時任務拒絕策略</li>
                <li>最佳化檔案上傳相容Weblogic環境</li>
                <li>最佳化定時任務預設儲存到記憶體中執行</li>
                <li>最佳化部門修改縮放後出現的錯位問題</li>
                <li>最佳化Excel格式化不同型別的日期物件</li>
                <li>最佳化選單表關鍵字導致的外掛報錯問題</li>
                <li>最佳化Oracle使用者頭像列為空時不顯示問題</li>
                <li>最佳化頁面若未匹配到字典標籤則返回原字典值</li>
                <li>最佳化修復登入失效後多次請求提示多次彈窗問題</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.1 - 2022-01-01">
              <ol>
                <li>新增Vue3前端程式碼生成模板</li>
                <li>新增圖片預覽元件</li>
                <li>新增壓縮外掛實現打包Gzip</li>
                <li>自定義xss校驗註解實現</li>
                <li>自定義文字複製剪貼指令</li>
                <li>程式碼生成預覽支援複製內容</li>
                <li>路由支援單獨配置選單或角色許可權</li>
                <li>使用者管理部門查詢選擇節點後分頁引數初始</li>
                <li>修復使用者分配角色屬性錯誤</li>
                <li>修復打包後字型圖示偶現的亂碼問題</li>
                <li>修復選單管理重置表單出現的錯誤</li>
                <li>修復版本差異導致的懶載入報錯問題</li>
                <li>修復Cron元件中週迴顯問題</li>
                <li>修復定時任務多引數逗號分隔的問題</li>
                <li>修復根據ID查詢列表可能出現的主鍵溢位問題</li>
                <li>修復tomcat配置引數已過期問題</li>
                <li>升級clipboard到最新版本2.0.8</li>
                <li>升級oshi到最新版本v5.8.6</li>
                <li>升級fastjson到最新版1.2.79</li>
                <li>升級spring-boot到最新版本2.5.8</li>
                <li>升級log4j2到2.17.1，防止漏洞風險</li>
                <li>最佳化下載解析blob異常提示</li>
                <li>最佳化程式碼生成字典組重複問題</li>
                <li>最佳化查詢使用者的角色組&崗位組程式碼</li>
                <li>最佳化定時任務cron表示式小時設定24</li>
                <li>最佳化使用者匯入提示溢位則顯示捲軸</li>
                <li>最佳化防重複提交標識組合為(key+url+header)</li>
                <li>最佳化分頁方法設定成通用方便靈活呼叫</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.8.0 - 2021-12-01">
              <ol>
                <li>新增配套並同步的Vue3前端版本</li>
                <li>新增通用方法簡化模態/快取/下載/許可權/頁籤使用</li>
                <li>最佳化匯出資料/使用通用下載方法</li>
                <li>Excel註解支援自定義資料處理器</li>
                <li>Excel註解支援匯入匯出標題資訊</li>
                <li>Excel匯入支援@Excels註解</li>
                <li>新增元件data-dict，簡化資料字典使用</li>
                <li>新增Jaxb依賴，防止jdk8以上出現的相容錯誤</li>
                <li>生產環境使用路由懶載入提升頁面響應速度</li>
                <li>修復五級以上選單出現的404問題</li>
                <li>防重提交註解支援配置間隔時間/提示訊息</li>
                <li>日誌註解新增是否儲存響應引數</li>
                <li>任務遮蔽違規字元&引數忽略雙引號中的逗號</li>
                <li>升級SpringBoot到最新版本2.5.6</li>
                <li>升級pagehelper到最新版1.4.0</li>
                <li>升級spring-boot-mybatis到最新版2.2.0</li>
                <li>升級oshi到最新版本v5.8.2</li>
                <li>升級druid到最新版1.2.8</li>
                <li>升級velocity到最新版本2.3</li>
                <li>升級fastjson到最新版1.2.78</li>
                <li>升級axios到最新版本0.24.0</li>
                <li>升級dart-sass到版本1.32.13</li>
                <li>升級core-js到最新版本3.19.1</li>
                <li>升級jsencrypt到最新版本3.2.1</li>
                <li>升級js-cookie到最新版本3.0.1</li>
                <li>升級file-saver到最新版本2.0.5</li>
                <li>升級sass-loader到最新版本10.1.1</li>
                <li>升級element-ui到最新版本2.15.6</li>
                <li>新增sendGet無參請求方法</li>
                <li>禁用el-tag元件的漸變動畫</li>
                <li>程式碼生成點選預覽重置啟用tab</li>
                <li>AjaxResult重寫put方法，以方便鏈式呼叫</li>
                <li>最佳化登入/驗證碼請求headers不設定token</li>
                <li>最佳化使用者個人資訊介面防止修改使用者名稱</li>
                <li>最佳化Cron表示式生成器關閉時銷燬避免快取</li>
                <li>最佳化註冊成功提示訊息型別success</li>
                <li>最佳化aop語法，使用spring自動注入註解</li>
                <li>最佳化記錄登入資訊，移除不必要的修改</li>
                <li>最佳化mybatis全域性預設的執行器</li>
                <li>最佳化Excel匯入圖片可能出現的異常</li>
                <li>修復程式碼生成模板主子表刪除缺少事務</li>
                <li>修復日誌記錄可能出現的轉換異常</li>
                <li>修復程式碼生成核取方塊字典遺漏問題</li>
                <li>修復關閉xss功能導致可重複讀RepeatableFilter失效</li>
                <li>修復字串無法被反轉義問題</li>
                <li>修復後端主子表程式碼模板方法名生成錯誤問題</li>
                <li>修復xss過濾後格式出現的異常</li>
                <li>修復swagger沒有指定dataTypeClass導致啟動出現warn日誌</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.7.0 - 2021-09-13">
              <ol>
                <li>引數管理支援配置驗證碼開關</li>
                <li>新增是否開啟使用者註冊功能</li>
                <li>定時任務支援線上生成cron表示式</li>
                <li>選單管理支援配置路由引數</li>
                <li>支援自定義註解實現介面限流</li>
                <li>Excel註解支援Image圖片匯入</li>
                <li>自定義彈層溢位滾動樣式</li>
                <li>自定義可拖動彈窗寬度指令</li>
                <li>自定義可拖動彈窗高度指令</li>
                <li>修復任意賬戶越權問題</li>
                <li>修改時檢查使用者資料許可權範圍</li>
                <li>修復儲存配置主題顏色失效問題</li>
                <li>新增暗色選單風格主題</li>
                <li>選單&部門新增展開/摺疊功能</li>
                <li>頁籤新增關閉左側&新增圖示</li>
                <li>頂部選單排除隱藏的預設路由</li>
                <li>頂部選單同步系統主題樣式</li>
                <li>跳轉路由高亮相對應的選單欄</li>
                <li>程式碼生成主子表多選行資料</li>
                <li>日期範圍支援新增多組</li>
                <li>升級element-ui到最新版本2.15.5</li>
                <li>升級oshi到最新版本v5.8.0</li>
                <li>升級commons.io到最新版本v2.11.0</li>
                <li>定時任務遮蔽ldap遠端呼叫</li>
                <li>定時任務遮蔽http(s)遠端呼叫</li>
                <li>補充定時任務表欄位註釋</li>
                <li>定時任務對檢查異常進行事務回滾</li>
                <li>啟用父部門狀態排除頂級節點</li>
                <li>富文字新增上傳檔案大小限制</li>
                <li>預設首頁使用keep-alive快取</li>
                <li>修改程式碼生成字典回顯樣式</li>
                <li>自定義分頁合理化傳入引數</li>
                <li>修復字典元件值為整形不顯示問題</li>
                <li>修復定時任務日誌執行狀態顯示</li>
                <li>角色&選單新增欄位屬性提示資訊</li>
                <li>修復角色分配使用者頁面引數型別錯誤提醒</li>
                <li>最佳化佈局設定動畫特效</li>
                <li>最佳化異常處理資訊</li>
                <li>最佳化錯誤token導致的解析異常</li>
                <li>密碼框新增顯示切換密碼圖示</li>
                <li>定時任務新增更多操作</li>
                <li>更多操作按鈕新增許可權控制</li>
                <li>匯入使用者樣式最佳化</li>
                <li>提取通用方法到基類控制器</li>
                <li>最佳化使用許可權工具獲取使用者資訊</li>
                <li>最佳化使用者不能刪除自己</li>
                <li>最佳化XSS跨站指令碼過濾</li>
                <li>最佳化程式碼生成模板</li>
                <li>驗證碼預設20s超時</li>
                <li>BLOB下載時清除URL物件引用</li>
                <li>程式碼生成匯入表按建立時間排序</li>
                <li>修復程式碼生成頁面資料編輯儲存之後總是跳轉第一頁的問題</li>
                <li>修復帶safari瀏覽器無法格式化utc日期格式yyyy-MM-dd'T'HH:mm:ss.SSS問題</li>
                <li>多圖上傳元件移除多餘的api地址&驗證失敗導致圖片刪除問題&無法刪除相應圖片修復</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.6.0 - 2021-07-12">
              <ol>
                <li>角色管理新增分配使用者功能</li>
                <li>使用者管理新增分配角色功能</li>
                <li>日誌列表支援排序操作</li>
                <li>最佳化引數&字典快取操作</li>
                <li>系統佈局配置支援動態標題開關</li>
                <li>選單路由配置支援內鏈訪問</li>
                <li>預設訪問後端首頁新增提示語</li>
                <li>富文字預設上傳返回url型別</li>
                <li>新增自定義彈窗拖拽指令</li>
                <li>全域性註冊常用通用元件</li>
                <li>全域性掛載字典標籤元件</li>
                <li>ImageUpload元件支援多圖片上傳</li>
                <li>FileUpload元件支援多檔案上傳</li>
                <li>檔案上傳元件新增數量限制屬性</li>
                <li>富文字編輯元件新增型別屬性</li>
                <li>富文字元件工具欄配置影片</li>
                <li>封裝通用iframe元件</li>
                <li>限制超級管理員不允許操作</li>
                <li>使用者資訊長度校驗限制</li>
                <li>分頁元件新增pagerCount屬性</li>
                <li>新增bat指令碼執行應用</li>
                <li>升級oshi到最新版本v5.7.4</li>
                <li>升級element-ui到最新版本2.15.2</li>
                <li>升級pagehelper到最新版1.3.1</li>
                <li>升級commons.io到最新版本v2.10.0</li>
                <li>升級commons.fileupload到最新版本v1.4</li>
                <li>升級swagger到最新版本v3.0.0</li>
                <li>修復關閉confirm提示框控制檯報錯問題</li>
                <li>修復存在的SQL隱碼攻擊漏洞問題</li>
                <li>定時任務遮蔽rmi遠端呼叫</li>
                <li>修復使用者搜尋分頁變數錯誤</li>
                <li>修復匯出角色資料範圍翻譯缺少僅本人</li>
                <li>修復表單構建選擇下拉選擇控制檯報錯問題</li>
                <li>最佳化圖片工具類讀取檔案</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.5.0 - 2021-05-25">
              <ol>
                <li>新增選單導航顯示風格TopNav（false為左側導航選單，true為頂部導航選單）</li>
                <li>佈局設定支援儲存&重置配置</li>
                <li>修復樹表資料顯示不全&載入慢問題</li>
                <li>新增IE瀏覽器版本過低提示頁面</li>
                <li>使用者登入後記錄最後登入IP&時間</li>
                <li>頁面匯出按鈕點選之後新增遮罩</li>
                <li>富文字編輯器支援自定義上傳地址</li>
                <li>富文字編輯元件新增readOnly屬性</li>
                <li>頁籤TagsView新增關閉右側功能</li>
                <li>顯隱列元件載入初始預設隱藏列</li>
                <li>關閉頭像上傳視窗還原預設圖片</li>
                <li>個人資訊新增手機&郵箱重複驗證</li>
                <li>程式碼生成模板匯出按鈕點選後新增遮罩</li>
                <li>程式碼生成模板樹表操作列新增新增按鈕</li>
                <li>程式碼生成模板修復主子表欄位重名問題</li>
                <li>升級fastjson到最新版1.2.76</li>
                <li>升級druid到最新版本v1.2.6</li>
                <li>升級mybatis到最新版3.5.6 阻止遠端程式碼執行漏洞</li>
                <li>升級oshi到最新版本v5.6.0</li>
                <li>velocity剔除commons-collections版本，防止3.2.1版本的反序列化漏洞</li>
                <li>資料監控頁預設賬戶密碼防止越權訪問</li>
                <li>修復firefox下表單構建拖拽會新打卡一個選項卡</li>
                <li>修正後端匯入表許可權標識</li>
                <li>修正前端操作日誌&登入日誌許可權標識</li>
                <li>設定Redis配置HashKey序列化</li>
                <li>刪除操作日誌記錄資訊</li>
                <li>上傳媒體型別新增影片格式</li>
                <li>修復請求形參未傳值記錄日誌異常問題</li>
                <li>最佳化xss校驗json請求條件</li>
                <li>樹級結構更新子節點使用replaceFirst</li>
                <li>最佳化ExcelUtil空值處理</li>
                <li>日誌記錄過濾BindingResult物件，防止異常</li>
                <li>修改主題後mini型別按鈕無效問題</li>
                <li>最佳化通用下載完成後刪除節點</li>
                <li>通用Controller新增響應返回訊息</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.4.0 - 2021-02-22">
              <ol>
                <li>程式碼生成模板支援主子表</li>
                <li>表格右側工具欄元件支援顯隱列</li>
                <li>圖片元件新增預覽&移除功能</li>
                <li>Excel註解支援Image圖片匯出</li>
                <li>操作按鈕組調整為樸素按鈕樣式</li>
                <li>程式碼生成支援檔案上傳元件</li>
                <li>程式碼生成日期控制元件區分範圍</li>
                <li>程式碼生成資料庫文字型別生成表單文字域</li>
                <li>使用者手機郵箱&選單元件修改允許空字串</li>
                <li>升級SpringBoot到最新版本2.2.13 提升啟動速度</li>
                <li>升級druid到最新版本v1.2.4</li>
                <li>升級fastjson到最新版1.2.75</li>
                <li>升級element-ui到最新版本2.15.0</li>
                <li>修復IE11瀏覽器報錯問題</li>
                <li>最佳化多級選單之間切換無法快取的問題</li>
                <li>修復四級選單無法顯示問題</li>
                <li>修正側邊欄靜態路由丟失問題</li>
                <li>修復角色管理-編輯角色-功能許可權顯示異常</li>
                <li>配置檔案新增redis資料庫索引屬性</li>
                <li>許可權工具類增加admin判斷</li>
                <li>角色非自定義許可權範圍清空選擇值</li>
                <li>修復匯入資料為負浮點數時丟失精度問題</li>
                <li>移除path-to-regexp正則匹配外掛</li>
                <li>修復生成樹表程式碼異常</li>
                <li>修改ip欄位長度防止ipv6地址長度不夠</li>
                <li>防止get請求引數值為false或0等特殊值會導致無法正確的傳參</li>
                <li>登入後push新增catch防止出現檢查錯誤</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.3.0 - 2020-12-14">
              <ol>
                <li>新增快取監控功能</li>
                <li>支援主題風格配置</li>
                <li>修復多級選單之間切換無法快取的問題</li>
                <li>多級選單自動配置元件</li>
                <li>程式碼生成預覽支援高亮顯示</li>
                <li>支援Get請求對映Params引數</li>
                <li>刪除使用者和角色解綁關聯</li>
                <li>去除使用者手機郵箱部門必填驗證</li>
                <li>Excel支援註解align對齊方式</li>
                <li>Excel支援匯入Boolean型資料</li>
                <li>最佳化頭像樣式，滑鼠移入懸停遮罩</li>
                <li>程式碼生成預覽提供滾動機制</li>
                <li>程式碼生成刪除多餘的數字float型別</li>
                <li>修正轉換字串的目標字符集屬性</li>
                <li>回顯資料字典防止空值報錯</li>
                <li>日誌記錄增加過濾多檔案場景</li>
                <li>修改快取Set方法可能導致巢狀的問題</li>
                <li>移除前端一些多餘的依賴</li>
                <li>防止安全掃描YUI出現的風險提示</li>
                <li>修改node-sass為dart-sass</li>
                <li>升級SpringBoot到最新版本2.1.18</li>
                <li>升級poi到最新版本4.1.2</li>
                <li>升級oshi到最新版本v5.3.6</li>
                <li>升級bitwalker到最新版本1.21</li>
                <li>升級axios到最新版本0.21.0</li>
                <li>升級element-ui到最新版本2.14.1</li>
                <li>升級vue到最新版本2.6.12</li>
                <li>升級vuex到最新版本3.6.0</li>
                <li>升級vue-cli到版本4.5.9</li>
                <li>升級vue-router到最新版本3.4.9</li>
                <li>升級vue-cli到最新版本4.4.6</li>
                <li>升級vue-cropper到最新版本0.5.5</li>
                <li>升級clipboard到最新版本2.0.6</li>
                <li>升級core-js到最新版本3.8.1</li>
                <li>升級echarts到最新版本4.9.0</li>
                <li>升級file-saver到最新版本2.0.4</li>
                <li>升級fuse.js到最新版本6.4.3</li>
                <li>升級js-beautify到最新版本1.13.0</li>
                <li>升級js-cookie到最新版本2.2.1</li>
                <li>升級path-to-regexp到最新版本6.2.0</li>
                <li>升級quill到最新版本1.3.7</li>
                <li>升級screenfull到最新版本5.0.2</li>
                <li>升級sortablejs到最新版本1.10.2</li>
                <li>升級vuedraggable到最新版本2.24.3</li>
                <li>升級chalk到最新版本4.1.0</li>
                <li>升級eslint到最新版本7.15.0</li>
                <li>升級eslint-plugin-vue到最新版本7.2.0</li>
                <li>升級lint-staged到最新版本10.5.3</li>
                <li>升級runjs到最新版本4.4.2</li>
                <li>升級sass-loader到最新版本10.1.0</li>
                <li>升級script-ext-html-webpack-plugin到最新版本2.1.5</li>
                <li>升級svg-sprite-loader到最新版本5.1.1</li>
                <li>升級vue-template-compiler到最新版本2.6.12</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.2.1 - 2020-11-18">
              <ol>
                <li>阻止任意檔案下載漏洞</li>
                <li>程式碼生成支援上傳控制元件</li>
                <li>新增圖片上傳元件</li>
                <li>調整預設首頁</li>
                <li>升級druid到最新版本v1.2.2</li>
                <li>mapperLocations配置支援分隔符</li>
                <li>許可權資訊調整</li>
                <li>調整sql預設時間</li>
                <li>解決程式碼生成沒有bit型別的問題</li>
                <li>升級pagehelper到最新版1.3.0</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v3.2.0 - 2020-10-10">
              <ol>
                <li>升級springboot版本到2.1.17 提升安全性</li>
                <li>升級oshi到最新版本v5.2.5</li>
                <li>升級druid到最新版本v1.2.1</li>
                <li>升級jjwt到版本0.9.1</li>
                <li>升級fastjson到最新版1.2.74</li>
                <li>修改sass為node-sass，避免el-icon圖示亂碼</li>
                <li>程式碼生成支援同步資料庫</li>
                <li>程式碼生成支援富文字控制元件</li>
                <li>程式碼生成頁面時不忽略remark屬性</li>
                <li>程式碼生成新增select必填選項</li>
                <li>Excel匯出型別NUMERIC支援精度浮點型別</li>
                <li>Excel匯出targetAttr最佳化獲取值，防止get方法不規範</li>
                <li>Excel註解支援自動統計資料總和</li>
                <li>Excel註解支援設定BigDecimal精度&舍入規則</li>
                <li>選單&資料許可權新增（展開/摺疊 全選/全不選 父子聯動）</li>
                <li>允許使用者分配到部門父節點</li>
                <li>選單新增是否快取keep-alive</li>
                <li>表格操作列間距調整</li>
                <li>限制系統內建引數不允許刪除</li>
                <li>富文字元件最佳化，支援自定義高度&圖片衝突問題</li>
                <li>富文字工具欄樣式對齊</li>
                <li>匯入excel整形值校驗最佳化</li>
                <li>修復頁籤關閉所有時固定標籤路由不重新整理問題</li>
                <li>表單構建佈局型元件新增按鈕</li>
                <li>左側選單文字過長顯示省略號</li>
                <li>修正根節點為子部門時，樹狀結構顯示問題</li>
                <li>修正呼叫目標字串最大長度</li>
                <li>修正選單提示資訊錯誤</li>
                <li>修正定時任務執行一次許可權標識</li>
                <li>修正資料庫字串型別nvarchar</li>
                <li>最佳化遞迴子節點</li>
                <li>最佳化資料許可權判斷</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v3.1.0 - 2020-08-13">
              <ol>
                <li>表格工具欄右側新增重新整理&顯隱查詢元件</li>
                <li>後端支援CORS跨域請求</li>
                <li>程式碼生成支援選擇上級選單</li>
                <li>程式碼生成支援自定義路徑</li>
                <li>程式碼生成支援核取方塊</li>
                <li>Excel匯出匯入支援dictType字典型別</li>
                <li>Excel支援分割字串組內容</li>
                <li>驗證碼型別支援（陣列計算、字元驗證）</li>
                <li>升級vue-cli版本到4.4.4</li>
                <li>修改 node-sass 為 dart-sass</li>
                <li>表單型別為Integer/Long設定整形預設值</li>
                <li>程式碼生成器預設mapper路徑與預設mapperScan路徑不一致</li>
                <li>最佳化防重複提交攔截器</li>
                <li>最佳化上級選單不能選擇自己</li>
                <li>修復角色的許可權分配後，未實時生效問題</li>
                <li>修復線上使用者日誌記錄型別</li>
                <li>修復富文字空格和縮排儲存後不生效問題</li>
                <li>修復線上使用者判斷邏輯</li>
                <li>唯一限制條件只返回單條資料</li>
                <li>新增獲取當前的環境配置方法</li>
                <li>超時登入後頁面跳轉到首頁</li>
                <li>全域性異常狀態漢化攔截處理</li>
                <li>HTML過濾器改為將html轉義</li>
                <li>檢查字元支援小數點&降級改成異常提醒</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v3.0.0 - 2020-07-20">
              <ol>
                <li>單應用調整為多模組專案</li>
                <li>升級element-ui版本到2.13.2</li>
                <li>刪除babel，提高編譯速度。</li>
                <li>新增選單預設主類目</li>
                <li>編碼檔名修改為uuid方式</li>
                <li>定時任務cron表示式驗證</li>
                <li>角色許可權修改時已有許可權未自動勾選異常修復</li>
                <li>防止切換許可權使用者後登入出現404</li>
                <li>Excel支援sort匯出排序</li>
                <li>建立使用者不允許選擇超級管理員角色</li>
                <li>修復程式碼生成匯入表結構出現異常頁面不提醒問題</li>
                <li>修復程式碼生成點選多次表修改資料不變化的問題</li>
                <li>修復頭像上傳成功二次開啟無法改變裁剪框大小和位置問題</li>
                <li>修復佈局為small者mini使用者表單顯示錯位問題</li>
                <li>修復熱部署導致的強換異常問題</li>
                <li>修改使用者管理核取方塊寬度，防止部分瀏覽器出現省略號</li>
                <li>IpUtils工具，清除Xss特殊字元，防止Xff注入攻擊</li>
                <li>生成domain 如果是浮點型 統一用BigDecimal</li>
                <li>定時任務調整label-width，防止部署出現錯位</li>
                <li>調整表頭固定列預設樣式</li>
                <li>程式碼生成模板調整，欄位為String並且必填則加空串條件</li>
                <li>程式碼生成字典Integer/Long使用parseInt</li>
                <li>
                  修復dict_sort不可update為0的問題&查詢返回增加dict_sort升序排序
                </li>
                <li>修正崗位匯出許可權註解</li>
                <li>禁止加密密文返回前端</li>
                <li>修復程式碼生成頁面中的查詢條件建立時間未生效的問題</li>
                <li>修復首頁搜尋選單外鏈無法點選跳轉問題</li>
                <li>修復選單管理選擇圖示，backspace刪除時不過濾資料</li>
                <li>使用者管理部門分支節點不可檢查&顯示計數</li>
                <li>資料範圍過濾屬性調整</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.3.0 - 2020-06-01">
              <ol>
                <li>升級fastjson到最新版1.2.70 修復高危安全漏洞</li>
                <li>dev啟動預設開啟瀏覽器</li>
                <li>vue-cli使用預設source-map</li>
                <li>slidebar eslint報錯最佳化</li>
                <li>當tags-view滾動關閉右鍵選單</li>
                <li>字典管理新增快取讀取</li>
                <li>引數管理支援快取操作</li>
                <li>支援一級選單（和主頁同級）在main區域顯示</li>
                <li>限制外鏈地址必須以http(s)開頭</li>
                <li>tagview & sidebar 主題顏色與element ui(全域性)同步</li>
                <li>修改資料來源型別優先順序，先根據方法，再根據類</li>
                <li>支援是否需要設定token屬性，自定義返回碼訊息。</li>
                <li>swagger請求字首加入配置。</li>
                <li>登入地點設定內容過長則隱藏顯示</li>
                <li>修復定時任務執行一次按鈕後不提示訊息問題</li>
                <li>修改上級部門（選擇項排除本身和下級）</li>
                <li>通用http傳送方法增加引數 contentType 編碼型別</li>
                <li>更換IP地址查詢介面</li>
                <li>修復頁籤變數undefined</li>
                <li>新增校驗部門包含未停用的子部門</li>
                <li>修改定時任務詳情下次執行時間日期顯示錯誤</li>
                <li>角色管理查詢設定預設排序欄位</li>
                <li>swagger新增enable引數控制是否啟用</li>
                <li>只對json型別請求構建可重複讀取inputStream的request</li>
                <li>修改程式碼生成字典欄位int型別沒有自動選中問題</li>
                <li>vuex使用者名稱取值修正</li>
                <li>表格樹模板去掉多餘的)</li>
                <li>程式碼生成序號修正</li>
                <li>全屏情況下不調整上外邊距</li>
                <li>程式碼生成Date欄位新增預設格式</li>
                <li>使用者管理角色選擇許可權控制</li>
                <li>修復路由懶載入報錯問題</li>
                <li>模板sql.vm新增選單狀態</li>
                <li>設定使用者名稱稱不能修改</li>
                <li>dialog新增append-to-body屬性，防止ie遮罩</li>
                <li>選單區分狀態和顯示隱藏功能</li>
                <li>升級fastjson到最新版1.2.68 修復安全加固</li>
                <li>修復程式碼生成如果選擇字典型別缺失逗號問題</li>
                <li>登入請求params更換為data，防止暴露url</li>
                <li>日誌返回時間格式處理</li>
                <li>新增handle控制允許拖動的元素</li>
                <li>佈局設定點選擴大範圍</li>
                <li>程式碼生成列屬性排序查詢</li>
                <li>程式碼生成列支援拖動排序</li>
                <li>修復時間格式不支援ios問題</li>
                <li>表單構建新增父級class，防止衝突</li>
                <li>定時任務併發屬性修正</li>
                <li>角色禁用&選單隱藏不查詢許可權</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.2.0 - 2020-03-18">
              <ol>
                <li>系統監控新增定時任務功能</li>
                <li>新增一個打包Web工程bat</li>
                <li>修復頁籤滑鼠滾輪按下的時候，可以關閉不可關閉的tag</li>
                <li>修復點選退出登入有時會無提示問題</li>
                <li>修復防重複提交註解無效問題</li>
                <li>修復通知公告批次刪除異常問題</li>
                <li>新增選單時路由地址必填限制</li>
                <li>程式碼生成欄位描述可編輯</li>
                <li>修復使用者修改個人資訊導致快取不過期問題</li>
                <li>個人資訊建立時間獲取正確屬性值</li>
                <li>操作日誌詳細顯示正確型別</li>
                <li>匯入表單擊行資料時選中對應的核取方塊</li>
                <li>批次替換表字首邏輯調整</li>
                <li>固定重定向路徑表示式</li>
                <li>升級element-ui版本到2.13.0</li>
                <li>操作日誌排序調整</li>
                <li>修復charts切換側邊欄或者縮放視窗顯示bug</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.1.0 - 2020-02-24">
              <ol>
                <li>新增表單構建</li>
                <li>程式碼生成支援樹表結構</li>
                <li>新增使用者匯入</li>
                <li>修復動態載入路由頁面重新整理問題</li>
                <li>修復地址開關無效問題</li>
                <li>漢化錯誤提示頁面</li>
                <li>程式碼生成已知問題修改</li>
                <li>修復多資料來源下配置關閉出現異常處理</li>
                <li>新增HTML過濾器，用於去除XSS漏洞隱患</li>
                <li>修復上傳頭像控制檯出現異常</li>
                <li>修改使用者管理分頁不正確的問題</li>
                <li>修復驗證碼記錄提示錯誤</li>
                <li>修復request.js缺少Message引用</li>
                <li>修復表格時間為空出現的異常</li>
                <li>新增Jackson日期反序列化時區配置</li>
                <li>調整根據使用者許可權載入選單資料樹形結構</li>
                <li>調整成功登入不恢復按鈕，防止多次點選</li>
                <li>修改使用者個人資料同步快取資訊</li>
                <li>修復頁面同時出現el-upload和Editor不顯示處理</li>
                <li>修復在角色管理頁修改選單許可權偶爾未選中問題</li>
                <li>配置檔案新增redis密碼屬性</li>
                <li>設定mybatis全域性的配置檔案</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>

            <el-collapse-item title="v2.0.0 - 2019-12-02">
              <ol>
                <li>新增程式碼生成</li>
                <li>新增@RepeatSubmit註解，防止重複提交</li>
                <li>新增選單主目錄新增/刪除操作</li>
                <li>日誌記錄過濾特殊物件，防止轉換異常</li>
                <li>修改程式碼生成路由指令碼錯誤</li>
                <li>使用者上傳頭像實時同步快取，無需重新登入</li>
                <li>調整切換頁籤後不重新載入資料</li>
                <li>新增jsencrypt實現引數的前端加密</li>
                <li>系統退出刪除使用者快取記錄</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.1.0 - 2019-11-11">
              <ol>
                <li>新增線上使用者管理</li>
                <li>新增按鈕組功能實現（批次刪除、匯出、清空）</li>
                <li>新增查詢條件重置按鈕</li>
                <li>新增Swagger全域性Token配置</li>
                <li>新增後端引數校驗</li>
                <li>修復字典管理頁面的日期查詢異常</li>
                <li>修改時間函式命名防止衝突</li>
                <li>去除選單上級校驗，預設為頂級</li>
                <li>修復使用者密碼無法修改問題</li>
                <li>修復選單型別為按鈕時不顯示許可權標識</li>
                <li>其他細節最佳化</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="v1.0.0 - 2019-10-08">
              <ol>
                <li>若依前後端分離系統正式釋出</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>捐贈支援</span>
          </div>
          <div class="body">
            <img
              src="@/assets/images/pay.png"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px"
              >你可以請作者喝杯咖啡表示鼓勵</span
            >
          </div>
        </el-card>
      </el-col>
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

