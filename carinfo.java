package application;

import javafx.beans.property.SimpleStringProperty;

public class carinfo
{
	private final SimpleStringProperty carid;
	private final SimpleStringProperty carname;
	private final SimpleStringProperty ttype;
	private final SimpleStringProperty press;
	private final SimpleStringProperty carclass;
	private final SimpleStringProperty location;
	private final SimpleStringProperty free;
	private final SimpleStringProperty money;
	
	public carinfo(String bid, String bname, String bttype, String bpress, String bclass, String blocation, String bfree,String bmoney)
	{
		carid = new SimpleStringProperty(bid);
		carname = new SimpleStringProperty(bname);
		ttype = new SimpleStringProperty(bttype);
		press = new SimpleStringProperty(bpress);
		carclass = new SimpleStringProperty(bclass);
		location = new SimpleStringProperty(blocation);
		free = new SimpleStringProperty(bfree);
		money = new SimpleStringProperty(bmoney);
	}
	public carinfo(String bid, String bname, String bttype, String bpress, String bclass, String blocation, String bfree)
	{
		carid = new SimpleStringProperty(bid);
		carname = new SimpleStringProperty(bname);
		ttype = new SimpleStringProperty(bttype);
		press = new SimpleStringProperty(bpress);
		carclass = new SimpleStringProperty(bclass);
		location = new SimpleStringProperty(blocation);
		free = new SimpleStringProperty(bfree);
		money = new SimpleStringProperty("");
	}
	public carinfo(String bid, String bname, String bttype, String bpress, String bclass, String blocation)
	{
		carid = new SimpleStringProperty(bid);
		carname = new SimpleStringProperty(bname);
		ttype = new SimpleStringProperty(bttype);
		press = new SimpleStringProperty(bpress);
		carclass = new SimpleStringProperty(bclass);
		location = new SimpleStringProperty(blocation);
		free = new SimpleStringProperty("");
		money = new SimpleStringProperty("");
	}
	//注意这里一定要 setcarid这样子写，，不能都写成小写，，不然会出现，表格看不到文字的情况
	public void setCarid(String bname)
	{
		carid.set(bname);
	}
	public String getCarid()
	{
		return carid.get();
	}
	
	public void setCarname(String bname)
	{
		carname.set(bname);
	}
	public String getCarname()
	{
		return carname.get();
	}
	
	public void setTtype(String bttype)
	{
		ttype.set(bttype);
	}
	public String getTtype()
	{
		return ttype.get();
	}
	
	public void setPress(String bpress)
	{
		press.set(bpress);
	}
	public String getPress()
	{
		return press.get();
	}
	
	public void setCarclass(String bclass)
	{
		carclass.set(bclass);
	}
	public String getCarclass()
	{
		return carclass.get();
	}
	
	public void setLocation(String blocation)
	{
		location.set(blocation);
	}
	public String getLocation()
	{
		return location.get();
	}
	
	public void setFree(String bfree)
	{
		free.set(bfree);
	}
	public String getFree()
	{
		return free.get();
	}
	public void setMoney(String bmoney)
	{
		money.set(bmoney);
	}
	public String getMoney()
	{
		return money.get();
	}
	  public String toString()
	  {
		  return carid.get()+carname.get();
	  }
}
