<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
</head>
<body>
    <h2>Editar Producto: ${producto.nombre}</h2>
    
    <form action="guardarProducto" method="POST">
        
        <input type="hidden" name="id" value="${producto.idProducto}">
        
        <label>Nombre:</label><br>
        <input type="text" name="nombre" value="${producto.nombre}" required><br><br>
        
        <label>ID Categoría:</label><br>
        <input type="number" name="idCategoria" value="${producto.idCategoria}" required><br><br>
        
        <label>Precio:</label><br>
        <input type="number" step="0.01" name="precio" value="${producto.precio}" required><br><br>
        
        <button type="submit">Guardar Cambios</button>
        <a href="listarProductos">Cancelar</a>
    </form>
</body>
</html>

