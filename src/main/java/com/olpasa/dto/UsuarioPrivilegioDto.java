package com.olpasa.dto;


import com.olpasa.model.Privilegio;
import com.olpasa.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioPrivilegioDto {

    private Integer id_up;
    private Usuario nombre_cuenta;
    private Privilegio id_privilegio;
}
