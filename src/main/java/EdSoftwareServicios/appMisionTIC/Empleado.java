package EdSoftwareServicios.appMisionTIC;

public class Empleado {
    private String nombre;
    private String correo;
    private Empresa empresaJefe;
    private Rol rolEmpleado;

    public Empleado(String nombre, String correo, Empresa empresaJefe, Rol rolEmpleado) {
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
}
