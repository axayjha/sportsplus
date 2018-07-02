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
	 	@Column(name="Name")
		private String name;
		@Column(name="Academy_Created_Date")
		private String Academy_Created_Date;
		@Column(name="Academy_Updated_Date")
		private String Academy_Updated_Date;
		
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

		public String getAcademy_Created_Date() {
			return Academy_Created_Date;
		}

		public void setAcademy_Created_Date(String academy_Created_Date) {
			Academy_Created_Date = academy_Created_Date;
		}

		public String getAcademy_Updated_Date() {
			return Academy_Updated_Date;
		}

		public void setAcademy_Updated_Date(String academy_Updated_Date) {
			Academy_Updated_Date = academy_Updated_Date;
		}

		
		
}	
		