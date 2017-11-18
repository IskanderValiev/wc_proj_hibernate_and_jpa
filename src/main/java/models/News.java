package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;

    @Column(name = "news_header")
    private String header;

    @Column(name = "news_content")
    private String content;

    @Column(name = "news_image")
    private String image;

    @Column(name = "news_date")
    private Date date;

    @Column(name = "news_type")
    private String type;

//    @OneToMany(mappedBy = "news")
//    private Set<Comment> commentSet;

    public News() {}

    public News(String header, String content, String image, Date date, String type) {
        this.header = header;
        this.content = content;
        this.image = image;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public static Builder builder() {
        return new News().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder header(String header) {
            News.this.header = header;
            return this;
        }

        public Builder content(String content) {
            News.this.content = content;
            return this;
        }

        public Builder image(String image) {
            News.this.image = image;
            return this;
        }

        public Builder date(Date date) {
            News.this.date = date;
            return this;
        }

        public Builder type(String type) {
            News.this.type = type;
            return this;
        }

        public News build() {
            return News.this;
        }
    }
}