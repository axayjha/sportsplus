package com.cse.sportsplus.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
		@Column(name="updated")
		private String updated;
		
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

		public String getUpdated() {
			return updated;
		}

		public void setUpdated(String updated) {
			this.updated = updated;
		}

		

		
		
}	
		
