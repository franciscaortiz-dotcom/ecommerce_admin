package com.insumos.controlador;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.insumos.dao.ProductoDAO;
import com.insumos.modelo.Producto;

@WebServlet({"/listarProductos", "/guardarProducto", "/eliminarProducto", "/editarProducto", "/nuevoProducto"})
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductoDAO dao = new ProductoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/listarProductos")) {
            List<Producto> lista = dao.listarProductos();
            request.setAttribute("productos", lista);
            request.getRequestDispatcher("view/listar.jsp").forward(request, response);

        } else if (path.equals("/eliminarProducto")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminarProducto(id);
            request.getSession().setAttribute("mensaje", "Producto eliminado con éxito.");
            response.sendRedirect("listarProductos");

        } else if (path.equals("/editarProducto")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Producto p = dao.obtenerProductoPorId(id);
            request.setAttribute("producto", p);
            
            request.setAttribute("categorias", dao.listarCategorias());
            request.getRequestDispatcher("view/editar.jsp").forward(request, response);

        } else if (path.equals("/nuevoProducto")) {
          
            request.setAttribute("categorias", dao.listarCategorias());
            request.getRequestDispatcher("view/nuevo.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int idCat = Integer.parseInt(request.getParameter("idCategoria"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        String idStr = request.getParameter("id");

        if (precio <= 0) {
            request.getSession().setAttribute("mensaje", "Error: El precio debe ser mayor a 0.");
            response.sendRedirect("nuevoProducto");
            return;
        }

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Producto p = new Producto(id, nombre, idCat, precio);
            dao.actualizarProducto(p);
            request.getSession().setAttribute("mensaje", "Producto actualizado correctamente.");
        } else {
            Producto p = new Producto(0, nombre, idCat, precio);
            dao.agregarProducto(p);
            request.getSession().setAttribute("mensaje", "Producto agregado con éxito.");
        }
        response.sendRedirect("listarProductos");
    }
}

