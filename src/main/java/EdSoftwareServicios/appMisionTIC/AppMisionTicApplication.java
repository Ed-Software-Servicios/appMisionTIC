package EdSoftwareServicios.appMisionTIC;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.entities.Empresa;
import EdSoftwareServicios.appMisionTIC.entities.MovimientoDinero;
import EdSoftwareServicios.appMisionTIC.entities.Rol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AppMisionTicApplication {
    public static void main(String[] args) {

        SpringApplication.run(AppMisionTicApplication.class, args);

    }
}
        /*
		//Instansacion de las clases
		Empresa empresa = new Empresa("Empresademo Ltda. ", "Carrera 7 # 13", 7234123, 5432143);
		Empleado vendedor = new Empleado("Juan", "Juan@gmail.com", empresa, Rol.OPERATIVO);
		MovimientoDinero movimiento = new MovimientoDinero(654343.50,"ingresos de julio", LocalDate.of(2022,12,12));

		//Modificacion de los datos de la clase
		empresa.setDireccion("Calle 5 # 2-1");
		vendedor.setNombre("Juan Guzman");
		movimiento.setMonto(-500.80);


		System.out.println("Existe una instancia de Empresa: \n"
				+ empresa.getNombre() + "\n" + empresa.getNit() + "\n" + empresa.getDireccion() + "\n" + empresa.getTelefono() + "\n"
				+ "Existe una instancia de Empleado: \n" + vendedor.getNombre() + "\n" + vendedor.getCorreo() + "\n" + vendedor.getRolEmpleado() + "\n"
				+ "Existe una instancia de MovimientoDinero:\n" + movimiento.getMonto() + "\n" + movimiento.getConcepto() + "\n" + movimiento.getFecha() + "\n"
				+ "Los datos se pueden leer y modificar como se puede evidenciar en el codigo");
	}
         */

