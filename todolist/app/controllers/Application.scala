package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Task

object Application extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  // Use redirect instead of `OK` to specify a 303 See Other HTTP Response type.
  // We use the reverse router to get the URL needed to fetch the `tasks` actions.
  def index = Action {
    Redirect(routes.Application.tasks)
  }

  // TODO is a built-in action that returns a 501 Not Implemented HTTP Response
  def tasks = Action(
    Ok(views.html.index(Task.all(), taskForm))
    )

  def newTask = Action { implicit request =>
  taskForm.bindFromRequest.fold(
    errors => BadRequest(views.html.index(Task.all(), errors)),
    label => {
      Task.create(label)
      Redirect(routes.Application.tasks)
    }
  )
}

  def deleteTask(id: Long) = TODO
}