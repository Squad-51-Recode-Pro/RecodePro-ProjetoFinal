package com.jobteens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobteens.model.Vagas;
import com.jobteens.repository.EmpresaRepository;
import com.jobteens.repository.VagasRepository;

@Controller
@RequestMapping("/vagas")
public class VagasController {

	@Autowired
	private VagasRepository vagasRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	// Listar vagas
	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("vagas/home");

		modelAndView.addObject("vagas", vagasRepository.findAll());

		return modelAndView;
	}

	// Listar vagas no arquivo vagas.html
	@GetMapping("/vagasdisponiveis")
	public ModelAndView outraRota() {
		ModelAndView modelAndView = new ModelAndView("/vagas");
		modelAndView.addObject("vagas", vagasRepository.findAll());
		return modelAndView;
	}

	// Cadastrar vagas
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("vagas/form");

		modelAndView.addObject("vagas", new Vagas());
		modelAndView.addObject("empresas", empresaRepository.findAll());

		return modelAndView;
	}

	// Cadastrar vagas
	@PostMapping("/cadastrar")
	public String cadastrar(Vagas vagas) {

		vagasRepository.save(vagas);

		return "redirect:/vagas";
	}

	// Editar vagas
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("vagas/form");
		modelAndView.addObject("vagas", vagasRepository.findById(id));
		modelAndView.addObject("empresas", empresaRepository.findAll());
		return modelAndView;
	}

	// Editar vagas
	@PostMapping("/{id}/editar")
	public String editar(Vagas vagas) {

		vagasRepository.save(vagas);
		return "redirect:/vagas";
	}

	// Excluir vagas
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		vagasRepository.deleteById(id);

		return "redirect:/vagas";
	}
}
