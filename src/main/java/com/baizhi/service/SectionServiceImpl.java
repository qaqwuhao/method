package com.baizhi.service;


import com.baizhi.dao.SectionDao;
import com.baizhi.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{

    @Autowired
    private SectionDao sectionDao;

    public void add(Section section){
        sectionDao.add(section);
    }
}
