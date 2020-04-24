 package br.com.uti.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_medico")
@SequenceGenerator(name = "medico", sequenceName = "sq_medico", allocationSize = 1)
public class Medico {

	@Id
	@Column(name = "id_medico")
	@GeneratedValue(generator = "medico", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_crm", nullable = false, length = 20)
	private String crm;

	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "ds_nacionalidade", nullable = false, length = 100)
	private String nacionalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "tp_sanguineo", nullable = false)
	private TipoSanguineo tipoSanguineo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_medico_medicacao", joinColumns = @JoinColumn(name = "id_medico"), inverseJoinColumns = @JoinColumn(name = "id_medicacao"))
	private List<Medicacao> medicacoes;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_medico_exame", joinColumns = @JoinColumn(name = "id_medico"), inverseJoinColumns = @JoinColumn(name = "id_exame"))
	private List<Exame> exames;

	@OneToMany(mappedBy = "medico", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Paciente> pacientes = new ArrayList<Paciente>();

	public Medico() {
	}

	public Medico(String crm, String nome, Calendar dataNascimento, String nacionalidade, TipoSanguineo tipoSanguineo) {
		
		this.crm = crm;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.tipoSanguineo = tipoSanguineo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public List<Medicacao> getMedicacoes() {
		return medicacoes;
	}

	public void setMedicacoes(List<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
		paciente.setMedico(this);
	}
}
