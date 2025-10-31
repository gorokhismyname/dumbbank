package aq.example.dumbbank;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class RedisClient {

    private final RedisTemplate<String, Object> redisTemplate;

    public void saveValue(String key, String value, long ttlSeconds) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value, ttlSeconds, TimeUnit.SECONDS);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

}
