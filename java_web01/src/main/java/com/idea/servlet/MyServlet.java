package com.idea.servlet;
import com.sun.net.httpserver.HttpsServer;

import  java.io.IOException;
public class MyServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletRequest reponse){

    }
    protected  void doGet(HttpServletRequest request,HttpServletRequest reponse){
        request.getRequestDispatcher(s:"/hello.jsp").forward(request,reponse);
    }

}
