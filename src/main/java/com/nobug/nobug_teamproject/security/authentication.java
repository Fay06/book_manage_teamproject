package com.nobug.nobug_teamproject.security;

import io.jsonwebtoken.*;
import org.testng.annotations.Test;

public class authentication {
    private String signature = "XNzdWVyIjoiQWRtaW4iL";
    @Test
    public void encryption(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // Set header
                .setHeaderParam("typ", "jwt")
                .setHeaderParam("alg", "HS256")
                // Set payload
                .claim("client", "fake_client")
                // Sign
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(jwtToken);
    }
    @Test
    public void decryption(){
        String token = "eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJjbGllbnQiOiJmYWtlX2NsaWVudCJ9.L1WJs2N0nFR9iH60C8urUDgg_24gPk5y9BTelQkIASY";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("client"));

    }
}
