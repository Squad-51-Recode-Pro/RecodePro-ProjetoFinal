package com.jobteens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobteens.model.Candidatura;
import com.jobteens.repository.CandidaturaRepository;
import com.jobteens.repository.UsuarioRepository;
import com.jobteens.repository.VagasRepository;

@Controller
@RequestMapping("/candidaturas")
public class CandidaturasController {

	@Autowired
	private VagasRepository vagasRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CandidaturaRepository candidaturaRepository;

	// Listar candidaturas
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("candidatura/home");

		modelAndView.addObject("candidaturas", candidaturaRepository.findAll());

		return modelAndView;
	}

	// Cadastrar candidaturas
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("candidatura/form");

		modelAndView.addObject("candidaturas", new Candidatura());
		modelAndView.addObject("vagas", vagasRepository.findAll());
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		
		return modelAndView;
	}

	// Cadastrar candidaturas
	@PostMapping("/cadastrar")
	public String cadastrar(Candidatura candidatura) {

		candidaturaRepository.save(candidatura);

		return "redirect:/candidaturas";
	}

	// Editar candidaturas
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("candidatura/form");
		modelAndView.addObject("candidaturas", candidaturaRepository.findById(id));
		modelAndView.addObject("vagas", vagasRepository.findAll());
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}

	// Editar candidaturas
	@PostMapping("/{id}/editar")
	public String editar(Candidatura candidatura) {

		candidaturaRepository.save(candidatura);
		return "redirect:/candidaturas";
	}

	// Excluir candidaturas
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		candidaturaRepository.deleteById(id);

		return "redirect:/candidaturas";
	}
}
