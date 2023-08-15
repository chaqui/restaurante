package com.chaqui.sysres.service;

import com.chaqui.sysres.dto.ProductoDto;
import com.chaqui.sysres.misc.Descriminadores;
import com.chaqui.sysres.model.Producto;
import com.chaqui.sysres.model.Tipo;
import com.chaqui.sysres.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    /**
     * Repositorio de productos
     */
    @Autowired
    ProductoRepository productoRepository;

    /**
     * Servicio de tipos
     */
    @Autowired
    TipoService tipoService;

    /**
     * ModelMapper para mapear objetos
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Guarda un producto en la base de datos
     *
     * @param productoDto producto a guardar
     */
    public void guardarProducto(ProductoDto.Request productoDto) {
        Tipo tipo = this.tipoService.getTipo(productoDto.getIdTipo());

        Optional<Producto> productoOptional = this.obtenerProductoPorNombre(productoDto.getNombre());
        if (productoOptional.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Ya existe un producto con ese nombre"
            );
        }
        if (!Descriminadores.PRODUCTO.equals(tipo.getDescriminador())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El tipo no es un producto"
            );
        }
        Producto producto = new Producto(productoDto, tipo);
        productoRepository.save(producto);
    }

    /**
     * Obtiene los productos por tipo
     *
     * @param idTipo id del tipo a buscar
     * @return lista de productos
     */
    public List<ProductoDto.Response> obtenerProductos(Integer idTipo) {
        Tipo tipo = tipoService.getTipo(idTipo);
        List<Producto> productos = productoRepository.findByTipo(tipo.getId());
        return productos.stream().map(producto ->
                modelMapper.map(producto, ProductoDto.Response.class)
        ).toList();
    }


    /**
     * Obtiene un producto por su id, solo usar de forma interna, no exponer en el controlador
     *
     * @param idProducto
     * @return
     */
    public Producto obtenerProducto(Integer idProducto) {
        return productoRepository.findById(idProducto).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontro el producto"
        ));
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
