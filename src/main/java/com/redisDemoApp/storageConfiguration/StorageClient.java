package com.redisDemoApp.storageConfiguration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class StorageClient {

	private Jedis jedisSG;

	private String subscribedEventPattern = "__keyevent@" + 2 + "__:expired";

	JedisPool jedisPool = new JedisPool("localhost", 6379);

	@Async
	public void getStorageClient() {
		System.out.println("connection established");
		Jedis jedis = jedisPool.getResource();
		jedis.psubscribe(new KeyExpiredListener(), subscribedEventPattern );
	}

	public void set(String jKey, String jValue) {
		jedisSG = jedisPool.getResource();
		jedisSG.select(2);
		jedisSG.setex(jKey, 2 ,jValue);
	}

	public String get(String jKey) {
		jedisSG.select(2);
		return jedisSG.get(jKey);
	}

}
