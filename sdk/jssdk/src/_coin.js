import axios from "axios";
import {
  genSign
} from "./_sign";

// 环境变量

const domain = "https://newidea4-gamecenter-backend.1sapp.com";

const urls = {
  coinAdd: `${domain}/x/open/coin/add`, // 金币增加
  coinSub: `${domain}/x/open/coin/sub` // 扣减金币
}
/**
 * 金币操作
 */

const _coinOperation = (
  api,
  appKey,
  app_id,
  open_id,
  coin_num,
  trade_no,
) => {
  let _appKey = appKey || "";
  let _appId = app_id || "";
  let _openId = open_id || "";
  let _coinNum = coin_num;
  let _tradeNo = trade_no || "";

  if (!_coinNum || Number.isNaN(_coinNum) || _coinNum < 0) {
    const tip = "jssdk error: 金币数额必须是不小于零的数字";
    console.error(tip);
    return Promise.reject(tip);
  }
  const params = {
    app_id: _appId,
    open_id: _openId,
    coin_num: _coinNum,
    trade_no: _tradeNo,
  };
  let flag = true;
  Object.entries(Object.assign(params,{appKey: _appKey})).forEach(([k, v]) => {
    if (["open_id", "coin_num", "trade_no", "sign"].includes(k) && !v) {
      console.error(`jssdk error: ${k} 不能为空。`);
      flag = false;
    }
  });

  let time = Math.floor(Date.now() / 1000);
  let sign = genSign(Object.assign(params,{time}), _appKey);
  if (!flag) return Promise.reject("jssdk error: 存在空置必填参数");
  // 发送请求
  let fd = new FormData()
  Object.entries(Object.assign(params,{sign})).forEach(([k, v]) => {
    fd.append(k, v)
  });
  return axios
    .post(api, fd, {
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
      },
      timeout: 2000
    })
    .then(res => {
      console.log(res);
      const resData = res.data || {};
      if (resData.code === 0) {
        // 扣减成功
        return  Promise.resolve(resData)
      }
      // 扣减失败
      return Promise.reject(resData)
    });
};

// 添加金币
export const coinAdd = (
  appKey,
  app_id,
  open_id,
  coin_num,
  trade_no,
) => _coinOperation(
  urls.coinAdd,
  appKey,
  app_id,
  open_id,
  coin_num,
  trade_no, );

// 扣减金币
export const coinSub = (
  appKey,
  app_id,
  open_id,
  coin_num,
  trade_no,
) => _coinOperation(
  urls.coinSub,
  appKey,
  app_id,
  open_id,
  coin_num,
  trade_no, );
