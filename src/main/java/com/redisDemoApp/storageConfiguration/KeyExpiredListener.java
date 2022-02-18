package com.redisDemoApp.storageConfiguration;

import redis.clients.jedis.JedisPubSub;

public class KeyExpiredListener extends JedisPubSub {
	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("on subscribe " + pattern + " " + subscribedChannels);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("on message pattern: " + pattern + " channel: " + channel + " message: " + message);
	}
}
