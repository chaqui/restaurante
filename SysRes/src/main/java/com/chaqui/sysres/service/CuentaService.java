package com.chaqui.sysres.service;

import com.chaqui.sysres.dto.CuentaDto;
import com.chaqui.sysres.misc.EstadosComanda;
import com.chaqui.sysres.model.Comanda;
import com.chaqui.sysres.model.Cuenta;
import com.chaqui.sysres.repository.CuentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private CuentaProductoService cuentaProductoService;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Obtiene una cuenta de la base de datos
     * @param request
     */
    public void crearCuenta(CuentaDto.Request request) {
        Comanda comanda = this.comandaService.obtenerComanda(request.getIdComanda());
        if (!Objects.equals(comanda.getEstado().getId(), EstadosComanda.ABIERTA)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La comanda no esta abierta"
            );
        }
        Cuenta cuenta = new Cuenta(comanda);
        this.cuentaRepository.save(cuenta);

    }

    /**
     * Cierra una cuenta
     * @param idCuenta id de la cuenta a cerrar
     */
    public void cerrarCuenta(Integer idCuenta) {
        Cuenta cuenta = this.obtenerCuenta(idCuenta);
        Comanda comanda = cuenta.getComanda();
        if (!Objects.equals(comanda.getEstado().getId(), EstadosComanda.ABIERTA)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La comanda no esta abierta"
            );
        }
        if (!Objects.isNull(cuenta.getTotal())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La cuenta ya esta cerrada"
            );
        }
        cuenta.setTotal(this.cuentaProductoService.obtenerTotalCuenta(idCuenta));
    }

    /**
     * Obtener la cuenta de la base de datos
     * @param idCuenta id de la cuenta a obtener
     */
    public CuentaDto.Response obtenerCuentaDto(Integer idCuenta) {
        Cuenta cuenta = this.obtenerCuenta(idCuenta);
        return this.modelMapper.map(cuenta, CuentaDto.Response.class);
    }

    /**
     * Obtiene una cuenta de la base de datos por su id, si no existe lanza una excepcion, si existe la retorna, no usar en controladores
     *
     * @param idCuenta id de la cuenta
     * @return cuenta
     */
    public Cuenta obtenerCuenta(Integer idCuenta) {
        return this.cuentaRepository.findById(idCuenta).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "No existe la cuenta"
        ));
    }

}
