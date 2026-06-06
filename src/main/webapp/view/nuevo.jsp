<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- ESTA LÍNEA ES CLAVE PARA QUE FUNCIONE EL FOREACH --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h3 class="mb-0">Ingresar Nuevo Producto</h3>
                </div>
                <div class="card-body">
                    <form action="guardarProducto" method="POST">
                        <div class="mb-3">
                            <label class="form-label">Nombre del Producto:</label>
                            <input type="text" name="nombre" class="form-control" placeholder="Ej: Guantes de látex" required>
                        </div>
                        
                       
                        <div class="mb-3">
                 <label class="form-label">Categoría:</label>
                <select name="idCategoria" class="form-select" required>
              <option value="">-- Seleccione una categoría --</option>
        
               <c:forEach var="cat" items="${categorias}">
                  <option value="${cat.id}">${cat.nombre}</option>
                    </c:forEach>
                    </select>
                      </div>

                        <div class="mb-3">
                            <label class="form-label">Precio:</label>
                            <input type="number" step="0.01" name="precio" class="form-control" required>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-success">Guardar Producto</button>
                            <a href="listarProductos" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>


