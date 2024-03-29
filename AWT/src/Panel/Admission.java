package Panel;
import java.applet.Applet;
import java.awt.Label;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;

	public class Admission extends Applet{
		Label lb1,lbcdname,lbdob,lbadd,lbdeg,lbfac;
		Label lbftname,lbdfee,lbffee,lbtfee;
		TextField txcdname,txftname,txdfee,txffee,txtfee;
		TextArea taadd;
		Button btcal,btrecp,btrefresh ,btclose;

		Panel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
		Choice ch1,ch2,ch3,ch4;
		Checkbox chmale,chfemale,chmess,chhostel,chbus;
		CheckboxGroup gr;

		public void init() {
			
			gr = new CheckboxGroup();
			chmale = new Checkbox("Male",gr,true);
			chfemale = new Checkbox("Female",gr,false);
			
			chmess = new Checkbox("Mess");
			chhostel = new Checkbox("Hostel");
			chbus = new Checkbox("Bus");

			
			ch1 = new Choice();
			ch1.add("Year");
			for(int i=0;i<=1;i++)
				for(int j=0;j<=9;j++)
			ch1.add("20"+i+""+j);
			
			ch2 = new Choice();
			ch2.add("Month");
			for(int i=1;i<=12;i++)
			ch2.add(i+"");
			
			ch3 = new Choice();
			ch3.add("Date");
			for(int i=1;i<=30;i++)
			ch3.add(i+"");
			
			ch4 = new Choice();
			ch4.add("Degree");
			ch4.add("Btch");
			ch4.add("Bse");
			ch4.add("Barch");
			ch4.add("Mtech");
			
			
			taadd = new TextArea(5,10);
			
			lb1 = new Label("Admission Form");
			lbcdname = new Label("Candidate Name");
			lbftname = new Label("Fathers Name");
			lbdob = new Label("DOB");
			lbtfee = new Label("Total Fee");
			lbdfee = new Label("Degree Fee");
			lbffee = new Label("Facility Fee");
			lbadd = new Label("Address");
			lbdeg = new Label("Degree");
			lbfac = new Label("Facility");
			
			txcdname = new TextField(20);
			txftname = new TextField(20);
			txdfee = new TextField(20);
			txffee = new TextField(20);
			txtfee = new TextField(20);
			
			
			btcal = new Button("Calculate");
			btrecp = new Button("Reciept");
			btrefresh = new Button("Refresh");
			btclose = new Button("Cancel");
			
			add();
	

		}
		
		void add()
		{
			p1 = new Panel();
			p1.add(lb1);
			
			p2 = new Panel();
			p2.setLayout(new GridLayout(1,2,10,10));		
			p2.add(lbcdname);
			p2.add(txcdname);
			
			
			p3 = new Panel();
			p3.setLayout(new GridLayout(1,2,10,10));		
			p3.add(lbftname);
			p3.add(txftname);
			
			p4 = new Panel();
			p4.setLayout(new GridLayout(1,3,10,10));
			p4.add(new Label("Gender"));
			p4.add(chmale);
			p4.add(chfemale);
			
			p5 = new Panel();
			p5.setLayout(new GridLayout(1,4,10,10));		
			p5.add(lbdob);
			p5.add(ch1);
			p5.add(ch2);
			p5.add(ch3);
			
			p6 = new Panel();
			p6.setLayout(new GridLayout(1,2,10,10));		
			p6.add(lbadd);
			p6.add(taadd);
			
			p7 = new Panel();
			p7.setLayout(new GridLayout(1,2,10,10));		
			p7.add(lbdeg);
			p7.add(ch4);
			
			p8 = new Panel();
			p8.setLayout(new GridLayout(1,2,10,10));		
			p8.add(lbdfee);
			p8.add(txdfee);
			
			p9 = new Panel();
			p9.setLayout(new GridLayout(1,4,10,10));		
			p9.add(lbfac);
			p9.add(chmess);
			p9.add(chhostel);
			p9.add(chbus);
			
			p10 = new Panel();
			p10.setLayout(new GridLayout(1,2,10,10));		
			p10.add(lbffee);
			p10.add(txffee);
			
			p11 = new Panel();
			p11.setLayout(new GridLayout(1,2,10,10));		
			p11.add(lbtfee);
			p11.add(txtfee);
				
			p12 = new Panel();
			p12.setLayout(new GridLayout(1,4,10,10));		
			p12.add(btcal);
			p12.add(btrecp);
			p12.add(btrefresh);
			p12.add(btclose);
			
			setLayout(new GridLayout(12,1,10,20));
			add(p1);
			add(p2);
			add(p3);
			add(p4);
			add(p5);
			add(p6);
			add(p7);
			add(p8);
			add(p9);
			add(p10);
			add(p11);
			add(p12);
		}
		
}
