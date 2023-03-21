package com.example.store.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query {
    private  final String queryInserted = "INSERT INTO signup (username,email,password)VALUES(?,?,?)";
    private  final String query= "SELECT * FROM  signup WHERE email=? AND password=?";
    private  final String UPDATE= "UPDATE FROM  signup WHERE email=? AND password=?";
    private  final String DELETE= "DELETE FROM  signup WHERE email=? ";


}
