import router from '@/router'
import { MessageBox, } from 'element-ui'
import { login, logout, getInfo } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { isHttp, isEmpty } from "@/utils/validate"
import defAva from '@/assets/images/profile.jpg'

const user = {
  state: {
    token: getToken(),
    id: '',
    name: '',
    nickName: '',
    avatar: '',
    roles: [],
    permissions: []
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_ID: (state, id) => {
      state.id = id
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_NICK_NAME: (state, nickName) => {
      state.nickName = nickName
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_PERMISSIONS: (state, permissions) => {
      state.permissions = permissions
    }
  },

  actions: {
    // 登入
    Login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      const password = userInfo.password
      const code = userInfo.code
      const uuid = userInfo.uuid
      return new Promise((resolve, reject) => {
        login(username, password, code, uuid).then(res => {
          setToken(res.token)
          commit('SET_TOKEN', res.token)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 獲取使用者資訊
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo().then(res => {
          const user = res.user
          let avatar = user.avatar || ""
          if (!isHttp(avatar)) {
            avatar = (isEmpty(avatar)) ? defAva : process.env.VUE_APP_BASE_API + avatar
          }
          if (res.roles && res.roles.length > 0) { // 驗證返回的roles是否是一個非空陣列
            commit('SET_ROLES', res.roles)
            commit('SET_PERMISSIONS', res.permissions)
          } else {
            commit('SET_ROLES', ['ROLE_DEFAULT'])
          }
          commit('SET_ID', user.userId)
          commit('SET_NAME', user.userName)
          commit('SET_NICK_NAME', user.nickName)
          commit('SET_AVATAR', avatar)
          /* 初始密碼提示 */
          if(res.isDefaultModifyPwd) {
            MessageBox.confirm('您的密碼還是初始密碼，請修改密碼！',  '安全提示', {  confirmButtonText: '確定',  cancelButtonText: '取消',  type: 'warning' }).then(() => {
              router.push({ name: 'Profile', params: { activeTab: 'resetPwd' } })
            }).catch(() => {})
          }
          /* 過期密碼提示 */
          if(!res.isDefaultModifyPwd && res.isPasswordExpired) {
            MessageBox.confirm('您的密碼已過期，請儘快修改密碼！',  '安全提示', {  confirmButtonText: '確定',  cancelButtonText: '取消',  type: 'warning' }).then(() => {
              router.push({ name: 'Profile', params: { activeTab: 'resetPwd' } })
            }).catch(() => {})
          }
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 退出系統
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          commit('SET_PERMISSIONS', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default user
