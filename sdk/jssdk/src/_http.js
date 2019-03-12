import http from 'axios'

http.defaults.timeout = 2000;

export const get = (url, opts) => {
    return http.get(url, opts)
}