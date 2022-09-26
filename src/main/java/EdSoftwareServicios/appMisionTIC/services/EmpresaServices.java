package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class EmpresaServices {

    private EmpresaRepository repositorio;

    public EmpresaServices(EmpresaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Empresa> getListaEmpresas(){
        return this.repositorio.findAll();
    }

    public Empresa getEmpresa(Long id){
        return this.repositorio.findByEmpresaId(id);
    }

    public Empresa createEmpresa(Empresa nuevaEmpresa){
        return this.repositorio.save(nuevaEmpresa);
    }

    public void deleteEmpresa(Long id) {
        this.repositorio.deleteById(id);
    }

    public void patchEmpresa(Long id, Empresa modificaciones){

        Empresa empresaPorModificar = this.repositorio.findByEmpresaId(id);

        boolean seModifica = false;

        if (!Objects.equals(modificaciones.getNombre(), empresaPorModificar.getNombre())) {
            empresaPorModificar.setNombre(modificaciones.getNombre());
            seModifica = true;
        }

        if (!Objects.equals(modificaciones.getDireccion(), empresaPorModificar.getDireccion())) {
            empresaPorModificar.setDireccion(modificaciones.getDireccion());
            seModifica = true;
        }

        if (!Objects.equals(modificaciones.getNit(), empresaPorModificar.getNit())) {
            empresaPorModificar.setNit(modificaciones.getNit());
            seModifica = true;
        }
        if (!Objects.equals(modificaciones.getTelefono(), empresaPorModificar.getTelefono())) {
            empresaPorModificar.setTelefono(modificaciones.getTelefono());
            seModifica = true;
        }
        if (seModifica) {
            this.repositorio.save(empresaPorModificar);
        }

    }

}
