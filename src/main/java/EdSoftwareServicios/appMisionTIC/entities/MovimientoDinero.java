package EdSoftwareServicios.appMisionTIC.entities;


import EdSoftwareServicios.appMisionTIC.TipoMovimiento;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MovimientoId", nullable = false)
    public Long movimientoId;

    @Column(name = "TipoMovimiento")
    TipoMovimiento tipoMovimiento;

    @Column(name = "Monto")
    private Double monto;
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

    public MovimientoDinero(String monto, String concepto, LocalDate fecha, TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        this.concepto = concepto;
        this.fecha = fecha;
        double valorMonto =Double.parseDouble(monto);
        if (tipoMovimiento==TipoMovimiento.EGRESO || valorMonto>0){
            this.monto = valorMonto*-1;
        }else
            this.monto = valorMonto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
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

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

}
