# JSSDK

## 使用说明
获取用户信息
```js
var appkey = "xxx";
var app_id = "xxx";
var platform = "xxx";
var ticket = "XXX";
QTTGame.getUserInfo(appkey, app_id, ticket, platform).then(res => {
    document.getElementById("output").innerHTML = JSON.stringify(res)
}).catch(err => {
    document.getElementById("output").innerHTML = JSON.stringify(err)
})
```
查询订单状态
```js
var appkey = "xxx";
var app_id = "xxx";
var open_id = "xxx";
var trade_no = "xxx";
QTTGame.queryOrder(appkey, app_id, open_id, trade_no).then(res => {
    document.getElementById("output").innerHTML = JSON.stringify(res)
}).catch(err => {
    document.getElementById("output").innerHTML = JSON.stringify(err)
})
```

## Getting started
* make sure node and npm installed;

## Development
* make sure node and npm installed;
* clone the repo to local;
* run `npm install` to install node modules;
* run `npm run build` to get an *unminified* build file at `dist` folder;


