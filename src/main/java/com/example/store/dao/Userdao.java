package com.example.store.dao;

import com.example.store.Db.Config;
import com.example.store.model.AppUser;
import com.example.store.model.Login;
import com.example.store.queries.Query;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.store.Db.Config.getConnection;


public class Userdao {
    Config config;
    Connection connection = getConnection();

    public Userdao() throws SQLException, ClassNotFoundException {
        this.config = new Config();
    }

    public ResultSet getAllUser() throws SQLException {
        String query = "SELECT * FROM signup";
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static Userdao getObject() throws SQLException, ClassNotFoundException {
        return new Userdao();

    }

    public static List<String> getAllUserEmail() throws SQLException, ClassNotFoundException {

        ResultSet allUser = getObject().getAllUser();
        List<String> emailList = new ArrayList<>();
        while (allUser.next()) {
            emailList.add(allUser.getString("email"));
        }
        return emailList;
    }

    public boolean insertUser(AppUser appUser) {
        boolean status = false;
        Query query=new Query();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.getQueryInserted());
            preparedStatement.setString(1, appUser.getUsername());
            preparedStatement.setString(2, appUser.getEmail());
            preparedStatement.setString(3, appUser.getPassword());
            if (!getAllUserEmail().contains(appUser.getEmail())) {
                preparedStatement.executeUpdate();
                status = true;
                preparedStatement.close();
            }
            return status;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUser(Login user) throws SQLException, ClassNotFoundException {
        boolean status= false;
        Query query=new Query();

            PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                status = true;
                preparedStatement.close();
            }

            return status;

    }


    public String getUserId(String username, String password) throws SQLException {
        String user_Id = null;

        String query = "SELECT * FROM signup WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            user_Id = resultSet.getString("id");
            String name = resultSet.getString("username");
            String email = resultSet.getString("email");
            String cpassword = resultSet.getString("password");
            System.out.println(
                    "---------------ID "+user_Id+"\n" +
                    "---------------Name "+name+"\n" +
                    "---------------Username "+name+"\n" +
                    "---------------Password "+cpassword);
            statement.close();
        }
        return user_Id;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Userdao userdao = new Userdao();
        Query query=new Query();
        System.out.println(query.getQuery());
        System.out.println(userdao.insertUser(new AppUser("dsfdf","chi@gmail.com","12345"))+" is login");
        System.out.println(userdao.loginUser(new Login("chi@gmail.com","12345"))+" is login");
        System.out.println(userdao.getUserId("chi@gmail.com","12345"));

    }



}
