package com.example.saso.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 自定义的Redis序列化器，使用FastJson库将对象序列化为字节数组，并将字节数组反序列化为对象。
 * 实现了RedisSerializer接口，用于将对象序列化为字节数组和将字节数组反序列化为对象。
 * 使用FastJson库将对象转换为JSON字符串，并将JSON字符串转换为字节数组。
 * 在序列化时，使用SerializerFeature.WriteClassName参数将对象的类名写入JSON字符串中，以便在反序列化时能够正确地恢复对象的类型。
 * 在反序列化时，将字节数组转换为字符串，并使用JSON.parseObject方法将字符串转换为指定类型的对象。
 * 通过构造方法传入要序列化/反序列化的对象的Class对象，以便在反序列化时能够正确地恢复对象的类型。
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T>
{
    // public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    //下面是一个静态代码块，它的作用是在类加载时执行一次，用于设置FastJson的全局配置
    static
    {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }


    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException
    {
        if (t == null)
        {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException
    {
        if (bytes == null || bytes.length <= 0)
        {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz);
    }


    protected JavaType getJavaType(Class<?> clazz)
    {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}