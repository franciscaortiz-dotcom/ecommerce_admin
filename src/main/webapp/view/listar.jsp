<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo - Insumos Médicos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h2 class="mb-0">Catálogo de Insumos Médicos</h2>
            </div>
            <div class="card-body">
                <a href="nuevoProducto" class="btn btn-success mb-3">Agregar Nuevo Producto</a>

                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Categoría</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${productos}">
                            <tr>
                                <td>${p.idProducto}</td>
                                <td>${p.nombre}</td>
                                <td>$${p.precio}</td>
                                <td>${p.nombreCategoria}</td>
                                <td>
                                    <a href="editarProducto?id=${p.idProducto}" class="btn btn-sm btn-primary">Editar</a>
                                    <a href="eliminarProducto?id=${p.idProducto}" 
                                       onclick="return confirm('¿Seguro que quieres borrar este producto?');" 
                                       class="btn btn-sm btn-danger">Borrar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>



