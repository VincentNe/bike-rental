package com.csharp.bikerental.config.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.SmartView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(UserInterceptor.class);

    public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication()
                    .getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isRedirectView(ModelAndView mv) {
        String viewName = mv.getViewName();
        if (viewName.startsWith("redirect:/")) {
            return true;
        }
        View view = mv.getView();
        return (view != null && view instanceof SmartView
                && ((SmartView) view).isRedirectView());
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (isUserLogged()) {
            //ADD username to session
            HttpSession session = request.getSession();
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            log.info(username +" just accesed the following: " + request.getRequestURI());
        }
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !isRedirectView(modelAndView)) {
            if (isUserLogged()) {
                String loggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
                modelAndView.addObject("loggedUsername", loggedUsername);
            }
        }
    }

   }
