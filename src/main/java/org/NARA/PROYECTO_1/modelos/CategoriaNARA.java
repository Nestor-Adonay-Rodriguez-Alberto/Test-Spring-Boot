package org.NARA.PROYECTO_1.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "CategoriaNARA")
public class CategoriaNARA
{

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String NombreNARA;

    @NotBlank(message = "La descripción es requerida")
    private String DescripcionNARA;


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

    public @NotBlank(message = "La descripción es requerida") String getDescripcionNARA() {
        return DescripcionNARA;
    }
    public void setDescripcionNARA(@NotBlank(message = "La descripción es requerida") String descripcionNARA) {
        DescripcionNARA = descripcionNARA;
    }

}
