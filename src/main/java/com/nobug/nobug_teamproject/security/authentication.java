package com.nobug.nobug_teamproject.security;

import io.jsonwebtoken.*;
import org.testng.annotations.Test;

public class authentication {
    private static String signature = "315f7653-8c7a-4fc5-ac2b-e10f964b746c";

    @Test
    public void encryption(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
//                .setSubject("client-1")
//                .claim("authorities",
//                        grantedAuthorities.stream()
//                                .map(GrantedAuthority::getAuthority)
//                                .collect(Collectors.toList()))
//                .signWith(SignatureAlgorithm.HS512,
//                        signature.getBytes()).compact();
                // Set header
                .setHeaderParam("typ", "jwt")
                .setHeaderParam("alg", "HS256")
                // Set payload
                .claim("client", "fake_client")
                // Sign
                .signWith(SignatureAlgorithm.HS512, signature)
                .compact();
        System.out.println(jwtToken);
    }

    public static boolean validateToken(String token){
        JwtParser jwtParser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String result = claims.get("client").toString();
            System.out.println(result);
            if (result.equals("fake_client")){
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }
    @Test
    public void test(){
        validateToken("eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzUxMiJ9.eyJjbGllbnQiOiJmYWtlX2NsaWVudCJ9.P5yuxIa8n-T47SYKuqShwn_AS4CCkV6OOIYi5EDQ5V_C3zrMSufcGXoo18121hGt-Q3aXuSjEpebpwtKkRT1-w");
    }

}
