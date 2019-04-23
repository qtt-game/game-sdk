# JSSDK

## 获取用户信息
```js
const QTTGame = require("./dist/jssdk-1.0.0");

var appkey = "xxx";
var app_id = "xxx";
var platform = "xxx";
var ticket = "XXX";
QTTGame.getUserInfo(appkey, app_id, ticket, platform).then(res => {
    // 成功
}).catch(err => {
    // 失败
})
```

## 查询订单状态

```js
const QTTGame = require("./dist/jssdk-1.0.0");

var appkey = "xxx";
var app_id = "xxx";
var open_id = "xxx";
var trade_no = "xxx";
QTTGame.queryOrder(appkey, app_id, open_id, trade_no).then(res => {
    // 成功
}).catch(err => {
    // 失败
})
```

## 添加金币

```js
const QTTGame = require("./dist/jssdk-1.0.0");

var appkey = "xxx";
var app_id = "xxx";
var open_id = "xxx";
var coin_num = xxx; // 不小于0的数字
var trade_no = "xxx";

// 参数均为必填
QTTGame.coinAdd(appkey, app_id, open_id, coin_num, trade_no).then(res => {
    // 成功
}).catch(err => {
    // 失败
})
```

coinAdd()方法返回Promise

## 扣减金币

```js
const QTTGame = require("./dist/jssdk-1.0.0");

var appkey = "xxx";
var app_id = "xxx";
var open_id = "xxx";
var coin_num = xxx; // 不小于0的数字
var trade_no = "xxx";

// 参数均为必填
QTTGame.coinSub(appkey, app_id, open_id, coin_num, trade_no).then(res => {
    // 成功
}).catch(err => {
    // 失败
})
```

coinSub()方法返回Promise

## Development
* make sure node and npm installed;
* clone the repo to local;
* run `npm install` to install node modules;
* run `npm run build` to get an *unminified* build file at `dist` folder;


