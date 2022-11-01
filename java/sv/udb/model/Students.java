package sv.udb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private Integer phone;
	@Column
	private String carnet;

	public Students() {
		
	}

	public Students(long id) {
		this.id = id;
	}

	public Students(long id, String firstName, String lastName, String email, Integer phone, String carnet) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.carnet = carnet;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	public String getCarnet() {
		return this.carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	@Override
	public String toString() {
		String message = "Estudiante ["
						+ "Id = " + id
						+ ", Nombres = " + firstName
						+ ", Apellidos = " + lastName
						+ ", Correo = " + email
						+ ", Telefono = " + phone
						+ ", Carnet = " + carnet
						+ "]";
		return message;
	}

}
