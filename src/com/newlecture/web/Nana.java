package com.newlecture.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("Content-Type","text/html; charset=UTF-8");

        String temp = req.getParameter("cnt");
        int cnt = 0;

        if (temp!= null && !temp.equals("")){
            cnt = Integer.parseInt(temp);
        }

        PrintWriter out = resp.getWriter();

        for(int i=0;i<cnt;i++){
            out.println((i+1) + ": 안녕 Servlet !! <br >");
        }

    }
}
