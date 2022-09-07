package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.services.EmpleadoServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuariosController {

    EmpleadoServices servicio;

    public UsuariosController(EmpleadoServices servicio){
        this.servicio = servicio;
    }

    @GetMapping("/users")
    public List<Empleado> listaEmpleados(){
        return this.servicio.getListaEmpleados();
    }

    @PostMapping("/users")
    public Empleado createEmpleado(@RequestBody Empleado nuevoEmpleado){
        return this.servicio.createEmpleado(nuevoEmpleado);
    }


}
