package br.com.cesar.challenge.searchonlist.utils

object Typos {

    fun checkIfIsTypos(baseSequence: String, validationSequence: String): Boolean{


        return if (baseSequence.length == validationSequence.length){
            checkTyposSameLengthChar(baseSequence,validationSequence)
        }else{
            checkTyposDiffLengthChar(baseSequence,validationSequence)
        }

    }


    /**
     * This function verify character's  errors of sequences with same amount of characters
     */
    private fun checkTyposSameLengthChar(baseSequence: String, validationSequence: String): Boolean {
        var differences = 0

        if (baseSequence.length == validationSequence.length) {
            for (char in baseSequence) {
                if (char !in validationSequence) {
                    differences++
                }
            }
        }

        return when {
            differences == 1 -> true // digit error
            differences != 1 -> false // no digit error
            else -> true // digit error
        }

    }

    /**
     * This function evaluates based on number of different characters
     */
    private fun checkTyposDiffLengthChar(baseSequence: String, validationSequence: String): Boolean{
        var differences = 0

        if (baseSequence.length > validationSequence.length) {
            for (char in baseSequence) {
                if (char !in validationSequence) {
                    differences++
                }
            }
        }

        if (baseSequence.length < validationSequence.length) {
            for (char in baseSequence) {
                if (char !in validationSequence) {
                    differences++
                }
            }
        }

        return when {
            differences == 1 -> true // digit error
            differences > 1 -> false // no digit error
            else -> true // digit error
        }

    }

}