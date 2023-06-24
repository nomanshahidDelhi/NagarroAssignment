package com.example.Nagarro.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Account {
    private Integer id;
    private String accountType;
    private String accountNumber;

    public Integer getid() {
        return id;
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     * It takes the account number, hashes it, and returns the hash
     *
     * @return The account number is being returned.
     */
    public String getAccountNumber() throws NoSuchAlgorithmException {
        String plaintext = this.accountNumber;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }

    /**
     * The toString() method returns a string representation of the object
     *
     * @return The account id, account type, and account number.
     */
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountType='" + accountType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}

