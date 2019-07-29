/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebasession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luis
 */
public class HttpUtil {

    public static void checkAndPrintIfSessionIsNew(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        if (session.isNew()) {

            out.println("<h2>This is a new session!!!</h2>");

        } else {

            out.println("<h2>You are still in same session!!!</h2>");

        }

    }

    public static void checkCookiesAndPrintJSESSIONID(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            boolean cookieJSESSIONIDFound = false;

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("JSESSIONID")) {

                    cookieJSESSIONIDFound = true;

                    out.print("<h2>Cookie with name JSESSIONID found!</h2>");

                    out.println("JSESSIONID=" + cookie.getValue());

                }

            }

            if (!cookieJSESSIONIDFound) {

                out.print("<br><h2>Cookie with name JSESSIONID NOT found!</h2>");

            }

        } else
                out.print("<br><h2>HABILITA LAS COOKIES!</h2>");

    }

    public static void printSessionRelatedRequestMethods(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();

        out.print("<h2>Session related methods in request object</h2>");

        out.print("request.getRequestedSessionId()="
                + request.getRequestedSessionId());

        out.print("<br>request.isRequestedSessionIdFromCookie()="
                + request.isRequestedSessionIdFromCookie());

        out.print("<br>request.isRequestedSessionIdFromURL()="
                + request.isRequestedSessionIdFromURL());

        out.print("<br>request.isRequestedSessionIdValid()="
                + request.isRequestedSessionIdValid());

    }

    public static void printURLsAndNavigationLink(HttpServletRequest request,
            HttpServletResponse response, String next, String label)
            throws IOException {

        PrintWriter out = response.getWriter();

        String URL = request.getContextPath() + next;

        String encodedURL = response.encodeURL(URL);

        out.print("<h2>URLs</h2>");

        out.print("Original URL=" + URL);

        out.print("<br>Encoded URL=" + encodedURL);

        out.print("<br><br><a href=\"" + URL + "\">" + label + "(No Encoding)</a>");

        out.print("<br><br><a href=\"" + encodedURL + "\">" + label + "(Encoded)</a>");

    }
}
