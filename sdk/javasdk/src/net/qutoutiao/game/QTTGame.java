package net.qutoutiao.game;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class QTTGame {

	/**
	 * 获取用户信息
	 * @param appkey
	 * @param app_id
	 * @param ticket
	 * @param platform
	 * @return
	 */
	public static String getUserInfo(String appkey, String app_id, String ticket, String platform) {
		String url = "https://newidea4-gamecenter-backend.1sapp.com/x/open/user/ticket";
		int time = (int) (System.currentTimeMillis() / 1000);
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_id", app_id);
		params.put("platform", platform);
		params.put("ticket", ticket);
		params.put("time", time + "");
		String sign = sign(params, appkey);
		params.put("sign", sign);
		return request(url, params);
	}

	/**
	 * 获取订单信息
	 * @param appkey
	 * @param app_id
	 * @param open_id
	 * @param trade_no
	 * @return
	 */
	public static String queryOrder(String appkey, String app_id, String open_id, String trade_no) {
		String url = "https://newidea4-gamecenter-backend.1sapp.com/x/pay/union/order/query";
		int time = (int) (System.currentTimeMillis() / 1000);
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_id", app_id);
		params.put("open_id", open_id);
		params.put("trade_no", trade_no);
		params.put("time", time + "");
		String sign = sign(params, appkey);
		params.put("sign", sign);
		return request(url, params);
	}

	private static String inputStream2str(InputStream stream, String encode) {
		ByteArrayOutputStream nBuilder = new ByteArrayOutputStream();
		try {
			int len = 0;
			byte[] data = new byte[1024];
			while ((len = stream.read(data)) != -1) {
				nBuilder.write(data, 0, len);
			}
			nBuilder.close();
		} catch (IOException e1) {
		}
		try {
			return nBuilder.toString(encode);
		} catch (Exception e) {
			return "";
		}
	}

	private static String getStringParams(Map<String, String> params) {
		if (params != null && !params.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}
		return "";
	}

	private static String request(String url, Map<String, String> params) {
		HttpURLConnection connection = null;
		try {
			String encode = "utf-8";
			String urlString = url + "?" + getStringParams(params);
			URL requestUrl = new URL(urlString);
			if (url.toLowerCase().startsWith("https")) {
				HttpsURLConnection https = (HttpsURLConnection) requestUrl.openConnection();
				https.setHostnameVerifier(new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				});
				connection = https;
			} else {
				connection = (HttpURLConnection) requestUrl.openConnection();
			}
			connection.setConnectTimeout(2000);
			connection.setReadTimeout(2000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.connect();
			int code = connection.getResponseCode();
			if (code == 200) {
				InputStream inputStream;
				inputStream = connection.getInputStream();
				Map<String, List<String>> map = connection.getHeaderFields();
				for (String name : map.keySet()) {
					if ("Content-Type".equals(name)) {
						int m = map.get(name).toString().indexOf("charset=");
						encode = map.get(name).toString().substring(m + 8).replace("]", "");
					}
				}
				return inputStream2str(inputStream, encode);
			}
		} catch (Exception e1) {
		} finally {
			try {
				if (connection != null) {
					connection.disconnect();
				}
			} catch (Exception e) {
			}
		}
		int time = (int) (System.currentTimeMillis() / 1000);
		return "{\"code\":-1,\"message\":\"Failure\",\"showErr\":0,\"currentTime\":" + time + ",\"data\":{}}";
	}

	private static String sign(Map<String, String> params, String appkey) {
		params.remove("sign");
		params.put("app_key", appkey);
		ArrayList<String> keys = new ArrayList<>();
		for (String key : params.keySet()) {
			keys.add(key);
		}
		keys.sort(new Comparator<String>() {
			@Override
			public int compare(String l, String r) {
				int i = l.compareTo(r);
				if (i > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		String str = "";
		for (String i : keys) {
			str += i + params.get(i);
		}
		params.remove("app_key");
		return md5(str);
	}

	private static String md5(String need2Encode) {
		try {
			byte[] buf = need2Encode.getBytes();
			MessageDigest md5;
			md5 = MessageDigest.getInstance("MD5");
			md5.update(buf);
			byte[] tmp = md5.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : tmp) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}

}