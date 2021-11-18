package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.sql.*;


public class Main extends Application 
{
	
	//to connect database
	static final String drivername = "com.mysql.jdbc.Driver";
	static final String dburl = "jdbc:mysql://localhost:3306/DBAS设计";
	static final String username = "root";
	static final String userpwd = "********";
	static Connection con;
	static Statement st;
	static int number;
	static Stage primarystage = null;
	private static Scene loginscene = null;
	private Parent loginparent = null;
	
	@Override
	public void start(Stage primaryStage) {
		try {
				try 
				{
					Class.forName(drivername);
					con = DriverManager.getConnection(dburl,username,userpwd);
					st= con.createStatement();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				primaryStage.setTitle("CAR RENTAL SYSTEM -- CS1707刘浩哲");
				primarystage = primaryStage;
				loginparent = FXMLLoader.load(getClass().getResource("loginfxml.fxml"));
				
				
				loginscene = new Scene(loginparent);
				setloginui();
				primarystage.show();
			} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void setprimarystage(Stage stage)
	{
		this.primarystage = stage;
	}
	public static Stage getprimarystage()
	{
		return primarystage;
	}
	public static void setloginui()
	{
		primarystage.setScene(loginscene);
	}
	public static void settitle(String title)
	{
		primarystage.setTitle(title);
	}
	public static void setscene(Scene scene)
	{
		primarystage.setScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
