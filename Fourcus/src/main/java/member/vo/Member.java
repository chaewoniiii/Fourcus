package member.vo;

import lombok.Getter;

import java.sql.Date;

@Getter
public class Member {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String title;
    private Date production;
    private Long category_id;

    public Member(Long id, String username, String nickname, String email, String title, Long category_id){
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.title = title;
        this.category_id = category_id;
    }

    public Member(Long id, String username, String password, String nickname, String email, String title){
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.title = title;
    }

    public Member(Long id, String nickname, String title) {
        this.id = id;
        this.nickname = nickname;
        this.title = title;
    }

    public Member(String username, String password, String nickname, String email, Long category_id) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}