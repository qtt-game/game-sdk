<?php
namespace QttGame;

class GameCenter
{
    private $app_id;
    private $app_key;
    private $host        = 'https://newidea4-gamecenter-backend.1sapp.com';
    private $userInfoUrl = '/x/open/user/ticket';
    private $queryUrl    = '/x/pay/union/order/query';

    public function __construct($app_id, $app_key)
    {
        $this->app_id = $app_id;
        $this->app_key = $app_key;
    }

    public function getSign($params)
    {
        if (!isset($params['time']))
        {
            $params['time'] = time();
        }
        $params['app_key'] = $this->app_key;
        ksort($params, SORT_NATURAL);
        $sign = '';
        foreach ($params as $k => $v) {
            $sign .= $k . $v;
        }
        unset($params['app_key']);
        return md5($sign);
    }

    public function getUserInfo($ticket, $platform)
    {
        $params = [
            'app_id'   => $this->app_id,
            'platform' => $platform,
            'ticket'   => $ticket,
            'time'     => time(),
            'app_key'  => $this->app_key
        ];
        $sign = $this->getSign($params);
        $params['sign'] = $sign;
        $url = $this->host . $this->userInfoUrl . '?' . $this->getUrlParams($params);

        list($errno, $errmsg, $response) = $this->httpGet($url);
        if ($errno != 0)
        {
            return [
                'code'        => $errno,
                'message'     => $errmsg,
                'showErr'     => 0,
                'currentTime' => $params['time'],
                'data'        => []
            ];
        }
        return json_decode($response, true);
    }

    public function queryPay($trade_no, $open_id)
    {
        $params = [
            'trade_no'=> $trade_no,
            'app_id'  => $this->app_id,
            'open_id' => $open_id,
            'time'    => time(),
            'app_key' => $this->app_key
        ];
        $sign = $this->getSign($params);
        $params['sign'] = $sign;
        $url = $this->host . $this->queryUrl . '?' . $this->getUrlParams($params);

        list($errno, $errmsg, $response) = $this->httpGet($url);
        if ($errno != 0)
        {
            return [
                'code'        => $errno,
                'message'     => $errmsg,
                'showErr'     => 0,
                'currentTime' => $params['time'],
                'data'        => []
            ];
        }
        return json_decode($response, true);
    }

    private function getUrlParams($params)
    {
        $_data = [];
        foreach ($params as $k => $v) {
            $_data[] = $k . '=' . rawurlencode($v);
        }
        return implode('&', $_data);
    }

    private function httpGet($url, $timeout = 1)
    {
        $curl = curl_init();
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, 0);
        curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 0);
        curl_setopt($curl, CURLOPT_AUTOREFERER, 1);
        curl_setopt($curl, CURLOPT_NOSIGNAL, 1);
        if (defined('CURLOPT_CONNECTTIMEOUT_MS')) {
            curl_setopt($curl, CURLOPT_CONNECTTIMEOUT_MS, 1000);
        } else {
            curl_setopt($curl, CURLOPT_TIMEOUT, 1);
        }
        if (defined('CURLOPT_TIMEOUT_MS')) {
            curl_setopt($curl, CURLOPT_TIMEOUT_MS, $timeout * 1000);
        } else {
            curl_setopt($curl, CURLOPT_TIMEOUT, ceil($timeout));
        }
        curl_setopt($curl, CURLOPT_HEADER, 0);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
        $errno = 0;
        $errmsg = '';
        $response = curl_exec($curl);

        if ($response === false) {
            $errno = curl_errno($curl);
            $errmsg = curl_error($curl);
        }
        @curl_close($curl);
        return [$errno, $errmsg, $response];
    }
}