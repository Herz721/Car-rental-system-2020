package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

//import application.usercontroller.carquerylistener;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.*;

public class admincontroller implements Initializable{

	//新车登记
	@FXML
	private TextField carinnumtextfield;
	@FXML
	private TextField carincarnametextfield;
	@FXML
	private TextField carinauthortextfield;
	@FXML
	private TextField carinpresstextfield;
	@FXML
	private TextField carinclasstextfield;
	@FXML
	private TextField carinpricetextfield;
	@FXML
	private TextField carinlocationtextfield;
	@FXML
	private Button  carininbutton;

	//旧车报修
	@FXML
	private TextField cardowncaridtextfield;
	@FXML
	private TextField cardowncarnametextfield;
	@FXML
	private TextField cardownauthortextfield;
	@FXML
	private TextField cardownclasstextfield;
	@FXML
	private TextField cardownpresstextfield;

	@FXML
	private TableView<carinfo> cardowntableview;

	@FXML
	private TableColumn<?,?> cardowncolumncarid,cardowncolumncarname;
	@FXML
	private TableColumn<?,?> cardowncolumnauthor,cardowncolumnpress;
	@FXML
	private TableColumn<?,?>  cardowncolumnclass,cardowncolumnlocation;

	@FXML
	private Button cardowndownbutton;
	@FXML
	private Button cardownquerybutton;

	private ObservableList<carinfo> cardowndata = FXCollections.observableArrayList();
	//汽车查询
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
	private RadioButton carquerybrokeradiobutton;
	@FXML
	private Button carqueryquerybutton;

	@FXML
	private TableView<carinfo> carquerytableview;

	@FXML
	private TableColumn<?,?> carquerycolumncarid,carquerycolumncarname;
	@FXML
	private TableColumn<?,?> carquerycolumnauthor,carquerycolumnpress;
	@FXML
	private TableColumn<?,?> carquerycolumnclass,carquerycolumnlocation,carquerycolumnfree;
	@FXML
	private TableColumn<?,?> carquerycolumnmoney;

	private ObservableList<carinfo> carquerydata = FXCollections.observableArrayList();
	//录入用户
	@FXML
	private TextField userinuseridtextfield;
	@FXML
	private TextField userinusernametextfield;
	@FXML
	private ComboBox<String> userinsexcombobox;
	@FXML
	private TextField userinpasswordtextfield;
	@FXML
	private TextField userinuserranktextfield;
	@FXML
	private Button  userininbutton;

	//注销用户
	@FXML
	private TextField useroutuseridtextfield;
	@FXML
	private TextField useroutusernametextfield;
	@FXML
	private TableView<userinfo> userouttableview;
	@FXML
	private TableColumn<?,?> useroutcolumnuserid,useroutcolumnusername,useroutcolumnsex,useroutcolumnrank;
	@FXML
	private Button useroutoutbutton;
	@FXML
	private Button useroutquerybutton;

	private ObservableList<userinfo> userdowndata = FXCollections.observableArrayList();
	//修改用户信息
	@FXML
	private TextField usermodifyuseridtextfield;
	@FXML
	private TextField usermodifyusernametextfield;
	@FXML
	private ComboBox<String> usermodifysexcombobox;
	@FXML
	private TextField usermodifypasswordtextfield;
	@FXML
	private TextField usermodifyranktextfield;
	@FXML
	private Button usermodifymodifybutton;
	@FXML
	private Button usermodifyquerybutton;
	//查询用户信息
	@FXML
	private TextField userqueryuseridtextfield;
	@FXML
	private TextField userqueryusernametextfield;
	@FXML
	private TextField userquerysextextfield;
	@FXML
	private TextField userquerypasswordtextfield;
	@FXML
	private TextField userqueryuserranktextfield;
	@FXML
	private Button userqueryquerybutton;
	@FXML
	private Button userqueryclearbutton;

	//租车还车管理
	@FXML
	private TextField rentreturnuseridtextfield;
	@FXML
	private TextField rentreturncaridtextfield;
	@FXML
	private TextField rentreturnoverdaytextfield;
	@FXML
	private TextField rentreturnovertimetextfield;

	@FXML
	private ComboBox<String> rentreturnbrokencombobox;

	@FXML
	private Button rentreturnrentbutton;
	@FXML
	private Button rentreturnreturnbutton;

	@FXML
	private TableView<rentinfo>  rentreturntableview;

	@FXML
	private TableColumn<?,?> rentreturncolumnuserid,rentreturncolumncarid;
	@FXML
	private TableColumn<?,?> rentreturncolumncarname,rentreturncolumnendtime;

	private ObservableList<rentinfo> rentreturndata = FXCollections.observableArrayList();

	//付款管理
	@FXML
	private TextField profituseridtextfield;
	@FXML
	private TextField profitfinetextfield;

	@FXML
	private TableView<profitinfo> profittableview;

	@FXML
	private TableColumn<?,?> profitcolumnuserid,profitcolumnusername;
	@FXML
	private TableColumn<?,?> profitcolumncarid,profitcolumncarname;
	@FXML
	private TableColumn<?,?> profitcolumnovertime,profitcolumnoverday;
	@FXML
	private TableColumn<?,?> profitcolumnbroken,profitcolumnfine;

