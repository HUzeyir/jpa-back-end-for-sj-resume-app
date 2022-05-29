package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.LanguageDaoImple;
import com.mycompany.daoInter.LanguageDaoInter;
import com.mycompany.entity.Language;
import com.mycompany.service.LanguageService;
import java.util.List;

public class LanguageServiceImpl implements LanguageService {

    private LanguageDaoInter ldi = new LanguageDaoImple();

    @Override
    public List<Language> getAllLanguage() {
        return ldi.getAllLanguage();
    }

    @Override
    public Language addLanguage(Language lang) {
        return ldi.addLanguage(lang);
    }

    @Override
    public Language findLanguage(Integer id) {
        return ldi.findLanguage(id);
    }

    @Override
    public Language updateLanguage(Language lang) {
        return ldi.updateLanguage(lang);
    }

    @Override
    public Language removeLanguage(Language lang) {
        return ldi.removeLanguage(lang);
    }

}
