package com.chaqui.sysres.service;

import com.chaqui.sysres.dto.CuentaProductoDto;
import com.chaqui.sysres.dto.ProductoDto;

import com.chaqui.sysres.model.Cuenta;
import com.chaqui.sysres.model.CuentaProducto;
import com.chaqui.sysres.model.Producto;
import com.chaqui.sysres.repository.CuentaProductoRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaProductoService {


    @Autowired
    ProductoService productoService;

    @Autowired
    CuentaService cuentaService;

    @Autowired
    CuentaProductoRepository cuentaProductoRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Agrega un producto a una cuenta
     *
     * @param cuentaProductoDto producto a agregar a la cuenta
     */
    public void agregarProductoACuenta(CuentaProductoDto.Request cuentaProductoDto) {
        Producto producto = this.productoService.obtenerProducto(cuentaProductoDto.getIdProducto());
        Cuenta cuenta = this.cuentaService.obtenerCuenta(cuentaProductoDto.getIdCuenta());
        CuentaProducto cuentaProducto = new CuentaProducto(producto, cuenta, cuentaProductoDto.getComentario());
        this.cuentaProductoRepository.save(cuentaProducto);
    }


    public List<ProductoDto.Response> obtenerProductosDeCuenta(Integer idCuenta) {
        Cuenta cuenta = this.cuentaService.obtenerCuenta(idCuenta);
        List<Producto> productos = this.cuentaProductoRepository.findByCuenta(cuenta.getId());
        if (CollectionUtils.isEmpty(productos)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se encontraron productos para la cuenta con id: " + idCuenta
            );
        }
        return productos.stream().map(tipo ->
                modelMapper.map(tipo, ProductoDto.Response.class)
        ).toList();
    }

    public BigDecimal obtenerTotalCuenta(Integer idCuenta) {
        BigDecimal total = BigDecimal.ZERO;
        List<ProductoDto.Response> productos = this.obtenerProductosDeCuenta(idCuenta);
        for (ProductoDto.Response producto : productos) {
            total = total.add(producto.getPrecio());
        }
        return total;
    }
}
