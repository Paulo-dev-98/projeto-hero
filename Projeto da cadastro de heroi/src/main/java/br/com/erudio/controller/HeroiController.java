package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.HeroiVO;
import br.com.erudio.services.HeroiServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "EndpointHeroi")
@RestController
@RequestMapping("/api/heroi/v1")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class HeroiController {

	@Autowired
	private HeroiServices service;

	@ApiOperation(value = "busca todos os Herois")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<PagedResources<HeroiVO>> findAll(
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue = "15") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction,
			PagedResourcesAssembler assembler) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<HeroiVO> herois = service.findAll(pageable);
		herois.stream()
				.forEach(p -> p.add(linkTo(methodOn(HeroiController.class).findById(p.getKey())).withSelfRel()));
		return new ResponseEntity<> (assembler.toResource(herois), HttpStatus.OK);
	}
	
	@ApiOperation(value = "busca todos os herois filtrando por nome")
	@GetMapping(value = "/findHeroiByName/{nome}",produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<PagedResources<HeroiVO>> findHeroiByName(
			@PathVariable("nome") String nome,
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="limit", defaultValue = "5") int limit,
			@RequestParam(value="direction", defaultValue = "asc") String direction,
			PagedResourcesAssembler assembler) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"nome"));
		
		Page<HeroiVO> herois = service.findHeroiByName(nome, pageable);
		herois.stream()
		.forEach(p -> p.add(linkTo(methodOn(HeroiController.class).findById(p.getKey())).withSelfRel()));
		return new ResponseEntity<> (assembler.toResource(herois), HttpStatus.OK);
	}
	
	@ApiOperation(value = "busca heroi por id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public HeroiVO findById(@PathVariable("id") Long id) {
		HeroiVO heroiVo = service.findById(id);
		heroiVo.add(linkTo(methodOn(HeroiController.class).findById(id)).withSelfRel());
		return heroiVo;
	}

	@ApiOperation(value = "cadastrar Heroi")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public HeroiVO create(@RequestBody HeroiVO heroi) {
		HeroiVO heroiVo = service.created(heroi);
		heroiVo.add(linkTo(methodOn(HeroiController.class).findById(heroiVo.getKey())).withSelfRel());
		return heroiVo;
	}

	@ApiOperation(value = "editar heroi")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public HeroiVO update(@RequestBody HeroiVO heroi) {
		HeroiVO HeroiVo = service.update(heroi);
		HeroiVo.add(linkTo(methodOn(HeroiController.class).findById(HeroiVo.getKey())).withSelfRel());
		return HeroiVo;
	}

	@ApiOperation(value = "deletar heroi")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}