package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.services.MovimientosServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientosController {
    MovimientosServices servicio;
    public MovimientosController(MovimientosServices servicio){
        this.servicio = servicio;
    }

    @GetMapping("/movimientos")
    public List<MovimientoDinero> listaMovimientos(){
        return this.servicio.getListaMovimientos();
    }

    @PostMapping("/movimientos")
    public MovimientoDinero createMovimiento(@RequestBody MovimientoDinero nuevoMovimiento){
        return this.servicio.createMovimiento(nuevoMovimiento);
    }
}
