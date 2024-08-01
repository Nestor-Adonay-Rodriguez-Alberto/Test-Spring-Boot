package org.NARA.PROYECTO_1.modelos;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="ClienteNARA")
public class ClienteNARA
{
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String NombreNARA;

    @NotBlank(message = "La Direccion Es Requerida")
    private String DireccionNARA;


    @NotBlank(message = "La Fecha De Nacimiento Es Requerida")
    private Date FechaNacimientoNARA;

    @NotBlank(message = "El Sueldo Es Requerido")
    private Double SueldoNARA;

    @NotBlank(message = "Ingrese El Estado")
    private Byte Estatus;

    // ACCESORS:

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

    public @NotBlank(message = "La Direccion Es Requerida") String getDireccionNARA() {
        return DireccionNARA;
    }
    public void setDireccionNARA(@NotBlank(message = "La Direccion Es Requerida") String direccionNARA) {
        DireccionNARA = direccionNARA;
    }

    public @NotBlank(message = "La Fecha De Nacimiento Es Requerida") Date getFechaNacimientoNARA() {
        return FechaNacimientoNARA;
    }
    public void setFechaNacimientoNARA(@NotBlank(message = "La Fecha De Nacimiento Es Requerida") Date fechaNacimientoNARA) {
        FechaNacimientoNARA = fechaNacimientoNARA;
    }

    public @NotBlank(message = "El Sueldo Es Requerido") Double getSueldoNARA() {
        return SueldoNARA;
    }
    public void setSueldoNARA(@NotBlank(message = "El Sueldo Es Requerido") Double sueldoNARA) {
        SueldoNARA = sueldoNARA;
    }

    public @NotBlank(message = "Ingrese El Estado") Byte getEstatus() {
        return Estatus;
    }
    public void setEstatus(@NotBlank(message = "Ingrese El Estado") Byte estatus) {
        Estatus = estatus;
    }

}
