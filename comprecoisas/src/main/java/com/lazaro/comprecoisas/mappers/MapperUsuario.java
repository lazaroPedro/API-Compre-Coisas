package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Usuario;
import com.lazaro.comprecoisas.model.dtos.UsuarioDTO;

public class MapperUsuario {
    public static Usuario toEntity(UsuarioDTO usuario) {
        Usuario usuarioRetorno = new Usuario();
        usuarioRetorno.setId(usuario.getId());
        usuarioRetorno.setNome(usuario.getNome());
        usuarioRetorno.setEmail(usuario.getEmail());
        usuarioRetorno.setCpf(usuario.getCpf());
        usuarioRetorno.setTelefone(usuario.getTelefone());
        usuarioRetorno.setGenero(usuario.getGenero());
        return usuarioRetorno;
    }
    public static UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO usuarioRetorno = new UsuarioDTO();
        usuarioRetorno.setId(usuario.getId());
        usuarioRetorno.setNome(usuario.getNome());
        usuarioRetorno.setEmail(usuario.getEmail());
        usuarioRetorno.setCpf(usuario.getCpf());
        usuarioRetorno.setTelefone(usuario.getTelefone());
        usuarioRetorno.setGenero(usuario.getGenero());
        return usuarioRetorno;
    }
}
