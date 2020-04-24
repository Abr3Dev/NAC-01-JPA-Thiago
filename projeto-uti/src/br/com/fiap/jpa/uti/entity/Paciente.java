package br.com.fiap.jpa.uti.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_paciente")
@SequenceGenerator(name = "paciente", sequenceName = "sq_paciente", allocationSize = 1)
public class Paciente {

	@Id
	@Column(name = "id_paciente")
	@GeneratedValue(generator = "paciente", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "ds_sexo", nullable = false)
	private char sexo;

	@Enumerated(EnumType.STRING)
	@Column(name = "tp_sanguineo")
	private TipoSanguineo tipoSanguineo;

	@Column(name = "ds_alergia_medicacao", length = 30)
	private String alergiaMedicacao;

	@Column(name = "ds_etnia", length = 30)
	private String etnia;

	@Enumerated(EnumType.STRING)
	@Column(name = "tp_estado_paciente", nullable = false)
	private EstadoPaciente estadoPaciente;

	// no contexto de internação, muitos pacientes são internados por um médico, mas
	// cada paciente só é internado por um médico
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;

	// Apenas um responsável é cadastrado para cada paciente.
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", nullable = false, unique = true)
	private Responsavel responsavel;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_paciente_medicacao", joinColumns = @JoinColumn(name = "id_paciente"), inverseJoinColumns = @JoinColumn(name = "id_medicacao"))
	private List<Medicacao> medicacoes;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tb_paciente_exame", joinColumns = @JoinColumn(name = "id_paciente"), inverseJoinColumns = @JoinColumn(name = "id_exame"))
	private List<Exame> exames;

	public Paciente() {
	}

	public Paciente(String nome, Calendar dataNascimento, char sexo, TipoSanguineo tipoSanguineo,
			String alergiaMedicacao, String etnia, EstadoPaciente estadoPaciente, Responsavel responsavel,
			Medico medico) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.tipoSanguineo = tipoSanguineo;
		this.alergiaMedicacao = alergiaMedicacao;
		this.etnia = etnia;
		this.estadoPaciente = estadoPaciente;
		this.responsavel = responsavel;
		this.medico = medico;
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

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getAlergiaMedicacao() {
		return alergiaMedicacao;
	}

	public void setAlergiaMedicacao(String alergiaMedicacao) {
		this.alergiaMedicacao = alergiaMedicacao;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public EstadoPaciente getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(EstadoPaciente estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
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

}
