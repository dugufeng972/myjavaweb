package com.ddw.myjavaweb.utils;

import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
    //HS256,密钥长度不能低于256位
    private static final String SECRET_KEY = "6L+Z5pivZGR355qEbXlqYXZh6aG555uu55qE5a+G6ZKl";
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                      .addClaims(claims)
                      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                      .compact();
    }
    public static Map<String, Object> parserToken(String jwt) {
        return Jwts.parser().setSigningKey(SECRET_KEY).build()
                            .parseClaimsJws(jwt)
                            .getBody();
    }
}
