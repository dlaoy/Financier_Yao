<!--奇哉至理，常净常清。 @Enrace-->
<template>
  <body id="login-page">
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input
          @focus="clearError"
          type="text"
          v-model="loginForm.loginName"
          auto-complete="off"
          placeholder="账号"
      >
      </el-input>
    </el-form-item>
    <el-form-item>
      <el-input
          @focus="clearError"
          type="password"
          v-model="loginForm.loginPasswd"
          auto-complete="off"
          placeholder="密码"
      >
      </el-input>
      <span class="showError" >{{errorInfo}}</span>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button
          type="primary"
          style="width: 100%;  border: none"
          @click = "login"
      >登录
      </el-button
      >
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
import { useRouter } from 'vue-router';
export default {
  setup(){
    const $router = useRouter();
    const urlClick= () => {
      $router.push({path:'/'})
    }
    return{
      urlClick
    }
  },
  name: "Login",
  data() {
    return {
      loginForm: {
        loginName: "",
        loginPasswd: "",
      },
      responseResult: [],
      errorInfo: "",
      saltData:"22ba2ce7e5203e6e885b8fc68a020851",
    };
  },
  mounted(){
    this.init()
  },
  methods: {
    init(){
      this.$axios.post('/loginStatus').then(successResponse => {
        if (successResponse.data.loginState === 200) {
          this.$message("您已登录该网站")
          this.urlClick()
        }
      })
    },
    login() {
      if(this.loginForm.loginName === "") {
        this.errorInfo = "请输入账号"
      } else {
        if(this.loginForm.loginPasswd === ""){
          this.errorInfo = "请输入密码"
        } else {
          this.$axios.post('/loginUser', {
            userName: this.loginForm.loginName,
            password: this.$md5(this.$md5(this.loginForm.loginPasswd)+this.saltData)
          })
              .then(successResponse => {
                if (successResponse.data.loginState === 200) {
                  this.urlClick()
                } else {
                  this.errorInfo = "账号密码错误";
                }
              })
              .catch(failResponse => {
                this.errorInfo = "服务器异常，请稍后";
              })
        }
      }
    },
    clearError() {
      this.errorInfo = "";
    },
  }
};
</script>

<style scoped>
#login-page {
  background: url("../assets/bg.jpeg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #f7fad8;
}

.login_title {
  margin: 0 auto 40px auto;
  text-align: center;
  color: #000000;
}

.showError {
  color: red;
  font-size: 16px;
}
</style>

