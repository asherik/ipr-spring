package com.ipr.iprspring.fixProblemNplusOne.domain;

import com.ipr.iprspring.common.enums.CommentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "post_comment")
@Entity
@Getter
@Setter
public class PostCommentFixNplusOne {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private PostFixNplusOne post;

    @Column(name = "review", length = 400)
    private String review;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private CommentType commentType;
}