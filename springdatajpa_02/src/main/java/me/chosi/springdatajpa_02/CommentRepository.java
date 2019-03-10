package me.chosi.springdatajpa_02;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

//    Comment save(Comment comment);
//
//    List<Comment> findAll();

//    @Query(value = "select c FROM Comment AS c", nativeQuery = true)
//    List<Comment> findByCommentContains(String keyword);

//    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);

//    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

//    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}
