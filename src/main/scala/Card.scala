package mla

import Symbol.list
import scala.util.Random
import mla.Types.Category

final case class Card(categoryOne: Category,
                      symbol: Symbol,
                      categoryTwo: Category) {
  def matches(c: Card): Boolean = this.symbol == c.symbol
}

final case class WildCard(symbolOne: Symbol,
                           symbolTwo: Symbol)


object CardGeneration {

  def deck(numOfCards: Int, cats: List[Category]) =
    regularCards(numOfCards * .9, cats) ++ wildCards(numOfCards * .1)

  private def regularCards(n: Double, cats: List[Category]): List[Card] = {
    def looper(cards: List[Card], n: Double, cats: List[Category]): List[Card] = {
      if (n <= 0.0) cards
      else {
        val rando = new Random
        val newCats = rando.shuffle(cats)
        newCats match {
          case a :: b :: c => {
            val sym = rando.shuffle(list).head
            looper(Card(a, sym, b) :: cards, n - 1, c)
          }
          case _ => cards
        }
      }
    }

    looper(List.empty, n, cats)
  }
  private def wildCards(n: Double): List[WildCard] = {

    def looper(wilds: List[WildCard], n: Double): List[WildCard] = {
      if (wilds.length >= n) wilds
      else {
        val rando = new Random
        val sliding = rando.shuffle(list).sliding(2)

        sliding.flatMap({
          case h :: t :: Nil => List(WildCard(h, t))
          case _ => List.empty
        }).toList
      }
    }

    looper(List.empty, n)
  }
}
