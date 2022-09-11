package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;


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

        if (modificaciones.getNombre()!=null) {
            empresaPorModificar.setNombre(modificaciones.getNombre());
            seModifica = true;
        }

        if (modificaciones.getDireccion()!=null) {
            empresaPorModificar.setDireccion(modificaciones.getDireccion());
            seModifica = true;
        }

        if (modificaciones.getNit() > 0) {
            empresaPorModificar.setNit(modificaciones.getNit());
            seModifica = true;
        }
        if (modificaciones.getTelefono() > 0) {
            empresaPorModificar.setTelefono(modificaciones.getTelefono());
            seModifica = true;
        }
        if (seModifica) {
            this.repositorio.save(empresaPorModificar);
        }

    }

}
