package EdSoftwareServicios.appMisionTIC.entities;


import javax.persistence.*;

@Entity
@Table(name = "movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Monto")
    private double monto;
    @Column(name = "Concepto")
    private String concepto;
    @Column(name = "Fecha")
    private String fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovimientoDinero() {
    }

    public MovimientoDinero(double monto, String concepto, String fecha) {
        this.monto = monto;
        this.concepto = concepto;
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
