package com.crunchify.jsp.servlet;

import DAO.FormularioDAO;
import Formulario.Formulario;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "ForumPost")
public class ForumPost extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Formulariojsp.jsp";
    private static String LIST_USER = "/Formulariojsp.jsp";
    private FormularioDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new FormularioDAO();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Formulario newCliente = new Formulario();
        newCliente.setTitulo(request.getParameter("titulo"));
        newCliente.setDescripcion(request.getParameter("descripcion"));

        dao.addCampos(newCliente);
        doGet(request, response);
      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("formularioJSP", dao.getAllCampos());
        view.forward(request, response);
    }
}
