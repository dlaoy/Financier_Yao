import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import installElementPlus from './plugins/element'
import axios from 'axios'
import md5 from 'js-md5'
import cookie from 'js-cookie'

const app = createApp(App)
installElementPlus(app)
app.use(router)
app.mount('#app')
app.config.globalProperties.$router = router
app.config.globalProperties.$axios = axios
app.config.globalProperties.$md5 = md5
app.config.globalProperties.$cookie = cookie

axios.defaults.baseURL = '/api'
