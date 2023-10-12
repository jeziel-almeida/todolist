package com.rocketseat.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rocketseat.todolist.service.UserService;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.startsWith("/api/tasks")) {

            var authorization = request.getHeader("Authorization");
            // System.out.println("Autorization: " + authorization);

            var authEncoded = authorization.substring("Basic".length()).trim();
            // System.out.println("authEncoded: " + authEncoded);

            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);

            var authString = new String(authDecoded);
            // System.out.println("authString: " + authString);

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            var user = this.userService.findByUsername(username);

            if (user == null) {
                response.sendError(401, "Usuário não autorizado! Verifique username e senha e tente novamente.");
            } else {

                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerify.verified) {
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401, "Usuário não autorizado! Verifique username e senha e tente novamente.");
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}