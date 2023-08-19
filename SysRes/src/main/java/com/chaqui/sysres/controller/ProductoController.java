package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.ProductoDto;
import com.chaqui.sysres.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "producto")
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
    @Operation(summary = "Crea un producto")
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
    @Operation(summary =  "Consulta los tipos por descriminador")
    public List<ProductoDto.Response> obtenerProductos(@Parameter(name = "idTipo", description = "Id del tipo de producto a consultar")
                                                           @RequestParam(required = true)
                                                           @NotNull(message = "Debe especificar el tipo de producto")Integer idTipo) {
        return productoService.obtenerProductos(idTipo);
    }
}
