package com.baizhi.service;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService{



    @Autowired
    private CarouselDao carouselDao;

//查询所有
    public List<Carousel> findAll() {
        List<Carousel> carousels = carouselDao.findAll();
        return carousels;
    }
//删除
    public void date(String id) {
        carouselDao.delete(id);
    }

    @Override
    public void add(Carousel carousel) {
        carouselDao.add(carousel);
    }

//查一个
    public Carousel findAllone(String id) {
        Carousel allone = carouselDao.findAllone(id);
        return allone;
    }

//   修改
    public void update(Carousel carousel) {
        carouselDao.update(carousel);
    }

}
