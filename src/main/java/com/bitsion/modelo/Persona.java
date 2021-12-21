package com.bitsion.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@Column
	@NotBlank
	private String nombre;
	@Column
	@NotBlank
	private String apellido;
	@Column
	@NotBlank
	private Integer dni;
	@Column
	@Size(min = 18, max = 110)
	private Integer edad;
	@Column
	private String genero;
	@Column
	@NotBlank
	private Boolean estado;
	@Column
	private Boolean maneja;
	@Column
	private Boolean lentes;
	@Column
	private Boolean diabetico;
	@Column(name = "otra_enefermedad")
	private Boolean otraEnfermedad;
	@Column
	private String enfermedad;
	
}
