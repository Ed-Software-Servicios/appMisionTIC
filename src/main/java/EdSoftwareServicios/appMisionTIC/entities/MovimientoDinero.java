package EdSoftwareServicios.appMisionTIC.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MovimientoId", nullable = false)
    private Long movimientoId;

    @Column(name = "Monto")
    private double monto;
    @Column(name = "Concepto")
    private String concepto;
    @Column(name = "Fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "empresaId")
    @JsonBackReference
    private Empresa empresa;

    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long id) {
        this.movimientoId = id;
    }

    public MovimientoDinero() {
    }

    public MovimientoDinero(double monto, String concepto, LocalDate fecha) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
