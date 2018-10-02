package com.sda.hangman.domain;

import com.sda.hangman.domain.exceptions.ForbiddenWordsInPhraseException;
import com.sda.hangman.domain.exceptions.PhraseAlreadyExistsException;
import com.sda.hangman.domain.port.PhraseRepository;
import org.junit.Test;
import org.mockito.Mockito;

public class PhraseServiceTest {

    @Test
    public void addPhraseShouldAddNewPhrase() throws Exception {
        //given
        PhraseRepository phraseRepository = Mockito.mock(PhraseRepository.class);
        ForbiddenWordsValidator forbiddenWordsValidator = Mockito.mock(ForbiddenWordsValidator.class);
        PhraseService phraseService = new PhraseService(phraseRepository, forbiddenWordsValidator);

        //when
        phraseService.addPhrase("phrase with forbiddenWord");
    }

    @Test(expected = PhraseAlreadyExistsException.class)
    public void addPhraseShouldThrowAnExceptionWhenPhraseAlreadyExists() throws Exception {
        //given
        PhraseRepository phraseRepository = Mockito.mock(PhraseRepository.class);
        ForbiddenWordsValidator forbiddenWordsValidator = Mockito.mock(ForbiddenWordsValidator.class);
        PhraseService phraseService = new PhraseService(phraseRepository, forbiddenWordsValidator);

        //when
        phraseService.addPhrase("phrase with forbiddenWord");
    }

    @Test(expected = ForbiddenWordsInPhraseException.class)
    public void addPhraseShouldThrowAnExceptionWhenPhraseContainsForbiddenWords() throws Exception {
        //given
        PhraseRepository phraseRepository = Mockito.mock(PhraseRepository.class);
        ForbiddenWordsValidator forbiddenWordsValidator = Mockito.mock(ForbiddenWordsValidator.class);
        Mockito.when(forbiddenWordsValidator.validate(Mockito.anyString())).thenReturn(false);
        PhraseService phraseService = new PhraseService(phraseRepository, forbiddenWordsValidator);

        //when
        phraseService.addPhrase("phrase with forbiddenWord");
    }
}
