package com.example.Integrador2.model;

public record LoginRequest(String grantType,
                           String correo,
                           String contrasena,
                           String refreshToken) {
}
