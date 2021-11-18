package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.*;

public class usercontroller implements Initializable
{
	static ResultSet rs = null;
	static String SQL=null;
	
	
	
	/*
	 * 汽车查询部分
	 * */
	@FXML
	private TextField carquerycarnametextfield;
	@FXML
	private TextField carqueryauthortextfield;
	@FXML
	private TextField carqueryclasstextfield;
	@FXML
	private TextField carquerypresstextfield;
	@FXML
	private RadioButton carqueryfreeradiobutton;
	@FXML
	private Button carqueryquerybutton;
	@FXML
	private TableView<carinfo> carquerytable;
	@FXML
	private TableColumn<?,?> carquerycolumncarid,carquerycolumncarname;
	@FXML
	private TableColumn<?,?> carquerycolumnauthor,carquerycolumnpress;
	@FXML
	private TableColumn<?,?> carquerycolumnclass,carquerycolumnlocation,carquerycolumnfree;
	@FXML
	private TableColumn<?,?> carquerycolumnmoney;

	private ObservableList<carinfo> carquerydata = FXCollections.observableArrayList();

	String ttype;
	String press;
	String bclass;
	String blocation;
	String bfree;
	String bname;
	String stime;
	String etime;
	String ireturn;
	String userid;
	String username;
	String sex;
	String pwd;
	String rank;
	String bid;
	String otime;
	String oday;
	String brk;
	String fn;
	String money;
	/*
	 * 租车记录查询部分
	 * */
	@FXML
	private TableView<rentinfo> rentquerytable;
	@FXML
	private TableColumn<?,?> rentquerycolumncarname,rentquerycolumnstarttime;
	@FXML
	private TableColumn<?,?> rentquerycolumnendtime,rentquerycolumnreturn;



	private ObservableList<rentinfo> rentinfotable = FXCollections.observableArrayList();
	/*
	 * 基本信息查询
	 * */
	@FXML
	private TextField infoqueryuseridtextfield;
	@FXML
	private TextField infoqueryusernametextfield;
	@FXML
	private TextField infoquerysextextfield;
	@FXML
	private TextField infoquerypasswordtextfield;
	@FXML
	private TextField infoqueryranktextfield;

	/*
	 * 付款部分
	 * */
	@FXML
	private TableView<profitinfo> profittableview;
	@FXML
	private TableColumn<?,?> profitcolumncarid,profitcolumncarname;
	@FXML
	private TableColumn<?,?> profitcolumnovertime,profitcolumnoverday;
	@FXML
	private TableColumn<?,?> profitcolumnbroken,profitcolumnfine;

