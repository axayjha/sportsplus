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
		private Long created;

	 	@Column(name="upStringd")
		private Long upStringd;

	 	@OneToMany(mappedBy = "academy")
	 	private List<Group> groupList;



		Academy(){}

	

	public Academy(Long id, String name, Long created, Long upStringd, List<Group> groupList) {
			super();
			this.id = id;
			this.name = name;
			this.created = created;
			this.upStringd = upStringd;
			this.groupList = groupList;
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

		public Long getCreated() {
			return created;
		}

		public void setCreated(Long created) {
			this.created = created;
		}

		public Long getUpStringd() {
			return upStringd;
		}

		public void setUpStringd(Long upStringd) {
			this.upStringd = upStringd;
		}

//		public List<Group> getGroupList() {
//			return groupList;
//		}

		public void setGroupList(List<Group> groupList) {
			this.groupList = groupList;
		}
}
		