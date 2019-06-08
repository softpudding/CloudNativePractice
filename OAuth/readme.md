# OAuth
## 调用接口
用户认证时访问:
https://github.com/login/oauth/authorize?client_id=7dbe5073bd774dfb4817
之后会跳转到github登陆的界面，认证一个oauth。
## OAuth处理
项目目录里新增的OAuth文件夹下面是我们的OAuth app。Controller里面的"/oauthcallback"是给github进行回调使用的，这个函数进一步获取并验证了用户的合法性。确认完毕，如果用户不合法将会抛出exception，用户如果合法，我们用一个post请求把相应的token发给wordladder需要的地方（我不知道应该是哪里，我写的是
```
https://localhost:8080/oauthtoken
```
## token的用处
1. 验证了用户。
2. 后续如果需要调用github的api，采用如下格式：
```
Authorization: token OAUTH-TOKEN
GET https://api.github.com/user
```
## 概括一下还需要做的事情
1. 在主页面加一个按钮，登陆键，替代security的作用。这个按钮导航指向https://github.com/login/oauth/authorize?client_id=7dbe5073bd774dfb4817。
2. 这里概述一下之后发生的事情。上述的那个链接会让用户进行认证，认证完会把一个code发到我oAuthController的oauthcallback的接口。这个接口会继续把这个code发给github认证，然后得到一个token（认证失败就得不到，抛出exception）。成功之后，我会把token转发给一个接口。
3. 上述接受token请求的暂定是https://localhost:8080/oauthtoken。你可以修改成别的你认为合适的端口。也就是说你需要写一个函数接受这个token，然后允许该用户进行后续的访问。