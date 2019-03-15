# JAVASDK

获取用户信息
```java
String appkey = "xxx";
String app_id = "xxx";
String platform = "xxx";
String ticket = "XXX";
String body = QTTGame.getUserInfo(appkey, app_id, ticket, platform);
// body
```
查询订单状态
```java
String appkey = "xxx";
String app_id = "xxx";
String open_id = "xxx";
String trade_no = "xxx";
String body = QTTGame.queryOrder(appkey, app_id, open_id, trade_no);
```


