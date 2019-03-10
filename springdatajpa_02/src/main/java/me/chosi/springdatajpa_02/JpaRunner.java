package me.chosi.springdatajpa_02;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        postRepository.findAll().forEach(System.out::println);
        Post post = new Post();
        post.setTitle("spring");

        Comment comment = new Comment();
        comment.setComment("hello");

        postRepository.save(post);
    }

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // japql 이용
//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);

        // Criteria 이용
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query = builder.createQuery(Post.class);
//        Root<Post> root = query.from(Post.class);
//        query.select(root);
//
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);

        // 네이티브 SQL 이용
        List<Post> posts = entityManager.createNativeQuery("SELECT * FROM Post", Post.class).getResultList();
        posts.forEach(System.out::println);

    }
    */

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("Spring Data JPA 언제 보나...");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어요.");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("곧 보여드릴게요.");
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
//        session.save(post);
        Post post = session.get(Post.class, 7l);
//        session.delete(post);
        System.out.println("=================");
        System.out.println(post.getTitle());
//
        post.getComments().forEach(c -> {
            System.out.println("=================");
            System.out.println(c.getComment());
        });

//        Comment comment = session.get(Comment.class, 5l);
//        System.out.println("=================");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());

    }
    */

    /*
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("seongil");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA");
//        study.setOwner(account);

        // 양방향 관계 설정 한 묶음으로 다녀야함
        // account.getStudies().add(study);
        // study.setOwner(account);

        // 위에서 묶은걸 리팩토링
        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account seongil = session.load(Account.class, account.getId());
        seongil.setUsername("seongil1");
        System.out.println("=================");
        System.out.println(seongil.getUsername());
    }
    */



}
