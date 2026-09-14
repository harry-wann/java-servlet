package tw.harry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.harry.api.BCrypt;
import tw.harry.api.Member;
import tw.harry.listener.InitListener;

public class MemberDao {
	
	private static final String SQL_QUERY_ID = """
		SELECT id, account, passwd, name, icon, bike
		FROM member
		WHERE account = ?;
	""";

	public Member login(String account, String passwd) throws Exception {
		try (
			Connection conn = InitListener.ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ID)
		) {
			pstmt.setString(1, account);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next() & BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					return new Member(
						rs.getLong("id"),
						rs.getString("account"),
						rs.getString("passwd"),
						rs.getString("name"),
						null,
						null
//							rs.getString("icon"),
//							rs.getString("account"),
					);
				} else {
					return null;
				}
			}
		}
	}
}
