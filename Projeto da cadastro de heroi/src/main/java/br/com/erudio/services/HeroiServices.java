package br.com.erudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Heroi;
import br.com.erudio.data.vo.v1.HeroiVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.HeroiRepository;
import br.com.erudio.services.validator.HeroiValidator;
import br.com.erudio.services.validator.Validator;

@Service
public class HeroiServices {
	
	@Autowired
	HeroiRepository repository;
	
	public HeroiVO created(HeroiVO heroi) {
		validarNome(new HeroiValidator(), heroi);
		var entity = DozerConverter.parseObject(heroi, Heroi.class);
		var vo = DozerConverter.parseObject(repository.save(entity),HeroiVO.class);
		return vo;
	}
	
	public Page<HeroiVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToHeroiVO) ;
	}
	
	public Page<HeroiVO> findHeroiByName(String nome, Pageable pageable) {
		var page = repository.findHeroiByNome(nome, pageable);
		return page.map(this::convertToHeroiVO) ;
	}
	
	private HeroiVO convertToHeroiVO(Heroi entity) {
		return DozerConverter.parseObject(entity,HeroiVO.class);
	}
	
	public HeroiVO findById(Long id) {
		
		var entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		return DozerConverter.parseObject(entity, HeroiVO.class);
	}
	
	public HeroiVO update(HeroiVO heroi) {
		validarNome(new HeroiValidator(), heroi);
		var entity = repository.findById(heroi.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		entity.setNome(heroi.getNome());
		entity.setNomeDoHeroi(heroi.getNomeDoHeroi());
		entity.setDataDeNascimento(heroi.getDataDeNascimento());
		entity.setAltura(heroi.getAltura());
		entity.setPeso(heroi.getPeso());
		var vo = DozerConverter.parseObject(repository.save(entity),HeroiVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Heroi entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id não encontrado"));
		repository.delete(entity);
		
	}
	
	private <T> void validarNome(Validator<T> validator, T objeto) {
		validator.valida(objeto);
	}

}
