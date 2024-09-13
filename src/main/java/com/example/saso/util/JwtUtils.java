package com.example.saso.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtils {
    //有效期
    public static final Long JWT_TTL = 60 * 60 * 24 * 1000L; // 60 * 60 *1000  一个小时
    //设置密钥
    public static final String JWT_KEY = "nanbei";

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //创建Jwt字符串
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }

    //创建带有过期时间的字符串
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    //构建JWT
    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis == null){
            ttlMillis=JwtUtils.JWT_TTL;
        }

        long expireMillis = nowMillis + ttlMillis;
        Date expireDate = new Date(expireMillis);
        return Jwts.builder()
                .setId(uuid)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm,secretKey)
                .setExpiration(expireDate);}

    /**
     * 创建一个带有自定义ID、主题和过期时间的JWT（JSON Web Token）字符串
     * @param id 参数id，用于设置JWT的唯一ID
     * @param subject 主题
     * @param ttlMillis 过期时间
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        //用了一个名为getJwtBuilder()的方法，该方法返回一个JwtBuilder对象。然后，使用该对象设置JWT的唯一ID（id）、主题（subject）和过期时间（ttlMillis）。
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);// 设置过期时间
        //调用JwtBuilder对象的compact()方法将JWT构建为一个字符串，并将其作为结果返回。
        return builder.compact();
    }

    public static void main(String[] args) throws Exception {
        String jwt = createJWT("132456");
        System.out.println(jwt);
    }

    /**
     * 生成一个密钥（SecretKey）用于JWT的签名。
     * @return
     */
    public static SecretKey generalKey() {
        //首先通过Base64解码将字符串JwtUtil.JWT_KEY转换为字节数组encodedKey
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtils.JWT_KEY);
        //使用SecretKeySpec类将字节数组encodedKey转换为一个SecretKey对象。这里使用的是AES对称加密算法。最后，返回生成的密钥对象。
        //这段代码中使用的密钥是从字符串JwtUtil.JWT_KEY解码而来的，实际应用中可能需要根据具体情况进行调整，例如从配置文件中读取密钥或使用其他方式生成密钥。
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析JWT（JSON Web Token）字符串，并返回其中的Claims对象。
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        //首先调用generalKey()方法获取密钥（SecretKey）
        SecretKey secretKey = generalKey();
        //然后，使用Jwts.parser()创建一个JwtParser对象，并通过调用setSigningKey()方法设置解析器的签名密钥为获取到的密钥。
        //接下来，调用JwtParser对象的parseClaimsJws()方法，传入JWT字符串jwt进行解析。该方法会返回一个Jws对象，通过调用getBody()方法获取其中的Claims对象。
        //最后，返回解析得到的Claims对象。
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
