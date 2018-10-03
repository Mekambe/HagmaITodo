package com.sda.hangman.domain.port;

import java.util.Arrays;
import java.util.List;

public interface ForbiddenWordsRepository {

    List<String> findAll();
}
