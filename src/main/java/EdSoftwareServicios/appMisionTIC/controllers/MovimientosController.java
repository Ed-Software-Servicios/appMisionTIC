package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.services.MovimientosServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class MovimientosController {
    MovimientosServices servicio;
    public MovimientosController(MovimientosServices servicio){
        this.servicio = servicio;
    }

/*
    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> listaMovimientos(@PathVariable Long id){
        return this.servicio.getListaMovimientosEmpresa(id);
    }

*/
    @PostMapping("/movements/{id}")
    public RedirectView createMovimiento(@PathVariable("id") Long id, @ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") MovimientoDinero nuevoMovimiento, Model model){
        model.addAttribute(nuevoMovimiento);
        this.servicio.createMovimiento(id, nuevoMovimiento);
        return new RedirectView("/movements");
    }

    @PatchMapping("/movements/{id}")
    public RedirectView patchMovimiento(@PathVariable("id") Long movimiento_id, @ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") MovimientoDinero modificaciones, Model model){
        model.addAttribute(modificaciones);
        this.servicio.patchMovimiento(movimiento_id, modificaciones);
        return new RedirectView("/movements");
    }

    @DeleteMapping("/movements/{idm}")
    public RedirectView deleteMovimiento(@PathVariable("idm") Long movimiento_id){
        this.servicio.deleteMovimiento(movimiento_id);
        return new RedirectView("/movements");
    }
    /*
    public RedirectView deleteEmpresa(@PathVariable Long id){
        this.servicio.deleteEmpresa(id);
        return new RedirectView("/enterprises");
    }*/
}
