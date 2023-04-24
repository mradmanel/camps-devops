package com.sip.entities;

	import javax.persistence.*;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotEmpty;
	import java.util.Set;
	import org.hibernate.validator.constraints.Length;

	@Entity
	@Table(name="role")
	public class Role {
			@Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    @Column(name="user_id")
			private int id;
            @Column (name ="role")
            private String role;
            
			public Role(String role) {
				super();
				this.id = id;
				this.role = role;
			}
			
			public Role() {
				super();
			}

			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
            
	        
		    
	        
	}		

			