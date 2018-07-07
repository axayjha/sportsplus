package com.cse.sportsplus.models;
import java.io.Serializable;
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
		
		Academy(){}

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
}
		
