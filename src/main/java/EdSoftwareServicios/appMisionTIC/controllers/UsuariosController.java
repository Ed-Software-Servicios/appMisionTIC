package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.services.UsuariosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    UsuariosServices servicio;

    public UsuariosController(UsuariosServices servicio){
        this.servicio = servicio;
    }

    @GetMapping("/users")
    public List<Empleado> listaEmpleados(){
        return this.servicio.getListaEmpleados();
    }

    @GetMapping("/users/{id}")
    public Empleado empleadoBuscado(@PathVariable Long id){
        return this.servicio.getEmpleado(id);
    }

    @PostMapping("/users")
    public Empleado createEmpleado(@RequestBody Empleado nuevoEmpleado){
        return this.servicio.createEmpleado(nuevoEmpleado);
    }
    @DeleteMapping("/users/{id}")
    public void deleteEmpresa(@PathVariable Long id){
        this.servicio.deleteEmpleado(id);
    }

    @PatchMapping("/users/{id}")
    public void patchEmpleado(@PathVariable Long id, @RequestBody Empleado modificaciones){
        this.servicio.patchUsuario(id,modificaciones);
    }

}
