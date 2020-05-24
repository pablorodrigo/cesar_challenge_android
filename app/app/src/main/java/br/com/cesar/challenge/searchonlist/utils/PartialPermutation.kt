package br.com.cesar.challenge.searchonlist.utils

object PartialPermutation {

    fun checkIfIs(word: String, jumbledWord: String): Boolean {

        // To be permutation it should have the same length and The first letter hasn’t changed place
        if (word.length == jumbledWord.length && word[0] == jumbledWord[0]) {
            val lengthOfTheWords = word.length;

            var countDifferentLetter = 0


            jumbledWord.forEachIndexed { index, letter ->
                if (word.indexOf(letter) == -1) {
                    return false;
                }
                if (index != word.indexOf(letter)) {
                    countDifferentLetter++
                }
            }

            // If word has more than 3 letters, up to 2/3 of the letters have changed place
            if (lengthOfTheWords > 3) {
                if (countDifferentLetter < (lengthOfTheWords * (2f / 3f))) {
                    return true
                }
            } else {
                return countDifferentLetter > 0
            }
        }

        return false


    }

}