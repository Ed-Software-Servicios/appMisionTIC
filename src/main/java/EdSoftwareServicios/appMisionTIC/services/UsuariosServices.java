package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.repositories.EmpleadoRepository;
import EdSoftwareServicios.appMisionTIC.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UsuariosServices {
    EmpleadoRepository repositorio;
    EmpresaRepository repositorioEmpresa;

    public UsuariosServices(EmpleadoRepository repositorio, EmpresaRepository repositorioEmp) {
        this.repositorio = repositorio;
        this.repositorioEmpresa = repositorioEmp;
    }

    public List<Empleado> getListaEmpleados(){
        return this.repositorio.findAll();
    }

    public Empleado getEmpleado(Long id){
        return this.repositorio.findByEmpleadoId(id);
    }

    public Empleado getUsuario(String correo){
        return this.repositorio.findByCorreo(correo);
    }

    public Empleado createEmpleado(Empleado nuevoEmpleado){
        Empresa empresaJef = this.repositorioEmpresa.findByEmpresaId(nuevoEmpleado.getEmpresaId());
        nuevoEmpleado.setEmpresaJefe(empresaJef);
        return this.repositorio.save(nuevoEmpleado);
    }

    public void deleteEmpleado(Long id) {
        this.repositorio.deleteById(id);
    }


    public void patchUsuario(Long id, Empleado modificaciones){
        Empleado empleadoPorModificar = this.repositorio.findByEmpleadoId(id);

        boolean seModifica = false;

        if (!Objects.equals(modificaciones.getCorreo(), empleadoPorModificar.getCorreo())){
            empleadoPorModificar.setCorreo(modificaciones.getCorreo());
            seModifica = true;
        }

        if (!Objects.equals(modificaciones.getNombre(), empleadoPorModificar.getNombre()))  {
            empleadoPorModificar.setNombre(modificaciones.getNombre());
            seModifica = true;
        }

        if (!Objects.equals(modificaciones.getPassword(), empleadoPorModificar.getPassword()))  {
            empleadoPorModificar.setPassword(modificaciones.getPassword());
            seModifica = true;
        }

        if (!Objects.equals(modificaciones.getEmpresaId(), empleadoPorModificar.getEmpresaId()))  {
            empleadoPorModificar.setEmpresaId(modificaciones.getEmpresaId());
            Empresa empresaJef = this.repositorioEmpresa.findByEmpresaId(modificaciones.getEmpresaId());
            empleadoPorModificar.setEmpresaJefe(empresaJef);
            seModifica = true;
        }
        if (modificaciones.getRolEmpleado() != empleadoPorModificar.getRolEmpleado())  {
            empleadoPorModificar.setRolEmpleado(modificaciones.getRolEmpleado());
            seModifica = true;
        }

        if (seModifica){
            this.repositorio.save(empleadoPorModificar);
        }
    }

}
