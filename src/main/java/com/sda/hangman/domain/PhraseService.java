package com.sda.hangman.domain;

import com.sda.hangman.domain.exceptions.ForbiddenWordsInPhraseException;
import com.sda.hangman.domain.exceptions.PhraseAlreadyExistsException;
import com.sda.hangman.domain.port.PhraseRepository;

public class PhraseService {

    private PhraseRepository phraseRepository;
    private ForbiddenWordsValidator forbiddenWordsValidator;

    public PhraseService(PhraseRepository phraseRepository,
                         ForbiddenWordsValidator forbiddenWordsValidator) {
        this.phraseRepository = phraseRepository;
        this.forbiddenWordsValidator = forbiddenWordsValidator;
    }



    public void addPhrase(String phrase) throws ForbiddenWordsInPhraseException, PhraseAlreadyExistsException {

    }
}
