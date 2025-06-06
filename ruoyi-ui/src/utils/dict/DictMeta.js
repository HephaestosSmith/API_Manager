import { mergeRecursive } from "@/utils/ruoyi"
import DictOptions from './DictOptions'

/**
 * @classdesc 字典後設資料
 * @property {String} type 型別
 * @property {Function} request 請求
 * @property {String} label 標籤欄位
 * @property {String} value 值欄位
 */
export default class DictMeta {
  constructor(options) {
    this.type = options.type
    this.request = options.request
    this.responseConverter = options.responseConverter
    this.labelField = options.labelField
    this.valueField = options.valueField
    this.lazy = options.lazy === true
  }
}


/**
 * 解析字典後設資料
 * @param {Object} options
 * @returns {DictMeta}
 */
DictMeta.parse= function(options) {
  let opts = null
  if (typeof options === 'string') {
    opts = DictOptions.metas[options] || {}
    opts.type = options
  } else if (typeof options === 'object') {
    opts = options
  }
  opts = mergeRecursive(DictOptions.metas['*'], opts)
  return new DictMeta(opts)
}
