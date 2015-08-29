package com.tickets.web.controllers;

import com.tickets.api.entitys.catalogos.Inventario;
import com.tickets.api.entitys.catalogos.Producto;
import com.tickets.api.entitys.catalogos.RequestWrapper;
import com.tickets.services.ProductoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author eduardo.chavez
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Resource
    ProductoService productoService;

    @RequestMapping(value = "/altaProducto", method = RequestMethod.POST)
    public @ResponseBody
    Producto altaProducto(@RequestBody Producto producto) {
        return productoService.altaProducto(producto);
    }
    
    @RequestMapping(value = "/actualizaInventario", method = RequestMethod.POST)
    public void actualizaInventario(@RequestBody Inventario inventario) {
         productoService.actualizaInventario(inventario);
    }

    @RequestMapping(value = "/consultarProducto", method = RequestMethod.POST)
    public @ResponseBody List<Producto> consultarProducto() {
        System.out.println("Consultando productos ");
        return productoService.consultaProducto();
    }

    @RequestMapping(value = "/consultarInventarioByProdcto", method = RequestMethod.POST)
    public @ResponseBody List<Inventario> consultarInventarioByProdcto(@RequestBody Long productoId) {
        System.out.println("Consultando productos ");
        return productoService.consultarInventarioByProdcto(productoId);
    }
    
    @RequestMapping(value = "/producto", method = RequestMethod.POST)
    public @ResponseBody
    Producto producto(@RequestBody RequestWrapper requestWrapper) {
        String accion = requestWrapper.getAccion();
        Producto producto = requestWrapper.getProducto();
        
        switch (accion) {
            case "alta":
                productoService.altaProducto(producto);
                break;
            case "baja":
                productoService.altaProducto(producto);
                break;
            case "actualiza":
                productoService.altaProducto(producto);
                break;
            default:
                break;
        }
        requestWrapper.getProducto();

        return productoService.altaProducto(producto);
    }

    @RequestMapping(value = "/bajaProducto", method = RequestMethod.POST)
    public @ResponseBody
    Producto bajaProducto(@RequestBody Producto producto) {

        return productoService.bajaProducto(producto);
    }

    @RequestMapping(value = "/actualizaProducto", method = RequestMethod.POST)
    public @ResponseBody
    Producto actualizaProducto(@RequestBody Producto producto) {
        return productoService.actualizaProducto(producto);
    }
}