package ItemListener;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AdmissionForm extends Applet implements ActionListener,ItemListener{
	
	Label lbcname,lbfname;
	Label lbgender,lbdob,lbaddress;
	Label lbdegree,lbdegreefee,lbfac,lbfacfee,lbtotalfee;
	Button btcal,btrec,btrefresh,btclose;
	TextField txcname,txfname,txdegreefee,txfacfee,txtotalfee;
	TextArea taddress;
	Panel Pgender,Pdob,Pfac,Pbutton1,Pbutton2;
	Checkbox ckmess,ckhostel,ckbus,ckmale,ckfemale,ckhidden;
	CheckboxGroup gr;
	Choice chyy,chmm,chdd,chdegree;
	int ffees,dfees;
		
	public void init()
	{


		lbcname = new Label("Candidate Name");
		lbfname = new Label("Father Name");
		
		lbgender = new Label("Gender");
		gr = new CheckboxGroup();
		ckmale = new Checkbox("Male",gr,false);
		ckfemale = new Checkbox("Female",gr,false);
		ckhidden = new Checkbox("Hidden",gr,false); // dont add this
		
		lbdob =  new Label("DOB");
		
		chyy = new Choice();
		chmm = new Choice();
		chdd = new Choice();
		
		lbaddress = new Label("Address");
		lbdegree = new Label("Degree");
		
		chdegree = new Choice();
		
		lbdegreefee = new Label("Degree Fee");
		lbfac = new Label("Facility");
		lbfacfee = new Label("Facility Fee");
		lbtotalfee = new Label("Total Fee");
		
		btcal = new Button("Calculate");
		btrec = new Button("Receipt");
		btrefresh= new Button("Refresh");
		btclose = new Button("Close");
		
		txcname = new TextField();   
		txfname = new TextField();
		txdegreefee = new TextField();
		txfacfee = new TextField(); 
		txtotalfee = new TextField();
		txdegreefee.setEnabled(false);
		txfacfee.setEnabled(false);
		txtotalfee.setEnabled(false);
		
		taddress = new TextArea();
		
		ckmess = new Checkbox("Mess");
		ckhostel = new Checkbox("Hostel");
		ckbus = new Checkbox("Bus");		
		
	
		print();
		
		chdegree.addItemListener(this);
		
		ckmess.addItemListener(this);
		ckhostel.addItemListener(this);
		ckbus.addItemListener(this);
		
		btcal.addActionListener(this);
		btrec.addActionListener(this);
		btrefresh.addActionListener(this);
		btclose.addActionListener(this);
	}
	
	public void print()
	{
		chyy.add("Year");
		for(int i=1981;i<=2000;i++)
		chyy.add(i+"");
		
		chmm.add("Month");
		for(int i=1;i<=12;i++)
			chmm.add(i+"");
		
		chdd.add("Date");
		for(int i=1;i<=31;i++)
			chdd.add(i+"");
		
		// according to month and year date must change
		
		chdegree.add("Select Degree");
		chdegree.add("Btech");
		chdegree.add("Mtech");
		chdegree.add("PG");
		chdegree.add("UG");
		
		Pgender = new Panel();
		Pgender.setLayout(new GridLayout(1, 2));
		Pdob = new Panel();
		Pdob.setLayout(new GridLayout(1, 3));
		Pfac = new Panel();
		Pfac.setLayout(new GridLayout(1, 3));
		Pbutton1 = new Panel();
		Pbutton1.setLayout(new GridLayout(1, 2));
		Pbutton2 = new Panel();
		Pbutton2.setLayout(new GridLayout(1, 2));
		
		Pgender.add(ckmale);
		Pgender.add(ckfemale);
		// dont add this hidden check box
		
		Pdob.add(chyy);
		Pdob.add(chmm);
		Pdob.add(chdd);
		
		Pfac.add(ckmess);
		Pfac.add(ckhostel);
		Pfac.add(ckbus);
		
		Pbutton1.add(btcal);
		Pbutton1.add(btrec);
		Pbutton2.add(btrefresh);
		Pbutton2.add(btclose);
		
		
		setLayout(new GridLayout(11,2));
		add(lbcname);
		add(txcname);
		add(lbfname);
		add(txfname);
		add(lbgender);
		add(Pgender);
		add(lbdob);
		add(Pdob);
		add(lbaddress);
		add(taddress);
		add(lbdegree);
		add(chdegree);
		add(lbdegreefee);
		add(txdegreefee);
		add(lbfac);
		add(Pfac);
		add(lbfacfee);
		add(txfacfee);
		add(lbtotalfee);
		add(txtotalfee);
		add(Pbutton1);
		add(Pbutton2);
	
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		
		// only degree fee

		dfees=0;
		int a = chdegree.getSelectedIndex();
		switch(a)
		{
		case 1:{// Btech
					dfees = 60000;
					break;
				}
		case 2:{//Mtech
					dfees = 	80000;
					break;
				}
		case 3:{//PG
					dfees = 30000;
					break;
				}
		case 4:{//UG
					dfees = 40000;
					break;
				}
		}
		
		txdegreefee.setText(dfees+"");
		
		
		ffees=0;
		if(ckmess.getState())
		{
			ffees += 9000;
		}
		if(ckhostel.getState())
		{
			ffees += 20000;
		}
		if(ckbus.getState())
		{
			ffees += 14000;
		}
		
		txfacfee.setText(ffees+"");
		
		txtotalfee.setText((dfees+ffees)+"");
}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object src = ae.getSource();
		// in refresh radio button will remain as it
		// making hidden radio button
		
		if(src == btcal)
		{
			
		}
		else if(src == btrec)
		{
			
		}
		else if(src == btrefresh)
		{
			txcname.setText(" ");
			txfname.setText(" ");
			
			//Radio button
			ckhidden.setState(true);
			// if it is true then other will automatically will get off
			
			chyy.select(0);
			chmm.select(0);
			chdd.select(0);
			taddress.setText(" ");
			chdegree.select(0);
			txdegreefee.setText(" ");
			
			
			ckmess.setState(false);
			ckhostel.setState(false);
			ckbus.setState(false);
			
			txfacfee.setText(" ");
			txtotalfee.setText(" ");
			
			
		}
		else 
		{
			System.exit(-1);
		}
	}
	
}
