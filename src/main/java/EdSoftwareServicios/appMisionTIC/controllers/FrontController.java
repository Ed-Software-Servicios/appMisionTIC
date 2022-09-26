package EdSoftwareServicios.appMisionTIC.controllers;


import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.repositories.EmpleadoRepository;
import EdSoftwareServicios.appMisionTIC.services.EmpresaServices;
import EdSoftwareServicios.appMisionTIC.services.MovimientosServices;
import EdSoftwareServicios.appMisionTIC.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FrontController {

    EmpresaServices servicioEmp;
    MovimientosServices servicioMov;
    UsuariosServices servicioUser;

    public FrontController(EmpresaServices servicioEmp, MovimientosServices servicioMov, UsuariosServices servicioUser){
        this.servicioEmp = servicioEmp;
        this.servicioMov = servicioMov;
        this.servicioUser = servicioUser;
    }


    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formularioUsuario", new Empleado());
        return "login";
    }

    @PostMapping("/login")
        public String postLogin(@ModelAttribute("formularioUsuario") Empleado usuario){
            return "/";
    }

    @GetMapping("/users")
    public String enterprises(Model model){
        List<Empleado> empleados = this.servicioUser.getListaEmpleados();
        List<Empresa> empresas = this.servicioEmp.getListaEmpresas();
        model.addAttribute("empresas", empresas);
        model.addAttribute("empleados", empleados);
        model.addAttribute("nuevoEmpleado", new Empleado());
        return "users";
    }

    @GetMapping(value = {"/movements"})
    public String movements(Model model, @RequestParam(value = "empId", required = false) Long id){
        List<Empresa> empresas = this.servicioEmp.getListaEmpresas();
        model.addAttribute("empresas", empresas);
        model.addAttribute("id", id);
        model.addAttribute("nuevoMovimiento", new MovimientoDinero());
        if(id!=null){
            Empresa empresa = this.servicioEmp.getEmpresa(id);
            List<MovimientoDinero> movimientos = this.servicioMov.getListaMovimientosEmpresa(id);
            model.addAttribute("movimientosEmpresa", movimientos);
            model.addAttribute("empresaModificar", empresa);
            return "movements";
        }
        return "movements";
    }

    @GetMapping("/enterprises")
    public String users(Model model){
        List<Empresa> empresas = this.servicioEmp.getListaEmpresas();
        model.addAttribute("empresas", empresas);
        model.addAttribute("nuevaEmpresa", new Empresa());
        return "enterprises";
    }

    @GetMapping("/enterprises/{id}")
    public String verEmpresa(@PathVariable("id") Long id, Model model){
        Empresa empresa = this.servicioEmp.getEmpresa(id);
        model.addAttribute("empresa", empresa);
        return "update-enterprise";
    }

    @GetMapping("/movements/{id}")
    public String verMovimiento(@PathVariable("id") Long id, Model model){
        MovimientoDinero movimiento = this.servicioMov.getMovimiento(id);
        model.addAttribute("movimiento", movimiento);
        return "update-movement";
    }

    @GetMapping("/users/{id}")
    public String verEmpleado(@PathVariable("id") Long id, Model model){
        Empleado empleado = this.servicioUser.getEmpleado(id);
        List<Empresa> empresas = this.servicioEmp.getListaEmpresas();
        model.addAttribute("empresas", empresas);
        model.addAttribute("empleado", empleado);
        return "update-user";
    }

}
