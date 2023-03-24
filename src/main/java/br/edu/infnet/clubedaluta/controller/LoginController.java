package br.edu.infnet.clubedaluta.controller;

import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Controller
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getPassword();
        System.out.println(email);
        System.out.println(senha);
        // Consulta o banco de dados para verificar se o usuário existe
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isEmpty()) {
            // O usuário não existe
            LoginResponse response = new LoginResponse(false, null);
            return ResponseEntity.ok(response);
        }

        Usuario usuario = usuarioOptional.get();
        System.out.println(usuario);
        // Verifica se a senha está correta
        if (!senha.equals(usuario.getPassword())) {
            LoginResponse response = new LoginResponse(false, null);
            return ResponseEntity.ok(response);
        }

        // A autenticação foi bem sucedida
        LoginResponse response = new LoginResponse(true, usuario);
        return ResponseEntity.ok(response);
    }

}
