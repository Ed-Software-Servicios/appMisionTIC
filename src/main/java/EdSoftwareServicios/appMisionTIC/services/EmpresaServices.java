package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmpresaServices {

    private EmpresaRepository repositorio;

    public EmpresaServices(EmpresaRepository repositorio) {
        this.repositorio = repositorio;
    }
    public List<Empresa> getListaEmpresas(){
        return this.repositorio.findAll();
    }

    public Empresa createEmpresa(Empresa nuevaEmpresa){
        return this.repositorio.save(nuevaEmpresa);
    }

}
