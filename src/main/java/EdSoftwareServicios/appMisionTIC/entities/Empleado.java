package EdSoftwareServicios.appMisionTIC.entities;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Empresa")
    private String empresaJefe;
    @Column(name = "Rol")
    private Rol rolEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado() {
    }

    public Empleado(String nombre, String correo, String empresaJefe, Rol rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaJefe = empresaJefe;
        this.rolEmpleado = rolEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaJefe() {
        return empresaJefe;
    }

    public void setEmpresaJefe(String empresaJefe) {
        this.empresaJefe = empresaJefe;
    }

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
