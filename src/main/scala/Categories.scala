package mla

import mla.Types.Category

import scala.io.Source
import scala.util.matching.Regex


object WikiScrape {

  //todo: add functionality to save found categories
  // todo: put in different urls
  // todo: clean up data somehow

  val categories =
    catPage("https://en.wikipedia.org/wiki/Portal:Contents/Lists")

  def catPage(u: String): List[Category] = {
    val html = Source.fromURL(u)

    val listOfRegEx = """title=\"lists? of ([^"]+)""".r

    listOfRegEx.findAllIn(html.mkString.toLowerCase)
      .matchData.map(m => m.group(1)).toList.map(Category)
  }
}
