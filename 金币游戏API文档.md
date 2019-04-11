# Note:
找商务申请金币cointype，sceneid以及设置金币风控
# 金币操作
注意：签名算法、环境地址可在[趣头条游戏中心接入文档](趣头条游戏中心接入文档.md)查看！

### 增加金币

地址 ： /x/open/coin/add

请求方式 ：POST

提交数据方式 ：x-www-form-urlencoded，不支持json

| key       | 必选 | 类型   | 说明         |
| :-------- | :--- | :----- | ------------ |
| app_id    | true | string | 项目 id      |
| open_id    | true | string | 用户在当前项目内的唯一标示       |
| coin_num       | true | int    | 增加金币数目 |
| trade_no | true | string | 订单号 |
| sign      | true | string | 签名                       |

返回示例

```
{
  "code": 0,
  "message": "",
  "showErr": 0,
  "currentTime": 0,
  "data": {
   
  }
}
```



### 扣减金币

地址 ：/x/open/coin/sub

请求方式 ：POST

提交数据方式 ：x-www-form-urlencoded，不支持json

| key       | 必选 | 类型   | 说明                       |
| :-------- | :--- | :----- | -------------------------- |
| app_id    | true | string | 项目 id                    |
| open_id    | true | string | 用户在当前项目内的唯一标示       |
| coin_num       | true | int    | 扣减金币数目               |
| trade_no | true | string | 订单号 |
| sign      | true | string | 签名                       |

返回示例

```
{
  "code": 0,
  "message": "",
  "showErr": 0,
  "currentTime": 0,
  "data": {
   
  }
}
```