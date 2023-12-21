package com.umut.contentcalendar.repository;


import com.umut.contentcalendar.model.Content;
import com.umut.contentcalendar.model.Status;
import com.umut.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {


    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findByID(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }


    @PostConstruct
    private void init() {
        Content c = new Content(1,
                "my first blog",
                "My first blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,null);
        contentList.add(c);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count()==1;
    }

    public void delete(Integer id) {

        contentList.removeIf(c->c.id().equals(id));
    }
}
