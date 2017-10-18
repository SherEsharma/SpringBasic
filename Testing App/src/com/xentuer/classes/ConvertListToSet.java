package com.xentuer.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertListToSet {

	static String s = "_java,_css,_php,_.Net";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int candidateid1 = 0;
		String firstname = null;
		System.out.println("Before the string split:=" + s);

		String s1[] = s.split(",");
		System.out.println("First split:" + s1[0]);
		System.out.println("Second split:" + s1[1]);
		List list = new ArrayList();
		for (int i = 0; i < s1.length; i++) {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabaajodb", "root", "");
			String sql1 = "SELECT `candidate_id`,`candidate_first_name` FROM `candidate` WHERE  `candidate_skills_list` LIKE '%"
					+ s1[i] + "%'";

			PreparedStatement p1 = conn.prepareStatement(sql1);
			ResultSet rs1 = p1.executeQuery();
			
			while (rs1.next()) {/*
								 * candidateid1 =rs1.getInt(1); firstname =
								 * rs1.getString(2);
								 * System.out.println(candidateid1+"  "+
								 * firstname);
								 */
				list.add(rs1.getInt(1));
				list.add(rs1.getString(2));
			}

		}
		System.out.println(list);
		
		 Set set = new HashSet(list);

	        System.out.println("Set values .....");
	        for (Object temp : set){
	        	System.out.println(temp);
	        }

	}
}
