package com.sda.hangman.domain;

import com.sda.hangman.domain.port.ForbiddenWordsRepository;

public class ForbiddenWordsValidator {
    private ForbiddenWordsRepository forbiddenWordsRepository;

    public ForbiddenWordsValidator(ForbiddenWordsRepository forbiddenWordsRepository) {
        this.forbiddenWordsRepository = forbiddenWordsRepository;
    }

    public boolean validate(String phrase) {
        return true;
    }
}
