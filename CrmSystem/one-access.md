# 认证中心接口文档

### 返回数据结构说明
除接口异常，所有接口均为以下数据结构
参数名 | 参数值 | 注释
---|---|---
code | 200 | 请求结果编码
success | true | 是否请求成功
msg | 操作成功 | 请求信息
data | {"id": "1",...} | 结果数据

## 1、登录接口
***<a id= "result">登录接口请求结果及示例</a>***
参数名 | 参数值 | 注释
---|---|---
access_token | eyJhbGciOiJ... | 访问令牌
token_type | bearer | token类型
refresh_token | eyJhbGciO... | 用于获取新的访问令牌的刷新令牌
expires_in | 3600 | 访问令牌的生存期(以秒为单位)。例如3600表示访问令牌将在响应时间1小时后过期
scope | all | 访问令牌的作用域
role_name | 管理员 | 登录用户在认证中心拥有的角色名称
license | powered by stjt | 访问令牌许可证
user_id | 5 | 访问令牌许可证
role_id | 1 | 访问令牌许可证
app_zone_id | gov-gate-pass | 应用在认证中心中注册后生成的应用id
oauth_id | “” | 第三方认证id
nick_name | gov-gate-pass | 登录用户昵称
avatar | “” | 登录用户头像
detail | {"type": "web"}, | 额外信息
dept_id | “” | 登录用户部门id
account | admin | 登录用户账号
level | LV1 | 用户认证等级
jti | dfbcc91a... | token唯一标识
device_id | 123... | 登录设备唯一标识
***请求结果示例***

```
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ0ZXN0X3piIiwicmVhbF9uYW1lIjoi5YWa5bu65YWI6ZSLIiwiYXZhdGFyIjoiIiwiY2xpZW50X2lkIjoiZ292LWdhdGUtcGFzcyIsInJvbGVfbmFtZSI6IiIsImxpY2Vuc2UiOiJwb3dlcmVkIGJ5IHN0anQiLCJhdWQiOlsiNiJdLCJ1c2VyX2lkIjoiNSIsInJvbGVfaWQiOiIiLCJzY29wZSI6WyJhbGwiXSwiYXBwX3pvbmVfaWQiOiJnb3YtZ2F0ZS1wYXNzIiwib2F1dGhfaWQiOiIiLCJkZXRhaWwiOnsidHlwZSI6IndlYiJ9LCJleHAiOjE2NDk0MDQ5NzAsImRlcHRfaWQiOiIxIiwianRpIjoiZGZiY2M5MWEtNWY0OS00ZmRkLTlkN2UtOTMyOWEyNjE3NDk1IiwiYWNjb3VudCI6InRlc3RfemIifQ.33digbrHmaRBmEQj8K1tTlrOrdsE-wdkIJKnG0r1nB8",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ0ZXN0X3piIiwicmVhbF9uYW1lIjoi5YWa5bu65YWI6ZSLIiwiYXZhdGFyIjoiIiwiY2xpZW50X2lkIjoiZ292LWdhdGUtcGFzcyIsInJvbGVfbmFtZSI6IiIsImxpY2Vuc2UiOiJwb3dlcmVkIGJ5IHN0anQiLCJhdWQiOlsiNiJdLCJ1c2VyX2lkIjoiNSIsInJvbGVfaWQiOiIiLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiZGZiY2M5MWEtNWY0OS00ZmRkLTlkN2UtOTMyOWEyNjE3NDk1IiwiYXBwX3pvbmVfaWQiOiJnb3YtZ2F0ZS1wYXNzIiwib2F1dGhfaWQiOiIiLCJkZXRhaWwiOnsidHlwZSI6IndlYiJ9LCJleHAiOjE2NDk0MzczNzAsImRlcHRfaWQiOiIxIiwianRpIjoiYTdkNjE2MTMtNjJiMC00ZDAxLWIxNDAtZjRjZGU1YzcxMDZmIiwiYWNjb3VudCI6InRlc3RfemIifQ.CdSvyZ_VAgVeBU9GbIMsDVsIash9-WXl0L3rGBUF75M",
    "expires_in": 3600,
    "scope": "all",
    "role_name": "",
    "license": "powered by stjt",
    "user_id": "5",
    "role_id": "",
    "app_zone_id": "gov-gate-pass",
    "oauth_id": "",
    "real_name": "党建先锋",
    "avatar": "",
    "detail": {
        "type": "web"
    },
    "dept_id": "1",
    "account": "test_zb",
    "level": "LV1",
    "device_id": "12345600",
    "jti": "dfbcc91a-5f49-4fdd-9d7e-9329a2617495"
}
```

