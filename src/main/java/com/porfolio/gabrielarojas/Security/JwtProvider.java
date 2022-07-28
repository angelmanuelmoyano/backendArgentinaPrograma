package com.porfolio.gabrielarojas.Security;

/*import com.porfolio.gabrielarojas.Entity.Persona;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Value("$(jwt.secret)")
    private String secrect;
    @Value("$(jwt.expiration)")
    private String expiration;

    public String generateToken(Authentication authentication){
        Persona persona = (Persona) authentication.getClass().
        return Jwts.builder().setSubject(persona.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration+1000))
                .signWith(SignatureAlgorithm.HS512,secrect)
                .compact();
    }
    public String getUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secrect).parseClaimsJws(token).getBody().getSubject();
    }

    public  boolean validaToken (String token){
        try{
            Jwts.parser().setSigningKey(secrect).parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("token mal formado");
            return false;
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
            return false;
        }catch(ExpiredJwtException e ) {
         logger.error("token expirado");
            return false;
        }catch (IllegalArgumentException e){
            logger.error("toek vacion");
            return false;
        }catch (SignatureException e){
            logger.error("Firma no valida");
            return false;
        }

    }

}*/
