package EdSoftwareServicios.appMisionTIC.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empresaId")
    private Long empresaId;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Telefono")
    private long telefono;
    @Column(name = "NIT")
    private int nit;

    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> movimientos;

    @OneToMany(mappedBy = "empresaJefe")
    private List<Empleado> empleados;


    public Empresa() {
    }

    public Empresa(String nombre, String direccion, long telefono, int nit){
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setNit(nit);
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
