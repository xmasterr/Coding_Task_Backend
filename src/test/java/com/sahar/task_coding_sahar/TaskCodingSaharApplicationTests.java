package com.sahar.task_coding_sahar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

//Junit Tests
@SpringBootTest
class TaskCodingSaharApplicationTests {

    /**
     * Check that the text user entered contains only the command "consonants" or "vowels"
     * and nothing more as text to be analyzed
     */
    @Test
    void text_Analyzer_Parameter_Missing() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"consonants"});
        assertEquals(0, textAnalyzer.size(), "Map is not empty.");

        textAnalyzer = TextAnalyzer.analyse(new String[]{"vowels"});
        assertEquals(0, textAnalyzer.size(), "Map is not empty.");
    }

    /**
     * Check that second text is not confused as a command
     */
    @Test
    void text_Analyzer_Parameter_double_commands() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"consonants", "vowels"});
        assertEquals(4, textAnalyzer.size(), "Map size is wrong.");
        assertEquals(1, textAnalyzer.get("W"), "wrong W count.");


    }

    /**
     * Check the map size and G count for a consonants example
     */
    @Test
    void text_Analyzer_Consonant_check() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"consonants", "gsdfuagsf"});
        assertEquals(4, textAnalyzer.size(), "Map size is wrong.");
        assertEquals(2, textAnalyzer.get("G"), "wrong G count.");
    }

    /**
     * Check the map size and U count for a vowels example
     */
    @Test
    void text_Analyzer_Vowels_check() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"vowels", "gsudfuagsf"});
        assertEquals(5, textAnalyzer.size(), "size of map is wrong.");
        assertEquals(2, textAnalyzer.get("U"), "wrong U count.");

    }

    /**
     * Check the map size and U count for a consonants example (vowel alphabet should be null)
     */
    @Test
    void text_Analyzer_Consonants() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"consonants", "gsdfuagsf"});
        assertEquals(4, textAnalyzer.size(), "size of map is wrong.");
        assertEquals(null, textAnalyzer.get("U"), "wrong U count.");


    }

    /**
     * Check the map size and D count for a vowels example (Consonants alphabet should be null)
     */
    @Test
    void text_Analyzer_vowels() {
        Map<String, Integer> textAnalyzer = TextAnalyzer.analyse(new String[]{"vowels", "iueugdal"});
        assertEquals(5, textAnalyzer.size(), "size of map is wrong.");
        assertEquals(null, textAnalyzer.get("D"), "wrong D count.");

    }

}
