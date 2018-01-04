package com.model;
// Generated 2018-1-27 18:10:37 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "employees")
public class Role implements java.io.Serializable {

	private long roleId;
	private String name;
	private Set<Employees> employeeses = new HashSet<Employees>(0);

	public Role() {
	}

	public Role(long roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}

	public Role(long roleId, String name, Set<Employees> employeeses) {
		this.roleId = roleId;
		this.name = name;
		this.employeeses = employeeses;
	}

	@Id

	@Column(name = "roleId", unique = true, nullable = false)
	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<Employees> getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set<Employees> employeeses) {
		this.employeeses = employeeses;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}
	
	
}
