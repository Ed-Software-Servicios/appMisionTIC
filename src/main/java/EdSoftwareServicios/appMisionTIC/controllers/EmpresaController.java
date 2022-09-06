package EdSoftwareServicios.appMisionTIC.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpresaController {

    @GetMapping("/enterprises")
    public String Empresa(){
        return "si se ve esta funcionando, y ahora se actualiza tambien";
    }

    @GetMapping("/enterprises/id")
    public String entre(){
        return "Que es esto?";
    }
}
