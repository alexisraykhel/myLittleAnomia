package mla

object Main extends App {

    Categories.list.foreach(c => println(s"category: $c"))

    CardGeneration.deck(10, Categories.list).foreach(p => println(s"example card: $p"))
}