package ir.benji.benjfa_oauth_service.user.service;

import io.jsonwebtoken.Claims;
import ir.benji.benjfa_oauth_service.user.model.Person;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;
import java.security.Key;
public interface JwtService {
    String generateToken(Person userInfo);

    boolean isTokenValid(String token, UserDetails userDetails);

    String getUsernameFromToken(String token);

    String getRoleFromToken(String token);

    Claims getClaimsFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    String getRefreshToken(Map<String, Object> claims, UserDetails userDetails);

    Key getSigningKey();

    void logout(String token);

    boolean existToken(String token);


    boolean isAdmin(String token);

}
