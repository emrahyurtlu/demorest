package com.company.repository;

import com.company.model.Alien;

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

    public List<Alien> getAliens() {
        String sql = "select id, name, point from aliens";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Alien temp = new Alien();
                temp.setId(resultSet.getInt(1));
                temp.setName(resultSet.getString(2));
                temp.setPoint(resultSet.getInt(3));
                aliens.add(temp);
            }
            resultSet.close();
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
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Alien alien) {
        String sql = "update aliens set name=?, point=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alien.getName());
            ps.setInt(2, alien.getPoint());
            ps.setInt(3, alien.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        String sql = "delete from aliens where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Alien alien) {
        String sql = "delete from aliens where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, alien.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
