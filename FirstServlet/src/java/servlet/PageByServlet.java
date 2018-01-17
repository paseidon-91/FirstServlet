/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexp_000
 */
public class PageByServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecondServlet</title>");
            out.println("<link rel = 'stylesheet' href='" + request.getContextPath() + "/Styles/styles.css' type='text/css'>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='menu'>");
            out.println("<p>Шапка и главное меню</p>");
            out.println("</div>");

            out.println("<div class='sidebar_left'>");
            out.println("<p>Side 1</p>");
            out.println("</div>");
            out.println("<div class='content'>");
            out.println("<table width = 100% align = 'center' border='' >");
            out.println("<tr align = 'center'> <th rowspan='4' bgcolor = #eee width = 30%>");
            out.println("<img src='" + request.getContextPath() + "/images/Java_logo.svg.png' alt='Картинка'> </th>");
            out.println("<th bgcolor = #00e>Имя</th> <th bgcolor = #00e>Телефон</th> </tr>");
            out.println("<tr align = 'center'> <th>Петр</th> <th>123456</th> </tr>");
            out.println("<tr align = 'center'> <th>Иван</th> <th>654321</th> </tr>");
            out.println("<tr> <th colspan='2'></th> </tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("<div class='sidebar_right'>");
            out.println("<p>Side 2</p>");
            out.println("</div>");
            out.println("<div class='footer'>");
            out.println("<p>Тестовый проект 2018</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
