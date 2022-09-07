package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmpleadoServices {
    EmpleadoRepository repositorio;

    public EmpleadoServices(EmpleadoRepository repositorio) {

        this.repositorio = repositorio;
    }
    public List<Empleado> getListaEmpleados(){

        return this.repositorio.findAll();
    }

    public Empleado createEmpleado(Empleado nuevoEmpleado){

        return this.repositorio.save(nuevoEmpleado);
    }



}
