/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexp_000
 */
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //private  ArrayList<String> lst = new ArrayList<>();       

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double one = Double.valueOf(request.getParameter("one"));
        double two = Double.valueOf(request.getParameter("two"));
        String operation = request.getParameter("operation");

    
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            ArrayList<String> lst;
            try {
//
                HttpSession ses = request.getSession(true);

                if (ses.isNew()) {
                    lst = new ArrayList<String>();
                }else{
                    lst = (ArrayList<String>)ses.getAttribute("formula");
                }
                /*if (ses.isNew()) {
                    lst.clear();
                }*/
                lst.add(printCalc(one,two,operation));
                
                ses.setAttribute("formula", lst);

                out.println("<h1> Идентификатор сессии: " + ses.getId() + "</h1>");
                out.println("<h2> Количество операций: " + lst.size() + "</h2>");
                for (String x : lst) {
                    out.println("<h3>Servlet Calculator at " + x + "</h3>");
                }               
                
            } catch (Exception e) {
                out.println("<h1> Ошибка ввода параметров</h1>");
                for (StackTraceElement x : e.getStackTrace()) {
                    out.println("<h3> " + x.toString() + "</h3>");
                }

            } finally {
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    public static String printCalc(double one, double two, String operation) {
        if (operation.equals("+")) {
            return one + " + " + two + " = " + CalcOperations.add(one, two);
        } else if (operation.equals("-")) {
            return one + " - " + two + " = " + CalcOperations.subtract(one, two);
        } else if (operation.equals("*")) {
            return one + " * " + two + " = " + CalcOperations.multiply(one, two);
        } else if (operation.equals("div")) {
            return one + " / " + two + " = " + CalcOperations.divide(one, two);
        }
        return null;
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
