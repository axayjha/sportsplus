package com.cse.sportsplus.models;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="academy_table")
public class Academy implements Serializable {
	 	@Id
	    @GeneratedValue
	    @Column(name="Academy_id")
		private Long id;
	
	 	@Column(name="Name",unique=true)
		private String name;

	 	@Column(name="created")
		private String created;

	 	@Column(name="upStringd")
		private String upStringd;

	 	@OneToMany(mappedBy = "academy")
	 	private List<Group> groupList;



		Academy(){}

	public Academy(String name, String created, String upStringd) {
		this.name = name;
		this.created = created;
		this.upStringd = upStringd;
	}

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public String getUpStringd() {
			return upStringd;
		}

		public void setUpStringd(String upStringd) {
			this.upStringd = upStringd;
		}

//		public List<Group> getGroupList() {
//			return groupList;
//		}

		public void setGroupList(List<Group> groupList) {
			this.groupList = groupList;
		}
}
		
