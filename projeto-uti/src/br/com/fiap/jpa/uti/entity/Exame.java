package br.com.fiap.jpa.uti.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_exame")
@SequenceGenerator(name = "exame", sequenceName = "sq_exame", allocationSize = 1)
public class Exame {

	@Id
	@Column(name = "id_exame")
	@GeneratedValue(generator = "exame", strategy = GenerationType.SEQUENCE)
	private long codigo;

	@Column(name = "ds_exame", nullable = false, length = 50)
	private String tipoExame;

	@Column(name = "ds_observacao", length = 255)
	private String observacao;

	@Column(name = "dt_exame")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataExame;

	@ManyToMany(mappedBy = "exames", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Medico> medicos;

	@ManyToMany(mappedBy = "exames", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Paciente> pacientes;

	public Exame() {
	}

	public Exame(String tipoExame, String observacao, Calendar dataExame) {

		this.tipoExame = tipoExame;
		this.observacao = observacao;
		this.dataExame = dataExame;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Calendar getDataExame() {
		return dataExame;
	}

	public void setDataExame(Calendar dataExame) {
		this.dataExame = dataExame;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
