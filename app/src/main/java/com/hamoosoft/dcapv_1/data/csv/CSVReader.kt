package com.hamoosoft.dcapv_1.data.csv

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.IOException
import java.io.Reader


@RequiresApi(Build.VERSION_CODES.P)
class CSVReader(reader: Reader?, separator: Char, quotechar: Char, line: Int) {
    private val br: BufferedReader
    private var hasNext = true
    private val separator: Char
    private val quotechar: Char
    private val skipLines: Int
    private var linesSkiped = false

    /**
     * Constructs CSVReader using a comma for the separator.
     *
     * @param reader
     * the reader to an underlying CSV source.
     */
    constructor(reader: Reader?) : this(
        reader, DEFAULT_SEPARATOR, DEFAULT_QUOTE_CHARACTER,
        DEFAULT_SKIP_LINES
    ) {
    }

    /**
     * Constructs CSVReader with supplied separator and quote char.
     *
     * @param reader
     * the reader to an underlying CSV source.
     * @param separator
     * the delimiter to use for separating entries
     * @param quotechar
     * the character to use for quoted elements
     * @param line
     * the line number to skip for start reading
     */
    init {
        br = BufferedReader(reader)
        this.separator = separator
        this.quotechar = quotechar
        skipLines = line
    }

    /**
     * Reads the next line from the buffer and converts to a string array.
     *
     * @return a string array with each comma-separated element as a separate
     * entry.
     *
     * @throws IOException
     * if bad things happen during the read
     */
    @Throws(IOException::class)
    fun readNext(): Array<String>? {
        val nextLine = nextLine
        return if (hasNext) parseLine(nextLine) else null
    }

    /**
     * Reads the next line from the file.
     *
     * @return the next line from the file without trailing newline
     * @throws IOException
     * if bad things happen during the read
     */
    @get:Throws(IOException::class)
    private val nextLine: String?
        get() {
            if (!linesSkiped) {
                for (i in 0 until skipLines) {
                    br.readLine()
                }
                linesSkiped = true
            }
            val nextLine = br.readLine()
            if (nextLine == null) {
                hasNext = false
            }
            return if (hasNext) nextLine else null
        }

    /**
     * Parses an incoming String and returns an array of elements.
     *
     * @param nextLine
     * the string to parse
     * @return the comma-tokenized list of elements, or null if nextLine is null
     * @throws IOException if bad things happen during the read
     */
    @Throws(IOException::class)
    private fun parseLine(nextLine: String?): Array<String>? {
        var nextLine = nextLine ?: return null
        val tokensOnThisLine: MutableList<String> = ArrayList()
        var sb = StringBuffer()
        var inQuotes = false
        do {
            if (inQuotes) {
                // continuing a quoted section, reappend newline
                sb.append("\n")
                nextLine = this.nextLine.orEmpty()
            }
            var i = 0
            while (i < nextLine.length) {
                val c = nextLine[i]
                if (c == quotechar) {
                    // this gets complex... the quote may end a quoted block, or escape another quote.
                    // do a 1-char lookahead:
                    if (inQuotes && nextLine.length > i + 1 && nextLine[i + 1] == quotechar) { // ..and that char. is a quote also.
                        // we have two quote chars in a row == one quote char, so consume them both and
                        // put one on the token. we do *not* exit the quoted text.
                        sb.append(nextLine[i + 1])
                        i++
                    } else {
                        inQuotes = !inQuotes
                        // the tricky case of an embedded quote in the middle: a,bc"d"ef,g
                        if (i > 2 && nextLine[i - 1] != separator && nextLine.length > i + 1 && nextLine[i + 1] != separator //not at the	end of an escape sequence
                        ) {
                            sb.append(c)
                        }
                    }
                } else if (c == separator && !inQuotes) {
                    tokensOnThisLine.add(sb.toString())
                    sb = StringBuffer() // start work on next token
                } else {
                    sb.append(c)
                }
                i++
            }
        } while (inQuotes)
        tokensOnThisLine.add(sb.toString())
        return tokensOnThisLine.toTypedArray()
    }

    /**
     * Closes the underlying reader.
     *
     * @throws IOException if the close fails
     */
    @Throws(IOException::class)
    fun close() {
        br.close()
    }

    companion object {
        /** The default separator to use if none is supplied to the constructor.  */
        const val DEFAULT_SEPARATOR = ','

        /**
         * The default quote character to use if none is supplied to the
         * constructor.
         */
        const val DEFAULT_QUOTE_CHARACTER = '"'

        /**
         * The default line to start reading.
         */
        const val DEFAULT_SKIP_LINES = 0
    }
}
