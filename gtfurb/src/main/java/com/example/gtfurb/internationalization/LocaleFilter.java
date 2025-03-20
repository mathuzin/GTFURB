package com.example.gtfurb.internationalization;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader("Accept-Language");
        if (header != null && !header.isEmpty()) {
            LocaleContextHolder.setLocale(new Locale(header));
        } else {
            LocaleContextHolder.setLocale(Locale.getDefault());
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        //LocaleContextHolder.resetLocaleContext();
    }
}
