package db;
import java.sql.*;
import java.util.ArrayList;

public class GestoreDB {
	String connectionString = "jdbc:mysql://localhost:3306/albergo?user=root&password=root&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	
	public ArrayList<String> getClienteHotelData(String cf) {
		ArrayList<String> clienteData = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from clientihotel where cf = '"+cf+"'");
			while (rs.next()) {
				clienteData.add(rs.getString("nome"));
				clienteData.add(rs.getString("cognome"));
				clienteData.add(rs.getString("cf"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return clienteData;
	}
	
	public ArrayList<String> getSoggiornoData(String cf){
		ArrayList<String> soggiornoData = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from soggiorni where cfCliente = '"+cf+"'");
			while (rs.next()) {
				soggiornoData.add(rs.getString("dataInizio"));
				soggiornoData.add(rs.getString("idRegistrazione"));
				soggiornoData.add(rs.getString("dataFine"));
				soggiornoData.add(rs.getString("saldo"));
				soggiornoData.add(rs.getString("idCamera"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return soggiornoData;
	}
	
	public ArrayList<String> getCameraData(int idCamera){
		ArrayList<String> cameraData = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from camere where idCamera = '"+idCamera+"'");
			while (rs.next()) {
				cameraData.add(rs.getString("idCamera"));
				cameraData.add(rs.getString("stato"));
				cameraData.add(rs.getString("tipo"));
				cameraData.add(rs.getString("costoNotte"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return cameraData;
	}

	public int getFrigoData(int idCamera) {
		int idFrigo = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select idFrigoBar from frigobarcamere where idCamera = '"+idCamera+"'");
			while (rs.next()) {
				idFrigo = rs.getInt("idFrigoBar");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return idFrigo;
	}
	
	public ArrayList<String> getOrdineRistoranteData(String cf, int idCamera, int idReg){
		ArrayList<String> ordineRistoranteData = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from righeordiniristorante where idCamera = '"+idCamera+"' and cfCliente = '"+cf+"' and idRegistrazione = '"+idReg+"'");
			while (rs.next()) {
				ordineRistoranteData.add(rs.getString("idPietanza"));
				ordineRistoranteData.add(rs.getString("data"));
				ordineRistoranteData.add(rs.getString("quantita"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return ordineRistoranteData;
	}
	
	public ArrayList<String> getPietanzaData(int id){
		ArrayList<String> pietanza = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from pietanze where idPietanza = '"+id+"'");
			while (rs.next()) {
				pietanza.add(rs.getString("prezzo"));
				pietanza.add(rs.getString("desc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return pietanza;
	}
	
	public ArrayList<String> getOrdineBibitaData(String cf, int idCamera, int idReg){
		ArrayList<String> ordineBibiteData = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from righeordinibibite where idCamera = '"+idCamera+"' and cfCliente = '"+cf+"' and idRegistrazione = '"+idReg+"'");
			while (rs.next()) {
				ordineBibiteData.add(rs.getString("idBibita"));
				ordineBibiteData.add(rs.getString("data"));
				ordineBibiteData.add(rs.getString("quantita"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return ordineBibiteData;
	}
	
	public ArrayList<String> getBibitaData(int id){
		ArrayList<String> bibita = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from bibite where idBibita = '"+id+"'");
			while (rs.next()) {
				bibita.add(rs.getString("prezzo"));
				bibita.add(rs.getString("desc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return bibita;
	}
	
	public ArrayList<String> getContoData(String cf, int idReg){
		ArrayList<String> conto = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from conti where cfCliente = '"+cf+"' and idRegistrazione = '"+idReg+"' and stato = 0");
			while (rs.next()) {
				conto.add(rs.getString("conto"));
				conto.add(rs.getString("stato"));
				conto.add(rs.getString("idConto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conto;
	}
	
	public boolean checkCliente(String cf) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from clientihotel join conti on (cf = cfCliente) where cf = '"+cf+"' and stato = 0");
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return false;
	}
	
	public void salvaPagamento(int idConto, float importoTotale, int tipoPagamento) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			stm.executeUpdate("insert into pagamenti (idConto, importoTotale, tipoPagamento) values ('"+idConto+"', '"+importoTotale+"', '"+tipoPagamento+"')");
			stm.executeUpdate("update conti set stato = '1', conto = '"+importoTotale+"' where idConto = '"+idConto+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
}
