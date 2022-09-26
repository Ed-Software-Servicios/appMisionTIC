package EdSoftwareServicios.appMisionTIC.services;


import EdSoftwareServicios.appMisionTIC.TipoMovimiento;
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
        if(nuevoMovimiento.getTipoMovimiento() == TipoMovimiento.EGRESO && nuevoMovimiento.getMonto()>0){
            nuevoMovimiento.setMonto(nuevoMovimiento.getMonto()*-1);
        }
        if(nuevoMovimiento.getTipoMovimiento() == TipoMovimiento.INGRESO && nuevoMovimiento.getMonto()<0){
            nuevoMovimiento.setMonto(nuevoMovimiento.getMonto()*-1);
        }
        empresa.setTotal(nuevoMovimiento.getMonto());
        nuevoMovimiento.setEmpresa(empresa);
        return this.repositorioMovimientos.save(nuevoMovimiento);
    }


    public MovimientoDinero getMovimiento(Long movimiento_id){
        return this.repositorioMovimientos.findByMovimientoId(movimiento_id);
    }

    public void patchMovimiento (Long movimiento_id, MovimientoDinero modificaciones){
        MovimientoDinero movimientoPorModificar = this.repositorioMovimientos.findByMovimientoId(movimiento_id);
        Empresa empresa = this.repositorioEmpresas.findByEmpresaId(movimientoPorModificar.getEmpresa().getEmpresaId());

        boolean seModifica = false;


        if (!Objects.equals(modificaciones.getTipoMovimiento(), movimientoPorModificar.getTipoMovimiento())){
            movimientoPorModificar.setTipoMovimiento(modificaciones.getTipoMovimiento());


            if (Objects.equals(modificaciones.getMonto(), movimientoPorModificar.getMonto())){
                empresa.setTotal((movimientoPorModificar.getMonto()*-2));
                movimientoPorModificar.setMonto(modificaciones.getMonto()*-1);
            }
            if (!Objects.equals(modificaciones.getMonto(), movimientoPorModificar.getMonto())){
                empresa.setTotal((movimientoPorModificar.getMonto()*-1));

                if(modificaciones.getTipoMovimiento() == TipoMovimiento.EGRESO && modificaciones.getMonto()>0){
                    movimientoPorModificar.setMonto(modificaciones.getMonto()*-1);
                }else if(modificaciones.getTipoMovimiento() == TipoMovimiento.INGRESO && modificaciones.getMonto()<0){
                        movimientoPorModificar.setMonto(modificaciones.getMonto()*-1);
                }else{
                    movimientoPorModificar.setMonto(modificaciones.getMonto());
                }
                empresa.setTotal((movimientoPorModificar.getMonto()));
            }
            seModifica = true;
        }
        if (Objects.equals(modificaciones.getTipoMovimiento(), movimientoPorModificar.getTipoMovimiento())){

            if (!Objects.equals(modificaciones.getMonto(), movimientoPorModificar.getMonto())){
                empresa.setTotal((movimientoPorModificar.getMonto()*-1));

                if(modificaciones.getTipoMovimiento() == TipoMovimiento.EGRESO && modificaciones.getMonto()>0){
                    movimientoPorModificar.setMonto(modificaciones.getMonto()*-1);
                } else if (modificaciones.getTipoMovimiento() == TipoMovimiento.INGRESO && modificaciones.getMonto()<0){
                    movimientoPorModificar.setMonto(modificaciones.getMonto()*-1);
                } else {
                    movimientoPorModificar.setMonto(modificaciones.getMonto());
                }
                empresa.setTotal(movimientoPorModificar.getMonto());

                seModifica = true;
            }

        }

        if (!Objects.equals(modificaciones.getConcepto(), movimientoPorModificar.getConcepto())){
            movimientoPorModificar.setConcepto(modificaciones.getConcepto());
            seModifica = true;
        }

        if (modificaciones.getFecha() != movimientoPorModificar.getFecha()){
            movimientoPorModificar.setFecha(modificaciones.getFecha());
            seModifica = true;
        }

        if (seModifica){
            this.repositorioMovimientos.save(movimientoPorModificar);
        }


    }

    public Boolean deleteMovimiento(Long movimiento_id) {
        MovimientoDinero movimientoEliminar = getMovimiento(movimiento_id);
        Empresa empresa = this.repositorioEmpresas.findByEmpresaId(movimientoEliminar.getEmpresa().getEmpresaId());
        empresa.setTotal((movimientoEliminar.getMonto()*-1));
        this.repositorioMovimientos.deleteById(movimiento_id);
        return true;
    }

}
