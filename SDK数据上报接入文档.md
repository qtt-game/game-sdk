# SDK 上报接入


### 引入 sdk

#### 生产环境 

```
<script type="text/javascript" src="//newidea4-gamecenter-frontend.1sapp.com/sdk/prod/h5.v1.0.0.js"></script>
```

调用示例：

 1.成功完成加载
 ```
/**
@param app_id { String} [必填]
@param open_id {String} [必填]
@param game_name {String} [必填] 游戏名称
@param extend_info  [选填] json对象 {}

**/
// 示例
qttGame.loadComplete({open_id:111, app_id:222, game_name:'哈哈哈',extend_info:{time:'1000'}})
```

2.新增创角

```
/**
@param game_role { String} [必填] 游戏角色
@param game_region { String} [必填] 游戏所属区域
@param extend_info  [选填] json对象 {}

**/
// 示例
qttGame.addNewRole({game_role:'大乔',game_region:'区域1',extend_info:{level:'10'}})
```

3.新增用户

```
/**
@param user_name { String} [必填] 用户名称
@param game_region { String} [必填] 游戏所属区域
@param extend_info  [选填] json对象 {}

**/
// 示例
qttGame.addNewUser({user_name:'趣友30001',game_region:'区域2',extend_info:{age:'18'}})
```

4.用户游戏信息

```
/**
@param role { String} [必填] 角色名称
@param region { String} [必填] 游戏区
@param level { int} [必填] 等级
@param extend_info  [选填] json对象 {}
**/
// 示例
qttGame.userInfo({role:'孙悟空',region:'区域1',level:'100',extend_info:{age:'18'}})

```
5.点击支付 集成在qttGame.pay()里面  如果想额外多传一些信息 就直接加在ext里面即可
```
/**
@param money { String} [必填] 多少钱
@param ext  [选填] 额外信息
**/
// 示例
qttGame.pay({money:'300'})

```

5.游戏异常

```
/**
@param message { String} [必填] 异常信息
@param extend_info  [选填] json对象 {}

**/
// 示例
qttGame.abnormalGame({message:'验证失败',extend_info:{code:'-1'}})
```
