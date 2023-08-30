package Member;

import common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    private DbUtils dbconn;

    public MemberDao() {
        dbconn = DbUtils.getInstance();
    }

    // 회원가입
    public void insert(Member m){
        Connection conn = dbconn.getConnection();
        String sql = "insert into Member (Category_id, Username, Password, Nickname, Email) values(?,?,?,?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, m.getCategory_id());
            pstmt.setString(2, m.getUsername());
            pstmt.setString(3, m.getPassword());
            pstmt.setString(4, m.getNickname());
            pstmt.setString(5, m.getEmail());

            pstmt.executeUpdate();
            System.out.println(m.getUsername() + "가입 완료!");

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    // 회원 검색
    public Member selectById(Long id){
        Connection conn = dbconn.getConnection();
        String sql = "select * from Member where Id=?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                return new Member(rs.getLong(1), rs.getString(5), rs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public Member select(int num, String str){
        // 1 = username 으로 검색
        // 2 = nickname 으로 검색
        Connection conn = dbconn.getConnection();
        String sql = "";
        switch (num){
            case 1:
                sql = "select * from Member where username=?";
                break;
            case 2:
                sql = "select * from Member where nickname=?";
                break;
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, str);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return new Member(rs.getLong(1), rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getString(7));
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    // 회원 정보 수정(칭호)
    public void updateTitle(String username){

    }

    // 회원 정보 수정(비밀번호)
    public void updatePwd(String password, Long id){
        Connection conn = dbconn.getConnection();
        String sql = "update Member set Password=? where Id=?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, password);
            pstmt.setLong(2, id);

            pstmt.executeUpdate();
            System.out.println("비밀번호 변경이 완료되었습니다.");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    // 회원 정보 수정(닉네임)
    public void updateNickname(String nickname, Long id){
        Connection conn = dbconn.getConnection();
        String sql = "update Member set Nickname=? where Id=?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, nickname);
            pstmt.setLong(2, id);

            pstmt.executeUpdate();
            System.out.println("닉네임 변경이 완료되었습니다.");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    // 회원 정보 수정(카테고리)
    public void updateCategory(String username){

    }

    public void delete(Long id){
        Connection conn = dbconn.getConnection();
        String sql = "delete from Member where Id=?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, id);

            pstmt.executeUpdate();
            System.out.println("회원 탈퇴 완료");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}