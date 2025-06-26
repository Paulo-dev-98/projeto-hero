package br.com.erudio.services.validator;

import br.com.erudio.data.vo.v1.HeroiVO;
import br.com.erudio.exception.RegrasDoNomeException;

public class HeroiValidator implements Validator<HeroiVO> {

	@Override
	public void valida(HeroiVO heroiVO) throws RegrasDoNomeException {
		
		if(heroiVO.getNomeDoHeroi().isEmpty()) {
			throw new RegrasDoNomeException("O Nome do heroi não pode ser nulo");
		}
		
	}

}
