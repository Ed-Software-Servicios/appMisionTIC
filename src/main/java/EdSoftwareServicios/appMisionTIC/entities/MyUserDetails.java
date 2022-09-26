package EdSoftwareServicios.appMisionTIC.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String password;
    private String userName;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(Empleado empleado){
        this.password = empleado.getPassword();
        this.userName = empleado.getCorreo();
        this.authorities = new ArrayList<>();

        for (Rol rol: empleado.getRolEmpleado()){
            this.authorities.add(new SimpleGrantedAuthority(rol.name()));
        }
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