### 1.1、用户名密码登录
**请求地址** ：[http://192.168.5.54:5000/one-access/oauth/token]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
account | admin/13888888888 | 用户名或电话号码
password | admin123 | 密码
grant_type | captcha | 认证类型（验证码）
scope | all | 认证范围

***请求结果***

**见 [登录接口请求结果及示例](#result)**


### 1.2、短信验证码登录
#### 1.2.1 发送短信验证码
**请求地址**：[/one-access/auth/smsCode]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码


***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
phoneNum | 13888888888 | 手机号码

***请求结果***
参数名 | 参数值 | 注释
---|---|---
code | 200 | 请求结果编码
success | true | 是否请求成功
msg | 操作成功 | 请求信息
data | {"isRegister": "false",...} | 结果数据
isRegister | false | 是否为首次注册登录
uniId | 1649832402498 | 验证码唯一标识

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "isRegister": false,
        "uniId": 1649832402498
    },
    "msg": "操作成功"
}
```
#### <a id= "codeLogin">1.2.2 使用短信验证码登录</a>

**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
phoneNum | 13888888888 | 手机号码
captcha | 319755 | 用户输入验证码
uniId | 1649832402498 | 验证码唯一标识（接口2.1返回）
grant_type | smsCode | 认证类型（短信验证码）
scope | all | 认证范围
userOauthId | 122... | 第三方用户信息id，三方用户登录绑定手机号时传入

***请求结果***
***见 [登录接口请求结果及示例](#result)***


### 1.3、使用refresh_token登录
**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
grant_type | refresh_token | 认证类型（验证码）
refresh_token | eyJhbGci... | 刷新token

***请求结果***
***见 [登录接口请求结果及示例](#result)***

### 1.4、手机号码一键登录（助通SDK）
**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST


***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
grant_type | oneLogin | 认证类型（一键登录）
process_id | dstwe... | 闪验流程id（一键登录sdk返回）
token | tewsd... | 闪验token（一键登录sdk返回）
authcode | hsdy... | 闪验认证码（一键登录sdk返回）

***请求结果***
***见 [登录接口请求结果及示例](#result)***

### 1.5、互联网平台第三方用户登录
**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST


***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
grant_type | social | 认证类型（第三方登录）
source | WECHAT_OPEN | 第三方登录方式编码，见下表
code | tewsd... | 第三方登录SDK获取的认证码

***互联网平台第三方登录方式编码***
平台名称 | 编码 
---|---
百度 | BAIDU
支付宝 | ALIPAY
QQ | QQ
微信 | WECHAT_OPEN
抖音 | DOUYIN

***登录成功结果***
***见 [登录接口请求结果及示例](#result)***

***登录失败结果说明***

* 用户首次使用三方账号进行登录，则需要绑定本地账号才能登录成功，此时接口将返回错误码 40013，如下：
```
{
    "code": 40013,
    "success": false,
    "data": null,
    "msg": "124"
}
```
客户端接收到此错误信息，应跳转至手机验证码绑定账号页面，并携带返回信息中的“msg”字段（三方认证信息id），并调用  ***[验证码登录接口](#codeLogin)*** 进行登录

### 1.6 微信小程序登录
#### 1.6.1 获取微信用户公开信息


**请求地址**：[/one-access/wechatMini/getOpenInfo]()
**请求方式**：POST


***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
code | dst... | 小程序api接口获取

***请求结果***
参数名 | 参数值 | 注释
---|---|---
unionid | sgds23... | 微信开放平台用户唯一id
isRegister | false | 用户是否已注册

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
         "unionid": "sgds23...",
         "isRegister": false,
    },
    "msg": ""
}
```

