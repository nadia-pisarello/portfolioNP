package com.portfolio.backend.security.jwt;

import com.portfolio.backend.model.Admin;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class Provider {
        private final static Logger logger = LoggerFactory.getLogger(Provider.class);
       
        @Value("${jwt.secret}")
        private String secret;
        @Value("${jwt.expiration}")
        private Long expiration;
        
        public String generateToken(Authentication authentication){
            Admin admin = (Admin) authentication.getPrincipal();
            return Jwts.builder().setSubject(admin.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime()+expiration*1000))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
        }
        
        public String getUserNameFromToken(String token){
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                    .getBody().getSubject();
        }
        
        public boolean validateToken (String token){
            try{
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                return true;
            } catch(MalformedJwtException error){
                logger.error("Malformed token");            
            } catch(UnsupportedJwtException error){
                logger.error("Unsupported token");
            } catch(ExpiredJwtException error){
                logger.error("Expired Token");            
            } catch(IllegalArgumentException error){
                logger.error("Empty token");           
            } catch(SignatureException error){
                logger.error("Invalid signature");
            }
            return false;
        }
}
