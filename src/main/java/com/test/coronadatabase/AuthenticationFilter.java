/*
 -14-
 Κλάση η οποία διαχειρίζεστε τα authentication Post  αιτήματα για τα endpoints εκτός του /login.
 Class that handles Post authentication requests for endpoints other than / login.
*/

package com.test.coronadatabase;

import com.test.coronadatabase.service.AuthenticationService;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest)request);

        SecurityContextHolder.getContext().
                setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}

