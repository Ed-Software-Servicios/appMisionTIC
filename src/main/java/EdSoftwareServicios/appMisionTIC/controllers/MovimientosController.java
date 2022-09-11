package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.services.MovimientosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientosController {
    MovimientosServices servicio;
    public MovimientosController(MovimientosServices servicio){
        this.servicio = servicio;
    }

    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> listaMovimientos(@PathVariable Long id){
        return this.servicio.getListaMovimientosEmpresa(id);
    }

    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero createMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero nuevoMovimiento ){
        return this.servicio.createMovimiento(id, nuevoMovimiento);
    }

    @PatchMapping("/enterprises/{empresa_id}/movements/{movimiento_id}")
    public void patchMovimiento(@PathVariable Long empresa_id,@PathVariable Long movimiento_id, @RequestBody MovimientoDinero modificaciones){
        this.servicio.patchMovimiento(empresa_id, movimiento_id, modificaciones);
    }

    @DeleteMapping("/enterprises/{empresa_id}/movements/{movimiento_id}")
    public void deleteMovimiento(@PathVariable Long empresa_id, @PathVariable Long movimiento_id){
        this.servicio.deleteMovimiento(empresa_id, movimiento_id);
    }
}
