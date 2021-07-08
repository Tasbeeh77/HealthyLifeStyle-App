package CONNECTION;

import Model.diet;
import Model.table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;


public class sql_connection extends table{
    public int x=1;

    Connection con;
    PreparedStatement pst ;
    ResultSet res ;
    public ObservableList<table> list = FXCollections.observableArrayList();
    public ObservableList<diet> list1 = FXCollections.observableArrayList();

                                      // JDBC Function

    public void  Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/healthy_lifestyle","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getStackTrace();
        }
    }


                                  // Showing  all data of calories Table

    public  void show_table () throws SQLException {
        Connection();
        res = con.createStatement().executeQuery("SELECT * FROM `calories` ");
        while (res.next())
        {
            list.add(new table(res.getString("food_name"), res.getDouble("amount"),
                    res.getString("unit"), res.getInt("calories")));
        }
    }


                                  // Showing  all data of diet Table

    public  void show_diet() throws SQLException {
        Connection();
        res = con.createStatement().executeQuery("SELECT * FROM `diet` ");
        while (res.next())
        {
            list1.add(new diet(res.getString("week"), res.getString("breakfast"),
                    res.getString("lunch"), res.getString("dinner")));
        }
    }

                               // Showing  a specific row of calories Table

    public  void show_food (String food) throws SQLException {

        Connection();
        res = con.createStatement().executeQuery("SELECT * FROM `calories` where food_name = '" + food + "'");
        while (res.next())
        {
            list.add(new table(res.getString("food_name"), res.getDouble("amount"),
                    res.getString("unit"), res.getInt("calories")));
        }

    }

                                  // Insert new food to Calories Table

    public void Insert_Food_data (String food_name, double amount, String unit, int calories) throws SQLException {
        Connection();
        pst = con.prepareStatement("INSERT INTO `calories`(`food_name`, `amount`, `unit`, `calories`)" +
                " VALUES (?,?,?,?)");
        pst.setString(1, food_name);
        pst.setDouble(2, amount);
        pst.setString(3, unit);
        pst.setInt(4, calories);

        pst.executeUpdate();

    }

                                     // Insert users information to users Table

    public void Insert_data (String namee, String Email, String password, LocalDate birth,
                             String gender) throws SQLException {
                Connection();
                pst = con.prepareStatement("INSERT INTO `users`( `Name`, `Email`, `Password`,"+
                        " `Age`, `Gender`) VALUES (?,?,?,?,?)");
                pst.setString(1, namee);
                pst.setString(2, Email);
                pst.setString(3, password);
                pst.setDate(4, Date.valueOf(birth));
                pst.setString(5, String.valueOf(gender));

                pst.executeUpdate();

            }


                                  // Compare the entered data of user to the data in users table

    public  Boolean select_sign_in(String email , String password)
            {
                try {
                    Connection();
                    pst = con.prepareStatement("SELECT * FROM users WHERE Email = ? and Password = ?");
                    pst.setString(1, email);
                    pst.setString(2, password);
                    pst.executeQuery();
                    if(!pst.executeQuery().next())
                    {

                        x=1;
                        return false;
                    }
                    else
                    {
                          x=0;
                        return true;
                    }
                }catch (
                        SQLException ex) {
                    System.out.println("Wrong sql :"+ ex);
                }
                return false;
            }

                                           // Insert users information to bmi Table

    public void BMI_Insert (String weight, String height, String Age ,String BMI , String calories) throws SQLException{

        Connection();
        pst = con.prepareStatement("INSERT INTO `bmi`( `weight`, `height`, `age`, `BMI`, `user_calories`) " +
                "VALUES (?,?,?,?,?)");
        pst.setDouble(1, Double.parseDouble(weight));
        pst.setDouble(2, Double.parseDouble(height));
        pst.setDouble(3, Integer.parseInt(Age));
        pst.setDouble(4, Double.parseDouble(BMI));
        pst.setDouble(5, Integer.parseInt(calories));

        pst.executeUpdate();
    }

    public  int data(String email) throws SQLException {
        Connection();
        res = con.createStatement().executeQuery("select * from users");
        while (res.next()) {
            String Email = res.getString("Email");
            if (email.equals(Email)) {
                int id = res.getInt("ID");
                return id;
            }
        }
        return 0;
    }


    public String[] result(int ID) throws SQLException {
        Connection();
        String[] data = new String[4];
        Boolean f = false;
            res = con.createStatement().executeQuery("select * from users ");
            while (res.next()) {
                int id = res.getInt("id");
                if (ID == id) {
                    f = true;
                    String Name = res.getString("Name");
                    data[0] = Name;
                }
            }
        res = con.createStatement().executeQuery("select * from bmi ");
        while (res.next()) {
            int id = res.getInt("id");
            if (ID == id) {
                f = true;
                String bmi = res.getString("BMI");
                String weight = res.getString("weight");
                String calo = res.getString("user_calories");
                data[1] = bmi;
                data[2] = weight;
                data[3] = calo;
            }
        }
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);
        System.out.println("sql");
        if (!f){
            return new String[]{"not found"};
        }
        return data;

    }


    public static void main(String[] args){}
}
