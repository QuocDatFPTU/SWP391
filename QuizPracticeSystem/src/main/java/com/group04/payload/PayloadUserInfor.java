/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.payload;

import com.group04.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ntdun
 */
@ToString
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PayloadUserInfor {
    private User user;
    private String roles;
}
