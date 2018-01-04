package com.model;
// Generated 2018-1-27 18:10:37 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DeptEmpId generated by hbm2java
 */
@Embeddable
public class DeptEmpId implements java.io.Serializable {

	private int empNo;
	private String deptNo;

	public DeptEmpId() {
	}

	public DeptEmpId(int empNo, String deptNo) {
		this.empNo = empNo;
		this.deptNo = deptNo;
	}

	@Column(name = "emp_no", nullable = false)
	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Column(name = "dept_no", nullable = false, length = 4)
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DeptEmpId))
			return false;
		DeptEmpId castOther = (DeptEmpId) other;

		return (this.getEmpNo() == castOther.getEmpNo())
				&& ((this.getDeptNo() == castOther.getDeptNo()) || (this.getDeptNo() != null
						&& castOther.getDeptNo() != null && this.getDeptNo().equals(castOther.getDeptNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmpNo();
		result = 37 * result + (getDeptNo() == null ? 0 : this.getDeptNo().hashCode());
		return result;
	}

}
