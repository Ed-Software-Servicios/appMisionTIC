package EdSoftwareServicios.appMisionTIC.services;


import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.repositories.EmpresaRepository;
import EdSoftwareServicios.appMisionTIC.repositories.MovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovimientosServices {
    private MovimientoDineroRepository repositorioMovimientos;
    private EmpresaRepository repositorioEmpresas;

    public MovimientosServices(MovimientoDineroRepository repositorio, EmpresaRepository repositorioEmpresas){
        this.repositorioMovimientos = repositorio;
        this.repositorioEmpresas = repositorioEmpresas;
    }

    public List<MovimientoDinero> getListaMovimientosEmpresa (Long id){
        Empresa empresa = this.repositorioEmpresas.findByEmpresaId(id);
        return empresa.getMovimientos();
    }

    public MovimientoDinero createMovimiento(Long id, MovimientoDinero nuevoMovimiento){
        Empresa empresa = this.repositorioEmpresas.findByEmpresaId(id);
        nuevoMovimiento.setEmpresa(empresa);
        return this.repositorioMovimientos.save(nuevoMovimiento);
    }

    public void patchMovimiento (Long empresa_id, Long movimiento_id, MovimientoDinero modificaciones){

        MovimientoDinero movimientoPorModificar = this.repositorioMovimientos.findByMovimientoId(movimiento_id);
        if (Objects.equals(movimientoPorModificar.getEmpresa().getEmpresaId(), empresa_id)) {

            boolean seModifica = false;

            if (modificaciones.getConcepto() != null){
                movimientoPorModificar.setConcepto(modificaciones.getConcepto());
                seModifica = true;
            }

            if (modificaciones.getFecha() != null){
                movimientoPorModificar.setFecha(modificaciones.getFecha());
                seModifica = true;
            }
            if (modificaciones.getMonto() != 0){
                movimientoPorModificar.setMonto(modificaciones.getMonto());
                seModifica = true;
            }
            if (seModifica){
                this.repositorioMovimientos.save(movimientoPorModificar);
            }
        }
    }

    public void deleteMovimiento(Long empresa_id, Long movimiento_id) {
        MovimientoDinero movimientoABorrar = this.repositorioMovimientos.findByMovimientoId(movimiento_id);
        if (Objects.equals(movimientoABorrar.getEmpresa().getEmpresaId(), empresa_id)) {
            this.repositorioMovimientos.deleteById(movimiento_id);
        }
    }

}
