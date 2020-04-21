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

	@ManyToMany(mappedBy = "medicos")
	private List<Medicacao> medicacoes = new ArrayList<Medicacao>();

	@ManyToMany(mappedBy = "medicos")
	private List<Exame> exames = new ArrayList<Exame>();

	//@OneToMany(mappedBy = "medico")
	//private List<Paciente> pacientes;

	public Medico() {
	}

	public Medico(String crm, String nome, Calendar dataNascimento, String nacionalidade, TipoSanguineo tipoSanguineo,
			List<Medicacao> medicacoes, List<Exame> exames, List<Paciente> pacientes) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.tipoSanguineo = tipoSanguineo;
		//this.medicacoes = medicacoes;
		this.exames = exames;
		//this.pacientes = pacientes;
	}

	//construtor teste relacionamento Medico_Medicacao, excluir esse grupo de código após teste
	public Medico(String crm, String nome, Calendar dataNascimento, String nacionalidade, TipoSanguineo tipoSanguineo) {
		this.crm = crm;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.tipoSanguineo = tipoSanguineo;
		
	}
	public Medico(String string, String string2, Object object, String string3, TipoSanguineo aPositvo,
			List<Medicacao> asList) {
		// TODO Auto-generated constructor stub
	}

	//fim construtor teste
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


	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	//public List<Paciente> getPacientes() {
		//return pacientes;
	//}

	//public void setPacientes(List<Paciente> pacientes) {
		//this.pacientes = pacientes;
	//}

}
