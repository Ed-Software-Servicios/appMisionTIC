package EdSoftwareServicios.appMisionTIC.entities;

public class MovimientoDinero {
    private double monto;
    private String concepto;
    private String fecha;

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
