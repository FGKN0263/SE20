import kotlin.math.*
import java.math.BigInteger


class BigIntegerRange(
        override val start: BigInteger,
        override val endInclusive: BigInteger
) : ClosedRange<BigInteger>, Iterable<BigInteger> {
    override operator fun iterator(): Iterator<BigInteger> = BigIntegerRangeIterator(this)
}

class BigIntegerRangeIterator(
        private val range: ClosedRange<BigInteger>
) : Iterator<BigInteger> {
    private var current = range.start

    override fun hasNext(): Boolean =
            current <= range.endInclusive

    override fun next(): BigInteger {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return current++
    }
}

operator fun BigInteger.rangeTo(other: BigInteger) = BigIntegerRange(this, other)

fun Long.toBigInteger() = BigInteger.valueOf(this)
fun Int.toBigInteger() = BigInteger.valueOf(toLong())

fun isPrime(x:BigInteger): Boolean{
    if(x==1L.toBigInteger()) return false

    for (j in 2L.toBigInteger()..x / 2.toBigInteger()) {
            if (x % j == 0L.toBigInteger()) {
                return false
            }
    }
    return true
}
fun main() {
    val search_length = 19L
    var Repunit  = "1"
    for (i in 1L..search_length) {
        var n = BigInteger(Repunit)
        Repunit = Repunit + "1"
        println("%d %b".format(n, isPrime(n)))
    }
}
