import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EndUser {
		public static void main(String args[]) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session s = sf.openSession();
			Scanner sc=new Scanner(System.in);
			while(true) {
			
				System.out.println("Enter Type : ");
				String type=sc.next();
				System.out.println("Enter Length : ");
				int length = sc.nextInt();
				System.out.println("Enter Colour : ");
				String colour=sc.next();
				System.out.println("Enter Cost : ");
				double cost=sc.nextDouble();
				Fabrics fr = new Fabrics();
				fr.setType(type);
				fr.setLength(length);
				fr.setColour(colour);
	
				fr.setCost(cost);
				Transaction txt = s.beginTransaction();
				s.save(fr);
				txt.commit();
				System.out.println("object saved");
			
				System.out.println("If you want to insert another record ? : type yes / no");
				String insert=sc.next();
				if(insert.equals("no")) {
					break;
				}				
			}
			s.close();
			sf.close();
		}
}
