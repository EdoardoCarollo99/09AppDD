package factories;


import dao.DaoDnD;
import dao.IDaoDnD;

public interface DaoFactory {

	String DB_ADDRESS = "jdbc:mysql://localhost:3306/dbDnD";
	String USER = "root";
	String PASSWORD = "root";
	
	static IDaoDnD make() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new DaoDnD(DB_ADDRESS, USER, PASSWORD);
	}
}
