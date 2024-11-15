package com.gymteam.gymteam.modelos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class TrabajadorDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final Trabajador trabajador;

    public TrabajadorDetails(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Sin roles ni autoridades
    }

    @Override
    public String getPassword() {
        return trabajador.getPassword();
    }

    @Override
    public String getUsername() {
        return trabajador.getUsername();
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