	@FXML
	private Button profitfinebutton;
	private ObservableList<profitinfo> profitdata = FXCollections.observableArrayList();

	//财务报表
	@FXML
	private TextField moneyfinetextfield;

	@FXML
	private TableView<moneyinfo> moneytableview;

	@FXML
	private TableColumn<?,?> moneycolumnuserid,moneycolumnusername;
	@FXML
	private TableColumn<?,?> moneycolumncarid,moneycolumncarname;
	@FXML
	private TableColumn<?,?> moneycolumnovertime,moneycolumnoverday;
	@FXML
	private TableColumn<?,?> moneycolumnbroken,moneycolumnfine;

	@FXML
	private ObservableList<moneyinfo> moneydata = FXCollections.observableArrayList();

	private ResultSet rs = null;
	private String SQL=null;

	String rdid;
	String rdname;
	String rdsex;
	String rdpwd;
	String rdrank;
	String bkid;
	String bkname;
	String ttype;
	String bkclass;
	String bkpress;
	String bklocation;
	String bknum;
	String price;
	String bkfree;
	String cstatus;
	String money;
	String stime;
	String otime;
	String oday;
	String brk;
	String fn;
	String cid;
	int allfine = 0;
	int allfine2 = 0;

	@Override
	public void initialize(URL location,ResourceBundle resources)
	{
		try{	//旧车报修的初始化
				SQL = "SELECT * \r\n" +
						"FROM CAR\r\n" +
						"WHERE CFREE = '是' AND \r\n" +
						"CSTATUS = '正常';";
				rs = Main.st.executeQuery(SQL);
				while(rs.next())
				{
					bkid = rs.getString(1);
					bkname = rs.getString(2);
					ttype = rs.getString(4);
					bkpress = rs.getString(3);
					bkclass = rs.getString(5);
					bklocation = rs.getString(7);
					carinfo newcar = new carinfo(bkid,bkname,ttype,bkpress,bkclass,bklocation);
					cardowndata.add(newcar);
				}
				cardowncolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
				cardowncolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
				cardowncolumnauthor.setCellValueFactory(new PropertyValueFactory<>("ttype"));
				cardowncolumnpress.setCellValueFactory(new PropertyValueFactory<>("press"));
				cardowncolumnclass.setCellValueFactory(new PropertyValueFactory<>("carclass"));
				cardowncolumnlocation.setCellValueFactory(new PropertyValueFactory<>("location"));
				cardowntableview.setItems(cardowndata);
				cardowntableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				//车辆查询的初始化
				SQL = "SELECT CID,CNAME,TTYPE,SEATNUM,CTYPE,CLOCATION,CFREE,CPRICE\r\n" +
						"FROM car\r\n" +
						"WHERE CSTATUS = '正常';";
				rs = Main.st.executeQuery(SQL);
				while(rs.next())
				{
					bkid = rs.getString(1);
					bkname = rs.getString(2);
					ttype = rs.getString(3);
					bkpress = rs.getString(4);
					bkclass = rs.getString(5);
					bklocation = rs.getString(6);
					bkfree = rs.getString(7);
					money = rs.getString(8);
					carinfo newcar = new carinfo(bkid,bkname,ttype,bkpress,bkclass,bklocation,bkfree,money);
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
				carquerytableview.setItems(carquerydata);
				//付款记录初始化
				SQL = "SELECT RENT.UID, USER.UNAME, RENT.CID,\r\n" +
						"PROFIT.VTIME,USER.URANK,PROFIT.RENTDAY,\r\n" +
						"PROFIT.ISBREAK,CAR.CPRICE\r\n" +
						"FROM CAR,RENT,USER,PROFIT \r\n" +
						"WHERE RENT.UID = USER.UID AND\r\n" +
						"RENT.RID = PROFIT.RID AND \r\n" +
						"RENT.CID = CAR.CID AND \r\n"+
						"PROFIT.ISPAID = '否';";
				rs = Main.st.executeQuery(SQL);
				allfine = 0;
				while(rs.next())
				{
					rdid = rs.getString(1);
					rdname = rs.getString(2);
					bkid = rs.getString(3);
					bkname = rs.getString(4);
					otime = rs.getString(5);
					oday = rs.getString(6);
					brk = rs.getString(7);
					fn = rs.getString(8);
					int price = Integer.parseInt(fn);
					price = price * Integer.parseInt(oday) + 300 * Integer.parseInt(bkname);
					if(brk.equals("是"))
					{
						price = price + 50000;
					}
					if(otime.equals("VIP"))
					{
						price = price * 8 / 10;
					}
					allfine = allfine + price;
					fn = price+"";
					profitinfo newprofit = new profitinfo(rdid,rdname,bkid,bkname,otime,oday,brk,fn);
					profitdata.add(newprofit);
				}
				profitfinetextfield.setText(allfine+"元");
				profitcolumnuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
				profitcolumnusername.setCellValueFactory(new PropertyValueFactory<>("username"));
				profitcolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
				profitcolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
				profitcolumnovertime.setCellValueFactory(new PropertyValueFactory<>("overtime"));
				profitcolumnoverday.setCellValueFactory(new PropertyValueFactory<>("overday"));
				profitcolumnbroken.setCellValueFactory(new PropertyValueFactory<>("broken"));
				profitcolumnfine.setCellValueFactory(new PropertyValueFactory<>("fine"));
				profittableview.setItems(profitdata);
				profittableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				//总财务报表初始化
				SQL = "SELECT RENT.UID, USER.UNAME, RENT.CID,\r\n" +
						"PROFIT.VTIME,USER.URANK,PROFIT.RENTDAY,\r\n" +
						"PROFIT.ISBREAK,CAR.CPRICE\r\n" +
						"FROM CAR,RENT,USER,PROFIT \r\n" +
						"WHERE RENT.UID = USER.UID AND\r\n" +
						"RENT.RID = PROFIT.RID AND \r\n" +
						"RENT.CID = CAR.CID AND \r\n"+
						"PROFIT.ISPAID = '是';";
				rs = Main.st.executeQuery(SQL);
				allfine2 = 0;
				while(rs.next())
				{
					rdid = rs.getString(1);
					rdname = rs.getString(2);
					bkid = rs.getString(3);
					bkname = rs.getString(4);
					otime = rs.getString(5);
					oday = rs.getString(6);
					brk = rs.getString(7);
					fn = rs.getString(8);
					int price = Integer.parseInt(fn);
					price = price * Integer.parseInt(oday) + 300 * Integer.parseInt(bkname);
					if(brk.equals("是"))
					{
						price = price + 50000;
					}
					if(otime.equals("VIP"))
					{
						price = price * 8 / 10;
					}
					allfine2 = allfine2 + price;
					fn = price+"";
					moneyinfo newmoney = new moneyinfo(rdid,rdname,bkid,bkname,otime,oday,brk,fn);
					moneydata.add(newmoney);
				}
				moneyfinetextfield.setText(allfine2+"元");
				moneycolumnuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
				moneycolumnusername.setCellValueFactory(new PropertyValueFactory<>("username"));
				moneycolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
				moneycolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
				moneycolumnovertime.setCellValueFactory(new PropertyValueFactory<>("overtime"));
				moneycolumnoverday.setCellValueFactory(new PropertyValueFactory<>("overday"));
				moneycolumnbroken.setCellValueFactory(new PropertyValueFactory<>("broken"));
				moneycolumnfine.setCellValueFactory(new PropertyValueFactory<>("fine"));
				moneytableview.setItems(moneydata);
				moneytableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				//租车还车的初始化:表格中不需要任何提前的信息
				rentreturnbrokencombobox.getItems().addAll("是","否");
				rentreturntableview.setItems(rentreturndata);
				rentreturncolumnuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
				rentreturncolumncarid.setCellValueFactory(new PropertyValueFactory<>("carid"));
				rentreturncolumncarname.setCellValueFactory(new PropertyValueFactory<>("carname"));
				rentreturncolumnendtime.setCellValueFactory(new PropertyValueFactory<>("starttime"));
				//录入用户的初始化
				userinsexcombobox.getItems().addAll("男","女");
				userinsexcombobox.getSelectionModel().select(0);
				//修改用户的初始化
				usermodifysexcombobox.getItems().addAll("男","女");
				//注销用户的初始化
				SQL = "SELECT *\r\n" +
						"FROM user \r\n";
				rs = Main.st.executeQuery(SQL);
				while(rs.next())
				{
					rdid = rs.getString(1);
					rdname = rs.getString(2);
					rdsex = rs.getString(4);
					rdrank = rs.getString(5);
					userinfo auser = new userinfo(rdid,rdname,rdsex,rdrank);
					userdowndata.add(auser);
				}
				userouttableview.setItems(userdowndata);
				useroutcolumnuserid.setCellValueFactory(new PropertyValueFactory<>("userid"));
				useroutcolumnusername.setCellValueFactory(new PropertyValueFactory<>("username"));
				useroutcolumnsex.setCellValueFactory(new PropertyValueFactory<>("sex"));
				useroutcolumnrank.setCellValueFactory(new PropertyValueFactory<>("rank"));
				userouttableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				useroutuseridtextfield.textProperty().addListener(new useroutlistener<String>());
				 //租借历史记录的动态处理，用户ID变化，动态改变表格内容
				 profituseridtextfield.textProperty().addListener(new profitlistener<String>());
				 //租车还车的动态处理，根据输入的user id来改变表格中的内容
				 rentreturnuseridtextfield.textProperty().addListener(new rentreturnlistener<String>());

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void carin()//新车登记
	{
		bknum = carinnumtextfield.getText().trim();
		if(bknum==null || bknum.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车数量!");
			alert.showAndWait();
			return;
		}
		int bkn = 0;
		try
		{
			bkn = Integer.parseInt(bknum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入数字!");
			alert.showAndWait();
			return;
		}
		bkname = carincarnametextfield.getText().trim();
		if(bkname==null || bkname.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车品牌!");
			alert.showAndWait();
			return;
		}
		ttype = carinauthortextfield.getText().trim();
		if(ttype==null || ttype.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车座位数!");
			alert.showAndWait();
			return;
		}
		bkpress = carinpresstextfield.getText().trim();
		if(bkpress==null || bkpress.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车变速!");
			alert.showAndWait();
			return;
		}
		bkclass = carinclasstextfield.getText().trim();
		if(bkclass==null || bkclass.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车类型!");
			alert.showAndWait();
			return;
		}
		price = carinpricetextfield.getText().trim();
		if(price==null || price.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入新车租金!");
			alert.showAndWait();
			return;
		}
		bklocation = carinlocationtextfield.getText().trim();
		if(bklocation==null || bklocation.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入商家所在地址!");
			alert.showAndWait();
			return;
		}
		int i=0;
		int insertednum = 0;
		for(i=0;i<bkn;i++)
		{
			try
			{
				SQL = "SELECT MAX(CID)+1 FROM CAR;";
				rs = Main.st.executeQuery(SQL);
				while(rs.next())
				cid = rs.getString(1);
				SQL = "INSERT INTO CAR VALUES (" +cid+ ",'"+bkname+"',"+ttype+",'"+bkpress+"','"+bkclass+"',"+price+",'"+bklocation+"','是','正常');";
				insertednum = insertednum + Main.st.executeUpdate(SQL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("登记未全部成功，新增汽车数量："+insertednum);
				alert.showAndWait();
				return;
			}

		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText("登记成功，新增汽车数量："+insertednum);
		alert.showAndWait();
		carinnumtextfield.setText("");
		carincarnametextfield.setText("");
		carinauthortextfield.setText("");
		carinpresstextfield.setText("");
		carinclasstextfield.setText("");
		carinpricetextfield.setText("");
		carinlocationtextfield.setText("");
	}


	public void cardownquery()//车辆查询
	{
		bkid = cardowncaridtextfield.getText().trim();
		bkname = cardowncarnametextfield.getText().trim();
		ttype = cardownauthortextfield.getText().trim();
		bkclass = cardownclasstextfield.getText().trim();
		bkpress = cardownpresstextfield.getText().trim();

		if(bkid!=null && !bkid.isEmpty()) {bkid = "AND CID = '"+bkid+"'";}
		else {bkid="";}

		if(bkname!=null && !bkname.isEmpty()){bkname = "AND CNAME = '"+bkname+"'";}
		else{bkname = "";}

		if(ttype!=null && !ttype.isEmpty()) {ttype = "AND TTYPE = '"+ttype+"'";}
		else {ttype = "";}

		if(bkclass!= null && !bkclass.isEmpty()) {bkclass = "AND CTYPE = '"+bkclass+"'";}
		else {bkclass = "";}

		if(bkpress!=null && !bkpress.isEmpty()) {bkpress = "AND SEATNUM = '"+bkpress+"'";}
		else {bkpress = "";}

		SQL = "SELECT * \r\n" +
				"FROM car\r\n" +
				"WHERE CFREE = '是' AND \r\n" +
				"CSTATUS = '正常'\r\n"+bkid+bkname+ttype+bkclass+bkpress;
		try
		{
			System.out.print(SQL);
			rs = Main.st.executeQuery(SQL);
			cardowndata.clear();
			while(rs.next())
			{
				bkid = rs.getString(1);
				bkname = rs.getString(2);
				ttype = rs.getString(4);
				bkpress = rs.getString(3);
				bkclass = rs.getString(5);
				bklocation = rs.getString(7);
				carinfo newcar = new carinfo(bkid,bkname,ttype,bkpress,bkclass,bklocation);
				cardowndata.add(newcar);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void cardown()//车辆报修
	{
		ObservableList<carinfo> selectedslots = FXCollections.observableArrayList();
		selectedslots = cardowntableview.getSelectionModel().getSelectedItems();
		carinfo slot;

		int i=0;
		int updateid;
		int index=0;
		int size = selectedslots.size();
		String downcars ="报修车辆：";
		for(i=0;i<size;i++)
		{
			slot = selectedslots.get(i);
			bkid = slot.getCarid();
			updateid = Integer.parseInt(bkid);
			SQL = "UPDATE CAR\r\n" +
					"SET CSTATUS = '报修'\r\n" +
					"WHERE CID = "+updateid;
			System.out.println("SQL:"+SQL);
			try
			{
				Main.st.executeUpdate(SQL);
				downcars = downcars +" "+ bkid;
				index = cardowndata.indexOf(slot);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("报修未成功，"+downcars);
				alert.showAndWait();
				cardownquery();
			}
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText(downcars);
		alert.showAndWait();
		cardownquery();
	}

	public void carquery()//车辆查询
	{
		bkname = carquerycarnametextfield.getText();
		ttype = carqueryauthortextfield.getText();
		bkclass = carqueryclasstextfield.getText();
		bkpress = carquerypresstextfield.getText();

		if(carqueryfreeradiobutton.isSelected()){bkfree = "AND CFREE = '是'";}
		else{bkfree = "";}

		if(carquerybrokeradiobutton.isSelected()){cstatus = "报修";}
		else{cstatus = "正常";}

		if(bkname!=null && !bkname.isEmpty()){bkname = "AND CNAME = '"+bkname+"'";}
		else{bkname = "";}

		if(ttype!=null && !ttype.isEmpty()) {ttype = "AND TTYPE = '"+ttype+"'";}
		else {ttype = "";}

		if(bkclass!= null && !bkclass.isEmpty()) {bkclass = "AND CTYPE = '"+bkclass+"'";}
		else {bkclass = "";}

		if(bkpress!=null && !bkpress.isEmpty()) {bkpress = "AND SEATNUM = '"+bkpress+"'";}
		else {bkpress = "";}

		SQL = "SELECT * FROM CAR\r\n" +
				"WHERE CSTATUS = '"+cstatus+"'\r\n"+bkname+ttype+bkclass+bkpress+bkfree;
		try
		{
			rs= Main.st.executeQuery(SQL);
			carquerydata.clear();
			while(rs.next())
			{
				bkid = rs.getString(1);
				bkname = rs.getString(2);
				ttype = rs.getString(4);
				bkpress = rs.getString(3);
				bkclass = rs.getString(5);
				bklocation = rs.getString(7);
				bkfree = rs.getString(8);
				money = rs.getString(6);
				carinfo newcar = new carinfo(bkid,bkname,ttype,bkpress,bkclass,bklocation,bkfree,money);
				carquerydata.add(newcar);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void pwdconsistent()
	{

	}

	public void userin()//用户注册
	{
		try
		{
			rdid = userinuseridtextfield.getText().trim();
			int newid = Integer.parseInt(rdid);
			rdname = userinusernametextfield.getText().trim();
			String pwd = userinpasswordtextfield.getText();
			rdrank = userinuserranktextfield.getText().trim();
			int sel = userinsexcombobox.getSelectionModel().getSelectedIndex();
			String sex=null;
			if(sel==0)
			{
				sex = "男";
			}
			else
			{
				if(sel == 1)
				{
					sex ="女";
				}
			}
			if(rdid ==null|rdid.isEmpty())
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("请输入用户ID!");
				alert.showAndWait();
				return;
			}
			if(rdname==null|| rdname.isEmpty())
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("请输入用户姓名!");
				alert.showAndWait();
				return;
			}
			if(rdrank==null || rdrank.isEmpty())
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("请输入用户等级!");
				alert.showAndWait();
				return;
			}
			if(pwd==null || pwd.isEmpty())
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("请输入密码!");
				alert.showAndWait();
				return;
			}
			SQL = "INSERT INTO USER \r\n" +
					"VALUES ("+newid+",'"+rdname+"','"+pwd+"','"+sex+"','"+rdrank+"');";
			Main.st.executeUpdate(SQL);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("注册成功!");
			alert.showAndWait();
			userinuseridtextfield.setText("");
			userinusernametextfield.setText("");
			userinuserranktextfield.setText("");
			userinpasswordtextfield.setText("");
		}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("注册失败!");
			alert.showAndWait();
			e.printStackTrace();
		}

	}
	public void useroutquery()//用户注销
	{
		userdowndata.clear();
		rdid = useroutuseridtextfield.getText().trim();
		rdname = useroutusernametextfield.getText().trim();
		if(rdid!=null && !rdid.isEmpty()) {rdid = "UID = '"+rdid+"'";}
		else {rdid = "";}
		if(rdname!=null && !rdname.isEmpty()) {rdname = " UNAME ='"+rdname+"'";}
		else {rdname = "";}

		try
		{
			SQL = "SELECT *\r\n" +
					"FROM USER \r\n";
			if(rdid.equals(""))
			{
				if(rdname.equals("")) {}
				else
				{
					SQL = SQL + "WHERE "+rdname;
				}
			}
			else
			{
				SQL = SQL +"WHERE "+rdid;
				if(rdname.equals("")) {}
				else
				{
					SQL = SQL + "\r\n AND"+rdname;
				}
			}
			rs = Main.st.executeQuery(SQL);
			userdowndata.clear();
			while(rs.next())
			{
				rdid = rs.getString(1);
				rdname = rs.getString(2);
				rdsex = rs.getString(4);
				rdrank = rs.getString(5);
				userinfo newuser = new userinfo(rdid,rdname,rdsex,rdrank);
				userdowndata.add(newuser);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	class useroutlistener<T> implements ChangeListener<T>
	{
		 @Override
		  public void changed(ObservableValue <? extends T> a, T old, T n)
		 {
			 useroutquery();
		 }
	}


	public void userout()//用户注销
	{
		ObservableList<userinfo> selectedslots = FXCollections.observableArrayList();
		selectedslots = userouttableview.getSelectionModel().getSelectedItems();
		userinfo slot;
		System.out.println(selectedslots.size());
		int i=0;
		int outnum = 0;
		for(i=0;i<selectedslots.size();i++)
		{
			slot = selectedslots.get(i);
			rdid = slot.getUserid();
			System.out.println(rdid);
			//注销时不能有车没还或者付款没交
			try
			{
				SQL = "SELECT *\r\n" +
						"FROM RENT \r\n" +
						"WHERE ISRETURN = '否'\r\n" +
						"AND UID = "+rdid;
				ResultSet carsrented = Main.st.executeQuery(SQL);
				if(carsrented.next())
				{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告");
					alert.setHeaderText(null);
					alert.setContentText("用户未还车，不可注销!");
					alert.showAndWait();
					return;
				}
				SQL = "SELECT *\r\n" +
						"FROM PROFIT,RENT\r\n" +
						"WHERE PROFIT.RID = RENT.RID\r\n" +
						"AND ISPAID = '否'\r\n" +
						"AND RENT.UID ="+rdid;
				ResultSet profititems = Main.st.executeQuery(SQL);
				if(profititems.next())
				{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告");
					alert.setHeaderText(null);
					alert.setContentText("用户未付款，不可注销!");
					alert.showAndWait();
					return;
				}
				SQL = "DELETE FROM USER\r\n" +
						"WHERE UID ="+rdid;
				outnum += Main.st.executeUpdate(SQL);
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("注销失败!");
				alert.showAndWait();
				e.printStackTrace();
				return;
			}
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText("注销成功!");
		alert.showAndWait();
		useroutquery();
	}

	public void usermodifyquery()//查询用户信息
	{
		rdid = usermodifyuseridtextfield.getText().trim();
		if(rdid==null || rdid.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户ID!");
			alert.showAndWait();
			return;
		}
		SQL = "SELECT * FROM USER \r\n" +
				"WHERE UID = "+rdid;
		try
		{
			rs = Main.st.executeQuery(SQL);
			rs.next();
			rdname = rs.getString(2);
			rdpwd = rs.getString(3);
			rdsex = rs.getString(4);
			rdrank = rs.getString(5);
			if(rdsex.equals("男"))
			{
				usermodifysexcombobox.getSelectionModel().select(0);
			}
			if(rdsex.equals("女"))
			{
				usermodifysexcombobox.getSelectionModel().select(1);
			}
			usermodifyusernametextfield.setText(rdname);
			usermodifypasswordtextfield.setText(rdpwd);
			usermodifyranktextfield.setText(rdrank);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void usermodify()//修改用户信息
	{
		rdid = usermodifyuseridtextfield.getText().trim();
		rdname = usermodifyusernametextfield.getText().trim();
		int sel = usermodifysexcombobox.getSelectionModel().getSelectedIndex();
		rdpwd = usermodifypasswordtextfield.getText().trim();
		rdrank = usermodifyranktextfield.getText().trim();
		if(rdid==null||rdid.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户ID!");
			alert.showAndWait();
			return;
		}

		if(sel==0) {rdsex = "男";}
		if(sel==1) {rdsex = "女";}

		rdname = "UNAME = '"+rdname+"',\r\n";
		rdpwd = "UPWD = '"+rdpwd+"',\r\n";
		rdsex = "USEX = '"+rdsex+"',\r\n";
		rdrank = "URANK = '"+rdrank+"'\r\n";
		SQL = "UPDATE user\r\n" +
				"SET "+rdname+rdsex+rdpwd+rdrank+"WHERE UID = "+rdid;
		System.out.println(SQL);
		try
		{
			Main.st.executeUpdate(SQL);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("修改成功!");
			alert.showAndWait();
		}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("修改失败!");
			alert.showAndWait();
			e.printStackTrace();
		}
	}

	public void userquery()//查询用户信息
	{
		rdid = userqueryuseridtextfield.getText().trim();
		if(rdid == null || rdid.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户ID!");
			alert.showAndWait();
			return;
		}
		int num=0;
		try
		{
			num = Integer.parseInt(rdid);
		}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("ID格式错误!");
			alert.showAndWait();
			e.printStackTrace();
			return;
		}
		SQL = "SELECT * FROM USER\r\n" +
				"WHERE UID  = "+num;
		try
		{
			rs = Main.st.executeQuery(SQL);
			if(!rs.next())//没有返回结果
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告");
				alert.setHeaderText(null);
				alert.setContentText("不存在该用户!");
				alert.showAndWait();
				return;
			}
			else
			{
				userqueryusernametextfield.setText(rs.getString(2));
				userquerypasswordtextfield.setText(rs.getString(3));
				userquerysextextfield.setText(rs.getString(4));
				userqueryuserranktextfield.setText(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	public void clearuserquery()//用户信息清除
	{
		userqueryuseridtextfield.clear();
		userqueryusernametextfield.clear();
		userquerysextextfield.clear();
		userquerypasswordtextfield.clear();
		userqueryuserranktextfield.clear();
	}
	//租借登记
	public void rentcar()
	{
		rdid = rentreturnuseridtextfield.getText();
		if(rdid==null|| rdid.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入用户ID!");
			alert.showAndWait();
			return;
		}
		bkid = rentreturncaridtextfield.getText();
		if(bkid==null || bkid.isEmpty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setHeaderText(null);
			alert.setContentText("请输入汽车ID!");
			alert.showAndWait();
			return;
		}
		try
		{
			SQL = "SELECT * \r\n" +
					"FROM CAR\r\n" +
					"WHERE CFREE = '是'\r\n" +
					"AND CSTATUS = '正常'\r\n" +
					"AND CID = '"+bkid+"';";
			ResultSet brcar = Main.st.executeQuery(SQL);//检查汽车是否可借
			if(!brcar.next())//没有返回结果
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText(null);
				alert.setContentText("此汽车暂时不可租用!");
				alert.showAndWait();
				return;
			}

			SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
			Date nowdate = new Date();
			SQL = "SELECT MAX(RID)+1 FROM RENT;";
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
				cid = rs.getString(1);
			SQL = "INSERT INTO RENT (RID,UID,CID,RENTTIME,ISRETURN) VALUES ("+cid+","+rdid+","+bkid+",'"+dateformatter.format(nowdate)+"','否');";
			Main.st.executeUpdate(SQL);//先借书表中插入一条记录

			SQL = "UPDATE CAR\r\n" +
					"SET CFREE = '否'\r\n" +
					"WHERE CID  = "+bkid;

			Main.st.executeUpdate(SQL);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("租车成功!");
			alert.showAndWait();
			queryrent();
		}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("租车失败!");
			alert.showAndWait();
			e.printStackTrace();
		}
	}

	public void choosereturn()//查询用户租车情况
	{
		ObservableList<rentinfo> selectedslots = FXCollections.observableArrayList();
		selectedslots = rentreturntableview.getSelectionModel().getSelectedItems();
		rentinfo slot = selectedslots.get(0);
		rdid = slot.getUserid();
		bkid = slot.getCarid();
		bkname = slot.getCarname();
		stime = slot.getStarttime();

		rentreturncaridtextfield.setText(bkid);

		Date nowdate;
		Date renttime;
		SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			SQL = "SELECT URANK FROM USER WHERE UID = "+rdid+";";
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
				cid = rs.getString(1);
			rentreturnovertimetextfield.setText(cid);
			nowdate = datefm.parse(datefm.format((new Date())));
			renttime = datefm.parse(stime);
			if(!nowdate.before(renttime))
			{
				rentreturnoverdaytextfield.setVisible(true);
				LocalDate date1 = LocalDate.parse(datefm.format(nowdate));
				LocalDate date2 = LocalDate.parse(datefm.format(renttime));
				long days = Math.abs(ChronoUnit.DAYS.between(date1,date2)) + 1;
				rentreturnoverdaytextfield.setText(days+"");
			}
			else
			{
				rentreturnoverdaytextfield.setVisible(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void returncar()//还车
	{
		try
		{
			rdid = rentreturnuseridtextfield.getText();
			ObservableList<rentinfo> selectedslots = FXCollections.observableArrayList();
			selectedslots = rentreturntableview.getSelectionModel().getSelectedItems();
			rentinfo slot = selectedslots.get(0);
			bkid = slot.getCarid();
			rdrank = rentreturnovertimetextfield.getText();
			oday = rentreturnoverdaytextfield.getText();
			int sel = rentreturnbrokencombobox.getSelectionModel().getSelectedIndex();
			int carid = Integer.parseInt(bkid);
			String brkn = sel == 0?"是":"否";
			SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
			Date nowdate = new Date();

			SQL = "SELECT RID FROM RENT WHERE UID = "+rdid+" AND CID = "+bkid+" AND ISRETURN = '否';";
			rs = Main.st.executeQuery(SQL);
			while(rs.next())
				cid = rs.getString(1);
			SQL = "INSERT INTO PROFIT VALUES ("+cid+","+oday+",0,'"+brkn+"','否');";
			System.out.println(SQL);
			Main.st.executeUpdate(SQL);
			if(sel==0)//汽车损坏，需报修
			{
				SQL = "UPDATE CAR\r\n" +
						"SET CSTATUS = '报修'\r\n" +
						"WHERE CID = "+carid;
				Main.st.executeUpdate(SQL);
				System.out.println(SQL);
			}
			SQL = "UPDATE CAR\r\n" +
					"SET CFREE = '是'\r\n" +
					"WHERE CID = "+carid;
			Main.st.executeUpdate(SQL);
			System.out.println(SQL);
			SQL = "UPDATE RENT \r\n" +
					"SET ISRETURN = '是',\r\n" +
					"RETURNTIME = '"+dateformatter.format(nowdate)+"'\r\n" +
					"WHERE UID = "+rdid+"\r\n" +
					"AND CID ="+bkid+" \r\n" +
					"AND ISRETURN = '否';";
			Main.st.executeUpdate(SQL);
			System.out.println(SQL);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("还车成功!请付款!");
			alert.showAndWait();
			queryrent();
		}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("还车失败!");
			alert.showAndWait();
			e.printStackTrace();
		}

	}

	public void queryrent()//动态查询用户租车记录
	{
		rentreturndata.clear();
		rdid = rentreturnuseridtextfield.getText().trim();
		if(rdid==null || rdid.isEmpty())
		{
			rentreturndata.clear();
			return;
		}
		else
		{
			SQL = "SELECT RENT.UID,RENT.CID,CAR.CNAME,RENT.RENTTIME\r\n" +
					"FROM  RENT,CAR\r\n" +
					"WHERE RENT.CID = CAR.CID \r\n" +
					"AND RENT.ISRETURN='否'\r\n" +
					"AND RENT.UID = '"+rdid+"'";
			try
			{
				rs = Main.st.executeQuery(SQL);
				while(rs.next())
				{
					rdid = rs.getString(1);
					bkid = rs.getString(2);
					bkname = rs.getString(3);
					stime = rs.getString(4);
					rentinfo newrent = new rentinfo(rdid,bkid,bkname,"",stime,"");
					rentreturndata.add(newrent);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}


	class rentreturnlistener<T> implements ChangeListener<T>
	{
		 @Override
		  public void changed(ObservableValue <? extends T> a, T old, T n)
		 {
			 queryrent();
		 }
	}


	public void finequery()
	{
		rdid = profituseridtextfield.getText().trim();
		if(rdid!=null && !rdid.isEmpty()) {rdid = "AND USER.UID ="+rdid;}
		else {rdid = "";}

		SQL = "SELECT RENT.UID, USER.UNAME, RENT.CID,\r\n" +
				"PROFIT.VTIME,USER.URANK,PROFIT.RENTDAY,\r\n" +
				"PROFIT.ISBREAK,CAR.CPRICE\r\n" +
				"FROM CAR,RENT,USER,PROFIT \r\n" +
				"WHERE RENT.UID = USER.UID AND\r\n" +
				"RENT.RID = PROFIT.RID AND \r\n" +
				"RENT.CID = CAR.CID AND \r\n"+
				"PROFIT.ISPAID = '否'"+rdid;
		try
		{
			rs = Main.st.executeQuery(SQL);
			profitdata.clear();
			allfine = 0;
			while(rs.next())
			{
				rdid = rs.getString(1);
				rdname = rs.getString(2);
				bkid = rs.getString(3);
				bkname = rs.getString(4);
				otime = rs.getString(5);
				oday = rs.getString(6);
				brk = rs.getString(7);
				fn = rs.getString(8);
				int price = Integer.parseInt(fn);
				price = price * Integer.parseInt(oday) + 300 * Integer.parseInt(bkname);
				if(brk.equals("是"))
				{
					price = price + 50000;
				}
				if(otime.equals("VIP"))
				{
					price = price * 8 / 10;
				}
				allfine = allfine + price;
				fn = price+"";
				profitinfo newprofit = new profitinfo(rdid,rdname,bkid,bkname,otime,oday,brk,fn);
				profitdata.add(newprofit);
			}
			profitfinetextfield.setText(allfine+"元");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void moneyquery()
	{
		SQL = "SELECT RENT.UID, USER.UNAME, RENT.CID,\r\n" +
				"PROFIT.VTIME,USER.URANK,PROFIT.RENTDAY,\r\n" +
				"PROFIT.ISBREAK,CAR.CPRICE\r\n" +
				"FROM CAR,RENT,USER,PROFIT \r\n" +
				"WHERE RENT.UID = USER.UID AND\r\n" +
				"RENT.RID = PROFIT.RID AND \r\n" +
				"RENT.CID = CAR.CID AND \r\n"+
				"PROFIT.ISPAID = '是'";
		try
		{
			rs = Main.st.executeQuery(SQL);
			moneydata.clear();
			allfine2 = 0;
			while(rs.next())
			{
				rdid = rs.getString(1);
				rdname = rs.getString(2);
				bkid = rs.getString(3);
				bkname = rs.getString(4);
				otime = rs.getString(5);
				oday = rs.getString(6);
				brk = rs.getString(7);
				fn = rs.getString(8);
				int price = Integer.parseInt(fn);
				price = price * Integer.parseInt(oday) + 300 * Integer.parseInt(bkname);
				if(brk.equals("是"))
				{
					price = price + 50000;
				}
				if(otime.equals("VIP"))
				{
					price = price * 8 / 10;
				}
				allfine2 = allfine2 + price;
				fn = price+"";
				moneyinfo newmoney = new moneyinfo(rdid,rdname,bkid,bkname,otime,oday,brk,fn);
				moneydata.add(newmoney);
			}
			moneyfinetextfield.setText(allfine2+"元");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	class profitlistener<T> implements ChangeListener<T>
	{
		@Override
		public void changed(ObservableValue <? extends T> a, T old, T n)
		{
			finequery();
		}
	}

	public void handlefine()
	{
		ObservableList<profitinfo> selectedslots = FXCollections.observableArrayList();
		selectedslots = profittableview.getSelectionModel().getSelectedItems();
		profitinfo slot;

		int i=0;
		int index;
		int handlenum=0;
		int size = selectedslots.size();
		for(i=0;i<size;i++)
		{
			slot = selectedslots.get(i);
			bkid = slot.getCarid();
			rdid = slot.getUserid();
			bkid = "AND RENT.CID = "+bkid;
			rdid = "AND RENT.UID =" + rdid;

			SQL = "UPDATE PROFIT\r\n" +
					"SET ISPAID = '是'\r\n" +
					"WHERE PROFIT.RID =\r\n" +
					"(\r\n" +
					"	SELECT TEMPRID\r\n" +
					"	FROM \r\n" +
					"   (\r\n" +
					"   SELECT PROFIT.RID AS TEMPRID\r\n" +
					"   FROM PROFIT,RENT\r\n" +
					"	WHERE PROFIT.RID = RENT.RID\r\n" +
					bkid+"\r\n"+rdid+") AS TEMP \r\n"+
					")";
			try
			{
				 handlenum += Main.st.executeUpdate(SQL);
				 System.out.println(SQL);
				 index = profitdata.indexOf(slot);
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("提示");
				 alert.setHeaderText(null);
				 alert.setContentText("付款成功!");
				 alert.showAndWait();
				 finequery();
				 moneyquery();
			}
			catch(Exception e)
			{
				finequery();
				moneyquery();
				e.printStackTrace();
			}
			
		}
	}
	
}
