package me.chosi.springdatajpa_03.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class PostListener /*implements ApplicationListener<PostPublishedEvent>*/ {

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("============");
        System.out.println(event.getPost().getTitle() + " is published!!");
        System.out.println("============");
    }

}
