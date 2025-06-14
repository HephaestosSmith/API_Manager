import store from '@/store'

/**
 * 字元許可權校驗
 * @param {Array} value 校驗值
 * @returns {Boolean}
 */
export function checkPermi(value) {
  if (value && value instanceof Array && value.length > 0) {
    const permissions = store.getters && store.getters.permissions
    const permissionDatas = value
    const all_permission = "*:*:*"

    const hasPermission = permissions.some(permission => {
      return all_permission === permission || permissionDatas.includes(permission)
    })

    return hasPermission

  } else {
    console.error(`need roles! Like checkPermi="['system:user:add','system:user:edit']"`)
    return false
  }
}

/**
 * 角色許可權校驗
 * @param {Array} value 校驗值
 * @returns {Boolean}
 */
export function checkRole(value) {
  if (value && value instanceof Array && value.length > 0) {
    const roles = store.getters && store.getters.roles
    const permissionRoles = value
    const super_admin = "admin"

    const hasRole = roles.some(role => {
      return super_admin === role || permissionRoles.includes(role)
    })

    return hasRole

  } else {
    console.error(`need roles! Like checkRole="['admin','editor']"`)
    return false
  }
}