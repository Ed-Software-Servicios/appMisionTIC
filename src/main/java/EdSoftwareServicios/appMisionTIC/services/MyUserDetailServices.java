package EdSoftwareServicios.appMisionTIC.services;

import EdSoftwareServicios.appMisionTIC.entities.Empleado;
import EdSoftwareServicios.appMisionTIC.entities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    UsuariosServices usuariosService;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Empleado usuario;

        try {
          usuario  = usuariosService.getUsuario(correo);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new MyUserDetails(usuario);
    }
}
