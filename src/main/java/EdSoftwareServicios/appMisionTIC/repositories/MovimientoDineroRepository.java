package EdSoftwareServicios.appMisionTIC.repositories;

import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Long> {
}
