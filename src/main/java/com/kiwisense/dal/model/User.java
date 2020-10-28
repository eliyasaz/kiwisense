package com.kiwisense.dal.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity(name = "User")
@Table(name = "user_info", uniqueConstraints={@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseModel{

	public User(String email, String password) {
	
		this.email = email;
		this.password = password;
	}

    public User() {
    	
    }

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_gender")
	private String userGender;

	@Column(name = "user_imei")
	private String userImei;
	
	@Column(name = "user_contact_number")
	private String contactNumber;
	
	@Column(name = "user_status")
	private Boolean userStatus;
	
	@Column(name = "user_age")
	private int age;

	
	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;

	
	@OneToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Device> devices;

	
	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

//    @Column(name = "active")
//    private Boolean active;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role_info", joinColumns = @JoinColumn(name = "login_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
 	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserImei() {
		return userImei;
	}

	public void setUserImei(String userImei) {
		this.userImei = userImei;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return this.email;
	}
	
	
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
