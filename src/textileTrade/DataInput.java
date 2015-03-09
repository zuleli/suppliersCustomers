package textileTrade;

/* Author: Zule Li
 * Email:zule.li@hotmail.com
 * Last Modified Date:Mar.7,2015
 * */

import java.io.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DataInput extends JFrame implements ActionListener {
	private JPanel Main = new JPanel();
	private JLabel cnameM = new JLabel();
	private JLabel streetM = new JLabel();
	private JLabel UnitM = new JLabel();
	private JLabel CityM = new JLabel();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JLabel CountryM = new JLabel();
	private JLabel PhoneM = new JLabel();
	private JLabel FaxM = new JLabel();
	private JLabel EmailM = new JLabel();
	private JLabel MobileM = new JLabel();
	private JLabel cpersonM = new JLabel();
	private JLabel cphoneM = new JLabel();
	private JLabel cmobileM = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JRadioButton sameasabove = new JRadioButton();
	private JLabel jLabel5 = new JLabel();
	private JTextField csName = new JTextField();
	private JTextField jTextField1 = new JTextField();
	private JTextField csUnit = new JTextField();
	private JTextField csStreet = new JTextField();
	private JTextField csStates = new JTextField();
	private JComboBox csCountry;
	private JTextField csPhone = new JTextField();
	private JTextField csFax = new JTextField();
	private JTextField csEmail = new JTextField();
	private JTextField csMobile = new JTextField();
	private JTextField cName = new JTextField();
	private JTextField cPhone = new JTextField();
	private JTextField cMobile = new JTextField();
	private JTextField cEmail = new JTextField();
	private JTextArea csComment = new JTextArea();
	private JComboBox csState;
	private JLabel noteM = new JLabel();
	private JLabel cStreetM = new JLabel();
	private JLabel cUnitM = new JLabel();
	private JLabel cCityM = new JLabel();
	private JLabel cStateM = new JLabel();
	private JLabel cZipM = new JLabel();
	private JLabel cCountryM = new JLabel();
	private JLabel cFaxM = new JLabel();
	private JTextField cStreet = new JTextField();
	private JTextField cUnit = new JTextField();
	private JTextField cCity = new JTextField();
	private JTextField cZip = new JTextField();
	private JComboBox cCountry;
	private JComboBox cState;
	private JTextField cFax = new JTextField();
	private JButton csUpdate = new JButton();
	private JButton csReset = new JButton();
	private JLabel IDM = new JLabel();
	private JTextField csID = new JTextField();
	private JTextField csWebsite = new JTextField();
	private JLabel websiteM = new JLabel();
	private JTextArea csNote = new JTextArea();
	private GridBagLayout gridBagLayout1 = new GridBagLayout();
	private JTabbedPane tab = new JTabbedPane();
	private Vector supplierIDs, customerIDs;
	private int customerIndex, supplierIndex;

	// ****************

	private JSplitPane SupplierPane;
	private JLabel spnameSP = new JLabel();
	private JLabel streetSP = new JLabel();
	private JLabel UnitSP = new JLabel();
	private JLabel CitySP = new JLabel();
	private JLabel jLabel1SP = new JLabel();
	private JLabel jLabel2SP = new JLabel();
	private JLabel CountrySP = new JLabel();
	private JLabel PhoneSP = new JLabel();
	private JLabel FaxSP = new JLabel();
	private JLabel EmailSP = new JLabel();
	private JLabel MobileSP = new JLabel();
	private JLabel cpersonSP = new JLabel();
	private JLabel cphoneSP = new JLabel();
	private JLabel cmobileSP = new JLabel();
	private JLabel jLabel4SP = new JLabel();
	private JRadioButton sameasaboveSP = new JRadioButton();
	private JLabel jLabel5SP = new JLabel();
	private JTextField spName = new JTextField();
	private JTextField spStreet = new JTextField();
	private JTextField spUnit = new JTextField();
	private JTextField spCity = new JTextField();
	private JTextField spZip = new JTextField();
	private JTextField spPhone = new JTextField();
	private JTextField spFax = new JTextField();
	private JTextField spEmail = new JTextField();
	private JComboBox spType;
	private JTextField cNamesp = new JTextField();
	private JTextField cPhonesp = new JTextField();
	private JTextField cMobilesp = new JTextField();
	private JTextField cEmailsp = new JTextField();
	private JTextArea spComment = new JTextArea();
	private JComboBox spState;
	private JComboBox spCountry;
	private JLabel noteSP = new JLabel();
	private JLabel cStreetSP = new JLabel();
	private JLabel cUnitSP = new JLabel();
	private JLabel cCitySP = new JLabel();
	private JLabel cStateSP = new JLabel();
	private JLabel cZipSP = new JLabel();
	private JLabel cCountrySP = new JLabel();
	private JLabel cFaxSP = new JLabel();
	private JTextField cStreetsp = new JTextField();
	private JTextField cUnitsp = new JTextField();
	private JTextField cCitysp = new JTextField();
	private JTextField cZipsp = new JTextField();
	private JComboBox cCountrysp;
	private JComboBox cStatesp;
	private JTextField cFaxsp = new JTextField();
	private JButton spUpdate = new JButton();
	private JButton spReset = new JButton();
	private JLabel spIDSP = new JLabel();
	private JTextField spID = new JTextField();
	private JTextField spWebsite = new JTextField();
	private JLabel websiteSP = new JLabel();
	private JTextArea spNote = new JTextArea();
	private GridBagLayout gridBagLayout2 = new GridBagLayout();

	private JButton spPrevious = new JButton();
	private JButton spNext = new JButton();
	private JButton spGoto = new JButton(" Goto ");
	private JButton rowAdd = new JButton("Add");
	private JButton rowDelete = new JButton("Delete");
	private JTextField gotoID = new JTextField(3);
	private JComboBox spSelectChoice;
	private JRadioButton sc = new JRadioButton();
	private JPanel spPane1 = new JPanel();
	private JPanel spPane2 = new JPanel();
	private JScrollPane spjScrollPane1 = new JScrollPane();
	private JScrollPane spjScrollPane2 = new JScrollPane();
	private JScrollPane spjScrollPane3 = new JScrollPane();
	private JTable spTable, cpTable;
	private GridBagLayout gridBagLayout4 = new GridBagLayout();
	private GridBagLayout gridBagLayout3 = new GridBagLayout();
	private CSModel csm, cpn;
	private JButton pPrevious = new JButton("<");
	private JButton pNext = new JButton(">");
	private JComboBox stdF;
	private JLabel picture = new JLabel();
	private JTextField pName = new JTextField(20);
	private File[] pictures = null;
	private int pictureIndex = 0;



	// ****************

	public DataInput() {
		/*
		 * / try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 * 
		 * } catch(ClassNotFoundException e) { e.printStackTrace(); } //
		 */
		try {
			init();
			jbInit2();
			jbInit();
			enableEvents(AWTEvent.WINDOW_EVENT_MASK);
			setTitle("Suppliers & Customers");
			pack();
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DataInput dataInput = new DataInput();
	}

	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			dispose();
			System.exit(0);
		}
		super.processWindowEvent(e);
	}

	private void jbInit() throws Exception {
	;
		Main.setLayout(gridBagLayout1);
		cnameM.setText("Company Name:");
		cnameM.setHorizontalAlignment(SwingConstants.TRAILING);
		streetM.setText("Street");
		streetM.setHorizontalAlignment(SwingConstants.TRAILING);
		UnitM.setText("Unit");
		UnitM.setHorizontalAlignment(SwingConstants.TRAILING);
		CityM.setText("City");
		CityM.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel1.setText("State/Provice");
		jLabel1.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel2.setText("Zip/Post Code:");
		jLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
		CountryM.setText("Country");
		CountryM.setHorizontalAlignment(SwingConstants.TRAILING);
		PhoneM.setText("Phone");
		PhoneM.setHorizontalAlignment(SwingConstants.TRAILING);
		FaxM.setText("Fax");
		FaxM.setHorizontalAlignment(SwingConstants.TRAILING);
		EmailM.setText("Email");
		EmailM.setHorizontalAlignment(SwingConstants.TRAILING);
		MobileM.setText("Type:");
		MobileM.setHorizontalAlignment(SwingConstants.TRAILING);
		cpersonM.setText("Contact Person:");
		cpersonM.setHorizontalAlignment(SwingConstants.TRAILING);
		cphoneM.setText("Phone");
		cphoneM.setHorizontalAlignment(SwingConstants.TRAILING);
		cmobileM.setText("Type");
		cmobileM.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel4.setText("Email");
		jLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
		sameasabove.setText("Same As Above");
		jLabel5.setText("Request:");
		jLabel5.setHorizontalAlignment(SwingConstants.TRAILING);
		csComment.setBorder(BorderFactory.createLineBorder(new Color(116, 123,
				207), 1));
		noteM.setText("Note:");
		cStreetM.setText("Street");
		cStreetM.setHorizontalAlignment(SwingConstants.TRAILING);
		cUnitM.setText("Unit");
		cCityM.setText("City");
		cCityM.setHorizontalAlignment(SwingConstants.TRAILING);
		cStateM.setText("State/Province");
		cStateM.setHorizontalAlignment(SwingConstants.TRAILING);
		cZipM.setText("Zip/Post code");
		cZipM.setHorizontalAlignment(SwingConstants.TRAILING);
		cCountryM.setText("Country");
		cCountryM.setHorizontalAlignment(SwingConstants.TRAILING);
		cFaxM.setText("Fax");
		cFaxM.setHorizontalAlignment(SwingConstants.TRAILING);
		csUpdate.setText("Update");
		csReset.setText("Reset");
		IDM.setText("CustomerID:");
		IDM.setHorizontalAlignment(SwingConstants.TRAILING);
		websiteM.setText("Website:");
		websiteM.setHorizontalAlignment(SwingConstants.TRAILING);
		csNote.setBorder(BorderFactory.createLineBorder(
				new Color(116, 123, 207), 1));
		
		tab.add("Company", new JScrollPane().getViewport().add(SupplierPane));
		
		tab.add("ALL Companies", new JScrollPane(cpTable));
		csComment.setLineWrap(true);
		csNote.setLineWrap(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(tab);

	}

	private void jbInit2() throws Exception {
		spComment.setLineWrap(true);
		spNote.setLineWrap(true);
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		FlowLayout flowLayout1 = new FlowLayout();

		spnameSP.setText("CM. Name:");
		spnameSP.setHorizontalAlignment(SwingConstants.TRAILING);
		streetSP.setText("Street");
		streetSP.setHorizontalAlignment(SwingConstants.TRAILING);
		UnitSP.setText("Unit");
		UnitSP.setHorizontalAlignment(SwingConstants.TRAILING);
		CitySP.setText("City");
		CitySP.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel1SP.setText("State/Provice");
		jLabel1SP.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel2SP.setText("Zip/Post Code:");
		jLabel2SP.setHorizontalAlignment(SwingConstants.TRAILING);
		CountrySP.setText("Country");
		CountrySP.setHorizontalAlignment(SwingConstants.TRAILING);
		PhoneSP.setText("Phone");
		PhoneSP.setHorizontalAlignment(SwingConstants.TRAILING);
		FaxSP.setText("Fax");
		FaxSP.setHorizontalAlignment(SwingConstants.TRAILING);
		EmailSP.setText("Email");
		EmailSP.setHorizontalAlignment(SwingConstants.TRAILING);
		MobileSP.setText("Type:");
		MobileSP.setHorizontalAlignment(SwingConstants.TRAILING);
		cpersonSP.setText("Contact:");
		cpersonSP.setHorizontalAlignment(SwingConstants.TRAILING);
		jLabel5SP.setText("Description:");
		jLabel5SP.setHorizontalAlignment(SwingConstants.TRAILING);
		spComment.setBorder(BorderFactory.createLineBorder(new Color(116, 123,
				207), 1));
		spState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// spState_actionPerformed(e);
			}
		});
		noteSP.setText("Note:");
		spUpdate.setText("Update");
		spReset.setText("Reset");
		spIDSP.setText("SupplierID:");
		spIDSP.setHorizontalAlignment(SwingConstants.TRAILING);
		websiteSP.setText("Website:");
		websiteSP.setHorizontalAlignment(SwingConstants.TRAILING);
		spNote.setBorder(BorderFactory.createLineBorder(
				new Color(116, 123, 207), 1));
		
		spPrevious.setText("<");
		spNext.setText(">");
		sc.setText("Supplier");
		sc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sc.isSelected())
					sc.setText("Customer");
				else
					sc.setText("Supplier");
				
			}
		});
		spPane1.setLayout(gridBagLayout4);
		spPane2.setLayout(flowLayout1);
		jPanel1.setLayout(gridBagLayout2);
		jPanel2.setLayout(gridBagLayout3);
		spPane1.add(spWebsite, new GridBagConstraints(3, 8, 4, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 15, 10, 0), 404, 6));
		spPane1.add(websiteSP, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						15, 10, 10, 0), 27, 11));
		spPane1.add(cpersonSP, new GridBagConstraints(11, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 35, 0, 0), 18, 6));
		spPane1.add(cNamesp, new GridBagConstraints(13, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 10, 0, 10), 89, 6));
		spPane1.add(FaxSP, new GridBagConstraints(4, 5, 1, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						15, 60, 0, 0), 7, 6));
		spPane1.add(spFax, new GridBagConstraints(6, 5, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 20, 0, 0), 94, 6));
		spPane1.add(spPhone, new GridBagConstraints(3, 5, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 15, 0, 0), 184, 6));
		spPane1.add(PhoneSP, new GridBagConstraints(0, 5, 1, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						15, 25, 0, 0), 20, 6));
		spPane1.add(jLabel1SP, new GridBagConstraints(4, 3, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 15, 0, 0), 15, 6));
		spPane1.add(spCity, new GridBagConstraints(3, 3, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 15, 0, 0), 184, 6));
		spPane1.add(CitySP, new GridBagConstraints(0, 3, 2, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						15, 45, 0, 0), 16, 6));
		spPane1.add(spState, new GridBagConstraints(6, 3, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 20, 0, 0), 81, 5));
		spPane1.add(spStreet, new GridBagConstraints(3, 2, 4, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 15, 0, 0), 404, 6));
		spPane1.add(streetSP, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 25, 0, 0), 25, 6));
		spPane1.add(UnitSP, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 30, 0, 0), 31, 6));
		spPane1.add(spUnit, new GridBagConstraints(10, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(15, 25, 0, 0), 104, 6));
		spPane1.add(spName, new GridBagConstraints(3, 0, 4, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(20, 15, 0, 0), 404, 6));
		spPane1.add(spnameSP, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 10, 0, 0), 17, 6));
		spPane1.add(jLabel2SP, new GridBagConstraints(7, 3, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 10, 0, 0), 14, 6));
		spPane1.add(spZip, new GridBagConstraints(10, 3, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 25, 0, 0), 104, 6));
		spPane1.add(EmailSP, new GridBagConstraints(7, 5, 2, 2, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 45, 0, 0), 21, 6));
		spPane1.add(spEmail, new GridBagConstraints(10, 5, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 25, 0, 0), 104, 6));
		spPane1.add(sc, new GridBagConstraints(13, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						20, 0, 0, 10), 42, 2));
		spPane1.add(CountrySP, new GridBagConstraints(11, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 45, 0, 0), 11, 6));
		spPane1.add(MobileSP, new GridBagConstraints(11, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						10, 50, 0, 0), 15, 1));
		spPane1.add(spCountry, new GridBagConstraints(13, 3, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 0, 10), 76, 0));
		spPane1.add(spType, new GridBagConstraints(13, 5, 1, 2, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 10, 0, 10), 89, 6));
		spPane1.add(jLabel5SP, new GridBagConstraints(7, 8, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						15, 25, 10, 0), 13, 11));
		spPane1.add(noteSP, new GridBagConstraints(11, 8, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 55, 10, 0), 18, 6));
		spPane1.add(spID, new GridBagConstraints(10, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(20, 25, 0, 0), 104, 6));
		spPane1.add(spIDSP, new GridBagConstraints(7, 0, 2, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
						20, 15, 0, 0), 22, 6));
		spPane2.add(spUpdate, null);
		spPane2.add(spReset, null);
		spPane2.add(spPrevious, null);
		spPane2.add(spSelectChoice, null);
		spPane2.add(spNext, null);
		spPane2.add(spGoto, null);
		spPane2.add(gotoID, null);
		spjScrollPane2.getViewport().add(spComment, null);
		
		spjScrollPane3.getViewport().add(spNote, null);
		
		JSplitPane split3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				spjScrollPane2, spjScrollPane3);
		split3.setOneTouchExpandable(true);
		split3.setDividerLocation(900);
		JPanel tablePane = new JPanel(new BorderLayout());
		tablePane.add(new JScrollPane(spTable));
		JPanel tableAD = new JPanel();
		tableAD.add(rowAdd);
		tableAD.add(rowDelete);
		tableAD.add(stdF);
		tablePane.add(tableAD, BorderLayout.SOUTH);
		JSplitPane split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spPane1,
				tablePane);
		split2.setOneTouchExpandable(true);
		split2.setDividerSize(5);
		
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new JScrollPane(split2), split3);
		split1.setOneTouchExpandable(true);
		split1.setDividerLocation(500);
		JPanel SupplierPane2 = new JPanel(new BorderLayout());
		SupplierPane2.add(split1);
		SupplierPane2.add(spPane2, BorderLayout.SOUTH);
		JPanel pControl = new JPanel();
		pControl.add(pPrevious);
		pControl.add(pName);
		pControl.add(pNext);
		JPanel SupplierPane3 = new JPanel(new BorderLayout());
		SupplierPane3.add(pControl, BorderLayout.NORTH);
		SupplierPane3.add(new JScrollPane(picture));
		SupplierPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, SupplierPane3,
				SupplierPane2);
		SupplierPane.setOneTouchExpandable(true);
		SupplierPane.setDividerLocation(0);

	}

	private void init() {
		spUpdate.addActionListener(this);
		spReset.addActionListener(this);
		spNext.addActionListener(this);
		spPrevious.addActionListener(this);
		spGoto.addActionListener(this);
		rowAdd.addActionListener(this);
		rowDelete.addActionListener(this);
		pNext.addActionListener(this);
		pPrevious.addActionListener(this);
		Vector country = Database.getCountry();
		Vector state = Database.getState();
		Vector type = Database.getType();
		cCountrysp = new JComboBox(country);
		cStatesp = new JComboBox(state);
		cCountry = new JComboBox(country);
		cState = new JComboBox(state);
		csState = new JComboBox(state);
		csCountry = new JComboBox(country);
		spState = new JComboBox(state);
		spCountry = new JComboBox(country);
		spType = new JComboBox(type);
		spSelectChoice = new JComboBox(type);
		supplierIDs = Database.getSupplierIDs();
		supplierIndex = supplierIDs.size();
		spID.setText("" + (Database.getMaxID() + 1));
		spID.setEditable(false);
		String[] names = new String[] { "F1", "F2", "F3", "F4", "F5", "F6",
				"F7", "F8", "F9", "F10", "F11", "F12" };
		boolean[] editable = new boolean[] { true, true, true, true, true,
				true, true, true, true, true, true };
		csm = new CSModel(names, editable);
		spTable = new JTable(csm);
		csm.setData(getSupplierForm());
		picture.setBackground(Color.WHITE);
		Vector std = new Vector();
		std.add("SupplierForm");
		std.add("CustomerForm");
		stdF = new JComboBox(std);
		stdF.addActionListener(this);
		names = new String[] { "ID", "Name", "City", "State", "Country",
				"Website", "Type" };
		editable = new boolean[] { false, false, false, false, false, false,
				false };
		cpn = new CSModel(names, editable);
		cpn.setData(Database.getCompany());
		cpTable = new JTable(cpn);
		cpTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel lsm = cpTable.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
				} else {
					int index = cpTable.getSelectedRow();
					String value = (String) (cpTable.getValueAt(index, 0));
					fillSupplier(Database.getSupplier(value));
					Vector tem = Database.getTableData(value);
					if (tem == null || tem.size() == 0)
						tem = getForm(stdF.getSelectedIndex());
					csm.setData(tem);
					File file = new File(Database.getPath("PhotoPath") + "/"
							+ value);
					pictures = file.listFiles();
					pictureIndex = 0;
					showPicture(0);
					supplierIndex = getIndex(Integer.parseInt(value));

				}
			}

		});
	}

	private Vector getSupplierForm() {
		Vector modeldata = new Vector();
		String[] row1, row2, row3, row4;
		row1 = new String[] { "Total", " ", "TotalEmplyee", " ", "YearStarted",
				" ", " ", " ", " ", " ", " ", " " };
		modeldata.add(row1);
		row2 = new String[] { "Muller", " ", "Export?", " ", "Area(MXM)", " ",
				" ", " ", " ", " ", " ", " " };
		modeldata.add(row2);
		row3 = new String[] { "S.Keara", " ", "QualitySystem", " ", " ", " ",
				" ", " ", " ", " ", " ", " " };
		modeldata.add(row3);
		row4 = new String[] { "Taiwan", " ", "Elastic ", " ", " ", " ", " ",
				" ", " ", " ", " ", " " };
		modeldata.add(row4);
		return modeldata;
	}

	private Vector getCustomerForm() {
		Vector modeldata = new Vector();
		String[] row1, row2, row3, row4;
		row1 = new String[] { "Total", " ", "TotalEmplyee", " ", " ", " ", " ",
				" ", " ", " ", " ", " " };
		modeldata.add(row1);
		row2 = new String[] { "Customer", " ", "Export?", " ", " ", " ", " ",
				" ", " ", " ", " ", " " };
		modeldata.add(row2);
		row3 = new String[] { "Customer", " ", " ", " ", " ", " ", " ", " ",
				" ", " ", " ", " " };
		modeldata.add(row3);
		row4 = new String[] { "Taiwan", " ", " ", " ", " ", " ", " ", " ", " ",
				" ", " ", " " };
		modeldata.add(row4);
		return modeldata;
	}

	private int getIndex(int id) {
		for (int i = 0; i < supplierIDs.size(); i++) {
			if (id == Integer.parseInt((String) (supplierIDs.get(i))))
				return i;
		}
		return 0;
	}

	private Vector getForm(int index) {
		if (index == 0)
			return getSupplierForm();
		else if (index == 1)
			return getCustomerForm();
		return (new Vector());
	}

	private void spGotoOp() {
		String s = gotoID.getText();
		if (s == null || (s.trim()).length() == 0)
			return;
		int id = Integer.parseInt(s);
		if (id > (supplierIDs.size() - 1) || id < 1)
			return;
		fillSupplier(Database.getSupplier("" + id));
		supplierIndex = getIndex(id);
		Vector tem = Database.getTableData((supplierIDs.get(supplierIndex))
				.toString());
		if (tem == null || tem.size() == 0)
			tem = getForm(stdF.getSelectedIndex());
		csm.setData(tem);
		

		File file = new File(Database.getPath("PhotoPath") + "/"
				+ (spID.getText().trim()));
		pictures = file.listFiles();
		pictureIndex = 0;
		showPicture(0);

	}

	private void pNextOp() {
		if (pictureIndex > pictures.length - 2)
			return;

		showPicture(++pictureIndex);
	}

	private void pPreviousOp() {
		if (pictureIndex < 1)
			return;
		showPicture(--pictureIndex);
	}

	private void showPicture(int ind) {
		if (pictures == null || pictures.length == 0) {
			picture.setIcon(null);
			pName.setText("");
			return;
		}
		pName.setText(pictures[ind].getName());
		ImageIcon icon = new ImageIcon(pictures[ind].getPath());
		picture.setIcon(icon);

	}

	private void spNextOp() {
	
		if ((supplierIndex + 1) > (supplierIDs.size() - 1))
			return;
		fillSupplier(Database.getSupplier((supplierIDs.get(supplierIndex + 1))
				.toString()));
		Vector tem = Database.getTableData((supplierIDs.get(supplierIndex + 1))
				.toString());
		if (tem == null || tem.size() == 0)
			tem = getForm(stdF.getSelectedIndex());
		csm.setData(tem);
	
		supplierIndex++;
		File file = new File(Database.getPath("PhotoPath") + "/"
				+ (spID.getText().trim()));
		pictures = file.listFiles();
		pictureIndex = 0;
		showPicture(0);
	}

	private void spPreviousOp() {
		
		if ((supplierIndex - 1) < 0)
			return;
		fillSupplier(Database.getSupplier((supplierIDs.get(supplierIndex - 1))
				.toString()));
		Vector tem = Database.getTableData((supplierIDs.get(supplierIndex - 1))
				.toString());
		if (tem == null || tem.size() == 0)
			tem = getForm(stdF.getSelectedIndex());
		csm.setData(tem);
		
		supplierIndex--;
		File file = new File(Database.getPath("PhotoPath") + "/"
				+ (spID.getText().trim()));
		pictures = file.listFiles();
		pictureIndex = 0;
		showPicture(0);
	}

	private void spUpdateOp() {
		String s = spID.getText();
		if (s == null || s.length() == 0) {
			
			return;
		}
		int status = Database.getStatus(s);
		if (Database.addSupplier(this.getSupplierInfo(), status)) {

			if (!Database.addTechData(csm.getData(),
					Integer.parseInt(spID.getText().trim())))
				;
			
			File file = new File(Database.getPath("PhotoPath") + "/"
					+ (spID.getText().trim()));
			if (!file.exists())
				file.mkdir();
			File rfile = new File(Database.getPath("WebPhotoPath"));
			File[] rfiles = rfile.listFiles();
			String filename = null;
			if (rfiles != null) {
				for (int i = 0; i < rfiles.length; i++) {
					try {
						filename = rfiles[i].getName();
						if (filename.endsWith(".db"))
							continue;
						File desFile = new File(Database.getPath("PhotoPath")
								+ "/" + (spID.getText().trim()) + "/"
								+ filename);
						DataInputStream datain = new DataInputStream(
								new BufferedInputStream(new FileInputStream(
										rfiles[i])));

						DataOutputStream writer = new DataOutputStream(
								new BufferedOutputStream(new FileOutputStream(
										desFile)));
						boolean EOF = false;
						byte c = 0;
						while (!EOF) {
							try {
								c = datain.readByte();
								writer.writeByte(c);
							} catch (EOFException eof) {
								EOF = true;
							}
						}
						writer.close();
						datain.close();
						rfiles[i].delete();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				File file2 = new File(Database.getPath("PhotoPath") + "/"
						+ (spID.getText().trim()));
				pictures = file2.listFiles();
				pictureIndex = 0;
				showPicture(0);
			}
			if (status == 0) {
				supplierIDs.add(spID.getText().trim());
				supplierIndex++;
				spID.setText("" + (Database.getMaxID() + 1));
				supplierReset();
				pictures = null;
				pictureIndex = 0;
				showPicture(0);
			}
		}
		

	}

	private void spResetOp() {
		spID.setText("" + (Database.getMaxID() + 1));
		supplierReset();
		csm.setData(getForm(stdF.getSelectedIndex()));
		pictures = null;
		pictureIndex = 0;
		showPicture(0);
	}

	private void rowDeleteOp() {
		int index = spTable.getSelectedRow();
		if (index < 0)
			return;
		csm.delete(index);
	}

	private void rowAddOp() {
		String[] ss = new String[] { " ", " ", " ", " ", " ", " ", " ", " ",
				" ", " ", " ", " " };
		int index = spTable.getSelectedRow();
		if (index < 0)
			csm.addData(ss);
		else
			csm.addData(ss, index);
	}

	private void fillSupplier(String[] ss) {
		spID.setText(ss[0]);
		spName.setText(ss[1]);
		spStreet.setText(ss[2]);
		spUnit.setText(ss[3]);
		spCity.setText(ss[4]);
		spState.setSelectedItem(ss[5]);
		spZip.setText(ss[6]);
		spCountry.setSelectedItem(ss[7]);
		spPhone.setText(ss[8]);
		spFax.setText(ss[9]);
		spEmail.setText(ss[10]);
		spType.setSelectedItem(ss[11]);
		cNamesp.setText(ss[12]);
		spWebsite.setText(ss[13]);
		spComment.setText(ss[14]);
		spNote.setText(ss[15]);
		if (ss[16].equalsIgnoreCase("0"))
			this.sc.setSelected(false);

	}

	private void supplierReset() {
		spName.setText("");
		spStreet.setText("");
		spUnit.setText("");
		spCity.setText("");
		spState.setSelectedIndex(0);
		spZip.setText("");
		spCountry.setSelectedIndex(0);
		spPhone.setText("");
		spFax.setText("");
		spEmail.setText("");
		spType.setSelectedIndex(0);
		cNamesp.setText("");
		cStreetsp.setText("");
		cUnitsp.setText("");
		cCitysp.setText("");
		cStatesp.setSelectedIndex(0);
		cZipsp.setText("");
		cCountrysp.setSelectedIndex(0);
		cPhonesp.setText("");
		cFaxsp.setText("");
		cEmailsp.setText("");
		cMobilesp.setText("");
		spWebsite.setText("");
		spComment.setText("");
		spNote.setText("");
		this.sc.setSelected(false);
	}

	private void stdFOp() {
		csm.setData(getForm(stdF.getSelectedIndex()));
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == stdF) {
			stdFOp();
			return;
		}
		if (source == rowAdd) {
			rowAddOp();
			return;
		}
		if (source == rowDelete) {
			rowDeleteOp();
			return;
		}
		if (source == pNext) {
			pNextOp();
			return;
		}
		if (source == pPrevious) {
			pPreviousOp();
			return;
		}
		if (source == spGoto) {
			spGotoOp();
			return;
		}
		if (source == spUpdate) {
			spUpdateOp();
			return;
		}
		if (source == spReset) {
			spResetOp();
			return;
		}
		if (source == spNext) {
			spNextOp();
			return;
		}
		if (source == spPrevious) {
			spPreviousOp();
			return;
		}
	}

	private String[] getSupplierInfo() {
		
		String[] ss = new String[16];
		Object o = null;
		ss[0] = spID.getText();
		ss[1] = spName.getText();
		ss[2] = spStreet.getText();
		ss[3] = spUnit.getText();
		ss[4] = spCity.getText();
		o = spState.getSelectedItem();
		ss[5] = (o == null ? "" : o.toString().trim());
		ss[6] = spZip.getText();
		o = spCountry.getSelectedItem();
		ss[7] = (o == null ? "" : o.toString().trim());
		ss[8] = spPhone.getText();
		ss[9] = spFax.getText();
		ss[10] = spEmail.getText();
		o = spType.getSelectedItem();
		ss[11] = (o == null ? "" : o.toString().trim());
		ss[12] = cNamesp.getText();
		ss[13] = spWebsite.getText();
		ss[14] = spComment.getText();
		ss[15] = spNote.getText();
		for (int i = 0; i < 16; i++) {
			if (ss[i] == null)
				ss[i] = " ";
			else
				ss[i] = ss[i].trim();
		}
		return ss;
	}
}