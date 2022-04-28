package com.liuqiang.commons.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * JWT工具类
 * @author LiuQiang
 * @date 7:00 下午
 */
@Slf4j
public class JwtUtils {

    public static final Long JWT_TTL = 6*600*300*100L;

    public static final String JWT_KEY = "graduation";

    /**
     * 生成ID
     * @return token
     */
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 创建jwt
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJwt(String subject,Long ttlMillis){

        return getJwtBuilder(subject,ttlMillis,getUuid()).compact();
    }

    public static String createJwt(String subject){
        return getJwtBuilder(subject,null,getUuid()).compact();
    }

    public static String createJwt(Map<String,Object> subject){
        return getJwtBuilder(subject,null,getUuid()).compact();
    }


    private static JwtBuilder getJwtBuilder(String subject,Long ttlMillis,String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        if(ttlMillis == null){
            ttlMillis = JwtUtils.JWT_TTL;
        }
        long expMillis = millis + ttlMillis;
        Date expDate = new Date((expMillis));
        return Jwts.builder().setId(uuid).setSubject(subject)
                .setIssuer("Liuqiang").setIssuedAt(date).signWith(signatureAlgorithm,secretKey)
                .setExpiration(expDate);
    }
    private static JwtBuilder getJwtBuilder(Map<String,Object> subject,Long ttlMillis,String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        if(ttlMillis == null){
            ttlMillis = JwtUtils.JWT_TTL;
        }
        long expMillis = millis + ttlMillis;
        Date expDate = new Date((expMillis));
        return Jwts.builder().setId(uuid).setClaims(subject)
                .setIssuer("Liuqiang").setIssuedAt(date).signWith(signatureAlgorithm,secretKey)
                .setExpiration(expDate);
    }
    /**
     * 创建token
     */
    public static String createJwt(String id,String subject,Long ttlMillis){
        return getJwtBuilder(subject,ttlMillis,id).compact();
    }

    /**
     * 生成加密后的密钥
     * @return 密钥
     */
    public static SecretKey generalKey(){
        byte[] decode = Base64.getDecoder().decode(JwtUtils.JWT_KEY);
        return new SecretKeySpec(decode, 0, decode.length, "AES");
    }

    /**
     * 解析jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims paresJwt(String jwt) throws Exception{
        SecretKey secretKey = generalKey();
        return Jwts.parser().
                setSigningKey(secretKey).
                parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 获取用户账号
     */
    public static String getUserNumber(String token) {

        String userNumber = null;
        try {
            Claims claims = paresJwt(token);
            userNumber = (String) claims.get("number");
        } catch (Exception e) {
            log.error("eror={}", e);
        }
        return userNumber;
    }

    /**
     * 获取用户名
     */
    public static String getUserName(String token) {

        String username = null;
        try {
            Claims claims = paresJwt(token);
            username = (String) claims.get("user");
        } catch (Exception e) {
            log.error("eror={}", e);
        }
        return username;
    }


    public static void main(String[] args) throws Exception {
//        Claims claims = paresJwt("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkOTJkNzcxZTBlOWM0MTI0YmQ4MjkwYzA4ZmFiYTgzYSIsInN1YiI6IjEwMDEyOuenkeavlCIsImlzcyI6IkxpdXFpYW5nIiwiaWF0IjoxNjUxMTM3MzY3LCJleHAiOjE2NTEyNDUzNjd9.j-3sPqdYD6hLnCkUwrCY6paOliVeKalveLTMRoBMd5M");
//        System.out.println(claims.getSubject());

       String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJMaXVxaWFuZyIsIm51bWJlciI6IjEwMDEyIiwiZXhwIjoxNjUxMjQ3NTc5LCJ1c2VyIjoi56eR5q-UIiwiaWF0IjoxNjUxMTM5NTc5fQ.a2hJzzW-AuX2QW1bDbtNzAPWMLK_-Rff_JkDECqUNCA";
        String userName = getUserName(token);

        System.out.println(userName);
    }
}
