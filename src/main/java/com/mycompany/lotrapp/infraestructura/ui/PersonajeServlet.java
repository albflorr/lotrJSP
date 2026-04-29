/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lotrapp.infraestructura.ui;

import com.mycompany.lotrapp.aplicacion.PersonajeService;
import com.mycompany.lotrapp.infraestructura.persistence.MySQLPersonajeRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author USER
 */
@WebServlet({"/generar", "/index"})
public class PersonajeServlet extends HttpServlet {
    private PersonajeService service = new PersonajeService(new MySQLPersonajeRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listaPersonajes", service.listarHeroes());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String raza = req.getParameter("raza");
        
        service.crearHeroe(nombre, raza);
        
        resp.sendRedirect("index");
    }
}