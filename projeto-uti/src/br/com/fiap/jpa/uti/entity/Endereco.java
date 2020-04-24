package br.com.fiap.jpa.uti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "endereco", sequenceName = "sq_endereco", allocationSize = 1)
public class Endereco {

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_logradouro", nullable = false, length = 30)
	private String logradouro;

	// pode ter número de casa com letras ex: 15A, 15B
	@Column(name = "ds_numero", nullable = false, length = 8)
	private String numero;

	@Column(name = "ds_complemento", length = 30)
	private String complemento;

	// 8 número e um caracter especial (-)
	@Column(name = "ds_cep", nullable = false, length = 9)
	private String cep;

	@Column(name = "ds_bairro", nullable = false, length = 100)
	private String bairro;

	@Column(name = "ds_cidade", nullable = false, length = 100)
	private String cidade;

	@Column(name = "tp_uf")
	@Enumerated(EnumType.STRING)
	private UF uf;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", nullable = false)
	private Responsavel responsavel;

	public Endereco() {
	}

	public Endereco(String logradouro, String numero, String complemento, String cep, String bairro, String cidade,
			UF uf) {

		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

}
