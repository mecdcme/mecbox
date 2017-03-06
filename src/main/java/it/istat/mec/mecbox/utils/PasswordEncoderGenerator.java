package it.istat.mec.mecbox.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Istat MecBox Team
 */
public class PasswordEncoderGenerator {

    public void genera() {
        //  public static void main(String[] args) {

        String password = "mec";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);

    }
}
