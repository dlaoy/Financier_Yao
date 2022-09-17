module.exports = {
  devServer:{
    proxy:{
      '/api':{
        // 跨域的服务器地址
        target: 'http://localhost:9090',
        // 是否允许跨域
        changeOrigin: true,
        // 替换掉请求路径的/sougou为“”
        pathRewrite:{'^/api': ""}
      },
    }
  }
}
