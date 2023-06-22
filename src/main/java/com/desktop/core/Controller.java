
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desktop.core;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Benny Iko
 */
public class Controller {
    private Connection conn;
    
    /*
     * Description:  This constructor will create a database connection used
     * throughout the life of the object;
     */
    public Controller() {        
        try {
           // get connection object from driver 
           conn = DriverManager.getConnection("jdbc:derby://localhost:1527/VOIProject;", "VOIProject", "voi"); 
            
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }        
    }
    
    /*
     * The finalize method for an object that represents an input/output connection 
     * might perform explicit I/O transactions to break the connection before the object is permanently discarded.
     * As of Java Platform SE 8, the finalize method of class Object performs no special action; it simply returns normally.
     * As a result, we declare, override finalize() and supress warnings. 
     */
    @Override
    @SuppressWarnings({"FinalizeDoesntCallSuperFinalize", "FinalizeDeclaration"})
    protected void finalize() {     
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }        
    }
        
    public void addMake(String make) {
        PreparedStatement psInsert;
        try {
            psInsert = conn.prepareStatement(
                    "insert into vehicle_make values (?)");
            psInsert.setString(1, make);
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMakeModel(String make, String model) {
        PreparedStatement psInsert;
        try {
            addMake(make);
            psInsert = conn.prepareStatement(
                    "insert into vehicle_model (make, model) values (?, ?)");
            psInsert.setString(1, make);
            psInsert.setString(2, model);
            psInsert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addROI(String reason, String description) {
        PreparedStatement psInsert;
        try {
            psInsert = conn.prepareStatement(
                    "insert into reason_for_interest (reason, description) values (?, ?)");
            psInsert.setString(1, reason);
            psInsert.setString(2, description);
            psInsert.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addVOI(String licensePlate, String reason, String make, String model, String year, String color, String name, String phone) {
        PreparedStatement psInsert;
        try {
            psInsert = conn.prepareStatement(
                    "insert into vehicle_of_interest (license_plate, reason, make, model, veh_year, color, owners_name, owners_phone) values (?, ?, ?, ? , ?, ? ,? ,?)");
            psInsert.setString(1, licensePlate);
            psInsert.setString(2, reason);
            psInsert.setString(3,make);
            psInsert.setString(4,model);
            psInsert.setString(5,year);
            psInsert.setString(6,color);
            psInsert.setString(7,name);
            psInsert.setString(8,phone);
            psInsert.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] allColors() {
        ArrayList<String> strings = new ArrayList<>();
        String black = "Black";
        String blue = "Blue";
        String red = "Red";
        String white = "White";
        String green = "Green";
        String orange = "Orange";
        String yellow = "Yellow";
        String gray = "Gray";
        strings.add(black);
        strings.add(blue);
        strings.add(red);
        strings.add(white);
        strings.add(green);
        strings.add(orange);
        strings.add(yellow);
        strings.add(gray);
        return strings.toArray();
    }
    
    public Object[] allDesc() {
        Statement stmt;
        ArrayList<String> descs = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select description from reason_for_interest");
            
            while(rs.next()) {
                String desc = rs.getString("description");
                descs.add(desc);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descs.toArray();
    }
    
    public Object[] allMakes() {
        Statement stmt;
        ArrayList<String> makes = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vehicle_make");
            
            while(rs.next()) {
                String make = rs.getString("make");
                makes.add(make);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return makes.toArray();
    }
    
    public Object[] allModels() {
        Statement stmt;
        ArrayList<String> models = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select model from vehicle_model");
            
            while(rs.next()) {
                String model = rs.getString("model");
                models.add(model);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return models.toArray();
    }
    
    public Object[] allModelsForAMake(String make) {
        PreparedStatement stmt;
        ArrayList<String> models = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select model from vehicle_model where make = ?");
            stmt.setString(1, make);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String model = rs.getString("model");
                models.add(model);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return models.toArray();
    }
    
    public Object[] allPlates() {
        Statement stmt;
        ArrayList<String> plates = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select license_plate from vehicle_of_interest");
            
            while(rs.next()) {
                String plate = rs.getString("license_plate");
                plates.add(plate);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plates.toArray();
    }
    
    public Object[] allROI() {
        Statement stmt;
        ArrayList<String> roi = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from reason_for_interest");
            
            while(rs.next()) {
                String make = rs.getString("reason");
                roi.add(make);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roi.toArray();
    }
    
            /*
    public Object[] allVOI() {
        Statement stmt;
        ArrayList<String> voi = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vehicle_of_interest");
            
            while(rs.next()) {
                String make = rs.getString("make");
                String licensePlate = rs.getString("license_plate");
                String reason = rs.getString("reason");;
                String model = rs.getString("model");
                String year = rs.getString("veh_year");
                String color = rs.getString("color");
                String name = rs.getString("owners_name");
                String phone = rs.getString("owners_phone");
                voi.add(make);
                voi.add(licensePlate);
                voi.add(reason);
                voi.add(model);
                voi.add(year);
                voi.add(color);
                voi.add(name);
                voi.add(phone);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voi.toArray();
    }*/
    
    public Object[] allYears() {
        int startYear = 1990;
        int currentYear;
        ArrayList<String> years = new ArrayList<>();
        LocalDate now = LocalDate.now();
        currentYear = now.getYear();
        currentYear++;
        while(startYear < currentYear) {
            String y = Integer.toString(startYear);
            years.add(y);
            startYear++;
        }
        return years.toArray();
    }
    
    public Object[] getDesc(String roi) {
        PreparedStatement psSelect;
        ArrayList<String> desc = new ArrayList<>();
        try {
            psSelect = conn.prepareStatement(
                    "select description from reason_for_interest where reason = ? ");
            psSelect.setString(1, roi);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                String row = rs.getString("description");
                desc.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desc.toArray();
    }
    
    public Object[] getVOIByPlate(String licensePlate) {
        Statement stmt;
        ArrayList<String> voi = new ArrayList<>();
        try {
            PreparedStatement psSelect= conn.prepareStatement("select * from vehicle_of_interest where license_plate = ?");
            psSelect.setString(1,licensePlate);
            ResultSet rs = psSelect.executeQuery();
            
            while(rs.next()) {
                String make = rs.getString("make");
                String lp = rs.getString("license_plate");
                String reason = rs.getString("reason");
                String model = rs.getString("model");
                String year = rs.getString("veh_year");
                String color = rs.getString("color");
                String name = rs.getString("owners_name");
                String phone = rs.getString("owners_phone");
                voi.add(make);
                voi.add(lp);
                voi.add(reason);
                voi.add(model);
                voi.add(year);
                voi.add(color);
                voi.add(name);
                voi.add(phone);
            }
            psSelect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voi.toArray();
    }

    /*
    public Object[] searchMake(String make) {
        PreparedStatement psSelect;
        ArrayList<String> makes = new ArrayList<>();
        try {
            psSelect = conn.prepareStatement(
                    "update vehicle_model \n" +
                    "set model = '?', make = '?'\n" +
                    "where make = '?'");
            psSelect.setString(1, make);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                String row = rs.getString("make");
                makes.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return makes.toArray();
    }*/
    
    /*    
    public Object[] searchPlate(String plate) {
        PreparedStatement psSelect;
        ArrayList<String> plates = new ArrayList<>();
        try {
            psSelect = conn.prepareStatement(
                    "select license_plate from vehicle_of_interest where license_plate = ? ");
            psSelect.setString(1, plate);
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()) {
                String row = rs.getString("plate");
                plates.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plates.toArray();
    }*/
    
    /*
    public void updateModel(String make, String oldModel, String newModel) {
        PreparedStatement psInsert;
        PreparedStatement psUpdate;
        PreparedStatement psDelete;
        try {
            psInsert = conn.prepareStatement(
                    "insert into vehicle_model (make, model) values (?, ?);");
            psInsert.setString(1, make);
            psInsert.setString(2, newModel);
            psInsert.executeUpdate();
            psUpdate = conn.prepareStatement(
                    "update vehicle_of_interest set model = ? where model = ?");
            psUpdate.setString(1, newModel);
            psUpdate.setString(2, oldModel);
            psUpdate.executeUpdate();
            psDelete = conn.prepareStatement(
                    "delete from vehicle_model where model = '?'");
            psDelete.setString(1, oldModel);
            psDelete.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
