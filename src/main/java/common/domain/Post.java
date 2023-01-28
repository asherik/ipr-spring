package common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "post")
@Entity
@Getter
@Setter
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Lob
    @Column(name = "title")
    private String title;

}