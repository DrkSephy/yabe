package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok("Hello World")
  }

  // TODO is a built-in action that returns a 501 Not Implemented HTTP Response
  def tasks = TODO

  def newTask = TODO

  def deleteTask(id: Long) = TODO
}