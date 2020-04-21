package br.com.uti.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_medicacao")
@SequenceGenerator(name = "medicacao", sequenceName = "SQ_MEDICACAO", allocationSize = 1)
public class Medicacao {

	@Id
	@Column(name = "id_medicacao")
	@GeneratedValue(generator = "medicacao", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "qt_dosagem", nullable = false)
	private float dosagem;

	@Column(name = "ds_descricao", length = 255)
	private String descricao;

	@Column(name = "ds_observacao", length = 255)
	private String observacao;

	@Column(name = "dt_medicacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataMedicacao;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_medico_medicacao",
			   joinColumns = @JoinColumn(name = "id_medicacao", insertable = true, updatable = true), inverseJoinColumns = @JoinColumn(name = "id_medico", insertable = true, updatable = true))
	private List<Medico> medicos = new ArrayList<Medico>();

	//@ManyToMany(mappedBy = "medicacoes")
	//private List<Paciente> pacientes;

	@ManyToMany(mappedBy = "medicacoes")
	private List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

	public Medicacao() {
	}

//Construtor criado para testar o relacionamento Medico_Medicacao após teste deletar esse bloco de código e deixar o construtor completo
	public Medicacao(String nome, float dosagem, String descricao, String observacao, Calendar dataMedicacao, List<Medico> medicos) {

		this.nome = nome;
		this.dosagem = dosagem;
		this.descricao = descricao;
		this.observacao = observacao;
		this.dataMedicacao = dataMedicacao;
		this.medicos = medicos;
	}
// Fim do Construtor teste
	
	// Construtor completo
	public Medicacao(String nome, float dosagem, String descricao, String observacao, Calendar dataMedicacao,
			List<Medico> medicos, List<Paciente> pacientes, List<Enfermeiro> enfermeiros) {

		this.nome = nome;
		this.dosagem = dosagem;
		this.descricao = descricao;
		this.observacao = observacao;
		this.dataMedicacao = dataMedicacao;
		this.medicos = medicos;
		//this.pacientes = pacientes;
		this.enfermeiros = enfermeiros;
	}
	public Medicacao(String string, float f, String string2, String string3, Calendar instance) {
		// TODO Auto-generated constructor stub
	}

	//Fim construtor completo
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

	public float getDosagem() {
		return dosagem;
	}

	public void setDosagem(float dosagem) {
		this.dosagem = dosagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Calendar getDataMedicacao() {
		return dataMedicacao;
	}

	public void setDataMedicacao(Calendar dataMedicacao) {
		this.dataMedicacao = dataMedicacao;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	//public List<Paciente> getPacientes() {
		//return pacientes;
	//}

	//public void setPacientes(List<Paciente> pacientes) {
		//this.pacientes = pacientes;
	//}

	public List<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public void setEnfermeiros(List<Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

}
