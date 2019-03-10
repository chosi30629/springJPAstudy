package me.chosi.commonweb.post;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static me.chosi.commonweb.post.CommentSpecs.isBest;
import static me.chosi.commonweb.post.CommentSpecs.isGood;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    /*
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("comment");
        comment.setPost(savedPost);
        commentRepository.save(comment);

        Optional<Comment> byId = commentRepository.findById(1l);
        System.out.println(byId.get().getPost());


    }
    */

    @Autowired
    CommentRepository comments;

    @Autowired
    PostRepository posts;

    /*
    @Test
    public void getComment() {
        // FetchType.EAGER
        comments.getById(1l);

        System.out.println("====================");

        // FetchType.LAZY
        comments.findById(1l);
    }
    */

    @Test
    public void getComment() {
        Post post = new Post();
        post.setTitle("jps");
        Post savedPost = posts.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        comments.save(comment);

        comments.findByPost_id(savedPost.getId(), /*CommentSummary.class*/ CommentOnly.class).forEach(c -> {
            System.out.println("==================");
//            System.out.println(c.getVotes());
            System.out.println(c.getComment());
        });
    }

    @Test
    public void specs() {
        Page<Comment> page =
                comments.findAll(isBest().or(isGood()), PageRequest.of(0, 10));
    }

    @Test
    public void qbe() {
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("up", "down");

        Example<Comment> example = Example.of(prove, exampleMatcher);

        comments.findAll(example);
    }

}