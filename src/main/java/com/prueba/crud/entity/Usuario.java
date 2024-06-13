package com.prueba.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CLIENTE")
    private Float cliente;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FECHAALTA")
    private String fechaalta;

    @Column(name = "FECHABAJA")
    private String fechabaja;

    @Column(name = "STATUS")
    private char status;

    @Column(name = "INTENTOS")
    private Float intentos;

    @Column(name = "FECHAREVOCADO")
    private String fecharevocado;

    @Column(name = "FECHA_VIGENCIA")
    private String fechaVigencia;

    @Column(name = "NO_ACCESO")
    private Integer noAcceso;

    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "AREA")
    private BigDecimal area;

    @Column(name = "FECHAMODIFICACION")
    private String fechamodificacion;
}
