package com.jobteens.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

	public static String encoder(String senha) {
		BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
		return encoderSenha.encode(senha);
	}
}
