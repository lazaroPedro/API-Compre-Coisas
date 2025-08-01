package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Usuario;
import com.lazaro.comprecoisas.model.dtos.UsuarioRequestDTO;

public class MapperUsuarioRequest {
    public static Usuario toEntity(UsuarioRequestDTO usuario) {
        Usuario usuarioRetorno = new Usuario();
        usuarioRetorno.setNome(usuario.getNome());
        usuarioRetorno.setEmail(usuario.getEmail());
        usuarioRetorno.setCpf(usuario.getCpf());
        usuarioRetorno.setTelefone(usuario.getTelefone());
        usuarioRetorno.setGenero(usuario.getGenero());
        return usuarioRetorno;
    }
    public static UsuarioRequestDTO toDto(Usuario usuario) {
        UsuarioRequestDTO usuarioRetorno = new UsuarioRequestDTO();
        usuarioRetorno.setNome(usuario.getNome());
        usuarioRetorno.setEmail(usuario.getEmail());
        usuarioRetorno.setCpf(usuario.getCpf());
        usuarioRetorno.setTelefone(usuario.getTelefone());
        usuarioRetorno.setGenero(usuario.getGenero());
        return usuarioRetorno;
    }
}
