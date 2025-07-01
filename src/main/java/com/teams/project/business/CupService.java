package com.teams.project.business;

import com.teams.project.dataAccess.CupDao;
import com.teams.project.entities.Cup;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CupService {
    private CupDao cupDao;

    public void add(Cup cup) {
        cupDao.save(cup);
    }

    public List<Cup> getAll() {
        return cupDao.findAll();
    }
}
