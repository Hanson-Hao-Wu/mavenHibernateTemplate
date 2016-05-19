package org.hao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_person")
public class Person implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 50, nullable = false, unique = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	public Person() {}
	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
}
