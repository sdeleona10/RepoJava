<%-- 
    Document   : index
    Created on : 6/10/2024, 10:50:35 p. m.
    Author     : Sergio De León
--%>
<%@page import="Modelo.Puesto" %>
<%@page import="Modelo.Empleado" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario Empleados</h1>
        <div class = "container">
            <form action="sr_empleado" method = "post" class="form-group">
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" name="txt_id" class="form-control" id="txt_id" calue="0" readonly>
                <label for="lbl_codigo"><b>Codigo:</b></label>
                <input type="text" name="txt_codigo" class="form-control" id="txt_codigo" placeholder="Ejemplo: E001" required>
                <label for="lbl_nombres"><b>Nombres:</b></label>
                <input type="text" name="txt_nombres" class="form-control" id="txt_nombres" placeholder="Ejemplo: Nombre1 Nombre2" required>
                <label for="lbl_apellidos"><b>Apellidos:</b></label>
                <input type="text" name="txt_apellidos" class="form-control" id="txt_apellidos" placeholder="Ejemplo: Apellido1 Apellido2" required>
                <label for="lbl_direccion"><b>Direccion:</b></label>
                <input type="text" name="txt_direccion" class="form-control" id="txt_direccion" placeholder="Ejemplo: # Casa Calle Zona Ciudad" required>
                <label for="lbl_telefono"><b>Telefono:</b></label>
                <input type="number" name="txt_telefono" class="form-control" id="txt_telefono" placeholder="Ejemplo: 99999999" required>
                <label for="lbl_fn"><b>Fecha Nacimiento:</b></label>
                <input type="date" name="txt_fn" class="form-control" id="txt_fn" required>
                <label for="lbl_puesto"><b>Puesto:</b></label>
                <select name="drop_puesto" id="drop_puesto" class="form-control">
                    <%
                        Puesto puesto = new Puesto();
                        HashMap<String,String> drop = puesto.drop_sangre();
                        for(String i: drop.keySet()){
                            out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                        }
                    %>
                </select><br>   
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button name="btn_modificar" id="btn_eliminar" value="eliminar" class="btn btn-danger">Eliminar</button>
            </form>
                
   <table class="table table-striped">
    <thead>
      <tr>
        <th>Código</th>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Dirección</th>
        <th>Teléfono</th>
        <th>Nacimiento</th>
        <th>Puesto</th>
      </tr>
    </thead>
    <tbody id="tbl_empleados">
        <%
        Empleado empleado = new Empleado();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = empleado.leer();
        for(int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t, 0) + " data-id_p=" + tabla.getValueAt(t, 8) + ">");
            out.println("<td>" + tabla.getValueAt(t, 1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t, 7) + "</td>");
            out.println("</tr>");
            }
        
        %>
    </tbody>
  </table>
                
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $('#tbl_empleados').on('click','tr td',function(evt){
               var target, id, id_p, codigo, nombres, apellidos, direccion, telefono, nacimiento;
               target = $(event.target);
               id = target.parent().data('id');
               id_p = target.parent().data('id_p');
               codigo = target.parent("tr").find("td").eq(0).html();
               nombres = target.parent("tr").find("td").eq(1).html();
               apellidos = target.parent("tr").find("td").eq(2).html();
               direccion = target.parent("tr").find("td").eq(3).html();
               telefono = target.parent("tr").find("td").eq(4).html();
               nacimiento = target.parent("tr").find("td").eq(5).html();
               
               $("#txt_id").val(id);
               $("#txt_codigo").val(codigo);
               $("#txt_nombres").val(nombres);
               $("#txt_apellidos").val(apellidos);
               $("#txt_direccion").val(direccion);
               $("#txt_telefono").val(telefono);
               $("#txt_fn").val(nacimiento);
               $("#drop_puesto").val(id_p);
            });
            
        </script>
    </body>
</html>
