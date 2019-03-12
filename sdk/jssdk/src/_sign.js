import md5 from "md5"

export function genSign(params, appKey) {
    delete params.sign;
    params.app_key = appKey;
    let keysArr = [];
    for (let key in params) {
        keysArr.push(key)
    }
    keysArr.sort();
    let keys = ''
    keysArr.forEach((e) => {
        keys += e;
        keys += params[e];
    });
    delete params.app_key;
    let sign = md5(keys);
    return sign;
}