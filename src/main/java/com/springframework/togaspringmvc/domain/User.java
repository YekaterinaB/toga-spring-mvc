package com.springframework.togaspringmvc.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *  JSON:
 *  {
 * 	"phoneNumber": "XXXXXX",
 * 	"username":"XXXXX"
 * }
 */
@Data
@Entity
public class User {
    @Id
    private String phoneNumber;
    private String username;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
