package hello;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
	@GeneratedValue(generator = "GEN_USERS", strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
    private Integer id;

    @OneToOne
	@JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

