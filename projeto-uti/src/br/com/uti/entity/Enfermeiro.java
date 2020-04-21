package br.com.uti.entity;

import java.util.Calendar;
import java.util.List;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_enfermeiro")
@SequenceGenerator(name = "enfermeiro", sequenceName = "sq_enfermeiro", allocationSize = 1)
public class Enfermeiro {

	@Id
	@GeneratedValue(generator = "enfermeiro", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_enfermeiro")
	private long codigo;

	// identificação do enfermeiro
	@Column(name = "ds_coren", nullable = false, length = 20)
	private String coren;

	@Column(name = "ds_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "tp_sanguineo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_enfermeiro_medicacao", joinColumns = @JoinColumn(name = "id_enfermeiro"), inverseJoinColumns = @JoinColumn(name = "id_medicacao"))
	private List<Medicacao> medicacoes;

	public Enfermeiro() {
	}

	public Enfermeiro(String coren, String nome, Calendar dataNascimento, TipoSanguineo tipoSanguineo,
			List<Medicacao> medicacoes) {
		super();
		this.coren = coren;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoSanguineo = tipoSanguineo;
		this.medicacoes = medicacoes;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
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

}
