/**
 * @classdesc 字典資料
 * @property {String} label 標籤
 * @property {*} value 標籤
 * @property {Object} raw 原始資料
 */
export default class DictData {
  constructor(label, value, raw) {
    this.label = label
    this.value = value
    this.raw = raw
  }
}
