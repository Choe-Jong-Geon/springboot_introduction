package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter //아래 생성자들을 제거해도 되는 핵심요소(빌더패턴)(롬복의 애너테이션)
@NoArgsConstructor(access = AccessLevel.PROTECTED) //아래 생성자들을 제거해도 되는 핵심요소(빌더패턴)(롬복의 애너테이션)a
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }
    /*
    public Article() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }*/

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