#### 1.6.2 微信小程序手机号登录

**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码
device_id | 123... | 登录设备唯一标识

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
grant_type | wechatMini | 认证类型（微信小程序登录）
unionid | sgds23... | 接口1.6.1获取
code | tewsd... | 换取手机号的code, 微信小程序api获取

***登录成功结果***
***见 [登录接口请求结果及示例](#result)***

### 1.7 三方应用登录
**接口描述**：基于Oauth2协议，授权码模式进行登录

#### 1.7.1 获取授权码


**请求地址**：[/one-access/oauth/authCode]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
appZoneId | lze-market | 三方应用入驻认证中心授予的应用id

***请求结果***
参数名 | 参数值 | 注释
---|---|---
authCode | sgds23... | 认证授权码

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
         "oauthCode": "sgds23..."
    "msg": ""
}
```

#### 1.7.2 三方应用授权码登录

**请求地址**：[/one-access/oauth/token]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
grant_type | oauthCode | 认证类型（授权码模式登录）
oauthCode | sgds23... | 授权码接口1.7.1获取

***登录成功结果***
***见 [登录接口请求结果及示例](#result)***

#### 1.7.3 三方应用授权码登录后新增用户推送至认证中心

**请求地址**：[/one-access/oauth/bindThirdId]()
**请求方式**：POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
ThirdId | 22 | 三方用户主键

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {},
    "msg": "操作成功"
}
```


## 2、实名认证人脸核身相关接口

#### 2.1 检测身份证号是否已绑定账号
**请求地址**：[/one-access/certification/checkIdNumRepeat]()
**请求方式**：GET

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
realName | 张三 | 用户真实姓名
identifyCardNum | 51052319880... | 用户身份证号码

***请求结果***
参数名 | 参数值 | 注释
---|---|---
data | true | true:身份证号已绑定账号，false:身份证号未绑定账号

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": true,
    "msg": "身份证号已绑定账号！"
}
```

#### 2.2 腾讯云人脸核身SDK请求参数接口
**请求地址**：[/one-access/certification/getFaceParam]()
**请求方式**：GET

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***
参数名 | 参数值 | 注释
---|---|---
realName | 张三 | 用户真实姓名，可选，进行实名认证时传递
identifyCardNum | 51052319880... | 用户身份证号码，可选，进行实名认证时传递

***请求结果***
参数名 | 参数值 | 注释
---|---|---
faceId | twe532fsd | 此次刷脸用户标识
orderNo | order12324.. | 订单号
appId | IDAFOnTC | 人脸核身平台提供应用id
version | 1.0.0 | openapi  Version
nonce | g34gat43... | 32位随机字符串
userId | 13423... | 生成的用户id32位
sdkSign | ds23... | 签名信息
KEY_LICENCE | 432fd... | 人脸核身平台提供票据

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "faceId": "tx12203e1cb380a1b0bf9606c944b9f7",
        "orderNo": "bSCHMTiBCA00gMRK0hqo24Z1uVScGTrR",
        "appId": "IDAFOnTC",
        "version": "1.0.0",
        "nonce": "SJp7sRby4JOalyMHysWJIEmAtEVc2d03",
        "userId": "WbFaceVerifyAll1650543761402",
        "sdkSign": "491B7CE2C965E4FD403696649C0E63024CBE67DA",
        "KEY_LICENCE": "OVonIZVWE8jzlBWplEQbOTawawmL0vJZ4xXCf8hCASl75KBfstXLF1w3YXCOXTdM"
    },
    "msg": "操作成功"
}
```
#### 2.3 腾讯云人脸核身结果校验接口
**请求地址**：[/one-access/certification/checkCertifyResult]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
orderNo | TX343... | 人脸核身订单号
realName | 张三 | 用户真实姓名，可选，进行实名认证需要保存实名信息时传递
identifyCardNum | 51052319880... | 用户身份证号码，可选，进行实名认证需要保存实名信息时传递

