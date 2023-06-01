package com.productos.thread;

import com.productos.cliente.producto.ClienteProducto;
import com.productos.cliente.producto.Producto;
import java.util.ArrayList;
import java.util.List;


public class MainThreadProducto {
    
    public static void main(String[] args){
        
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        
        ClienteProducto cliente1 = new ClienteProducto("Pedro", productos);
        ClienteProducto cliente2 = new ClienteProducto("Diana", productos);
        
        long initialTime = System.currentTimeMillis();
        CajeraThreadProducto cajera1 = new CajeraThreadProducto("Magdalena", cliente1, initialTime);
        CajeraThreadProducto cajera2 = new CajeraThreadProducto("Anny", cliente2, initialTime);
        
        cajera1.start();
        cajera2.start();
    }
    
    private static void setProductos(List<Producto> productos){
        Producto p1 = new Producto("Papaya", 100, 4);
        Producto p2 = new Producto("Mandarina", 200, 2);
        Producto p3 = new Producto("Mandarina", 150, 3);
        
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
    }
}
