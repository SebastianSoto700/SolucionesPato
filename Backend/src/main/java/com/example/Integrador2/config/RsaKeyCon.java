package com.example.Integrador2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


//Vinculamos con nuestras key de la carpeta certs
@ConfigurationProperties(prefix = "rsa")
public record RsaKeyCon(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
