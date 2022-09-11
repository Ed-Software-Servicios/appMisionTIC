package EdSoftwareServicios.appMisionTIC.controllers;


import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.services.EmpresaServices;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class EmpresaController {

    EmpresaServices servicio;

    public EmpresaController(EmpresaServices servicio){
        this.servicio = servicio;
    }

    @GetMapping("/enterprises")
    public List<Empresa> listaEmpresas(){
        return this.servicio.getListaEmpresas();
    }

    @GetMapping("/enterprises/{id}")
    public Empresa empresaBuscada(@PathVariable Long id){
        return this.servicio.getEmpresa(id);
    }

    @PostMapping("/enterprises")
    public Empresa createEmpresa(@RequestBody Empresa nuevaEmpresa){
        return this.servicio.createEmpresa(nuevaEmpresa);
    }

    @DeleteMapping("/enterprises/{id}")
    public void deleteEmpresa(@PathVariable Long id){
        this.servicio.deleteEmpresa(id);
    }

    @PatchMapping("/enterprises/{id}")
    public void patchEmpresa(@PathVariable Long id, @RequestBody Empresa modificaciones){
        this.servicio.patchEmpresa(id,modificaciones);
    }


}
