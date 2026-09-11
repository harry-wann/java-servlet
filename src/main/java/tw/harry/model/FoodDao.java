package tw.harry.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.harry.listener.InitListener;
import tw.harry.record.Food;

public class FoodDao {
	
	private static final String SQL_QUERY_ALL = """
		SELECT id, name, tel, city, town, addr, picurl
		FROM food
	""";
	
	private static final String SQL_QUERY_ID = """
		SELECT id, name, tel, city, town, addr, picurl
		FROM food
		WHERE id = ?
	""";
	
	private static final String SQL_INSERT = """
		UPDATE food 
		(name, tel, city, town, addr, picurl)
		VALUES
		(?, ?, ?, ?, ?, ?)
		WHERE id = ?
	""";
	
	private static final String SQL_UPDATE = """
		UPDATE food SET
			name = ?
			tel = ?
			city = ?
			town = ?
			addr = ?
			prcurl = ?
		WHERE id = ?
	""";
	
	private static final String SQL_DELETE = """
		DELETE food
		WHERE id = ?
	""";
	
	public List<Food> findAll() throws Exception {
		List<Food> list = new ArrayList<Food>();
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ALL);
			ResultSet rs = pstmt.executeQuery()
		) {
			while (rs.next()) list.add(mapRow(rs));
		}
		return list;
	}
	
	public Food findById(long id) {
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ALL);
		) {
			pstmt.setLong(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				return mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Food food) {
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		) {
			setParams(pstmt, food);
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(long id, Food food) {
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
		) {
			setParams(pstmt, food);
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(long id) {
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
		) {
			pstmt.setLong(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private Food mapRow(ResultSet rs) throws SQLException {
		return new Food(
			rs.getLong("id"), 
			rs.getString("name"),
			rs.getString("tel"), 
			rs.getString("city"), 
			rs.getString("town"),
			rs.getString("addr"),
			rs.getString("picurl")
		);
	}
	
	private void setParams(PreparedStatement pstmt, Food food) throws Exception {
		pstmt.setString(1, food.name());
		pstmt.setString(2, food.tel());
		pstmt.setString(3, food.city());
		pstmt.setString(4, food.town());
		pstmt.setString(5, food.addr());
		pstmt.setString(6, food.picurl());
	}
}
