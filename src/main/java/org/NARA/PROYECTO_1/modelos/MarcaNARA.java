package org.NARA.PROYECTO_1.modelos;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="MarcaNARA")
public class MarcaNARA
{
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String NombreNARA;


    // ACCESORS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombreNARA() {
        return NombreNARA;
    }
    public void setNombreNARA(@NotBlank(message = "El nombre es requerido") String nombreNARA) {
        NombreNARA = nombreNARA;
    }
}
