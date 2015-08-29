package com.tickets.web.controllers;

import com.tickets.api.entitys.catalogos.Usuario;
import com.tickets.services.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuariosController {

    @Resource
    UsuarioService usuarioService;

    @RequestMapping(value = "/altaUsuario", method = RequestMethod.POST)
    public @ResponseBody Usuario altaUsuario(@RequestBody Usuario usuario) {
        return usuarioService.altaUsuario(usuario);
    }
    
    @RequestMapping(value = "/consultaUsuarios", method = RequestMethod.POST)
    public @ResponseBody List<Usuario> consultaUsuarios() {
        return usuarioService.consultaUsuariosList();
    }
    
    @RequestMapping(value = "/bajaUsuario", method = RequestMethod.POST)
    public @ResponseBody boolean bajaUsuario(@RequestBody Long id) {
        usuarioService.bajaUsuario(id);
        return true;
    }
    /*
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
    
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
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
    }*/
}