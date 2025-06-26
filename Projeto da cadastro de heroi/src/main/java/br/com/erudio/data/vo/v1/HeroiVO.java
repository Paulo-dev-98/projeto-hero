package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"key", "nome", "nome do heroi", "data de nascimento", "altura", "peso"})
public class HeroiVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("indentificador")
	private Long key;

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("nomeDoHeroi")
	private String nomeDoHeroi;
	
	@JsonProperty("dataDeNascimento")
	private Date dataDeNascimento;
	
	@JsonProperty("altura")
	private float altura;
	
	@JsonProperty("peso")
	private float peso;

	public HeroiVO() {
		
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeDoHeroi() {
		return nomeDoHeroi;
	}

	public void setNomeDoHeroi(String nomeDoHeroi) {
		this.nomeDoHeroi = nomeDoHeroi;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeDoHeroi == null) ? 0 : nomeDoHeroi.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeroiVO other = (HeroiVO) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null)
				return false;
		} else if (!dataDeNascimento.equals(other.dataDeNascimento))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeDoHeroi == null) {
			if (other.nomeDoHeroi != null)
				return false;
		} else if (!nomeDoHeroi.equals(other.nomeDoHeroi))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		return true;
	}

	
	
}
