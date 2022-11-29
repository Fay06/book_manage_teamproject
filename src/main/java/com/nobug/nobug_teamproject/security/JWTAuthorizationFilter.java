package com.nobug.nobug_teamproject.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nobug.nobug_teamproject.service.ClientService;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final  String HEADER = "Authorization";
    private static final  String PREFIX = "Bearer ";
    private static final String SECRET = "315f7653-8c7a-4fc5-ac2b-e10f964b746c";

    private final ClientService clientService;

    public JWTAuthorizationFilter(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (checkJWTToken(request)) {
                String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
                if (validateToken(jwtToken)) {
                    setUpSpringAuthentication();
                } else {
                    SecurityContextHolder.clearContext();
                }
            }else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            (response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }

    private boolean validateToken(String token){
        JwtParser jwtParser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = jwtParser.setSigningKey(SECRET).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String clientName = claims.get("client").toString();
            String clientNameTemp = null;

            try {
                clientNameTemp = clientService.searchClient(clientName).getClientName();
            } catch (Exception e) {
                return false;
            }

            return clientNameTemp.equals(clientName);
        } catch (Exception e) {
            return false;
        }
    }

    // Prepare for Subsequent Filter Authorization
    private void setUpSpringAuthentication() {
        @SuppressWarnings("unchecked")
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_CLIENT");

        List<String> authorities = grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("client", null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    // Check if the token exists
    private boolean checkJWTToken(HttpServletRequest request) {
        String authenticationHeader = request.getHeader(HEADER);
        return (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX));
    }

}