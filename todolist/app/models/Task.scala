package models


// Required for Anorm mapping capability
import anorm._
import anorm.SqlParser._

// Required for the Play db functionality
import play.api.db._
import play.api.Play.current

case class Task(id: Long, label: String)

object Task {

    // Task is a parser that, given a JDBC `ResultSet` row with at least 
    // an id and a label column, is able to create a `Task` value.

    val task = {
        get[Long]("id") ~
        get[String]("label") map {
            case id~label => Task(id, label)
        }
    }
    def all(): List[Task] = DB.withConnection { implicit c => 
        SQL("select * from task").as(task *)}

    def create(label: String) {}

    def delete(id: Long) {}
}