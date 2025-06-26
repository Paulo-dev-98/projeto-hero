package br.com.erudio.services.validator;

import br.com.erudio.exception.RegrasDoNomeException;

public interface Validator<T> {
	void valida(T object) throws RegrasDoNomeException;
}