***请求结果***

参数名 | 参数值 | 注释
---|---|---
orderNo | TX343... | 人脸核身订单号
realName | 张三 | 用户真实姓名
identifyCardNum | 51052319880... | 用户身份证号码

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "orderNo": "bSCHMTiBCA00gMRK0hqo24Z1uVScGTrR",
        "realName": "张三",
        "identifyCardNum": "51052319880",
    },
    "msg": "操作成功"
}
```

#### 2.4 保存用户实名认证信息
**请求地址**：[/one-access/certification/saveCertifyInfo]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
orderNo | TX343... | 人脸核身订单号，接口2.3返回

***请求结果***

参数名 | 参数值 | 注释
---|---|---
orderNo | TX343... | 人脸核身订单号
realName | 张三 | 用户真实姓名
identifyCardNum | 51052319880... | 用户身份证号码

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "orderNo": "bSCHMTiBCA00gMRK0hqo24Z1uVScGTrR",
        "realName": "张三",
        "identifyCardNum": "51052319880",
    },
    "msg": "操作成功"
}
```

## 3、查询用户信息相关接口

### 3.1 获取用户基础信息
**请求地址**：[/one-access/userAuthInfo/baseInfo]()
**请求方式**：GET

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token


***请求结果数据***
参数名 | 参数值 | 注释
---|---|---
id | 1 | 用户id
account | admin | 用户账号
nickName | 管理员 | 昵称
avatar | “” | 用户头像
sex | 1 | 1:男，2：女，3：未知
email | 66666@qq.com | 邮箱
phone | 158****2190 | 电话（脱敏）
birthday | 2021-12-8 | 生日
level | LV1 | 用户认证等级

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "id": "1",
        "account": "admin",
        "nickName": "管理员",
        "realName": "政务管理员",
        "avatar": "",
        "sex": 0,
        "email": "66666@qq.com",
        "phone": "158****2190",
        "birthday": "2021-12-8",    
        "level": "LV1",
    },
    "msg": "操作成功"
}
```


### 3.2 获取用户隐私信息
**请求地址**：[/one-access/userAuthInfo/privateInfo/{infoType}]()
**请求方式**：GET

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求地址栏参数***
参数名 | 参数值 | 注释
---|---|---
infoType | phoneNum\idNum | phoneNum：获取手机号,idNum：获取实名信息

***请求结果***
* ***获取手机号：***

参数名 | 参数值 | 注释
---|---|---
id | 1 | 用户id
phoneNum | admin | 用户账号

* ***获取实名信息：***

参数名 | 参数值 | 注释
---|---|---
id | 1 | 用户id
idNum | 5105215648... | 用户身份证号
realName | 管理员 | 用户真实姓名


***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "id": 1,
        "idNum": "",
        "realName": "政务管理员"
    },
    "msg": "操作成功"
}
```

## 4、修改用户信息相关接口

### 4.1 修改用户基础信息
**请求地址**：[/one-access/userAuthInfo/updateInfo/{infoType}]()
**请求方式**：  POST

