package Core_Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING extends JFrame implements ActionListener 
{
    JLabel l1, l2, l3, l4, l5, msg;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4;

    public DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING() 
    {
        setTitle("CRUD Operations - Employee Management");
        setSize(500, 350);
        setLayout(new GridLayout(10, 2, 8, 8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Labels and TextFields
        l1 = new JLabel("Employee ID :");
        t1 = new JTextField();
        l2 = new JLabel("First Name :");
        t2 = new JTextField();
        l3 = new JLabel("Last Name :");
        t3 = new JTextField();
        l4 = new JLabel("E-mail Address:");
        t4 = new JTextField();
        l5 = new JLabel("Mobile No.:");
        t5 = new JTextField();

        msg = new JLabel("");
        msg.setHorizontalAlignment(JLabel.CENTER);

        b1 = new JButton("Insert");
        b2 = new JButton("Update");
        b3 = new JButton("Delete");
        b4 = new JButton("Search");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(l5); add(t5);
        add(b1); add(b2);
        add(b3); add(b4);
        add(msg);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setVisible(true);
    }

	@Override
    public void actionPerformed(ActionEvent e) 
    {
        String url = "jdbc:mysql://localhost:3306/assessment_demonstration_of_gui_based_crud_operations_with_java?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(url, user, password);

	            if (e.getSource() == b1)
	            {
	                String query = "INSERT INTO employee (Id, FirstName, LastName, Email, Mobile) VALUES (?, ?, ?, ?, ?)";
	                PreparedStatement pstmt = cn.prepareStatement(query);
	                pstmt.setInt(1, Integer.parseInt(t1.getText()));
	                pstmt.setString(2, t2.getText());
	                pstmt.setString(3, t3.getText());
	                pstmt.setString(4, t4.getText());
	                pstmt.setString(5, t5.getText());
	                int result = pstmt.executeUpdate();
	                msg.setText(result > 0 ? "-> Record Inserted Sucessfully" : "-->> Note :- Insertion Failed! ");
	            }
	
	            if (e.getSource() == b2)
	            {
	                String query = "UPDATE employee SET FirstName=?, LastName=?, Email=?, Mobile=? WHERE Id=?";
	                PreparedStatement pstmt = cn.prepareStatement(query);
	                pstmt.setString(1, t2.getText());
	                pstmt.setString(2, t3.getText());
	                pstmt.setString(3, t4.getText());
	                pstmt.setString(4, t5.getText());
	                pstmt.setInt(5, Integer.parseInt(t1.getText()));
	                int result = pstmt.executeUpdate();
	                msg.setText(result > 0 ? "-> Record Updated Sucessfully" : "-->> Note :- Update Failed! ");
	            }
	
	            if (e.getSource() == b3)
	            {
	                String query = "DELETE FROM employee WHERE Id=?";
	                PreparedStatement pstmt = cn.prepareStatement(query);
	                pstmt.setInt(1, Integer.parseInt(t1.getText()));
	                int result = pstmt.executeUpdate();
	                msg.setText(result > 0 ? "-> Record Deleted Sucessfully" : "-->> Note :- Deletion Failed! ");
	            }
	
	            if (e.getSource() == b4)
	            {
	                String query = "SELECT * FROM employee WHERE Id=?";
	                PreparedStatement pstmt = cn.prepareStatement(query);
	                pstmt.setInt(1, Integer.parseInt(t1.getText()));
	                ResultSet rs = pstmt.executeQuery();
	                if (rs.next()) 
	                {
	                    t2.setText(rs.getString("FirstName"));
	                    t3.setText(rs.getString("LastName"));
	                    t4.setText(rs.getString("Email"));
	                    t5.setText(rs.getString("Mobile"));
	                    msg.setText("Record Search!");
	                } 
	                else 
	                {
	                    msg.setText("-->> *** No Record Found! *** <<--");
	                }
	            }
	
	            cn.close();
	        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        	msg.setText("-->> Error: Input Valid Employee ID -" + ex.getMessage());
        }
    }

    public static void main(String[] args) 
    {
        new DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING();
    }
}

