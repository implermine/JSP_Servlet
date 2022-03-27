package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ServletContext servletContext = req.getServletContext();
//        HttpSession servletContext = req.getSession();
        int value = Integer.parseInt(req.getParameter("v"));
        String op = req.getParameter("operator");

        if (op.equals("=")) {
//            Integer lastValue = (Integer) servletContext.getAttribute("value");
//            String lastOperator = (String)servletContext.getAttribute("operator");

            Cookie[] cookies = req.getCookies();
            int lastValue = 0;
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("value")){
                    lastValue = Integer.parseInt(cookie.getValue());
                    break;
                }
            }

            String lastOperator = "";
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("operator")){
                    lastOperator = cookie.getValue();
                }
            }

            int result = 0;
            if (lastOperator.equals("+")) {
                result = lastValue + value;
            } else {
                result = lastValue - value;
            }

            resp.getWriter().println(result);

        } else {
            Cookie value1 = new Cookie("value", String.valueOf(value));
            Cookie operator = new Cookie("operator", op);
            resp.addCookie(value1);
            resp.addCookie(operator);
//            servletContext.setAttribute("value", value);
//            servletContext.setAttribute("operator", op);

            resp.sendRedirect("calc2.html");
//            resp.setHeader("Location","calc2.html");
//            resp.setStatus(302);
        }
    }
}
