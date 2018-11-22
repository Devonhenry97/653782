/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

/**
 *
 * @author me-aydin
 */
public class UserServLet extends HttpServlet {

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
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        Jdbc dbBean = new Jdbc();
        dbBean.connect((Connection)request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", dbBean);

        String qry = "select * from Taxi.Customer";

        String qry_drivers = "select * from Taxi.Drivers";

        String qry_bookings = "select * from Taxi.Journey";
        
        String qry_demands = "select * from Taxi.Demands";
        
        String qry_dailyreport = "SELECT customer.name, journey.date, journey.time, drivers.name" 
                + " FROM customer"
                + " inner join journey on customer.id = journey.id "
                + " inner join drivers on drivers.registration = journey.registration";
        
         /*
                + " journey.date,"
                + " journey.time,"
                + " drivers.name"
                + " FROM Taxi.Customer, Taxi.Journey, Taxi.Drivers" 
                + " Inner Join journey ON customer.id=journey.id";
              */
             
        String qry_jobs = "SELECT drivers.registration, drivers.name,"
                + " journey.destination, journey.distance, journey.date,"
                + " journey.time" 
                + " FROM drivers"
                + " Inner Join journey ON drivers.registration=journey.registration"
                + " WHERE drivers.name = 'John Smith'";



         if (request.getSession().getAttribute("user_details") != null){

                

            List<String> values2 = (ArrayList) request.getSession().getAttribute("user_details");

            String driver = values2.get(0);


            if (driver.equals("admin")){

                qry_jobs = "SELECT drivers.registration, drivers.name,"
                + " journey.destination, journey.distance, journey.date,"
                + " journey.time" 
                + " FROM drivers"
                + " Inner Join journey ON drivers.registration=journey.registration";
            }

            else{

                qry_jobs = "SELECT drivers.registration, drivers.name,"
                + " journey.destination, journey.distance, journey.date,"
                + " journey.time" 
                + " FROM drivers"
                + " Inner Join journey ON drivers.registration=journey.registration"
                + " WHERE drivers.name = '"+driver+"'";
            }

         }
        
        
        
        
        if((Connection)request.getServletContext().getAttribute("connection")==null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
        if (request.getAttribute("login") != null){
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        else if (request.getParameter("tbl").equals("List")){
            String msg="No users";
            try {
                msg = dbBean.retrieve(qry);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
         else if (request.getParameter("tbl").equals("ListDrivers")){
            String msg="No users";
            try {
                msg = dbBean.retrieve(qry_drivers);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
          else if (request.getParameter("tbl").equals("ListBookings")){
            String msg="No users";
            try {
                msg = dbBean.retrieve(qry_bookings);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
          else if (request.getParameter("tbl").equals("ListBookings")){
            String msg="No users";
            try {
                msg = dbBean.retrieve(qry_bookings);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
          
          else if (request.getParameter("tbl").equals("DailyReport")){
            String msg="No demands";
            try {
                msg = dbBean.retrieve(qry_dailyreport);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/dailyreport.jsp").forward(request, response);
        }
         
           else if (request.getParameter("tbl").equals("ListJobs")){
            String msg="No users";
            try {
                msg = dbBean.retrieve(qry_jobs);
            } catch (SQLException ex) {
                Logger.getLogger(UserServLet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("query", msg);
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }
          
          
        else if(request.getParameter("tbl").equals("NewUser")){
            String name = "user";
            String action = "add";
            List<String> strg = new ArrayList<String>();
            strg.add(name);
            strg.add(action);
            request.setAttribute("msg", strg);
            request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
        } 
        else if(request.getParameter("tbl").equals("NewDriver")){
            String name = "driver";
            String action = "add";
            List<String> strg = new ArrayList<String>();
            strg.add(name);
            strg.add(action);
            request.setAttribute("msg", strg);
            request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
        } 
        else if(request.getParameter("tbl").equals("Update")){
            request.getRequestDispatcher("/WEB-INF/passwdChange.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("Book")){
            request.getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("Admin")){
            request.getRequestDispatcher("/WEB-INF/adminhome.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("Driver")){
            request.getRequestDispatcher("/WEB-INF/driverhome.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("User")){
            request.getRequestDispatcher("/WEB-INF/userhome.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("DailyReport")){
            request.getRequestDispatcher("/WEB-INF/dailyreport.jsp").forward(request, response);    
        }
        else if(request.getParameter("tbl").equals("DeleteUser")){
                String name = "user";
                String action = "del";
                List<String> strg = new ArrayList<String>();
                strg.add(name);
                strg.add(action);
                request.setAttribute("msg", strg);
                request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);    
        }
        
         else if(request.getParameter("tbl").equals("DeleteDriver")){
                String name = "driver";
                String action = "del";
                List<String> strg = new ArrayList<String>();
                strg.add(name);
                strg.add(action);
                request.setAttribute("msg", strg);
                request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);    
        }
        
        else {
            request.setAttribute("msg", "del");
            request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response); 
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
