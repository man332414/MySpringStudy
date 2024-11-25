package com.springmvc.projects;

public class User 
{
	public String id;
	public String pwd;
	public String name;
	public Integer birthDate;
	
	public User() {}

	public User(String id, String pwd, String name, Integer birthDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() 
	{
		return "id : "+ id +", pwd : "+ pwd +", name : "+ name + ", birtDate : " + birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Integer birthDate) {
		this.birthDate = birthDate;
	}
	
}
