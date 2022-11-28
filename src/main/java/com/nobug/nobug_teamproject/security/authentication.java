package com.nobug.nobug_teamproject.security;

import io.jsonwebtoken.*;


public class authentication {
    private static String signature = "315f7653-8c7a-4fc5-ac2b-e10f964b746c";


    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .setHeaderParam("typ", "jwt")
                .setHeaderParam("alg", "HS256")
                // Set payload
                .claim("client", "test_client")
                // Sign
                .signWith(SignatureAlgorithm.HS512, signature)
                .compact();
        System.out.println(jwtToken);
    }
}