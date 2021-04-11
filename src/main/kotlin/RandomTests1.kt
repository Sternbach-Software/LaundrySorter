import java.io.File

fun main() {
    var list = mutableListOf<File>()
    var list1 = mutableListOf<File>()
    for (file in File("D:\\10.12.2020 Backup slash preperation to move to red HP laptop\\IdeaProjects").listFiles()!!
        .sorted()) {
        if (file.isDirectory) {
            list.add(file)
        }
    }
    for (file1 in File("C:\\Users\\shmue\\OneDrive\\IdeaProjects").listFiles()!!
        .sorted()) {
        if (file1.isDirectory) {
            list1.add(file1)
        }
    }
    val zipped = list.zip(list1)
    val map1 = list.map { it.name }
    val map = list1.map { it.name }
    for (pair in zipped) {
        if(pair.first.name !in map) println("file in mine: ${pair.first.absolutePath}, ${pair.first.length()}")
        else if(pair.second.name !in map1) println("file in red: ${pair.second.absolutePath}, ${pair.second.length()}.")

    }
    /*val zipped = list.zip(list1)
    for (pair in zipped) {
        if (pair.first.length() != pair.second.length())
            println("file in mine: ${pair.first.absolutePath}, ${pair.first.length()}; file in red: ${pair.second.absolutePath}, ${pair.second.length()}.")
//            println("${pair.first.length()},${pair.second.length()}")
    }
    for(file1 in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling mine").listFiles()!!
        .sorted())
        for(file2 in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling red").listFiles()!!
            .sorted()) if(file1.hashCode()==file2.hashCode()){
            file1.delete()
            file2.delete()
        }*/
}