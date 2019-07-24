# CPC 游戏接入

### 接入步骤
> 1. 联系商务或运营申请app_id引入 sdk
> 2. 如果需要展示广告,联系商务在SDK中开通广告权限
> 3. [引入SDK](#引入-sdk)
> 4. [广告](./游戏广告接入文档.md),[支付](./游戏支付接入文档.md),[数据上报](./SDK数据上报接入文档.md) API 及用法参看对应[文档](./README.md)
> 5. 其他问题可以先参看[SDK Q&A文档](./SDK_Q&A.md)

### 引入 sdk

在HTML头部引入以下标签

```javascript
<script type="text/javascript" src="//newidea4-gamecenter-frontend.1sapp.com/sdk/prod/h5.v1.0.0.js?spread=required"></script>
```

> Tip: 务必将该标签放在HTML靠前位置加载, **禁止**动态加载, 务必在SDK加载完成后再调用`qttGame`的方法,否则可能出现`qttGame is not defined`的错误警告

### 浏览器中调试

1. 打开打开chrome的`Toggle device toolbar`
2. 在游戏地址后面加queryString`?app_id=xxxxx&_NO_BRIDGE_=true`
3. 刷新页面

> queryString加`app_id`保证 SDK 正确识别游戏,`_NO_BRIDGE_`使浏览器忽略桥接

> `app_id`联系商务或运营申请

> 如果游戏文件存在于本地, **禁止**以`ftp`协议打开游戏文件调试,只允许`http`或`https`方式的server中运行
