package com.baizhi.service;




import com.baizhi.entity.Artcle;

import java.util.List;

public interface ArtcleService {

    List<Artcle> findAll(Integer page, Integer rows);
    Long findTotals();
}
