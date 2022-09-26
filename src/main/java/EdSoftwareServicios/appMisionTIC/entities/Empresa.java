package EdSoftwareServicios.appMisionTIC.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empresaId")
    public Long empresaId;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Telefono")
    private Long telefono;
    @Column(name = "NIT")
    private Long nit;

    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> movimientos;

    @OneToMany(mappedBy = "empresaJefe")
    private List<Empleado> empleados;

    @Column(name="Total")
    private Double total =0.0;


    public Empresa() {
    }

    public Empresa(String nombre, String direccion, Long telefono, Long nit){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setNit(nit);
        this.setTotal(0.0);
    }


    public List<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long id) {
        this.empresaId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double monto) {
        this.total += monto;
    }
    
}
