# PHPSDK

### 引入方式

1. composer

   ```
   composer require qtt/game-center
   ```

   

2. 直接引入

   引入 src 目录下 QttGame.php 文件

### 使用
#### 获取签名

```php
$obj = new QttGame\GameCenter();
$params = [
    'k1' => 'v1',  //业务参数
    'k2' => 'v2',   //业务参数
    'k3' => 'v3',   //业务参数 
    'time' => time(),  //必填，当前时间戳
    'app_key' => 'xxx'   //必填，app_key
];
$sign = $obj->getSign($params);
```

#### 获取用户信息

```php 
$obj = new QttGame\GameCenter();
$ticket = 'xxx';
$platform = 'xxx';
$app_id = 'xxx';
$app_key = 'xxx';
$result = $obj->getUserInfo($ticket, $platform, $app_id, $app_key);
```

$result 返回示例

```php
[
    'code'        => 0,
    'message'     => "success",
    'showErr'     => 0,
    'currentTime' => 1552469206,
    'data'        => [
        "open_id" => "",
    	"nickname" => "",
    	"avatar" => ""
    ]
];
```

#### 查询订单状态

```json
$obj = new QttGame\GameCenter();
$trade_no = 'xxx';
$open_id = 'xxx';
$app_id = 'xxx';
$app_key = 'xxx';
$result = $obj->queryPay($trade_no, $open_id, $app_id, $app_key);
```

$result 返回示例

```php
[
    'code'        => 0,
    'message'     => "success",
    'showErr'     => 0,
    'currentTime' => 1552469206,
    'data'        => [
        "trade_no" => "",
    	"total_fee" => 0,
    	"status" => 1
    ]
];
```



