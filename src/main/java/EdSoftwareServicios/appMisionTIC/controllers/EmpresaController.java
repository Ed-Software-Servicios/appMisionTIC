package EdSoftwareServicios.appMisionTIC.controllers;


import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.services.EmpresaServices;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;


@RestController
public class EmpresaController {

    EmpresaServices servicio;

    public EmpresaController(EmpresaServices servicio){
        this.servicio = servicio;
    }
/*
    @GetMapping("/enterprises")
    public List<Empresa> listaEmpresas(){
        return this.servicio.getListaEmpresas();
    }

    @GetMapping("/enterprises/{id}")
    public Empresa empresaBuscada(@PathVariable Long id){
        return this.servicio.getEmpresa(id);
    }

 */

    @PostMapping("/enterprises")
    public RedirectView createEmpresa(@ModelAttribute Empresa nuevaEmpresa, Model model){
        model.addAttribute(nuevaEmpresa);
        this.servicio.createEmpresa(nuevaEmpresa);

        return new RedirectView("/enterprises");
    }

    @DeleteMapping("/enterprises/{id}")
    public RedirectView deleteEmpresa(@PathVariable Long id){
        this.servicio.deleteEmpresa(id);
        return new RedirectView("/enterprises");
    }

    @PatchMapping("/enterprises/{id}")
    public RedirectView patchEmpresa(@PathVariable("id") Long id, @ModelAttribute Empresa modificaciones, Model model){
        model.addAttribute(modificaciones);
        this.servicio.patchEmpresa(id,modificaciones);
        return new RedirectView("/enterprises");
    }


}
