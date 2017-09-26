package com.here.provenanceanalyzer.scanner

class ScanException : Exception {
    constructor(cause: Exception): super(cause)
    constructor(message: String): super(message)
    constructor(message: String, cause: Exception?): super(message, cause)
}
