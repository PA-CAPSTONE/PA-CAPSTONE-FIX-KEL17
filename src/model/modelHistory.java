/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class modelHistory {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Data History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel tableModel = new DefaultTableModel();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
            Statement statement = connection.createStatement();

            // Query data from the first table
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM table1");
            tableModel.setColumnIdentifiers(new String[]{"Column1", "Column2"});
            while (resultSet1.next()) {
                tableModel.addRow(new Object[]{resultSet1.getString(1), resultSet1.getString(2)});
            }

            // Query data from the second table
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM table2");
            while (resultSet2.next()) {
                tableModel.addRow(new Object[]{resultSet2.getString(1), resultSet2.getString(2)});
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
