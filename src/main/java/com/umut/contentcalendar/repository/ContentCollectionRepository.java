package com.umut.contentcalendar.repository;


import com.umut.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentCollectionRepository {

    private  final List<Content> content = new ArrayList<>();



}