	private ObservableList<profitinfo> profitinfotable = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location,ResourceBundle resources)
	{
		SQL = "SELECT * FROM USER WHERE UID = "+ Main.number +";";
		System.out.println(Main.number);
		System.out.println(SQL);
		try
		{
			//实现基本信息查询
			rs = Main.st.executeQuery(SQL);
			rs.next();
			userid = rs.getString(1);
			username = rs.getString(2);
			sex = rs.getString(4);
			pwd = rs.getString(3);
			rank = rs.getString(5);
			System.out.println(userid);
			System.out.println(username);
			System.out.println(sex);
			System.out.println(pwd);
			System.out.println(rank);
			infoqueryuseridtextfield.setText(userid);
			infoqueryusernametextfield.setText(username);
			infoquerysextextfield.setText(sex);
			infoquerypasswordtextfield.setText(pwd);
			infoqueryranktextfield.setText(rank);

			//实现租车记录的查询
			SQL = "SELECT RENT.CID,RENTTIME,RETURNTIME,ISPAID \r\n "
					+ "FROM PROFIT,RENT\r\n"
					+ "WHERE RENT.RID = PROFIT.RID AND RENT.UID = "+Main.number +";";
			//这里的换行符\r\n很重要，要是没有的话会报错:SQL 有语法错误。
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
			{
				bname = rs.getString("CID");
				stime= rs.getString("RENTTIME");
				etime = rs.getString("RETURNTIME");
				ireturn = rs.getString("ISPAID");
				rentinfo slot = new rentinfo(bname,stime,etime,ireturn);
				System.out.println(slot);
				rentinfotable.add(slot);
			}

			rentquerycolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
			rentquerycolumnstarttime.setCellValueFactory(new PropertyValueFactory<>("starttime"));
			rentquerycolumnendtime.setCellValueFactory(new PropertyValueFactory<>("endtime"));
			rentquerycolumnreturn.setCellValueFactory(new PropertyValueFactory<>("breturn"));
			rentquerytable.setItems(rentinfotable);
			//付款记录处理
			SQL = "SELECT CAR.CID,CAR.CNAME,PROFIT.VTIME,PROFIT.RENTDAY,ISBREAK,CAR.CPRICE\r\n" +
					"FROM CAR,RENT,PROFIT\r\n" +
					"WHERE RENT.RID = PROFIT.RID AND \r\n" +
					"RENT.CID = CAR.CID AND \r\n" +
					"ISPAID  = '是' AND RENT.UID = "+Main.number+";";
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
			{
				bid = rs.getString(1);
				bname = rs.getString(2);
				otime = rs.getString(3);
				oday = rs.getString(4);
				brk = rs.getString(5);
				int price = Integer.parseInt(rs.getString(6));
				price = price * Integer.parseInt(oday) + 300 * Integer.parseInt(otime);
				if(brk.equals("是"))
				{
					price = price + 50000;
				}
				if(rank.equals("VIP"))
				{
					price = price * 8 / 10;
				}
				profitinfo slot = new profitinfo(bid,bname,otime,oday,brk,price);
				System.out.println(slot);
				profitinfotable.add(slot);
			}
			profitcolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
			profitcolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
			profitcolumnovertime.setCellValueFactory(new PropertyValueFactory<>("overtime"));
			profitcolumnoverday.setCellValueFactory(new PropertyValueFactory<>("overday"));
			profitcolumnbroken.setCellValueFactory(new PropertyValueFactory<>("broken"));
			profitcolumnfine.setCellValueFactory(new PropertyValueFactory<>("fine"));
			profittableview.setItems(profitinfotable);

		///汽车查询的初始化
			SQL = "SELECT CID,CNAME,TTYPE,SEATNUM,CTYPE,CLOCATION,CFREE,CPRICE\r\n" +
					"FROM car\r\n" +
					"WHERE CSTATUS = '正常';";
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
			{
				bid = rs.getString(1);
				bname = rs.getString(2);
				ttype = rs.getString(3);
				press = rs.getString(4);
				bclass = rs.getString(5);
				blocation = rs.getString(6);
				bfree = rs.getString(7);
				money = rs.getString(8);
				carinfo newcar = new carinfo(bid,bname,ttype,press,bclass,blocation,bfree,money);
				carquerydata.add(newcar);
			}
			carquerycolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
			carquerycolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
			carquerycolumnauthor.setCellValueFactory(new PropertyValueFactory<>("ttype"));
			carquerycolumnpress.setCellValueFactory(new PropertyValueFactory<>("press"));
			carquerycolumnclass.setCellValueFactory(new PropertyValueFactory<>("carclass"));
			carquerycolumnlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
			carquerycolumnfree.setCellValueFactory(new PropertyValueFactory<>("free"));
			carquerycolumnmoney.setCellValueFactory(new PropertyValueFactory<>("money"));
			carquerytable.setItems(carquerydata);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

	/*租车的输入变化时调用
	 * */
	public void querycar()
	{
		bname = carquerycarnametextfield.getText();
		ttype = carqueryauthortextfield.getText();
		bclass = carqueryclasstextfield.getText();
		press = carquerypresstextfield.getText();

		if(carqueryfreeradiobutton.isSelected()){bfree = "AND CFREE = '是'";}
		else{bfree = "";}

		if(bname!=null && !bname.isEmpty()){bname = "AND CNAME = '"+bname+"'";}//注意要是\\ 转义的问题
		else{bname = "";}

		if(ttype!=null && !ttype.isEmpty()) {ttype = "AND TTYPE = '"+ttype+"'";}
		else {ttype = "";}

		if(bclass!= null && !bclass.isEmpty()) {bclass = "AND CTYPE = '"+bclass+"'";}
		else {bclass = "";}

		if(press!=null && !press.isEmpty()) {press = "AND SEATNUM = '"+press+"'";}
		else {press = "";}

		SQL = "SELECT CID,CNAME,TTYPE,SEATNUM,CTYPE,CLOCATION,CFREE,CPRICE\r\n" +
				"FROM car\r\n" +
				"WHERE CSTATUS = '正常'\r\n"+bname+"\r\n"+ttype+"\r\n"+bclass+"\r\n"+press+"\r\n"+bfree+";";
		try
		{
			rs = Main.st.executeQuery(SQL);
			System.out.print(SQL);
			carquerydata.clear();
			while(rs.next())
			{
				bid = rs.getString(1);
				bname = rs.getString(2);
				ttype = rs.getString(3);
				press = rs.getString(4);
				bclass = rs.getString(5);
				blocation = rs.getString(6);
				bfree = rs.getString(7);
				money = rs.getString(8);
				carinfo updateone = new carinfo(bid,bname,ttype,press,bclass,blocation,bfree,money);
				carquerydata.add(updateone);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
