import request from '@/utils/request'

// 獲取服務資訊
export function getServer() {
  return request({
    url: '/monitor/server',
    method: 'get'
  })
}