***请求头***
参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求地址栏参数***
参数名 | 参数值 | 注释
---|---|---
infoType | nickName | 昵称
infoType | avatar | 头像
infoType | email | 邮箱
infoType | birthday | 生日
infoType | sex | 性别：0:男，1：女，2：未知

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
newValue | 0/1996-6-5 | 更新后的值，根据infoType传递对应数据

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {},
    "msg": "操作成功"
}
```

### 4.2 发送短信验证码

**接口描述**：用于已登录状态重置密码，修改手机号时校验原手机号，绑定新手机号

**请求地址**：[/one-access/userAuthInfo/sendSms]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
codeType | smsUpPhoneOld | 发送验证码类型，见下表
phoneNum | 13888888888 | 手机号，仅在绑定新手机号发验证码时传入
ticket | 324124121 | 临时票据，接口4.3返回，仅在绑定新手机号发验证码时传入

***表 4.2.1 短信验证码类型***
编码 | 描述 
---|---
smsUpPhoneOld | 校验原手机号验证码
smsUpPhoneNew | 绑定新手机号验证码
smsResetPwd | 重置用户密码验证码
smsRetrievePwd | 用户找回密码

***请求结果***

参数名 | 参数值 | 注释
---|---|---
uniId | 1651919518971 | 当前用户验证码唯一id，校验验证码时传递

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "uniId": "1651919518971"
    },
    "msg": "操作成功"
}
```

### 4.3 校验短信验证码

**接口描述**：重置密码、修改手机号校验原号码，使用此接口

**请求地址**：[/one-access/userAuthInfo/checkSourceSmsCode]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
captcha | 424624 | 用户输入验证码
uniId | 324124121 | 验证码唯一标识
codeType | smsUpPhoneOld | 发送验证码类型，见表 4.2.1

***请求结果***

参数名 | 参数值 | 注释
---|---|---
ticket | 1651919518971 | 临时票据，用于绑定新手机号发送验证码、重置密码时传递

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "ticket": "1652071895354"
    },
    "msg": "操作成功"
}
```

### 4.4 绑定新手机号

**接口描述**：校验验证码并绑定新手机号

**请求地址**：[/one-access/userAuthInfo/bindNewPhone]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
phoneNum | 13666666666 | 新手机号码
captcha | 424624 | 用户输入验证码
uniId | 324124121 | 验证码唯一标识
codeType | smsUpPhoneOld | 验证码类型，见表 4.2.1

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {},
    "msg": "更新成功！"
}
```

### 4.5 重置用户密码（已登录状态）

**接口描述**：校验验证码并绑定新手机号

**请求地址**：[/one-access/userAuthInfo/resetPwd]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | bearer eyJhbGciOi... | eyJhbGciOi...为 access_token

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
ticket | 13666666666 | 临时票据，接口4.3返回
password | 123456 | 用户输入新密码


***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": true,
    "msg": "操作成功"
}
```

### 4.6 找回密码（未登录状态）
**接口描述**：用户登陆时忘记密码，需找回密码

#### 4.6.1 找回密码发送短信验证码

**接口描述**：用于输入账号绑定手机号，发送短信验证码

**请求地址**：[/one-access/retrieve/sendSms]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
codeType | smsRetrievePwd | 发送验证码类型，固定，用户找回密码
phoneNum | 13888888888 | 手机号，用户输入账号绑定的手机号



***请求结果***

参数名 | 参数值 | 注释
---|---|---
uniId | 1651919518971 | 当前用户验证码唯一id，校验验证码时传递

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "uniId": "1651919518971"
    },
    "msg": "操作成功"
}
```

#### 4.6.2 找回密码校验短信验证码

**请求地址**：[/one-access/retrieve/checkSmsCode]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
captcha | 424624 | 用户输入验证码
uniId | 324124121 | 验证码唯一标识
codeType | smsRetrievePwd | 发送验证码类型，固定，用户找回密码
phoneNum | 13888888888 | 手机号，用户输入账号绑定的手机号

***请求结果***

参数名 | 参数值 | 注释
---|---|---
ticket | 1651919518971 | 临时票据，用于设置新密码时传递

