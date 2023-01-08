package com.revanya.analytics.coffeecloud.common.authorization;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Arrays;
import java.util.HashSet;

public class GenerateToken {

    public static void main(String[] args) {
        String token =
                Jwt.issuer("https://revanyaanalytics.in")
                        .upn("info@revanyaanalytics.in")
                        .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                        .claim(Claims.birthdate.name(), "2001-07-13")
                        .sign();
        System.out.println(token);
    }

}
