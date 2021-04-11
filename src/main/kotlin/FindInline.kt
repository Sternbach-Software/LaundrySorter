import java.io.File
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


fun main() {
    val originalString = File("C:\\Users\\shmue\\Downloads\\LaundrySorter\\src\\main\\kotlin\\FindInlineTest.kt").readText()
    var newString = StringBuilder(originalString)

    val regex = "(?<=((var)|(val)) )\\w+".toRegex()
    val variables: Sequence<MatchResult> = regex.findAll(originalString)
    val listOfVariableNames = mutableListOf<String>(
    )
    variables.forEach{listOfVariableNames.add(it.value)}
    val listOfVariablesWhichAppearTwice = mutableListOf<String>()
    for(it in listOfVariableNames) {
        val wordRegex: Pattern = Pattern.compile("(?<=[)(\\]=\\[.}{$]\\s?)$it")
        val countEmailMatcher: Matcher = wordRegex.matcher(originalString)
        var count = 0
        while (countEmailMatcher.find()) {
            count++
        }
        println("count,variables: $count,$it,")/*${wordRegex.matcher(originalString).printEach()}*/
        if(count.toInt() ==2) listOfVariablesWhichAppearTwice.add(it)
    }
    println("listOfVariableNames: $listOfVariableNames")
    println("listOfVariablesWhichAppearTwice: $listOfVariablesWhichAppearTwice")
    for(variable in listOfVariablesWhichAppearTwice){
        val indexOfDecleration = originalString.indexOf(variable)
        val indexOfUse = originalString.lastIndexOf(variable)
        var assignedValue = originalString.substring(originalString.indexOf('=', indexOfDecleration)+1, originalString.indexOf('\n', indexOfDecleration))
//        var assignedValue = originalString.substring(indexOfDecleration - 4, originalString.indexOf('\n', indexOfDecleration))
        var comment = ""

        if(assignedValue.indexOf("/*",assignedValue.indexOf("="))!=-1){//contains // after = sign
            val oldValueBeforeComment = assignedValue.substring(0,assignedValue.indexOf("//"))
            comment = assignedValue.substring(assignedValue.indexOf("//"))
                assignedValue = oldValueBeforeComment
        }
        if(assignedValue.indexOf("/*",assignedValue.indexOf("="))!=-1){//this will break the code because it will be left as a partial block comment
            val oldValueBeforeComment = assignedValue.substring(0,assignedValue.indexOf("/*"))
            comment = assignedValue.substring(assignedValue.indexOf("/*"))
            assignedValue = oldValueBeforeComment
        }
        println("variable: $variable")
        println("indexOfDecleration: $indexOfDecleration")
        println("indexOfUse: $indexOfUse")
        println("assignedValue: $assignedValue")
        println("comment: $comment")

        newString.deleteRange(indexOfDecleration - 4, originalString.indexOf('\n', indexOfDecleration)) //delete line of decleration; minus 4 because it will be "val $variable"
        newString.replace(indexOfUse,indexOfUse+variable.length,assignedValue)//replace the variable usage with assigned value
        newString.insert(newString.indexOf('\n',indexOfUse),comment)//insert comment at end of line
    }
    println("originalString: $originalString")
    println("newString: $newString")
    /*val mapOfMatchesToIndex = mutableMapOf<String, MutableList<IntRange>>()
    for(q in variables) {
        val value = q.value
        if (value in listOfVariablesWhichAppearTwice) {
            val element = q.range
            if (mapOfMatchesToIndex.containsKey(value)) {
                mapOfMatchesToIndex[value]!!.add(element)
            } else mapOfMatchesToIndex[value] = mutableListOf(element)
        }
    }
    println(listOfVariableNames)
    println(listOfVariablesWhichAppearTwice)
    println(listOfEveryVariableOccurence)
    println(mapOfMatchesToIndex)*/
/*    val x = File("C:\\Users\\shmue\\Downloads\\LaundrySorter\\src\\main\\kotlin\\FindInlineTest.kt").readText()
    val regexOfVariable = "(?<=((var)|(val)))\\w+".toRegex()
    val matchResults = regexOfVariable.findAll(x)
    val varsWithCount = mutableListOf<MatchResult>()
     matchResults.forEach{if(it.)}*/
    // we have a expression
    // we have a expression
    val expression = "Hi, I am Hritik and I am a programmer"

    // splitting words using regex

    // splitting words using regex
    val words = expression.split("\\W".toRegex()).toTypedArray()

    // we are creating a Map for storing
    // strings and it's occurrence"

    // we are creating a Map for storing
    // strings and it's occurrence"
    val word_map: MutableMap<String, Int?> = HashMap()

    // Here we are iterating in words array and
    // increasing it's occurrence by 1.

    // Here we are iterating in words array and
    // increasing it's occurrence by 1.
    for (word in words) {
        if (word_map[word] != null) {
            word_map[word] = word_map[word]!! + 1
        } else {
            word_map[word] = 1
        }
    }

    // creating a keyset of word_map

    // creating a keyset of word_map
    val word_set: Set<String> = word_map.keys

    // We are iterating in word set

    // We are iterating in word set
    for (word in word_set) {

        // if word matched then checking occurrence
        if (word_map[word]!! > 1) // here we are printing the duplicate words
            println(word)
    }
}

private fun Matcher.printEach() {
    var x = 0
    while(x<this.end()){
        this.find()
        println(this.group())
        x++
    }
}

private fun java.util.stream.Stream<java.util.regex.MatchResult>.printEach() {
    this.forEach{
//        println(it.)
    }
}
