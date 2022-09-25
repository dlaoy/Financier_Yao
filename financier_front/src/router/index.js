import { createRouter, createWebHashHistory } from 'vue-router'
import axios  from 'axios'

const routes = [
  {
    path: '/',
    name: 'Home',
    meta:{
      requireAuth: true,
    },
    component:()=>import('@/views/Home.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: ()=>import('@/views/Login.vue')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

router.beforeEach((to,from,next)=>{
	if(to.meta.requireAuth){  // 判断该路由是否需要登录权限
    axios.post('/loginStatus').then(successResponse => {
      if (successResponse.data.loginState === 200) {
        next()
      } else {
        next('/login')
      }
    })
	}else{
        next()
    }
});


export default router
