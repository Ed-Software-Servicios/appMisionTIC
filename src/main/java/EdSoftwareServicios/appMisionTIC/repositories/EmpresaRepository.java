package EdSoftwareServicios.appMisionTIC.repositories;

import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long > {
    public abstract Empresa findByEmpresaId(Long id);
}
