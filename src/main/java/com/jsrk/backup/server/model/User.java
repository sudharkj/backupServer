package com.jsrk.backup.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "username")
	private String username;

	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "password")
	private String password;

	@Column(name = "created_date_time")
	private Date createdDateTime;

	@Column(name = "updated_date_time")
	private Date updatedDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "User=[id=" + id + ", username=" + username + ", password="
				+ password + ", createdDateTime=" + createdDateTime
				+ ", updatedDateTime=" + updatedDateTime + "]";
	}

}
