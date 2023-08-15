package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.ProductoDto;
import com.chaqui.sysres.service.ProductoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "producto")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /**
     * Crea un producto
     *
     * @param request datos del producto a crear
     */
    @PostMapping
    @ApiOperation(value = "Crea un producto", notes = "Crea un producto en el sistema")
    @ResponseStatus(code = HttpStatus.OK, reason = "Producto creado")
    public void crearProducto(@RequestBody ProductoDto.Request request) {
        this.productoService.guardarProducto(request);
    }

    /**
     * Obtiene los productos por tipo
     *
     * @param idTipo id del tipo a que pertenecen los productos
     * @return lista de productos
     */
    @ResponseBody
    @GetMapping
    @ApiOperation(value = "Consulta los tipos por descriminador")
    public List<ProductoDto.Response> obtenerProductos(@ApiParam(value = "Descriminador de tipos a consultar")
                                                           @RequestParam(required = true)
                                                           @NotNull(message = "Debe especificar el tipo de producto")Integer idTipo) {
        return productoService.obtenerProductos(idTipo);
    }
}
