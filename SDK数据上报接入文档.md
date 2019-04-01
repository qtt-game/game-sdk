# SDK 上报接入


### 引入 sdk

#### 生产环境 

```
<script type="text/javascript" src="//newidea4-gamecenter-frontend.1sapp.com/sdk/prod/h5.v1.0.0.js"></script>
```

调用示例：
 1.成功完成加载
/**
@param appId { String} [必填]
@param openId {String} [必填]
@param gameName {String} [必填] 游戏名称
@param extend_info {String} [选填] json对象 {}

**/
// 示例
qttGame.loadComplete({appId:111, openId:222, gameName:'哈哈哈',extend_info:{time:'1000'}})


2.新增创角
/**
@param gameRole { String} [必填] 游戏角色
@param extend_info {String} [选填] json对象 {}

**/
// 示例
qttGame.addNewRole({gameRole:'大乔',extend_info:{level:'10'}})


3.新增用户
/**
@param userName { String} [必填] 用户名称
@param extend_info {String} [选填] json对象 {}

**/
// 示例
qttGame.addNewUser({userName:'趣友30001',extend_info:{age:'18'}})


3.用户游戏信息
/**
@param role { String} [必填] 角色名称
@param region { String} [必填] 游戏区
@param level { int} [必填] 等级
@param extend_info {String} [选填] json对象 {}

**/
// 示例
qttGame.userInfo({role:'孙悟空',region:'区域1',level:'100',extend_info:{age:'18'}})


3.游戏异常
/**
@param message { String} [必填] 异常信息
@param extend_info {String} [选填] json对象 {}

**/
// 示例
qttGame.userInfo({message:'验证失败',extend_info:{code:'-1'}})
```
