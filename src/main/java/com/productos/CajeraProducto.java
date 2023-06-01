package com.productos;

import com.productos.cliente.producto.ClienteProducto;
import com.productos.cliente.producto.Producto;

public class CajeraProducto {
    
    private String nombre;

    public CajeraProducto(String nombre) {
        this.nombre = nombre;
    }
    
    public void procesarCompra(ClienteProducto cliente, long timeStamps){
        
        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del ciente " + cliente.getNombre() + " en el tiempo " +  (System.currentTimeMillis() - timeStamps) / 1000 + "Seg");
        
        int contCliente = 1;
        for (Producto producto : cliente.getProductos()){
            this.esperarXsegundos();
            System.out.println("Procesado el producto " + contCliente + " nombre producto " + producto.getNombre() + " precio de producto " + producto.getPrecio() + " cantidad de productos " + producto.getCantidad() + " costo total del producto " + producto.getCantidad() * producto.getPrecio() + " Tiempo: " + (System.currentTimeMillis() - timeStamps)/1000 + " Seg. "); 
        }
        System.out.println( "La cajera " + this.nombre + " ha terminado de proccesar "  + cliente.getNombre() + " en el tiempo:  " + (System.currentTimeMillis() - timeStamps)/1000 + " Seg. ");
        System.out.println(" ---------------------------------------------------------- ");
    }

    private void esperarXsegundos() {
       try{
           Thread.sleep(1000);
       } catch (InterruptedException ex){
           Thread.currentThread().interrupt();
       }
       
    }
}
