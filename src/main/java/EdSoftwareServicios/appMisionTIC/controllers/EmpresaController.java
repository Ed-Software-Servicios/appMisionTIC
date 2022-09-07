package EdSoftwareServicios.appMisionTIC.controllers;


import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.services.EmpresaServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

    @PostMapping("/enterprises")
    public Empresa createEmpresa(@RequestBody Empresa nuevaEmpresa){
        return this.servicio.createEmpresa(nuevaEmpresa);
    }

}
