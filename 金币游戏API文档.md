# Note:
找商务申请金币cointype，sceneid以及设置金币风控

## 金币操作
注意：签名算法、环境地址可在[趣头条游戏中心接入文档](趣头条游戏中心接入文档.md)查看！

## 注意事项
- ①金币游戏，扣除金币额和赠送金币额必须为能整除6的自然数
- ②扣除趣头条金币时，须有二次弹框确认，说明消耗的是趣头条金币
- ③游戏测试前须找商务申请金币cointype，sceneid，报备金币增减项及数量
- ④普通趣头条用户只有几千金币，金币只能通过趣头条活跃获得
- ⑤10000金币=1元rmb

## 增加金币

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

返回示例：

```json
{
    "code":0,
    "message":"",
    "showErr":0,
    "currentTime":0,
    "data":{

    }
}
```

## 扣减金币

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

```json
{
    "code":0,
    "message":"",
    "showErr":0,
    "currentTime":0,
    "data":{

    }
}
```

## 查询金币

地址 ：/x/open/coin/balance

请求方式 ：POST

提交数据方式 ：x-www-form-urlencoded，不支持json

| key       | 必选 | 类型   | 说明                       |
| :-------- | :--- | :----- | --------------------------|
| app_id    | true | string | 项目 id                    |
| open_id    | true | string | 用户在当前项目内的唯一标示    |
| sign      | true | string | 签名                       |

返回示例

```json
{
    "code":0,
    "message":"",
    "showErr":0,
    "currentTime":0,
    "data":{
		"coin_balance":10000
    }
}
```
