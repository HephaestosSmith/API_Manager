/**
 * v-dialogDragWidth 可拖動彈窗寬度（右側邊）
 * Copyright (c) 2019 ruoyi
 */

export default {
  bind(el) {
    const dragDom = el.querySelector('.el-dialog')
    const lineEl = document.createElement('div')
    lineEl.style = 'width: 5px; background: inherit; height: 80%; position: absolute; right: 0; top: 0; bottom: 0; margin: auto; z-index: 1; cursor: w-resize;'
    lineEl.addEventListener('mousedown',
      function (e) {
        // 滑鼠按下，計算當前元素距離可視區的距離
        const disX = e.clientX - el.offsetLeft
        // 當前寬度
        const curWidth = dragDom.offsetWidth
        document.onmousemove = function (e) {
          e.preventDefault() // 移動時禁用預設事件
          // 透過事件委託，計算移動的距離
          const l = e.clientX - disX
          dragDom.style.width = `${curWidth + l}px`
        }
        document.onmouseup = function (e) {
          document.onmousemove = null
          document.onmouseup = null
        }
      }, false)
    dragDom.appendChild(lineEl)
  }
}
