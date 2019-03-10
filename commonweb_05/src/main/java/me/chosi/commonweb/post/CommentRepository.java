package me.chosi.commonweb.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>, QueryByExampleExecutor<Comment> {

    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

//    List<CommentSummary> findByPost_id(Long id);
//
//    List<CommnetOnly> findByPost_id(Long id);
//    위에 두개가 겹치니 제네릭 사용
    @Transactional(readOnly = true)
    <T> List<T> findByPost_id(Long id, Class<T> type);

}