package com.jobteens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobteens.enums.Perfil;
import com.jobteens.model.Usuario;
import com.jobteens.repository.UsuarioRepository;
import com.jobteens.utils.SenhaUtils;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Listar usuários
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("usuario/home");

		modelAndView.addObject("usuarios", usuarioRepository.findAll());

		return modelAndView;
	}

	// Cadastrar usuários
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("usuario/form");

		modelAndView.addObject("usuario", new Usuario());

		return modelAndView;
	}

	// Cadastrar usuários
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		String senhaEncriptada = SenhaUtils.encoder(usuario.getSenha());

		usuario.setSenha(senhaEncriptada);
		usuario.setPerfil(Perfil.USUARIO);

		usuarioRepository.save(usuario);

		return "redirect:/usuarios";
	}

	// Editar usuários
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("usuario/form");

		modelAndView.addObject("usuario", usuarioRepository.findById(id));

		return modelAndView;
	}

	// Editar usuários
	@PostMapping("/{id}/editar")
	public String editar(Usuario usuario) {
		String senhaEncriptada = SenhaUtils.encoder(usuario.getSenha());

		usuario.setSenha(senhaEncriptada);
		usuarioRepository.save(usuario);

		return "redirect:/usuarios";
	}

	// Excluir usuários
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		usuarioRepository.deleteById(id);

		return "redirect:/usuarios";
	}

}
