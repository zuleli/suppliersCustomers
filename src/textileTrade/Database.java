package textileTrade;

/* Author: Zule Li
 * Email:zule.li@hotmail.com
 * Last Modified Date:Mar.7,2015
 * */

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Database extends Object {

	private static String source = "jdbc:odbc:Textrade";
	private static Connection con;

	/**
	 * Constructor
	 */
	public Database() {

	}

	public static boolean removeSetting(String value, String resid) {

		String str = "";

		str = "delete from Catagory where (restaurantid=? and catagory=?)";

		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			PreparedStatement pst = con.prepareStatement(str);
			pst.setString(1, resid);
			pst.setString(2, value);
			int index = pst.executeUpdate();
			if (index > 0)
				ok = true;

			pst.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static boolean addSupplier(String[] basic, int status) {

		
		String str = "";
		if (status == 0)
			str = "insert into Companies  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if (status == 1)
			str = "update Companies set CompanyName=?,Street=?,Unit=?,City=?,State=?,Zip=?,Country=?,Phone=?,Fax=?"
					+ ",Email=?,Type=?,Contact=?,Website=?,Description=?,SPNote=?,ModifyDate=? where SupplierID=? ";

	
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(str);
			pst.setString(1, basic[1]);
			pst.setString(2, basic[2]);
			pst.setString(3, basic[3]);
			pst.setString(4, basic[4]);
			pst.setString(5, basic[5]);
			pst.setString(6, basic[6]);
			pst.setString(7, basic[7]);
			pst.setString(8, basic[8]);
			pst.setString(9, basic[9]);
			pst.setString(10, basic[10]);
			pst.setString(11, basic[11]);
			pst.setString(12, basic[12]);
			pst.setString(13, basic[13]);
			pst.setString(14, basic[14]);
			pst.setString(15, basic[15]);
			pst.setDate(16, new java.sql.Date(System.currentTimeMillis()));

			if (status == 0) {

				pst.setDate(17, new java.sql.Date(System.currentTimeMillis()));
				pst.setInt(18, 0);
				pst.setInt(19, Integer.parseInt(basic[0]));
			} else if (status == 1) {

				pst.setInt(17, Integer.parseInt(basic[0]));
			}

			int index = pst.executeUpdate();
			if (index < 0) {

				con.rollback();
				pst.close();
				con.setAutoCommit(true);
				con.close();
				
				return ok;
			}

			con.commit();
			con.setAutoCommit(true);
			pst.close();
			con.close();
			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}

		return ok;
	}

	public static boolean addTechData(Vector data, int id) {

		String str = "delete from TechData where id=?";
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(str);
			pst.setInt(1, id);
			pst.executeUpdate();

			str = "insert into TechData  values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst.close();

			pst = con.prepareStatement(str);
			String[] basic = null;
			for (int i = 0; i < data.size(); i++) {
				basic = (String[]) (data.get(i));
				// p.p(""+basic.length);
				pst.setInt(1, id);
				pst.setString(2, basic[0]);
				pst.setString(3, basic[1]);
				pst.setString(4, basic[2]);
				pst.setString(5, basic[3]);
				pst.setString(6, basic[4]);
				pst.setString(7, basic[5]);
				pst.setString(8, basic[6]);
				pst.setString(9, basic[7]);
				pst.setString(10, basic[8]);
				pst.setString(11, basic[9]);
				pst.setString(12, basic[10]);
				pst.setString(13, basic[11]);

				pst.executeUpdate();
			}

			con.commit();
			con.setAutoCommit(true);
			pst.close();
			con.close();
			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static boolean updateCustomer(String[] basic) {

	
		String str = "update Customers  set firstName=?,LastName=?,Street=?,Apartment=?,city=?,state=?"
				+ ",zip=?,phone=? where (restaurantid=? and customerid=?)";
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(str);

			pst.setString(1, basic[2]);
			pst.setString(2, basic[3]);
			pst.setString(3, basic[4]);
			pst.setString(4, basic[5]);
			pst.setString(5, basic[6]);
			pst.setString(6, basic[7]);
			pst.setString(7, basic[8]);
			pst.setString(8, basic[9]);
			pst.setString(9, basic[0]);
			pst.setString(10, basic[1]);

			int index = pst.executeUpdate();
			if (index <= 0) {
				pst.close();
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return ok;
			}

			con.commit();
			con.setAutoCommit(true);
			pst.close();
			con.close();
			return true;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static Vector getMenu()// 1=working,0=close,2=startup,3=open,4=all
	{
		Vector data = new Vector();
		String[] tem = new String[] { "aaa", "bbb", "ccc", "ddd", "eee" };
		data.add(tem);
	
		return data;
	}

	public static boolean orderStatusChange(String orderno) {
		boolean status = false;
		String str = "UPDATE planning SET status=1 WHERE (order='" + orderno
				+ "' AND status=2)";
		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			int in = ste.executeUpdate(str);
			ste.close();
			con.close();
			if (in >= 1)
				status = true;
			return status;
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return false;
	}

	public static Vector getMeasureData() {
		String str = "select * from measurement where status=1";
		String[] ss = null;
		Vector v = new Vector();

		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			str = "select mc,position,stock,end,beamsize,measurement,"
					+ "((select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"
					+ "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000/"
					+ "((select (speed*efficiency/100) from MCS where MCS.MC=measurement.mc)/"
					+ "(SELECT pick from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))/36*0.9199*60)),"
					+

					"(select sum([status])from beams where(status=1 and beams.stock=measurement.stock and beams.end=measurement.end)),"
					+

					"(select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"
					+ "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000*0.9199*"
					+ "(SELECT (pick/Fpick) from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc)),"
					+

					"hot,orderno from measurement where status=1";

			ResultSet rs = ste.executeQuery(str);
			long lon = 0;
			while (rs.next()) {
				ss = new String[12];
			
				ss[0] = rs.getString("MC");
				ss[1] = "" + rs.getByte("Position");
				ss[2] = rs.getString("Stock");
				ss[3] = "" + rs.getInt("End");
				ss[4] = "" + rs.getByte("BeamSize");
				ss[5] = "" + rs.getDouble("Measurement");
				lon = (long) (rs.getDouble(7));
				ss[6] = ""
						+ (new java.sql.Date(System.currentTimeMillis() + lon
								* 60 * 60 * 1000)).toString();// dateOUt
				ss[7] = "" + rs.getInt(8);// Invertory
				ss[8] = "" + (int) (rs.getDouble(9)); 
				ss[10] = rs.getString("hot");
				ss[11] = rs.getString("Orderno");
				v.add(ss);
			}
			rs.close();
			ste.close();
			con.close();
		
			return v;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;

	}

	public static boolean updateItem(String[] ss) {
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			String str = "update menu set name=?,price=?"
					+ ",hot=?,catagory=?,status=?,description=? where (restaurantID=? and itemid=?)";
			System.out.println(str);
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, ss[2]);
			ste.setDouble(2, Double.parseDouble(ss[3]));
			ste.setString(3, ss[4]);
			ste.setString(4, ss[5]);
			ste.setString(5, ss[6]);
			ste.setString(6, ss[7]);
			ste.setString(7, ss[0]);
			ste.setString(8, ss[1]);
			int ind = ste.executeUpdate();
			if (ind > 0) {
				ok = true;
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;

	}

	public static boolean updateSUPPLIER(String[] basic) {

	
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			String str = "update suppliers set CompanyName=?"
					+ ",Street=?,Unit=?,City=?,State=?,Zip=?,Country=?,Phone=?,Fax=?,Email=?,Type=?,Contact=?,Website=?,SPNote=?,ModifyDate=? where SupplierID=? ";// ,Note=?
			PreparedStatement pst = con.prepareStatement(str);

			pst.setString(1, basic[1]);
			pst.setString(2, basic[2]);
			pst.setString(3, basic[3]);
			pst.setString(4, basic[4]);
			pst.setString(5, basic[5]);
			pst.setString(6, basic[6]);
			pst.setString(7, basic[7]);
			pst.setString(8, basic[8]);
			pst.setString(9, basic[9]);
			pst.setString(10, basic[10]);
			pst.setString(11, basic[11]);
			pst.setString(12, basic[12]);
			pst.setString(13, basic[13]);
			// pst.setString(14,basic[14]);
			pst.setString(14, basic[15]);
			pst.setDate(15, new java.sql.Date(System.currentTimeMillis()));// */
			pst.setInt(16, Integer.parseInt(basic[0]));

			int ind = pst.executeUpdate();

			if (ind > 0) {
				ok = true;
			}
			pst.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;

	}

	public static String deleteItem(String[] itid, String[] resid) {
		String ok = null;
		try {
			con = DriverManager.getConnection(source);
			// 0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay
			String str = "delete from menu  where (restaurantid=? and itemid=?)";
			PreparedStatement ste = con.prepareStatement(str);
			for (int i = 0; i < itid.length; i++) {
				ste.setString(1, resid[i]);
				ste.setString(2, itid[i]);
				int ind = ste.executeUpdate();
				if (ind <= 0) {
					if (ok == null)
						ok = "The Following item failed to delete from database:\nRestaurant ID:"
								+ resid[i] + ", ItemID:" + itid[i];
					else
						ok = ok + "\nRestaurant ID:" + resid[i] + ", ItemID:"
								+ itid[i];
				}
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static String deleteRestaurant(String[] itid) {
		String ok = null;
		try {
			con = DriverManager.getConnection(source);
			// 0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay
			String str = "delete from Restaurants  where restaurantid=?";
			System.out.println(str);
			PreparedStatement ste = con.prepareStatement(str);
			for (int i = 0; i < itid.length; i++) {
				ste.setString(1, itid[i]);
				int ind = ste.executeUpdate();
				if (ind < 0) {
					if (ok == null)
						ok = "The Following item failed to delete from database:\nRestaurant ID:"
								+ itid[i];
					else
						ok = ok + "\nRestaurant ID:" + itid[i];
				}
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static boolean updateAccount(String[] ss) {
		// 0=accountNO,1-first,2=last,3=street,4=apt,5=city,6=state,7=zip,8=phone,9=createDate,10=EndDate,11=status
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			String str = "update customers set firstName=?,lastName=?,Street=?"
					+ ",apartment=?,city=?,State=?,zip=?,phone=? where accountNo=?";
			System.out.println(str);
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, ss[1]);
			ste.setString(2, ss[2]);
			ste.setString(3, ss[3]);
			ste.setString(4, ss[4]);
			ste.setString(5, ss[5]);
			ste.setString(6, ss[6]);
			ste.setString(7, ss[7]);
			ste.setString(8, ss[8]);
			ste.setString(9, ss[0]);
			int ind = ste.executeUpdate();
			if (ind > 0) {
				ok = true;
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;

	}

	public static String[] getMeasueUpdate(String[] ss) {
		String[] out = new String[3];
		try {
			con = DriverManager.getConnection(source);
			String str = "select((select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"
					+ "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000/"
					+ "((select (speed*efficiency/100) from MCS where MCS.MC=measurement.mc)/"
					+ "(SELECT pick from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))/36*0.9199*60)),"
					+

					"(select sum([status])from beams where(status=1 and beams.stock=measurement.stock and beams.end=measurement.end)),"
					+

					"(select capacity/(RO*RO-RI*RI)*((RO-measurement)*(RO-measurement)-RI*RI) from emptybeam where size=beamsize)/end*453.6/"
					+ "(select Rawm.size*Rawm.modify from Rawm where Rawm.stock=Measurement.stock)*9000*0.9199*"
					+ "(SELECT (pick/Fpick) from styles where styles.styleno=(select styleno from mcs where MCS.MC=measurement.mc))"
					+

					" from measurement where (mc='"
					+ ss[0]
					+ "' and position="
					+ ss[1] + ")";
			Statement ste = con.createStatement();
			ResultSet rs = ste.executeQuery(str);
			if (rs.next()) {

				long lon = (long) (rs.getDouble(1));
				out[0] = ""
						+ (new java.sql.Date(System.currentTimeMillis() + lon
								* 60 * 60 * 1000)).toString();// dateOUt
				out[1] = "" + rs.getInt(2);
				out[2] = "" + (int) (rs.getDouble(3));
			}
			ste.close();
			con.close();
			return out;
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;

	}

	public static String setInActive(String[] ss) {
		String ok = null;
		try {
			con = DriverManager.getConnection(source);
			String str = "update customers set status='InActive' where accountno=?";
			PreparedStatement ste = con.prepareStatement(str);
			for (int i = 0; i < ss.length; i++) {
				ste.setString(1, ss[i]);
				int ind = ste.executeUpdate();
				if (ind < 0) {
					if (ok == null)
						ok = "The Following item failed to set InActive from database:\nAccount#:";
					else
						ok = ok + "\nAccount#:" + ss[i];
				}
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static boolean setLocalPort(String s) {
		boolean result = false;
		try {
			con = DriverManager.getConnection(source);

			String str = "update locals set localPort=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, s);
			int ind = ste.executeUpdate();
			if (ind > 0) {
				result = true;
			}
			ste.close();
			con.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return result;
	}

	
	public static int getStatus(String id) {

		String s = "";

		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "select * from Companies where SupplierID=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, id);
			rs = ste.executeQuery();
			if (rs.next()) {

				rs.close();
				ste.close();
				con.close();

				return 1;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return 0;
	}

	public static int getMaxID() {
		if (true)
			return -1;

		try {
			con = DriverManager.getConnection(source);

			String str = "select Max(supplierID) from Companies";

			Statement ste = con.createStatement();
			ResultSet rs = ste.executeQuery(str);
			if (rs.next()) {
				int result = rs.getInt(1);
				rs.close();
				ste.close();
				con.close();

				return result;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return 0;
	}

	public static Vector getCustomerIDs() {

		Vector data = new Vector();
		try {
			con = DriverManager.getConnection(source);

			String str = "select customerID from Customers";

			Statement ste = con.createStatement();
			ResultSet rs = ste.executeQuery(str);
			while (rs.next()) {
				data.add("" + rs.getInt("customerID"));

			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;
	}

	public static Vector getSupplierIDs() {

		
		Vector data = new Vector();
		if (true)
			return data;

		try {
			con = DriverManager.getConnection(source);

			String str = "select supplierID from Companies order by supplierID";

			Statement ste = con.createStatement();
			ResultSet rs = ste.executeQuery(str);
			while (rs.next()) {
				data.add("" + rs.getInt("SupplierID"));

			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;
	}

	public static long getNextValue(String id, String resid) {

		long s = 0;

		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "select * from NextValue where restaurantid=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, resid);

			rs = ste.executeQuery();
			if (rs.next()) {

				s = (long) (rs.getDouble(id));
				rs.close();
				ste.close();
				con.close();
				
				return s;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return s;
	}

	public static boolean checkForItemID(String itemid, String resid,
			String type) {
		boolean result = false;
		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "";
			if (type.equalsIgnoreCase("AccountNO"))
				str = "select * from customers where (restaurantid=? and customerID=?)";
			if (type.equalsIgnoreCase("ItemID"))
				str = "select * from menu where (restaurantid=? and itemID=?)";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, resid);
			ste.setString(2, itemid);
			rs = ste.executeQuery();

			if (rs.next()) {
				result = true;

			}
			rs.close();
			ste.close();
			con.close();
			return result;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"unknown,database connection problem");

		}
		return true;
	}

	public static boolean checkForValid(String id, String type) {
		boolean result = false;
		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "";
			if (type.equalsIgnoreCase("ItemID"))
				str = "select * from menu where itemid=?";
			if (type.equalsIgnoreCase("RestaurantID"))
				str = "select * from Restaurants where Restaurantid=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, id);
			rs = ste.executeQuery();

			if (rs.next()) {
				result = true;

			}
			rs.close();
			ste.close();
			con.close();
			return result;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, type
					+ " unknown,database connection problem");

		}
		return true;
	}

	public static String[] getItem(String itemid, String resid) {
		String[] ss = new String[7];
		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "select * from menu where (restaurantid=? and itemid=?)";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, resid);
			ste.setString(2, itemid);

			rs = ste.executeQuery();
			// 0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay,8=status,9=account
			if (rs.next()) {

				ss[0] = (rs.getString("ItemID")).trim();
				ss[1] = (rs.getString("Name")).trim();
				ss[2] = "" + rs.getDouble("Price");
				ss[3] = (rs.getString("Hot")).trim();
				ss[4] = (rs.getString("Catagory")).trim();
				ss[5] = (rs.getString("Status")).trim();
				ss[6] = (rs.getString("Description")).trim();
				rs.close();
				ste.close();
				con.close();
				return ss;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ss;

	}

	public static void addErrorMessage(String s) {

	}

	public static void toHistory(Vector returns) {
		String[] basic = new String[8];
		String str = "insert into History values(?,?,?,?,?,?)";

		try {
			con = DriverManager.getConnection(source);
			PreparedStatement pst = con.prepareStatement(str);
			for (int i = 0; i < returns.size(); i++) {
				basic = (String[]) (returns.get(i));
				pst.setString(1, basic[0]);
				pst.setString(2, basic[5]);
				pst.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				pst.setString(4, basic[2]);
				pst.setString(5, basic[7]);
				pst.setString(6, basic[6]);

				int index = pst.executeUpdate();
				System.out.println("tohistory= " + basic[5] + "  index="
						+ index);

			}
			pst.close();
			con.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
	}

	public static String getPath(String type) {
		// photopath,webphotopath
		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "select * from paths";
			Statement ste = con.createStatement();
			rs = ste.executeQuery(str);
			if (rs.next()) {
				str = rs.getString(type);
				rs.close();
				ste.close();
				con.close();
				return str;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;
	}

	public static boolean setGreetingMessage(String message) {
		boolean ok = false;
		try {
			con = DriverManager.getConnection(source);
			String str = "update NextValue set greeting=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, message);
			int ind = ste.executeUpdate();
			if (ind > 0) {
				ok = true;
			}
			ste.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ok;
	}

	public static Vector getUsers() {

		return null;
	}

	public static int getStep(String user, char[] psw) {

		return 0;
	}

	public static Vector getCountry() {

		Vector data = new Vector();

		if (true)
			return data;

		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			String str = "select * from Country";
			ResultSet rs = ste.executeQuery(str);
			while (rs.next()) {
				data.add(rs.getString("Name"));
			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

	public static Vector getType() {

		Vector data = new Vector();

		if (true)
			return data;

		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			String str = "select * from Types";
			ResultSet rs = ste.executeQuery(str);
			while (rs.next()) {
				data.add(rs.getString("Name"));
			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

	public static Vector getState() {

		Vector data = new Vector();
		if (true)
			return data;

		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			String str = "select * from State";
			ResultSet rs = ste.executeQuery(str);
			while (rs.next()) {
				data.add(rs.getString("Name"));
			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

	public static Vector getTableData(String id) {
		
		Vector data = new Vector();
		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			String str = "";

			str = "select * from TechData where id=?";
			ResultSet rs = null;
			PreparedStatement ste = con.prepareStatement(str);
			ste.setInt(1, Integer.parseInt(id));

			rs = ste.executeQuery();
			// 0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
			while (rs.next()) {

				ss = new String[12];
				ss[0] = (rs.getString("F1")).trim();
				ss[1] = (rs.getString("F2")).trim();
				ss[2] = (rs.getString("F3")).trim();
				ss[3] = (rs.getString("F4")).trim();
				ss[4] = (rs.getString("F5")).trim();
				ss[5] = (rs.getString("F6")).trim();
				ss[6] = (rs.getString("F7")).trim();
				ss[7] = (rs.getString("F8")).trim();
				ss[8] = (rs.getString("F9")).trim();
				ss[9] = (rs.getString("F10")).trim();
				ss[10] = (rs.getString("F11")).trim();
				ss[11] = (rs.getString("F12")).trim();

				data.add(ss);

			}
			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

	public static String getItemStatus(String id) {
		String s = "";
		try {
			con = DriverManager.getConnection(source);

			ResultSet rs = null;
			String str = "select * from Items where itemid=?";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, id);
			rs = ste.executeQuery();

			rs = ste.executeQuery(str);
			// 0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
			if (rs.next()) {

				s = (rs.getString("Status")).trim();
				rs.close();
				ste.close();
				con.close();
				return s;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return s;
	}

	public static String[] getRestaurants(String id, String status) {

		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			String str = "select * from Restaurants where RestaurantID=? ";
			PreparedStatement ste = con.prepareStatement(str);
			ste.setString(1, id);
			ResultSet rs = ste.executeQuery();
			if (rs.next()) {
				if (status.equalsIgnoreCase("Detail"))
					ss = new String[14];
				else if (status.equalsIgnoreCase("Summary"))
					ss = new String[9];
				else if (status.equalsIgnoreCase("Browse"))
					ss = new String[13];
				ss[0] = (rs.getString("restaurantID")).trim();
				ss[1] = (rs.getString("Businessname")).trim();
				ss[2] = (rs.getString("City")).trim();
				ss[3] = (rs.getString("State")).trim();
				ss[4] = rs.getString("Zip").toString();
				ss[5] = (rs.getString("Phone")).trim();
				ss[6] = (rs.getString("ABName")).trim();
				ss[7] = (rs.getString("FirstName")).trim();
				ss[8] = (rs.getString("LastName")).trim();
				if (status.equalsIgnoreCase("Browse")) {
					ss[9] = (rs.getString("Street")).trim();
					ss[10] = (rs.getString("unit")).trim();
					ss[11] = (rs.getString("CellPhone")).trim();
					ss[12] = (rs.getString("Phone3")).trim();
				}

			}

			rs.close();
			ste.close();
			con.close();
			return ss;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return ss;
	}

	public static String[] getSupplier(String status) {
		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			ResultSet rs = null;
			String str = null;

			str = "select * from Companies where supplierID=" + status;

			rs = ste.executeQuery(str);
			// 0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay,8=status,9=account
			while (rs.next()) {
				ss = new String[17];
				ss[0] = "" + rs.getInt("supplierID");
				ss[1] = rs.getString("companyName");
				ss[2] = rs.getString("Street");
				ss[3] = rs.getString("Unit");
				ss[4] = rs.getString("City");
				ss[5] = rs.getString("State");
				ss[6] = rs.getString("Zip");
				ss[7] = rs.getString("Country");
				ss[8] = rs.getString("Phone");
				ss[9] = rs.getString("fax");
				ss[10] = rs.getString("Email");
				ss[11] = rs.getString("Type");
				ss[12] = rs.getString("Contact");

				ss[13] = rs.getString("Website");
				ss[14] = rs.getString("Description");
				ss[15] = rs.getString("SPNote");
				ss[16] = "" + rs.getByte("Decided");

			}

			rs.close();
			ste.close();
			con.close();
			return ss;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;
	}

	public static Vector getCompany() {
		
		Vector data = new Vector();
		if (true)
			return data;
		
		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			ResultSet rs = null;
			String str = null;

			str = "select * from Companies order by supplierID";// sort by
																// supplierID";

			rs = ste.executeQuery(str);
			// 0-id,1=title,2=version,3=location,4=catagory,5-publisher,6=summary,7=createDay,8=status,9=account
			while (rs.next()) {
				ss = new String[7];
				ss[0] = "" + rs.getInt("supplierID");
				ss[1] = rs.getString("companyName");
				ss[2] = rs.getString("City");
				ss[3] = rs.getString("State");
				ss[4] = rs.getString("Country");
				ss[5] = rs.getString("Website");
				ss[6] = rs.getString("Type");
				data.add(ss);
			}

			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return null;
	}

	public static Vector getMenu(String resID, String catagory) {
		Vector data = new Vector();
		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			String str = null;
			if (catagory == null || catagory.equalsIgnoreCase("ALL"))
				str = "select * from menu where restaurantID=?";
			else
				str = "select * from menu where (restaurantID=? and catagory=?)";
			PreparedStatement ste = con.prepareStatement(str);

			ResultSet rs = null;
			ste.setString(1, resID);
			if (catagory != null && !catagory.equalsIgnoreCase("ALL"))
				ste.setString(2, catagory);
			rs = ste.executeQuery();
			// 0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
			while (rs.next()) {
				ss = new String[6];
				ss[0] = (rs.getString("ItemID")).trim();
				ss[1] = (rs.getString("Name")).trim();
				ss[2] = "" + rs.getDouble("Price");
				ss[3] = (rs.getString("Hot")).trim();
				ss[4] = rs.getString("Catagory").toString();
				ss[5] = (rs.getString("Status")).trim();
				data.add(ss);
			}

			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

	public static Vector search(String status, String type) {
		Vector data = new Vector();
		String[] ss = null;
		try {
			con = DriverManager.getConnection(source);
			Statement ste = con.createStatement();
			ResultSet rs = null;
			String str = null;
			if (type.equalsIgnoreCase("Account")) {
				str = "select * from History where accountno='" + status + "'";
				ss = new String[4];
			} else if (type.equalsIgnoreCase("ItemID")) {
				str = "select History.accountno,customers.firstname,customers.lastname,history.dateout,history.datein from History,customers where ((history.itemID='"
						+ status
						+ "') and (history.accountno=customers.accountno))";
				;
				ss = new String[5];

			}
			rs = ste.executeQuery(str);
			// 0-first,1=last,2=street,3=apt,4=city,5=state,6=zip,7=phone
			while (rs.next()) {
				if (type.equalsIgnoreCase("Account")) {
					ss = new String[4];
					ss[0] = (rs.getString(1)).trim();
					
					ss[2] = (rs.getDate(2)).toString();
					ss[3] = (rs.getDate(3)).toString();
				} else if (type.equalsIgnoreCase("ItemID")) {
					ss = new String[5];
					ss[0] = (rs.getString(1)).trim();
					ss[1] = (rs.getString(2)).trim();
					ss[2] = (rs.getString(3)).trim();
					ss[3] = (rs.getDate(4)).toString();
					ss[4] = (rs.getDate(5)).toString();
					
				}

				data.add(ss);

			}

			rs.close();
			ste.close();
			con.close();
			return data;

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}
		return data;
	}

}
