package br.com.uti.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_responsavel")
@SequenceGenerator(name = "responsavel", sequenceName = "sq_responsavel", allocationSize = 1)
public class Responsavel {

	@Id
	@Column(name = "id_responsavel")
	@GeneratedValue(generator = "responsavel", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "ds_sexo", nullable = false)
	private char sexo;

	@Column(name = "ds_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "ds_telefone", nullable = false, length = 12)
	private String telefone;

	@Column(name = "ds_parentesco", nullable = false, length = 30)
	private String parentesco;

	@OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToOne(mappedBy = "responsavel", cascade = CascadeType.ALL)
	private Paciente paciente;

	public Responsavel() {
	}

	public Responsavel(String nome, Calendar dataNascimento, char sexo, String cpf, String telefone,
			String parentesco) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.parentesco = parentesco;

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
		endereco.setResponsavel(this);
	}
}
