package com.company.repository;

import com.company.Alien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepo {
    private List<Alien> aliens = new ArrayList<Alien>();
    private Connection connection = null;

    public AlienRepo() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    ;

    public List<Alien> getAliens() {
        String sql = "select id, name, point from aliens";
        Alien temp = new Alien();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                temp.setId(resultSet.getInt(1));
                temp.setName(resultSet.getString(2));
                temp.setPoint(resultSet.getInt(3));
                aliens.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.aliens;
    }

    public Alien getById(Integer alienId) {
        String sql = "select id, name, point from aliens where id=" + alienId;
        Alien temp = new Alien();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                temp.setId(resultSet.getInt(1));
                temp.setName(resultSet.getString(2));
                temp.setPoint(resultSet.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return temp;
    }

    public void insert(Alien alien) {
        String sql = "insert into aliens (name, point) values (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alien.getName());
            ps.setInt(2, alien.getPoint());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Alien alien) {
        System.out.println("Will be updated: " + alien);
        Alien old = getById(alien.getId());
        delete(old);
        insert(alien);
        System.out.println(this.aliens);
    }

    public void delete(Integer id) {
        Alien old = getById(id);
        System.out.println("Will be deleted: " + old);
        this.aliens.remove(old);
        System.out.println(this.aliens);
    }

    public void delete(Alien alien) {
        this.aliens.remove(alien);
        System.out.println(this.aliens);
    }
}
