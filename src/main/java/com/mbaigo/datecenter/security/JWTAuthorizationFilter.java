package com.mbaigo.datecenter.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Autorisation au navigateur d'envoyer une requête à partir de n'importe quel domaine(envoi du JWT)
				response.addHeader("Access-Control-Allow-Origin", "*");
				//Autorisation au navigateur d'envoyer dans la prochaine requête les en-têtes (envoi de authorization)
				response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
				//Autorisation au navigateur de lire les en-tête, exposition des entêtes (lecture de authorization)
				response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
				response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,PATCH");
				if(request.getMethod().equals("OPTIONS")) {
					response.setStatus(HttpServletResponse.SC_OK);
				}
				/*
				else if(request.getRequestURI().equals("/login")) {
					filterChain.doFilter(request, response);
					return;
				}*/
				else {	
				String jwtToken=request.getHeader(SecurityParams.JWT_HEADER_NAME);
				System.out.println("Token="+jwtToken);
				if(jwtToken==null || !jwtToken.startsWith(SecurityParams.HEADER_PREFIX)) {
					filterChain.doFilter(request, response);
					return;
				}
				
				JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();
				String jwt=jwtToken.substring(SecurityParams.HEADER_PREFIX.length());
				DecodedJWT decodedJWT= verifier.verify(jwt);
				String username=decodedJWT.getSubject();
				List<String> roles=decodedJWT.getClaims().get("roles").asList(String.class);
				System.out.println("jwt="+jwt);
				System.out.println("username="+username);
				System.out.println("roles="+roles);
				Collection<GrantedAuthority> authorities= new ArrayList<>();
				roles.forEach(rolename->{
					authorities.add(new SimpleGrantedAuthority(rolename));
				});
				UsernamePasswordAuthenticationToken user = 
						new UsernamePasswordAuthenticationToken(username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(user);
				filterChain.doFilter(request, response);
		
	}

	}
}
