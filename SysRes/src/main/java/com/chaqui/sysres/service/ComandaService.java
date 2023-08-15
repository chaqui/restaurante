package com.chaqui.sysres.service;

import com.chaqui.sysres.dto.ComandaDto;
import com.chaqui.sysres.misc.EstadosComanda;
import com.chaqui.sysres.model.Comanda;
import com.chaqui.sysres.model.Tipo;
import com.chaqui.sysres.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ComandaService {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private ComandaRepository comandaRepository;

    /**
     * Crea una comanda en la base de datos
     * @param request datos de la comanda
     */
    public void crearComanda(ComandaDto.Request request) {
        Optional<Comanda> comandaOptional = this.comandaRepository.findByMesaAAndEstado(request.getIdMesa(), EstadosComanda.ABIERTA);
        if (comandaOptional.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Ya existe una comanda abierta para esa mesa"
            );
        }
        Tipo mesa = this.tipoService.getTipo(request.getIdMesa());
        Tipo estado = this.tipoService.getTipo(EstadosComanda.ABIERTA);
        Comanda comanda = new Comanda(mesa, estado);
        this.comandaRepository.save(comanda);
    }

    /**
     * Cierra una comanda
     * @param idComanda id de la comanda a cerrar
     */
    public void cerrarComanda(Integer idComanda) {
        Comanda comanda = this.obtenerComanda(idComanda);
        Tipo estado = this.tipoService.getTipo(EstadosComanda.PAGADA);
        comanda.setEstado(estado);
        this.comandaRepository.save(comanda);
    }

    /**
     * Cancela una comanda
     * @param idComanda id de la comanda a cancelar
     */
    public void cancelarComanda(Integer idComanda) {
        Comanda comanda = this.obtenerComanda(idComanda);
        Tipo estado = this.tipoService.getTipo(EstadosComanda.CANCELADA);
        comanda.setEstado(estado);
        this.comandaRepository.save(comanda);
    }

    /**
     * Obtiene una comanda de la base de datos por id o lanza una excepcion si no existe la comanda, no usar en controladores
     * @param idComanda id de la comanda a obtener
     * @return comanda obtenida
     */
    public Comanda obtenerComanda(Integer idComanda) {
        return this.comandaRepository.findById(idComanda).orElseThrow( () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontro la comanda"
        ));
    }

    /**
     * Obtiene una comanda abierta por mesa
     * @param idMesa id de la mesa
     * @return comanda abierta
     */
    public Comanda obtenerComandaAbiertaPorMesa(Integer idMesa) {
        return this.comandaRepository.findByMesaAAndEstado(idMesa, EstadosComanda.ABIERTA).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontro la comanda"
        ));
    }

}
