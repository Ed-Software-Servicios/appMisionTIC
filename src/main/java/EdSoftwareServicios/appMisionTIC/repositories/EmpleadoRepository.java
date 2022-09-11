package EdSoftwareServicios.appMisionTIC.repositories;


import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    public abstract Empleado findByEmpleadoId(Long id);

}
