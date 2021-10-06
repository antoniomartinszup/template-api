package br.com.antonio.template.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse salva(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioRepository.save(usuarioRequest.toModel());

        return new UsuarioResponse(usuario);
    }
}
