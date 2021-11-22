# **Random Sentence Generator**
This random sentence generator returns a grammatically correct (though often incoherent) sentence between two and six words long. It contains a subject, a verb conjugated in the present tense, and sometimes an object.

The noun wordbank is based on:  https://www.wordexample.com/list/most-common-nouns-english.
The adjective wordbank is based on:
https://grammar.yourdictionary.com/parts-of-speech/adjectives/list-of-adjective-words.html

## ParagraphBuilder Class
* 
* 
## SentenceBuilder Class
* `public static String getSentence()` : returns a sentence composed of at least two words (a subject and properly conjugated verb) in String format with correct capitalization and punctualization

## Word Class
* `public Object()` : constructs an instance of the object class and loads the lists from the text files
* `public Word(String word)` : constructs a new instance of the Word class and sets String word instance variable to String word (parameter)
* `public String toString()` : returns string version of object
* `public boolean equals(Word other)` : determines if two Words have the same values for String word

## Article Class (extends Word)
* `public Article(String word)` : creates new Article using Word constructor
* `public static Article getNew()` : returns a random Article

## Noun Class (extends Word)
* `public Noun(String word)` : creates new Noun using Word constructor
* `public static Noun getNew()` : returns a random Noun
* `public boolean isVowel()` : returns boolean indicating whether the first letter is a vowel

## Verb Class (extends Word)
* `public Verb(String word)` : creates a new Verb using Word constructor
* `public static Verb getNew()` : returns a random Verb
* `public Verb conjugate()` : returns a Verb conjugated in the present tense