package spring.security.token.config;

import java.io.IOException;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import spring.security.token.services.JWTService;
import spring.security.token.services.UserSetvice;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    @SuppressWarnings("unused")
    private final UserSetvice UserService;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
                final String authHeader = request.getHeader("Authorization");
                final String jwt;
                @SuppressWarnings("unused")
                final String userEmail;

            if(StringUtil.isNullOrEmpty(authHeader)|| !org.apache.commons.lang3.StringUtil.StartsWith(authHeader, "Bearer")){
                 filterChain.doFilter(request, response);
                    return;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUserName(jwt);

       // if(StringUtil.isNullOrEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null){
           // @SuppressWarnings("unused")
           // UserDetails userDetails = UserService.UserDetailsService().loadUserByUsername(userEmail);
       // }
 }
}

