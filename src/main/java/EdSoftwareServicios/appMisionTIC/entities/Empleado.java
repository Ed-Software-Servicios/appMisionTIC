package EdSoftwareServicios.appMisionTIC.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmpleadoId", nullable = false)
    private Long empleadoId;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo")
    private String correo;
    @ManyToOne
    @JoinColumn(name = "empresaId")
    @JsonBackReference
    private Empresa empresaJefe;
    @Enumerated(EnumType.STRING)
    private Rol rolEmpleado;

    @Column(name="idEmpresa")
    private Long empresaId;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, Long idEmpresa, Rol rolEmpleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresaId = idEmpresa;
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

    public Empresa getEmpresaJefe() {
        return empresaJefe;
    }

    public void setEmpresaJefe(Empresa empresaJefe) {
        this.empresaJefe = empresaJefe;
    }

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long id) {
        this.empleadoId = id;
    }



}
