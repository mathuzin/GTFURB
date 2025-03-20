package com.example.gtfurb.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

public class AutenticacaoFiltroJWT extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private UtilJWT jwtUtil;



	public AutenticacaoFiltroJWT(AuthenticationManager authenticationManager, UtilJWT jwtUtil) {
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		try {
			UserSS user = new ObjectMapper().readValue(req.getInputStream(), UserSS.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword(), new ArrayList<>());

			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.getWriter().append("{\"Authorization\": \"Bearer " + token + "\"}");
	}

	@Component
	private static class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			response.setStatus(401);
			response.setContentType("application/json");
			response.getWriter().append(json());
		}

		private String json() {
			long date = new Date().getTime();
			String naoAutorizado = "Não Autorizado";
			String usuarioOuSenhaIncorretos = "Usuário ou senha incorretos";
			if (LocaleContextHolder.getLocale().getLanguage().equals("en")) {
				naoAutorizado = "Unauthorized";
				usuarioOuSenhaIncorretos = "Username or password is incorrect";
			}
			return "{\"timestamp\": " + date + ", " + "\"status\": 401, " + "\"error\": \"" + naoAutorizado + "\", "
					+ "\"message\": \"" + usuarioOuSenhaIncorretos + "\", " + "\"path\": \"/login\"}";
		}

	}

}
