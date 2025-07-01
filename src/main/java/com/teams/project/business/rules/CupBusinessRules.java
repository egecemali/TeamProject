package com.teams.project.business.rules;

import com.teams.project.business.CupService;
import com.teams.project.core.utilities.exceptions.BusinessExeption;
import com.teams.project.dataAccess.CupDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
@AllArgsConstructor
public class CupBusinessRules {
    private CupService cupService;
    private CupDao cupDao;
    public void checkIfCupIdExists(long cupId) {
        if (!cupDao.findById(cupId).isPresent()) {
            throw new BusinessExeption("The cup id " + cupId + " does not exist");
        }
    }


}