***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": {
        "ticket": "1652071895354"
    },
    "msg": "操作成功"
}
```

#### 4.6.3 设置用户新密码

**请求地址**：[/one-access/retrieve/retrievePwd]()
**请求方式**：POST

***请求头***

参数名 | 参数值 | 注释
---|---|---
Authorization | Basic Z292LWdhdGU... | Z292LWdhdGU...为 （应用id:应用密钥） 转换为Base64编码

***请求表单参数***

参数名 | 参数值 | 注释
---|---|---
phoneNum | 13888888888 | 手机号，用户输入账号绑定的手机号
ticket | 13666666666 | 临时票据，接口4.6.2返回
password | 123456 | 用户输入新密码


***请求结果示例***

```
{
    "code": 200,
    "success": true,
    "data": true,
    "msg": "操作成功"
}
```


## 错误码


***系统错误码（部分）***

错误码 | 错误编码 | 错误原因
---|---|---
400 | FAILURE | 未明确的业务错误
400 | PARAM_MISS | 缺少必要的请求参数
400 | PARAM_VALID_ERROR | 参数校验失败
401 | UN_AUTHORIZED | 请求未授权
500 | INTERNAL_SERVER_ERROR | 未知的服务器异常


***登录认证错误码***

* **鉴权错误 （40001 - 40009）**

错误码 | 错误编码 | 错误原因
---|---|---
40001 | CROWD_OUT_LINE_ERROR | 账号已在其它设备登录！


* **数据校验错误（40010 - 40019）**

错误码 | 错误编码 | 错误原因
---|---|---
40010 | PHONE_NUM_ERROR | 手机号码格式错误！
40011 | INVALID_TOKEN_ERROR | token已失效！
40012 | INVALID_REFRESH_TOKEN_ERROR | refresh_token已失效！
40013 | SOCIAL_NO_BIND_ACCOUNT | 第三方用户未绑定账号！
40014 | PHONE_REPEAT_BIND | 该手机号码已被使用！

* **用户操作错误（40040 - 40059）**

错误码 | 错误编码 | 错误原因
---|---|---
40040 | USER_PASS_ERROR | 用户名或密码错误
40041 | SMS_CODE_ERROR | 验证码输入错误

* **系统错误 （50010 - 50019）**

错误码 | 错误编码 | 错误原因
---|---|---
50010 | SYSTEM_ERROR | 系统错误
50011 | PHONE_NUM_REQUEST_ERROR | 手机号码请求错误
50012 | USER_FACE_RESULT_SAVE_ERROR | 用户实名认证信息保存错误
50013 | SOCIAL_BIND_USER_INFO_ERROR | 第三方用户绑定账号信息异常
50014 | USER_INFO_UPDATE_ERROR | 用户信息更新错误

* **外部错误 （50050 - 50059）**

错误码 | 错误编码 | 错误原因
---|---|---
50050 | TENCENT_CLOUD_TOKEN_ERROR | 腾讯云token查询失败
50051 | TENCENT_CLOUD_SIGNTICKET_ERROR | 腾讯云api获取signTicket失败
50052 | TENCENT_CLOUD_FACEID_ERROR | 腾讯云api获取faceId失败
50055 | TENCENT_CLOUD_RESULT_ERROR | 人脸认证错误

***用户信息错误码***
* **用户信息错误 （40060 - 40069）**

错误码 | 错误编码 | 错误原因
---|---|---
40060 | USER_NO_CERTAIN | 用户未实名认证
40061 | USER_NO_PHONE_NUM | 用户未绑定手机号码
40062 | USER_NOT_SET_PWD | 用户未设置账号密码

* **系统错误 （50020 - 50029）**

错误码 | 错误编码 | 错误原因
---|---|---
50021 | USER_INFO_SAVE_ERROR | 用户信息保存错误
50022 | QUERY_USER_INFO_ERROR | 查询用户信息错误
