package by.prostrmk.controller

import java.lang.Exception

import by.prostrmk.view.Output



object MainController {

  def main(args: Array[String]): Unit = {
    val output = new Output
    try{
      output.print("ya")
    }catch (Exception) {
      print("exception")
    }
  }

}
