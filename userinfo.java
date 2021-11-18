package application;

import javafx.beans.property.SimpleStringProperty;

public class userinfo {
	 private final SimpleStringProperty userid; 
	 private final SimpleStringProperty username; 
	 private final SimpleStringProperty sex;
	 private final SimpleStringProperty pwd;
	 private final SimpleStringProperty rank;

	 public userinfo(String rid, String rname, String s, String pswd, String urank)
	 {
		 userid = new SimpleStringProperty(rid);
		 username = new SimpleStringProperty(rname);
		 sex = new SimpleStringProperty(s);
		 pwd = new SimpleStringProperty(pswd);
		 rank = new SimpleStringProperty(urank);
	 }
	 public userinfo(String rid, String rname, String s, String urank)
	 {
		 userid = new SimpleStringProperty(rid);
		 username = new SimpleStringProperty(rname);
		 sex = new SimpleStringProperty(s);
		 pwd = new SimpleStringProperty("");
		 rank = new SimpleStringProperty(urank);
	 }
	 
	 public void setUserid(String rid) {userid.set(rid);}
	 public void setUsername(String rname) {username.set(rname);}
	 public void setSex(String s) {sex.set(s);}
	 public void setPwd(String pswd) {pwd.set(pswd);}
	 public void setRank(String urank) {pwd.set(urank);}
	 
	 public String getUserid() {return userid.get();}
	 public String getUsername() {return username.get();}
	 public String getSex() {return sex.get();}
	 public String getPwd() {return pwd.get();}
	 public String getRank() {return rank.get();}
}
