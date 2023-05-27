package org.ignacio.rios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/registro")
public class Formservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Resultado Form</title>");
            out.println("<link rel=\"stylesheet\" href=\"styles.css\">");
            out.println("<style>");
            out.println("body {");
            out.println("  font-family: Arial, sans-serif;");
            out.println("  background-color: #f2f2f2;");
            out.println("  text-align: left;"); // Justificar a la izquierda
            out.println("  margin-left: 20px;"); // Margen izquierdo para el contenido
            out.println("}");

            out.println("h1 {");
            out.println("  color: #333333;");
            out.println("}");

            out.println("ul {");
            out.println("  list-style-type: none;");
            out.println("  padding: 0;");
            out.println("}");

            out.println("li {");
            out.println("  margin-bottom: 10px;");
            out.println("}");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado Form</h1>");
            out.println("<ul>");

            out.println("<li>");
            out.println("<h1>Nombre: " + username + "</h1>");
            out.println("</li>");

            out.println("<li>");
            out.println("<h1>Password: " + password + "</h1>");
            out.println("</li>");

            out.println("<li>");
            out.println("<h1>Email: " + email + "</h1>");
            out.println("</li>");

            out.println("<li>");
            out.println("<h1>País: " + pais + "</h1>");
            out.println("</li>");

            out.println("<li><h1>Lenguajes:</h1></li>");
            out.println("<ul>");
            Arrays.asList(lenguajes).forEach(len -> {
                out.println("<li><h1>" + len + "</h1></li>");
            });
            out.println("</ul>");

            out.println("<li><h1>Roles:</h1></li>");
            out.println("<ul>");
            Arrays.asList(roles).forEach(rol -> {
                out.println("<li><h1>" + rol + "</h1></li>");
            });
            out.println("</ul></li>");
            out.println("<li><h1> idioma : " + idioma + "</h1></li>");
            out.println("<li><h1> habilitado:  " + habilitar + "</h1></li>");
            out.println("<li><h1> secreto : " + secreto + "</h1></li>");

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
