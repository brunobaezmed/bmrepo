package com.S1.Sone.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class AuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/login.html") || request.getServletPath().equals("/")){
            filterChain.doFilter(request,response);
        }else{

            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
             try {
                 String token = authorizationHeader.substring("Bearer ".length());
                 Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
                 JWTVerifier verifier = JWT.require(algorithm).build();
                 DecodedJWT decodedJWT = verifier.verify(token);
                 String username = decodedJWT.getSubject();
                 String roles = decodedJWT.getClaim("ROLE").asString();
                 Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
                 authority.add(new SimpleGrantedAuthority (roles) );
                 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,null,authority);
                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                 filterChain.doFilter(request,response);
                 }catch (Exception exception){
                            logger.error("error loggin in",exception);
                            response.setHeader("error",exception.getMessage());
                            response.sendError(HttpServletResponse.SC_FORBIDDEN);
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            Map<String,String> error = new HashMap<>();
                            error.put("error messsage",exception.getMessage());
                            response.setContentType(APPLICATION_JSON_VALUE);
                            new ObjectMapper().writeValue(response.getOutputStream(),error);
                         }

             }
            else{
                filterChain.doFilter(request,response);
            }

        }
    }
}
