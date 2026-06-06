package com.insumos.modelo;

public class Producto {
    private int idProducto;
    private String nombre;
    private int idCategoria;
    private double precio;
    private String nombreCategoria; 

    public Producto() {}

    public Producto(int idProducto, String nombre, int idCategoria, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.precio = precio;
    }

    
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }
}


