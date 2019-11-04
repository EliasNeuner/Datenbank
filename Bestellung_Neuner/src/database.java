import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class database {
	/*
	 * Kunden
	 */

	public static void createCustomer(String vorname, String nachname) throws SQLException {
		java.sql.Connection cn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/swp", "NeunerElias",
				"neuner9er");
		String sql = "Insert into Kunde (vorname, nachname) values(?,?)";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setString(1, vorname);
		pstm.setString(2, nachname);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void deleteCustomer(int kundeID) throws SQLException {
		java.sql.Connection cn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/swp", "NeunerElias",
				"neuner9er");
		String sql = "Delete from Kunde where ID = " + kundeID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, kundeID);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void updateCustomer(int kundeID, String vorname, String nachname) throws SQLException {
		java.sql.Connection conn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Update kunde set vorname = ?, nachname = ? where ID = " + kundeID;
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, vorname);
		stm.setString(2, nachname);
		stm.executeUpdate();
		stm.close();
	}

	public static void readCustomer(int kundeID) throws SQLException {
		java.sql.Connection conn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Select * from Kunde where ID = " + kundeID;
		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");

			System.out.println(id);
			System.out.println(vorname);
			System.out.println(nachname);

		}
		stm.close();
	}

	/*
	 * Adresse
	 */

	public static void createAdress(String Stadt, String Straße, int PLZ, int Hnr) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Insert into address (Stadt, Straße, PLZ, HNR) values(?,?,?,?)";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setString(1, Stadt);
		pstm.setString(2, Straße);
		pstm.setInt(3, PLZ);
		pstm.setInt(4, Hnr);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void deleteAdress(int adressID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Delete from address where ID = " + adressID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, adressID);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void readAdress(int adressID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Select * FROM address where id = " + adressID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			String Stadt = rs.getString("stadt");
			String Strasse = rs.getString("strasse");
			int PLZ = rs.getInt("plz");
			String Hnr = rs.getString("hnr");

			System.out.println(ID);
			System.out.println(Stadt);
			System.out.println(Strasse);
			System.out.println(PLZ);
			System.out.println(Hnr);
		}
		pstm.close();
	}

	public static void updateAdress(int adressID, String Stadt, String Straße, int PLZ, int Hnr) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Update address set Stadt = ?, Straße = ?, PLZ = ?, Hnr = ? where ID = " + adressID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setString(1, Stadt);
		pstm.setString(2, Straße);
		pstm.setInt(3, PLZ);
		pstm.setInt(4, Hnr);
		pstm.executeUpdate();
		pstm.close();
	}

	/*
	 * Artikel
	 */

	public static void createArtikel(String name, double preis) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Insert into artikel (name, preis) values(?,?)";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setDouble(2, preis);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void deleteArtikel(int artikelID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Delete from artikel where ID = " + artikelID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, artikelID);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void readArtikel(int artikelID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Select * FROM artikel where id = " + artikelID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			String Name = rs.getString("artikelname");
			double Preis = rs.getDouble("preis");

			System.out.println(ID);
			System.out.println(Name);
			System.out.printf(Preis + "€");
			System.out.println();
		}
		pstm.close();
	}

	public static void updateArtikel(int artikelID, String name, double preis) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Update artikel set name = ?, preis = ? where ID = " + artikelID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setDouble(2, preis);
		pstm.executeUpdate();
		pstm.close();
	}

	/*
	 * Bestellung - Artikel
	 */

	public static void createBestellungArtikel(int orderID, int artikelID, int menge) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Insert into bestellung_artikel(bestell_id, artikel_id, menge) values (?,?,?)";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, orderID);
		pstm.setInt(2, artikelID);
		pstm.setInt(3, menge);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void deleteBestellungArtikel(int order_id, int artikel_id) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Delete from bestellung_artikel where bestell_id = ? and artikel_id = ?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, order_id);
		pstm.setInt(2, artikel_id);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void readBestellungArtikel(int order_id, int artikel_id) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Select * from bestellung_artikel where bestell_id = ? and artikel_id = ?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, order_id);
		pstm.setInt(2, artikel_id);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int bestellID = rs.getInt("bestell_id");
			int artikelID = rs.getInt("artikel_id");
			int menge = rs.getInt("menge");

			System.out.println(bestellID);
			System.out.println(artikelID);
			System.out.println(menge);
		}
		pstm.close();
	}

	public static void updateBestellungArtikel(int order_id, int artikel_id, int menge) throws SQLException {
		java.sql.Connection cn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/swp", "NeunerElias", "neuner9er");
		String sql = "Update bestellung_artikel set bestell_id = ?, artikel_id = ?, menge = ? where bestell_id = ? and artikel_id = ?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, order_id);
		pstm.setInt(2, artikel_id);
		pstm.setInt(3, menge);
		pstm.setInt(4, order_id);
		pstm.setInt(5, artikel_id);
		pstm.executeUpdate();
		pstm.close();
	}

	/*
	 * Bestellung v3
	 */

	public static void createBestellung(int kundeID, int adresseLieferID, int adresseRechnungID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Insert into bestellung_v3(kunde_id, adresse_liefer_id, adresse_rechnung_id) values (?,?,?)";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, kundeID);
		pstm.setInt(2, adresseLieferID);
		pstm.setInt(3, adresseRechnungID);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void deleteBestellung(int bestellungID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Delete from bestellung_v3 where ID = " + bestellungID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
	}

	public static void readBestellung(int bestellungID) throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Select * from bestellung_v3 where ID = " + bestellungID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			int Kunde = rs.getInt("kunde_id");
			int LieferAdresse = rs.getInt("adresse_liefer_id");
			int RechnungsAdresse = rs.getInt("adresse_rechnung_id");

			System.out.println(ID);
			System.out.println(Kunde);
			System.out.println(LieferAdresse);
			System.out.println(RechnungsAdresse);
		}
		pstm.close();
	}

	public static void updateBestellung(int orderID, int kundeID, int adresseLieferID, int adresseRechnungID)
			throws SQLException {
		java.sql.Connection cn = DriverManager
				.getConnection("jdbc:postgresql://127.0.0.1:5432/swp","NeunerElias", "neuner9er");
		String sql = "Update bestellung_v3 set kunde_id = ?, adresse_liefer_id = ?, adresse_rechnung_id = ? where ID = "
				+ orderID;
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, kundeID);
		pstm.setInt(2, adresseLieferID);
		pstm.setInt(3, adresseRechnungID);
		pstm.executeUpdate();
		pstm.close();
	}
	
	public static void run() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie CREATE, DELETE, READ oder UPDATE ein");
		String method = s.nextLine();

		if (method.equalsIgnoreCase("CREATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.nextLine();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("KundenID: ");
				int kundenID = s.nextInt();
				System.out.println("LieferadresseID: ");
				int lieferID = s.nextInt();
				System.out.println("RechnungsadresseID: ");
				int rechnungID = s.nextInt();
				createBestellung(kundenID, lieferID, rechnungID);
			} else if (a.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				System.out.println("Menge: ");
				int menge = s.nextInt();
				createBestellungArtikel(bestellID, artikelID, menge);
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("Name: ");
				String name = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				createArtikel(name, preis);
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				int hnr = s.nextInt();
				createAdress(stadt, strasse, plz, hnr);
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("Vorname:  ");
				String vorname = s.next();
				System.out.println("Nachname:  ");
				String nachname = s.next();
				try {
					createCustomer(vorname, nachname);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("DELETE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				deleteBestellung(ID);
			} else if (a.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				deleteBestellungArtikel(bestellID, artikelID);
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				deleteArtikel(ID);
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				deleteBestellung(ID);
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID:  ");
				int ID = s.nextInt();
				try {
					deleteCustomer(ID);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("UPDATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				System.out.println("KundenID: ");
				int kundenID = s.nextInt();
				System.out.println("LieferadresseID: ");
				int lieferID = s.nextInt();
				System.out.println("RechnungsadresseID: ");
				int rechnungID = s.nextInt();
				updateBestellung(ID, kundenID, lieferID, rechnungID);
			} else if (a.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				System.out.println("Menge: ");
				int menge = s.nextInt();
				updateBestellungArtikel(bestellID, artikelID, menge);
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				System.out.println("Name: ");
				String name = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				updateArtikel(ID, name, preis);
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				System.out.println("Stadt: ");
				String Stadt = s.next();
				System.out.println("Strasse: ");
				String Strasse = s.next();
				System.out.println("PLZ: ");
				int PLZ = s.nextInt();
				System.out.println("Hausnummer: ");
				int Hnr = s.nextInt();
				updateAdress(ID, Stadt, Strasse, PLZ, Hnr);
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				System.out.println("Vorname:  ");
				String Vorname = s.next();
				System.out.println("Nachname:  ");
				String Nachname = s.next();
				try {
					updateCustomer(ID, Vorname, Nachname);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("READ")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNG_ARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				readBestellung(ID);
			} else if (a.equalsIgnoreCase("BESTELLUNG_ARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				readBestellungArtikel(bestellID, artikelID);
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				readArtikel(ID);
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				readAdress(ID);
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID:  ");
				int ID = s.nextInt();
				try {
					readCustomer(ID);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		run();
	}
}