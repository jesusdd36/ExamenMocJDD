package com.example.ExamenMoc.controller;

import com.example.ExamenMoc.entity.Producto;
import com.example.ExamenMoc.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@Service
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable("productoId") Long productoId) {
        this.productoService.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId,producto);
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {


        if (precio >= 25){
            this.productoService.findByPrecio(precio);
        }else if (precio < 25){
            this.productoService.findAllProductos();
        }else{
            return productoService.findByCategoria(categoria);
        }


        return this.productoService.findByPrecioAndCategoria(precio,categoria);
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoService.findProducto(productoId);

    }

}