# OAuth
## 调用接口
用户认证时访问:
https://github.com/login/oauth/authorize?client_id=7dbe5073bd774dfb4817
之后会跳转到github登陆的界面，认证一个oauth。
## 回调
Github会回调我们的接口，然后产生一个token。这个token被我保存在用户的cookie里。
## 后续认证
检查用户token。
