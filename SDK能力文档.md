# SDK 能力文档

---

SDK 提供了获取一些 H5 api 中读取不到的信息的能力

使用方法：

1. [接入 SDK](./SDK接入步骤.md#引入_sdk)
2. 使用能力
---
## 列表：

- qttGame.systemInfo
- qttGame.openDialogMission

---
## API

### - qttGame.systemInfo

#### 描述：
SDK 在`qttGame`对象的`systemInfo`属性上暴露了一些设备相关的信息

#### 属性：

```javascript
qttGame.systemInfo <Object>
```

'qttgame.systemInfo'的属性：

| 属性名    | 类型    | 默认值 | 释义           |
| --------- | ------- | ------ | -------------- |
| brand     | String  | ''     | 手机品牌       |
| osVersion | String  | ''     | 系统版本       |
| model     | String  | ''     | 手机型号       |
| network   | String  | ''     | 当前网络状态   |
| isAndroid | Boolean | false  | 是否是安卓系统 |

#### Example:

```javascript
const {
  systemInfo: {
    brand = ''
  } = {
    brand: ''
  } = qttGame || {
    systemInfo: {
      brand: ''
    }
  }

  console.log(brand)
  // 'OPPO'
```
----

### - qttGame.openDialogMission

#### 描述:

##### 效果： 执行后会弹出SDK悬浮窗并进入任务tab

- 没有悬浮窗， 或者没有任务那个tab，或者如果是精简的悬浮窗，那么调用没反应，
同时控制台console会出一行提示：
  > ```javascript
  > "[qtt game sdk tip]: [qttGame.openDialogMission] 不符合任务弹出条件， 不弹出"
  >   ```
#### 属性:

```javascript
qttGame.openDialogMission void<function>
```

#### example:

```javascript
qttGame.openDialogMission();
```
---
