import { genSign } from "./_sign";
import { get } from "./_http";

export function getUserInfo(appkey, app_id, ticket, platform) {
    let url = "https://newidea4-gamecenter-backend.1sapp.com/x/open/user/ticket";
    let time = Math.floor(Date.now() / 1000);
    let sign = genSign({ app_id, platform, ticket, time }, appkey);
    return get(url, { params: { app_id, platform, ticket, time, sign } }).then(res => {
        if (res && res.data && res.data.code == 0) {
            return res.data;
        }
        throw res.data;
    });
}

export function queryOrder(appkey, app_id, open_id, trade_no) {
    let url = "https://newidea4-gamecenter-backend.1sapp.com/x/pay/union/order/query";
    let time = Math.floor(Date.now() / 1000);
    let sign = genSign({ trade_no, app_id, open_id, time }, appkey);
    return get(url, { params: { trade_no, app_id, open_id, time, sign } }).then(res => {
        if (res && res.data && res.data.code == 0) {
            return res.data;
        }
        throw res.data;
    });
}
