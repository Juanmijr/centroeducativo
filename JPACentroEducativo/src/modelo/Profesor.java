package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@Table(name="profesor")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String color;

	private String direccion;

	private String dni;

	private String email;

	@Lob
	private byte[] imagen;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to TipologiaSexo
	@ManyToOne
	@JoinColumn(name="idTipologiaSexo")
	private TipologiaSexo TipologiaSexo;

	//bi-directional many-to-one association to ValoracionMateria
	@OneToMany(mappedBy="profesor")
	private List<ValoracionMateria> ValoracionMaterias;

	public Profesor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipologiaSexo getTipologiaSexo() {
		return this.TipologiaSexo;
	}

	public void setTipologiaSexo(TipologiaSexo TipologiaSexo) {
		this.TipologiaSexo = TipologiaSexo;
	}

	public List<ValoracionMateria> getValoracionMaterias() {
		return this.ValoracionMaterias;
	}

	public void setValoracionMaterias(List<ValoracionMateria> ValoracionMaterias) {
		this.ValoracionMaterias = ValoracionMaterias;
	}

	public ValoracionMateria addValoracionMateria(ValoracionMateria ValoracionMateria) {
		getValoracionMaterias().add(ValoracionMateria);
		ValoracionMateria.setProfesor(this);

		return ValoracionMateria;
	}

	public ValoracionMateria removeValoracionMateria(ValoracionMateria ValoracionMateria) {
		getValoracionMaterias().remove(ValoracionMateria);
		ValoracionMateria.setProfesor(null);

		return ValoracionMateria;
	}

}