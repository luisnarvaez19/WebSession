/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebasession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
public class FirstServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpUtil.checkAndPrintIfSessionIsNew(request, response);

    HttpUtil.checkCookiesAndPrintJSESSIONID(request, response);

    HttpUtil.printSessionRelatedRequestMethods(request, response);

    HttpUtil.printURLsAndNavigationLink(request, response, "/SecondServlet",

        "Go Next");

  }
}
