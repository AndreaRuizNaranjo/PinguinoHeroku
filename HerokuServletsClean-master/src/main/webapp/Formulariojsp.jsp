<%-- 
    Document   : Formulario
    Created on : 4/02/2019, 01:42:00 PM
    Author     : Andrea
--%>
<%@page import="java.util.List"%>
<%@page import="Formulario.Formulario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Formulario</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum.scale=1.0">
    </head>
    <body>
         <div class="w3-container w3-padding-32" id="projects">
        
        <div>
            <form method="POST" action='ForumPost' name="frmAddUser">
                <h4>Titulo</h4>
                <input class="form-control" type="text" rows="2" name="titulo" ><br>
                <h4>Descripcion</h4>
                <textarea class="form-control" rows="5" name="descripcion" > </textarea>
                <br><br>
                <input type="submit" value="Add Artista" class="btn btn-danger"/>
            </form>
            <br>
            <br>
            <br>
 
        </div>
        
        <div class="form-style-5" >
           <h4>Tabla de datos</h4>
            <table border=1 class="table table-hover">
                <thead>
                    <tr>
                        <th>Titulo</th>
                        <th>Descripcion</th>
                    </tr>
                </thead>
                <tbody>
                
                    <%
                                List<Formulario> newArtista = (List<Formulario>) request.getAttribute("formularioJSP");
                                if (newArtista != null) {
                                    for (Formulario artista : newArtista) {
                            %>
                            <tr>
                                <td><%=artista.getTitulo()%></td>
                                <td><%=artista.getDescripcion()%></td>
                   
                            </tr>

                            <%
                                    }

                                }

                            %>

                    

                </tbody>
            </table>

        </div>
                            </div>
    </body>
</html>
