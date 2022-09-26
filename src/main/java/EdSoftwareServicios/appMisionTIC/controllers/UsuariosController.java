package EdSoftwareServicios.appMisionTIC.controllers;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.services.UsuariosServices;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class UsuariosController {

    UsuariosServices servicio;

    public UsuariosController(UsuariosServices servicio){
        this.servicio = servicio;
    }
/*
    @GetMapping("/users")
    public List<Empleado> listaEmpleados(){
        return this.servicio.getListaEmpleados();
    }
    @GetMapping("/users/{id}")
    public Empleado empleadoBuscado(@PathVariable Long id){
        return this.servicio.getEmpleado(id);
    }
*/

    @PostMapping("/users")
    public RedirectView createEmpleado(@ModelAttribute Empleado nuevoEmpleado, Model model){
        model.addAttribute(nuevoEmpleado);
        this.servicio.createEmpleado(nuevoEmpleado);
        return new RedirectView("/users");
    }


    @DeleteMapping("/users/{id}")
    public RedirectView deleteEmpleado(@PathVariable Long id){
        this.servicio.deleteEmpleado(id);
        return new RedirectView("/users");
    }


    @PatchMapping("/users/{id}")
    public RedirectView patchEmpleado(@PathVariable("id") Long id, @ModelAttribute Empleado modificaciones, Model model){
        model.addAttribute(modificaciones);
        this.servicio.patchUsuario(id,modificaciones);
        return new RedirectView("/users");
    }

}
