package com.insumos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.insumos.config.Conexion;
import com.insumos.modelo.Producto;
import com.insumos.modelo.Categoria; 

public class ProductoDAO {

   
	public List<Producto> listarProductos() {
	    List<Producto> lista = new ArrayList<>();
	    
	    String sql = "SELECT p.*, c.nombre AS nombre_categoria FROM productos p JOIN categorias c ON p.id_categoria = c.id_categoria";
	    
	    try (Connection con = Conexion.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        
	        while (rs.next()) {
	            Producto p = new Producto();
	            p.setIdProducto(rs.getInt("id_producto"));
	            p.setNombre(rs.getString("nombre"));
	            p.setPrecio(rs.getDouble("precio"));
	            
	            
	            p.setNombreCategoria(rs.getString("nombre_categoria")); 
	            
	            lista.add(p);
	        }
	    } catch (SQLException e) { 
	        e.printStackTrace(); 
	    }
	    return lista;
	}


    public void agregarProducto(Producto p) {
        String sql = "INSERT INTO productos (nombre, id_categoria, precio) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getIdCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Producto obtenerProductoPorId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE id_producto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Producto();
                    p.setIdProducto(rs.getInt("id_producto"));
                    p.setNombre(rs.getString("nombre"));
                    p.setIdCategoria(rs.getInt("id_categoria"));
                    p.setPrecio(rs.getDouble("precio"));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return p;
    }

    public void actualizarProducto(Producto p) {
        String sql = "UPDATE productos SET nombre = ?, id_categoria = ?, precio = ? WHERE id_producto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getIdCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getIdProducto());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    
    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id_categoria"));
                c.setNombre(rs.getString("nombre"));
                lista.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}

