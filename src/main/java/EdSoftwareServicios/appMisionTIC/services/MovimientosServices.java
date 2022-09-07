package EdSoftwareServicios.appMisionTIC.services;


import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.repositories.MovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientosServices {
    private MovimientoDineroRepository repositorio;

    public MovimientosServices(MovimientoDineroRepository repositorio){
        this.repositorio = repositorio;
    }

    public List<MovimientoDinero> getListaMovimientos(){
        return this.repositorio.findAll();
    }

    public MovimientoDinero createMovimiento(MovimientoDinero nuevoMovimiento){
        return this.repositorio.save(nuevoMovimiento);
    }

}
