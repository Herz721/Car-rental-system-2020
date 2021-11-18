package application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class logincontroller implements Initializable {
	
	@FXML
	private Button userlogin;
	@FXML
	private Button adminlogin;
	@FXML
	private TextField numbertext;
	@FXML
	private TextField passwordtext;

	@Override 
	public void initialize(URL location,ResourceBundle resources)
	{
		try
		{

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public void userlogin()
	{
		int number;
		String num;
		String password;
		String SQL;
		ResultSet SQLresult=null;
		
		num = numbertext.getText().trim();
			
		if(num.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户名!");
			alert.showAndWait();
			return;
		}
		number = Integer.parseInt(num);
		
		password = passwordtext.getText().trim();
		if(password.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入密码!");
			alert.showAndWait();
			return;
		}
		
		SQL = "SELECT * FROM USER WHERE UID =" + number +" AND UPWD ='"+password+"';";
		try 
		{
			SQLresult = Main.st.executeQuery(SQL);
			if(SQLresult.next())//正常登录
			{
				Main.number = number;
				
				Parent userparent = FXMLLoader.load(getClass().getResource("userfxml.fxml"));
				Scene  s = new Scene(userparent);
				SQL = "SELECT UNAME FROM USER WHERE UID = " + number +";";
				SQLresult = Main.st.executeQuery(SQL);
				SQLresult.next();
				String name = SQLresult.getString("UNAME");
				Main.settitle(name);
				Main.setscene(s);
			}
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("用户名或密码错误!");
				alert.showAndWait();
				return;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	}
	
	public void adminlogin()
	{
		int number;
		String num;
		String password;
		String  SQL;
		ResultSet rs=null;
		
		num = numbertext.getText();
			
		if(num.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户名!");
			alert.showAndWait();
			return;
		}
		else
		{
			number = Integer.parseInt(num);
		}
		
		password = passwordtext.getText();
		if(password.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入密码!");
			alert.showAndWait();
			return;
		}
		
		SQL = "SELECT * FROM ADMIN WHERE AID=" + number +" AND APWD ='"+password+"';";
		try
		{
			rs = Main.st.executeQuery(SQL);
			if(rs.next())
			{
				Main.number = number;
				Parent adminparent = FXMLLoader.load(getClass().getResource("adminfxml.fxml"));
				Scene s = new Scene(adminparent);
				SQL = "SELECT ANAME FROM ADMIN WHERE AID = " + number+";";
				rs = Main.st.executeQuery(SQL);
				rs.next();
				String name = rs.getString("ANAME");
				Main.settitle(name);
				Main.setscene(s);
			}
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("用户名和密码错误!");
				alert.showAndWait();
				return;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
