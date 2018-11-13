package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    List<Carousel> findAll();
    void date(String id);
    void add(Carousel carousel);
    Carousel findAllone(String id);
    void update(Carousel carousel);
}
