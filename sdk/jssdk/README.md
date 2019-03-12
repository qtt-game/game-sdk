# JSSDK

获取用户信息
```js
const QTTGame = require("./jssdk-1.0.0");
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
查询订单状态
```js
const QTTGame = require("./jssdk-1.0.0");
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

## Development
* make sure node and npm installed;
* clone the repo to local;
* run `npm install` to install node modules;
* run `npm run build` to get an *unminified* build file at `dist` folder;


