package tw.harry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.harry.api.Food;
import tw.harry.listener.InitListener;

public class FoodDao {
	
	private static final String SQL_QUERY_PAGE = """
		SELECT id, name, city, town, addr, tel, picurl
		FROM food
		ORDER BY id
		LIMIT ?, ?
	""";
	
	public List<Food> queryByPage(int page, int rpp) throws Exception {
		int spage = Math.max(1, page);
		int srpp = Math.max(1, rpp);
		int offset = (spage - 1);
		List<Food> foods = new ArrayList<Food>();
		
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_PAGE);
		) {
			pstmt.setInt(1, offset * srpp);
			pstmt.setInt(2, srpp);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Food food = new Food(
						rs.getLong("id"),
						rs.getString("name"),
						rs.getString("tel"),
						rs.getString("city"),
						rs.getString("town"),
						rs.getString("addr"),
						rs.getString("picurl")
					);
					foods.add(food);	
				}
			}
		}
		
		return foods;
	}
}
