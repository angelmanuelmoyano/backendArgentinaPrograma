package com.porfolio.gabrielarojas.Security;

import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Interface.IPersonaService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    PersonaService personaService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String token= getToken(request);
            if (token != null && jwtProvider.validaToken(token)){
                String usuario= jwtProvider.getUsuarioFromToken(token);
                Persona persona = personaService.loadUser(usuario);
                UsernamePasswordAuthenticationToken  auth = new UsernamePasswordAuthenticationToken(persona,null,null);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (Exception e){
            logger.error("fallo metodo do filter internal");
        }
        filterChain.doFilter(request,response);

    }
    private String getToken(HttpServletRequest request){
        String header =request.getHeader("Authorization");
        if (header!=null && header.startsWith("Bearer"))
            return header.replace("bearer","");
        return null;
    }
}
