package application;

import javafx.beans.property.SimpleStringProperty;

public class profitinfo
{
	  private final SimpleStringProperty userid; 
	  private final SimpleStringProperty username; 
	  private final SimpleStringProperty carid;
	  private final SimpleStringProperty carname;
	  private final SimpleStringProperty overtime;
	  private final SimpleStringProperty overday;
	  private final SimpleStringProperty broken;
	  private final SimpleStringProperty fine;
	  
	  public profitinfo(String rid, String rname, String bid, String bname, String otime, String oday, String brk, String fn)
	  {
		  userid = new SimpleStringProperty(rid);
		  username = new SimpleStringProperty(rname);
		  carid = new SimpleStringProperty(bid);
		  carname = new SimpleStringProperty(bname);
		  overtime = new SimpleStringProperty(otime);
		  overday =new SimpleStringProperty(oday);
		  broken = new SimpleStringProperty(brk);
		  fine = new SimpleStringProperty(fn);
	  }
	  
	  public profitinfo(String bid, String bname, String otime, String oday, String brk, int fn)
	  {
		  userid = new SimpleStringProperty("");
		  username = new SimpleStringProperty("");
		  carid = new SimpleStringProperty(bid);
		  carname = new SimpleStringProperty(bname);
		  overtime = new SimpleStringProperty(otime);
		  overday =new SimpleStringProperty(oday);
		  broken = new SimpleStringProperty(brk);
		  fine = new SimpleStringProperty(fn+"");
	  }
	  
	  public void setUserid(String rid) {userid.set(rid);}
	  public String getUserid() {return userid.get();}
	  
	  public void setUsername(String rname) {username.set(rname);}
	  public String getUsername() {return username.get();}
	  
	  public void setCarid(String bid) {carid.set(bid);}
	  public String getCarid() {return carid.get();}
	  
	  public void setCarname(String bname) {carname.set(bname);}
	  public String getCarname() {return carname.get();}
	  
	  public void setOvertime(String otime) {overtime.set(otime);}
	  public String getOvertime() {return overtime.get();}
	  
	  public void setOverday(String oday) {overday.set(oday);}
	  public String getOverday() {return overday.get();}
	  
	  public void setBroken(String brk) {broken.set(brk);}
	  public String getBroken() {return broken.get();}
	  
	  public void setFine(String fn) {fine.set(fn);}
	  public String getFine() {return fine.get();}
	  
	  public String toString()
	  {
		  return username.get()+carname.get();
	  }

}
