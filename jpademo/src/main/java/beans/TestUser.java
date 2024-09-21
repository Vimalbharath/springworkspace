package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="testuser")
public class TestUser {
	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String username;
	
	private int age;
	private String address;
	
	@Column(name="birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	public TestUser() {
		super();
	}
	public TestUser(int userId, String userName, int age, String address, Date birthdate) {
		super();
		this.userId = userId;
		this.username = userName;
		this.age = age;
		this.address = address;
		this.birthdate = birthdate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "TestUser [userId=" + userId + ", username=" + username + ", age=" + age + ", address=" + address
				+ ", birthdate=" + birthdate + "]";
	}
	
	
}
