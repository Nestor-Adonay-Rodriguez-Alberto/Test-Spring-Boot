package org.NARA.PROYECTO_1.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="DepartamentoTrabajoNARA")
public class DepartamentoTrabajoNARA
{
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String NombreNARA;

    @NotBlank(message = "El Telefono es requerido")
    private String TelefonoNARA;

    @NotBlank(message = "El Jefe es requerido")
    private String JefeNARA;


    // ACCESORS:

    public Integer getId()
    {
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

    public @NotBlank(message = "El Telefono es requerido") String getTelefonoNARA() {
        return TelefonoNARA;
    }
    public void setTelefonoNARA(@NotBlank(message = "El Telefono es requerido") String telefonoNARA) {
        TelefonoNARA = telefonoNARA;
    }

    public @NotBlank(message = "El Jefe es requerido") String getJefeNARA() {
        return JefeNARA;
    }
    public void setJefeNARA(@NotBlank(message = "El Jefe es requerido") String jefeNARA) {
        JefeNARA = jefeNARA;
    }
}
