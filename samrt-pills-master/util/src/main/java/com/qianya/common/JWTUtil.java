package com.qianya.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.qianya.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @Package: com.qianya.shiro_jwt.util
 * @ClassName: JWTUtil
 * @Author: lhl
 * @Description:
 * @Date: 2020/6/10 15:54
 * @Version: 1.0
 */
public class JWTUtil {
    /**
     * 过期时间 3分钟
     */
    private static final long EXPIRE_TIME = 1000*60*60*3;
    /**
     * 密钥，注意这里如果真实用到，应当设置到复杂点，相当于私钥的存在。如果被人拿到，想到于它可以自己制造token了。
     */
    private static final String SECRET = "L!hldssd;_;938";

    /**
     * 生成 token, 5min后过期
     *
     * @return 加密的token string
     */
    public static String createToken(String userName,Integer userId,Integer userType){
        Calendar c = Calendar.getInstance();
        //c.set
        c.add(Calendar.YEAR, 10);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        // 附带username信息
        return JWT.create()
                .withClaim("username", userName)
                .withClaim("userId",userId)
                .withClaim("uType",userId)
                //到期时间
                .withExpiresAt(c.getTime())
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);
    }

    /**
     * 校验 token 是否正确
     *
     * @param token    密钥
     * @param username 用户名
     * @return 是否正确 boolean
     */
    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @param token the token
     * @return token中包含的用户名 username
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static Integer getUserType(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("uType").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 刷新Token
     * @param token
     * @return
     */
    public static String refreshToken(String token){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim("username", getUsername(token))
                .withClaim("userId",getUserId(token))
                .withClaim("uType",getUserType(token))
                //到期时间
                .withExpiresAt(date)
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);
    }
}
