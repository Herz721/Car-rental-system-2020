package application;

import javafx.beans.property.SimpleStringProperty;

public class rentinfo
{
	private final SimpleStringProperty userid;
    private final SimpleStringProperty username; 
    private final SimpleStringProperty carid;
    private final SimpleStringProperty carname;
    private final SimpleStringProperty starttime;
    private final SimpleStringProperty endtime;
    private final SimpleStringProperty breturn;

    public rentinfo(String rid, String rname, String bid, String bname, String starttime, String endtime, String breturn)
    {
    	userid = new SimpleStringProperty(rid);
    	username = new SimpleStringProperty(rname);
    	carid = new SimpleStringProperty(bid);
    	carname = new SimpleStringProperty(bname);
    	this.starttime = new SimpleStringProperty(starttime);
    	this.endtime = new SimpleStringProperty(endtime);
    	this.breturn =new SimpleStringProperty(breturn);
    }
    public rentinfo(String bname, String starttime, String endtime, String breturn)
    {
    	userid = new SimpleStringProperty("");
    	username = new SimpleStringProperty("");
    	carid = new SimpleStringProperty("");
    	carname = new SimpleStringProperty(bname);
    	this.starttime = new SimpleStringProperty(starttime);
    	this.endtime = new SimpleStringProperty(endtime);
    	this.breturn =new SimpleStringProperty(breturn);
    }
    public rentinfo(String bid, String bname, String starttime, String endtime, String breturn)
    {
    	userid = new SimpleStringProperty("");
    	username = new SimpleStringProperty("");
    	carid = new SimpleStringProperty(bid);
    	carname = new SimpleStringProperty(bname);
    	this.starttime = new SimpleStringProperty(starttime);
    	this.endtime = new SimpleStringProperty(endtime);
    	this.breturn =new SimpleStringProperty(breturn);
    }
    public rentinfo(String rid, String bid, String bname, String endtime, String starttime, String breturn)
    {
    	userid = new SimpleStringProperty(rid);
    	username = new SimpleStringProperty("");
    	carid = new SimpleStringProperty(bid);
    	carname = new SimpleStringProperty(bname);
    	this.starttime = new SimpleStringProperty(starttime);
    	this.endtime = new SimpleStringProperty(endtime);
    	this.breturn =new SimpleStringProperty(breturn);
    }
    public String getUserid() {return userid.get();}
    public void setUserid(String rid) {userid.set(rid);}
    
    public String getUsername() {return username.get();}
    public void setUsername(String rname) {username.set(rname);}
    
    public String getCarid() {return carid.get();}
    public void setCarid(String bid) {carid.set(bid);}
    
    public String getCarname() {return carname.get();}
    public void setCarname(String bname) {carname.set(bname);}
    
    public String getStarttime() {return starttime.get();}
    public void setStartime(String stime) {starttime.set(stime);}
    
    public String getEndtime() {return endtime.get();}
    public void setEndtime(String etime) {endtime.set(etime);}
    
    public String getBreturn() {return breturn.get();}
    public void setBreturn(String brt) {breturn.set(brt);} 
    
    public String toString()
    {
    	return userid.get()+username.get()+carid.get()+carname.get()+starttime.get()+endtime.get()+breturn.get();
    }
}
