package in.yarraneella.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Voter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int voterID;
private String name;
private int age;
private String email;
}
