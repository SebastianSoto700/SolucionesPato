package com.example.Integrador2.controller;

import com.example.Integrador2.model.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
public class AuthController {


    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private UserDetailsService userDetailsService;

    private JwtEncoder jwtEncoder;
    private AuthenticationManager authenticationManager;

    public AuthController(JwtEncoder jwtEncoder, AuthenticationManager authenticationManager) {
        this.jwtEncoder = jwtEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> generarToken(@RequestBody LoginRequest tokenRequest) {


            String subject;
            String scope;

            if ("password".equals(tokenRequest.grantType())) {
                // --- Lógica para Grant Type: "password" ---
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(tokenRequest.correo(), tokenRequest.contrasena())
                );
                subject = authentication.getName();
                scope = authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(" "));

            } else if ("refresh_token".equals(tokenRequest.grantType())) {
                // --- Lógica para Grant Type: "refresh_token" ---
                if (tokenRequest.refreshToken() == null) {
                    return new ResponseEntity<>(Map.of("error", "Refresh token is missing"), HttpStatus.BAD_REQUEST);
                }
                try {
                    Jwt decodedJwt = jwtDecoder.decode(tokenRequest.refreshToken());
                    subject = decodedJwt.getSubject();
                    // Opcional pero recomendado: Verificar que el usuario aún existe y está activo
                    // UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
                    // scope = userDetails.getAuthorities()...
                    scope = decodedJwt.getClaim("scope"); // Es más eficiente tomar el scope del refresh token
                } catch (JwtException e) {
                    return new ResponseEntity<>(Map.of("error", "Invalid refresh token"), HttpStatus.UNAUTHORIZED);
                }

            } else {
                return new ResponseEntity<>(Map.of("error", "Unsupported grant type"), HttpStatus.BAD_REQUEST);
            }

            // --- Generación de Tokens (común para ambos flujos) ---
            Map<String, String> tokens = new HashMap<>();
            Instant now = Instant.now();

            // 1. Crear el Access Token (corta duración)
            JwtClaimsSet accessTokenClaims = JwtClaimsSet.builder()
                    .issuer("security-server")
                    .issuedAt(now)
                    .expiresAt(now.plus(5, ChronoUnit.MINUTES)) // Corta duración
                    .subject(subject)
                    .claim("scope", scope)
                    .build();
            String accessToken = jwtEncoder.encode(JwtEncoderParameters.from(accessTokenClaims)).getTokenValue();
            tokens.put("accessToken", accessToken);

            // 2. Si es el flujo de password, generar también un Refresh Token (larga duración)
            if ("password".equals(tokenRequest.grantType())) {
                JwtClaimsSet refreshTokenClaims = JwtClaimsSet.builder()
                        .issuer("security-server")
                        .issuedAt(now)
                        .expiresAt(now.plus(60, ChronoUnit.MINUTES)) // Larga duración
                        .subject(subject)
                        .claim("scope", scope)

                        // Nota: Un refresh token no necesita scope, pero no hace daño tenerlo.
                        .build();
                String refreshToken = jwtEncoder.encode(JwtEncoderParameters.from(refreshTokenClaims)).getTokenValue();
                tokens.put("refreshToken", refreshToken);
            }

            return new ResponseEntity<>(tokens, HttpStatus.OK);
        }

}
