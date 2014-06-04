package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  // Use redirect instead of `OK` to specify a 303 See Other HTTP Response type.
  // We use the reverse router to get the URL needed to fetch the `tasks` actions.
  def index = Action {
    Redirect(routes.Application.tasks)
  }

  // TODO is a built-in action that returns a 501 Not Implemented HTTP Response
  def tasks = TODO

  def newTask = TODO

  def deleteTask(id: Long) = TODO
}