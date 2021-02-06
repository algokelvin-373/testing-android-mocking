package id.ngoprek.testing.simple.static

object Addition {
    fun addition(a: Int, b: Int): Int {
        return a + b
    }
}

class StaticCalculator {
    var result = 0

    fun calc(a: Int, b: Int): Int {
        result = Addition.addition(a, b)
        return result
    }

}