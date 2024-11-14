package com.olpasa.security;

import com.olpasa.model.Usuario;
import com.olpasa.repo.IUsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Clase S4
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final IUsuarioRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repo.findOneByNombreCuenta(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getPrivilegios().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getDescripcion()));
        });

        return new org.springframework.security.core.userdetails.User(usuario.getNombre_cuenta(), usuario.getPassword(), roles);
    }
}
