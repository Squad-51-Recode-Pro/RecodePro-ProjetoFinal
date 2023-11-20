package com.jobteens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobteens.enums.Perfil;
import com.jobteens.model.Empresa;
import com.jobteens.repository.EmpresaRepository;
import com.jobteens.utils.SenhaUtils;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	private EmpresaRepository empresaRepository;

	// Listar empresa
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("empresa/home");

		modelAndView.addObject("empresas", empresaRepository.findAll());

		return modelAndView;
	}

	// Cadastrar empresa
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("empresa/form");

		modelAndView.addObject("empresa", new Empresa());

		return modelAndView;
	}

	// Cadastrar empresa
	@PostMapping("/cadastrar")
	public String cadastrar(Empresa empresa) {
		String senhaEncriptada = SenhaUtils.encoder(empresa.getSenha());

		empresa.setSenha(senhaEncriptada);
		empresa.setPerfil(Perfil.EMPRESA);
		
		empresaRepository.save(empresa);

		return "redirect:/empresa";
	}

	// Editar empresa
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("empresa/form");
		modelAndView.addObject("empresa", empresaRepository.findById(id));
		return modelAndView;
	}

	// Editar empresa
	@PostMapping("/{id}/editar")
	public String editar(Empresa empresa) {
		String senhaEncriptada = SenhaUtils.encoder(empresa.getSenha());

		empresa.setSenha(senhaEncriptada);
		
		empresaRepository.save(empresa);
		return "redirect:/empresa";
	}

	// Excluir empresa
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		empresaRepository.deleteById(id);

		return "redirect:/empresa";
	}
}
