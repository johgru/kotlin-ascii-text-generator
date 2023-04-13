package signature

fun main() {
    println("Enter name and surname:")
    val name = readln().split(" ")
    
    println("Enter person's status:")
    val status = readln()

    val mapLetter = mutableMapOf<Char, List<String>>()
    mapLetter['A'] = listOf("____", "|__|", "|  |")
    mapLetter['B'] = listOf("___ ", "|__]", "|__]")
    mapLetter['C'] = listOf("____", "|   ", "|___")
    mapLetter['D'] = listOf("___ ", "|  \\", "|__/")
    mapLetter['E'] = listOf("____", "|___", "|___")
    mapLetter['F'] = listOf("____", "|___", "|   ")
    mapLetter['G'] = listOf("____", "| __", "|__]")
    mapLetter['H'] = listOf("_  _", "|__|", "|  |")
    mapLetter['I'] = listOf("_", "|", "|")
    mapLetter['J'] = listOf(" _", " |", "_|")
    mapLetter['K'] = listOf("_  _", "|_/ ", "| \\_")
    mapLetter['L'] = listOf("_   ", "|   ", "|___")
    mapLetter['M'] = listOf("_  _", "|\\/|", "|  |")
    mapLetter['N'] = listOf("_  _", "|\\ |", "| \\|")
    mapLetter['O'] = listOf("____", "|  |", "|__|")
    mapLetter['P'] = listOf("___ ", "|__]", "|   ")
    mapLetter['Q'] = listOf("____", "|  |", "|_\\|")
    mapLetter['R'] = listOf("____", "|__/", "|  \\")
    mapLetter['S'] = listOf("____", "[__ ", "___]")
    mapLetter['T'] = listOf("___", " | ", " | ")
    mapLetter['U'] = listOf("_  _", "|  |", "|__|")
    mapLetter['V'] = listOf("_  _", "|  |", " \\/ ")
    mapLetter['W'] = listOf("_ _ _", "| | |", "|_|_|")
    mapLetter['X'] = listOf("_  _", " \\/ ", "_/\\_")
    mapLetter['Y'] = listOf("_   _", " \\_/ ", "  |  ")
    mapLetter['Z'] = listOf("___ ", "  / ", " /__")
    mapLetter['Ö'] = listOf("_  _", "____", "|__|")

    val row1 = mutableListOf<String>()
    val row2 = mutableListOf<String>()
    val row3 = mutableListOf<String>()

    val start = "* "
    val end = " *"
    val space = "    "

    row1.add(start)
    row2.add(start)
    row3.add(start)

    for (i in name[0]) {
        row1.add(mapLetter[i.uppercaseChar()]?.subList(0,1)!!.joinToString(""))
        row2.add(mapLetter[i.uppercaseChar()]?.subList(1,2)!!.joinToString(""))
        row3.add(mapLetter[i.uppercaseChar()]?.subList(2,3)!!.joinToString(""))
    }

    row1.add(space)
    row2.add(space)
    row3.add(space)

    for (i in name[1]) {
        row1.add(mapLetter[i.uppercaseChar()]?.subList(0,1)!!.joinToString(""))
        row2.add(mapLetter[i.uppercaseChar()]?.subList(1,2)!!.joinToString(""))
        row3.add(mapLetter[i.uppercaseChar()]?.subList(2,3)!!.joinToString(""))
    }

    row1.add(end)
    row2.add(end)
    row3.add(end)

    val nameLength = row1.joinToString(" ").length

    if (status.length + 6 > nameLength) {

        val wantedLength = status.length + 6 - 2
        val missingLength = wantedLength - row1.joinToString(" ").length + row1[0].length + row1[row1.lastIndex].length

        val bufferStart = if (missingLength % 2 == 0) missingLength / 2 else missingLength / 2
        val bufferEnd = if (missingLength % 2 == 0) missingLength / 2 else missingLength / 2 + 1

        row1[0] = "*" + " ".repeat(bufferStart)
        row1[row1.lastIndex] = " ".repeat(bufferEnd) + "*"
        row2[0] = "*" + " ".repeat(bufferStart)
        row2[row2.lastIndex] = " ".repeat(bufferEnd) + "*"
        row3[0] = "*" + " ".repeat(bufferStart)
        row3[row3.lastIndex] = " ".repeat(bufferEnd) + "*"

        val statusLine = "*  $status  *"
        val border = "*".repeat(row1.joinToString(" ").length)

        printTag(border, row1, row2, row3, statusLine)
    } else {

        val statusLine = if (status.length % 2 == 0 && nameLength % 2 == 1) {
            "*" + " ".repeat((nameLength - status.length - 2) / 2) +
                    status + " ".repeat((nameLength - status.length - 2) / 2 + 1) + "*"
        } else if (status.length % 2 == 1 && nameLength % 2 == 1) {
            "*" + " ".repeat((nameLength - status.length) / 2 - 1) +
                    status + " ".repeat((nameLength - status.length) / 2 - 1) + "*"
        } else {
            "*" + " ".repeat((nameLength - status.length) / 2 - 1) +
                    status + " ".repeat((nameLength - status.length) / 2) + "*"
        }

        val border = "*".repeat(nameLength)

        printTag(border, row1, row2, row3, statusLine)
    }
}

fun printTag(
    border: String,
    row1: MutableList<String>,
    row2: MutableList<String>,
    row3: MutableList<String>,
    statusLine: String
) {

    println(border)
    println(row1.joinToString(" "))
    println(row2.joinToString(" "))
    println(row3.joinToString(" "))
    println(statusLine)
    println(border)
}
