# 签名
注意：签名算法、环境地址可在[趣头条游戏中心接入文档](趣头条游戏中心接入文档.md)查看！

## 获取用户的好友列表

地址 ： /x/open/member-info

请求方式 ：POST

### request

提交数据方式 ：x-www-form-urlencoded，不支持json

| key       | 必选 | 类型   | 说明         |
| :-------- | :--- | :----- | ------------ |
| app_id    | true | string | 项目 id      |
| open_id    | true | string | 用户在当前项目内的唯一标示       |
| sign      | true | string | 签名                       |

### response


| key        | 类型   | 说明         |
| :--------  | :----- | ------------ |
| members    | list | 好友列表      |
| uid    | int64 | 用户在游戏中心的唯一id      |
| avatar    | string | 用户头像      |
| nickname    | string | 用户昵称      |
| sign       | string | 签名         |

返回示例：

```json
{
    "code":0,
    "message":"",
    "showErr":0,
    "currentTime":0,
    "data":{
        "members":[
            {
                "uid":248019,
                "user_info":{
                    "avatar":"http://static.1sapp.com/image/p/2017/05/19/1495187830605523.jpg",
                    "nickname":"趣友100339"
                }
            },
            {
                "uid":250238,
                "user_info":{
                    "avatar":"http://static.1sapp.com/image/p/2017/05/19/1495187830605523.jpg",
                    "nickname":"趣友6121183"
                }
            },
            {
                "uid":247985,
                "user_info":{
                    "avatar":"http://static.1sapp.com/image/p/2017/05/19/1495187830605523.jpg",
                    "nickname":"趣友6120898"
                }
            },
            {
                "uid":247965,
                "user_info":{
                    "avatar":"http://static.1sapp.com/image/p/2017/05/19/1495187830605523.jpg",
                    "nickname":"趣友6120894"
                }
            }
        ]
    }
}
```
