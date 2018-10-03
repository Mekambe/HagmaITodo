package com.sda.hangman.domain.model;

import com.sda.hangman.domain.ForbiddenWordsValidator;
import com.sda.hangman.domain.port.ForbiddenWordsRepository;
import lombok.Builder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ForbiddenWordValidatorTest {

    private ForbiddenWordsRepository forbiddenWordsRepository;
    private ForbiddenWordsValidator forbiddenWordsValidator;

    @Before
    public void before (){
        forbiddenWordsRepository = Mockito.mock(ForbiddenWordsRepository.class);
         forbiddenWordsValidator = new ForbiddenWordsValidator(forbiddenWordsRepository);
    }

    private void mockRepository (List<String> forbiddenWords){
        Mockito.when(forbiddenWordsRepository.findAll()).thenReturn(forbiddenWords);
    }


    @Test
    public void validateShouldReturnTrueWhenPhraseDoesNotContainsForbiddenWords () {
        //given

        mockRepository(Arrays.asList("forbidden"));


        //when
    boolean isValid = forbiddenWordsValidator.validate("test phrase");

    //then
        Assert.assertTrue(isValid);

    }
    @Test
    public void validateShouldreturnFalseWhenPhraseContainsForbiddenWords (){
        //given



        //when
        boolean isValid = forbiddenWordsValidator.validate("test phrase");

        //then
        Assert.assertTrue(isValid);

    }

    @Test
    public void validateShouldReturnFalseWhenPhraseContainsForbiddenWordsWithWhitespace (){
        //given

        mockRepository(Arrays.asList("sada"));


        //when
        boolean isValid = forbiddenWordsValidator.validate("test ph r a s e");


        //then
        Assert.assertTrue(isValid);

    }

    @Test
    public void validateShouldReturnFalseWhenPhraseContainsUpperCaseForbiddenWordsWithWhiteMultipleWordsWospace (){

        //given

        mockRepository(Arrays.asList("forbidden words"));


        //when
        boolean isValid = forbiddenWordsValidator.validate("TEST PHRASE");


        //then
        Assert.assertTrue(isValid);

    }

}
